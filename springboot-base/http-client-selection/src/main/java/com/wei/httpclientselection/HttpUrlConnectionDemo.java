package com.wei.httpclientselection;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConnectionDemo {
    public String doGet(String urlS) {
        HttpURLConnection httpURLConnection = null;
        try {
            // 1. 得到访问地址的URL
            URL url = new URL(urlS);
            // 2. 得到网络访问对象java.net.HttpURLConnection
            httpURLConnection = (HttpURLConnection) url.openConnection();
            /* 3. 设置请求参数（过期时间，输入、输出流、访问方式），以流的形式进行连接 */
            // 设置是否向HttpURLConnection输出
            httpURLConnection.setDoOutput(false);
            // 设置是否从httpUrlConnection读入
            httpURLConnection.setDoInput(true);
            // 设置请求方式　默认为GET
            httpURLConnection.setRequestMethod("GET");
            // 设置是否使用缓存
            httpURLConnection.setUseCaches(true);
            // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
            httpURLConnection.setInstanceFollowRedirects(true);
            // 设置超时时间
            httpURLConnection.setConnectTimeout(3000);
            // 连接
            httpURLConnection.connect();
            // 4. 得到响应状态码的返回值 responseCode
            int code = httpURLConnection.getResponseCode();
            // 5. 如果返回值正常，数据在网络中是以流的形式得到服务端返回的数据
            String msg = "";
            if (code == 200) { // 正常响应
                // 从流中读取响应信息
                BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String line = null;
                while ((line = reader.readLine()) != null) { // 循环从流中读取
                    msg += line + "\n";
                }
                reader.close(); // 关闭流
                return msg;
            }
            // 显示响应结果
        } catch (IOException e) {

        }finally {
            // 6. 断开连接，释放资源
            if (null != httpURLConnection){
                try {
                    httpURLConnection.disconnect();
                }catch (Exception e){

                }
            }
        }
        return "";
    }

    public void doPost() {
        HttpURLConnection httpURLConnection = null;
        try {
            // 1. 获取访问地址URL
            URL url = new URL("http://127.0.0.1:8001/postEcho?name=123");
            // 2. 创建HttpURLConnection对象
            httpURLConnection = (HttpURLConnection) url.openConnection();
            /* 3. 设置请求参数等 */
            // 请求方式  默认 GET
            httpURLConnection.setRequestMethod("POST");
            // 超时时间
            httpURLConnection.setConnectTimeout(3000);
            // 设置是否输出
            httpURLConnection.setDoOutput(true);
            // 设置是否读入
            httpURLConnection.setDoInput(true);
            // 设置是否使用缓存
            httpURLConnection.setUseCaches(false);
            // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
            httpURLConnection.setInstanceFollowRedirects(true);
            // 设置请求头
            httpURLConnection.addRequestProperty("name","weiwei");
            // 设置使用标准编码格式编码参数的名-值对
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // 连接
            httpURLConnection.connect();
            /* 4. 处理输入输出 */
            // 写入参数到请求中
            String params = "username=test&password=123456";
            OutputStream out = httpURLConnection.getOutputStream();
            out.write(params.getBytes());
            // 简化
            //httpURLConnection.getOutputStream().write(params.getBytes());
            out.flush();
            out.close();
            // 从连接中读取响应信息
            String msg = "";
            int code = httpURLConnection.getResponseCode();
            if (code == 200) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(httpURLConnection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    msg += line + "\n";
                }
                reader.close();
            }
            // 处理结果
        } catch (IOException e) {

        }finally {
            // 5. 断开连接
            if (null != httpURLConnection){
                try {
                    httpURLConnection.disconnect();
                }catch (Exception e){

                }
            }
        }
    }




    public static void main(String[] args) throws Exception {
        HttpUrlConnectionDemo demo = new HttpUrlConnectionDemo();
        String result =  demo.doGet("http://127.0.0.1:8001/echo?name=123");
        demo.doPost();
    }

}
