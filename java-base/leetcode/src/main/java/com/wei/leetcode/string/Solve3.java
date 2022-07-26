package com.wei.leetcode.string;



public class Solve3 {

    public static void main(String[] args) {
        String s1 = "          ";
        String s2 = "wei wei  ";
        Solve3 solve1 = new Solve3();
        String result = solve1.replaceSpaces(s1,5);
        System.out.println(result);
    }

    public String replaceSpaces(String s, int length) {
        String s1 = myTrim(s,length);
        char [] s1c = s1.toCharArray();
        if (s1c.length==0){
            return rt(length);
        }else {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s1c.length; i++) {
                if (s1c[i] == ' '){
                    result.append("%20");
                }else {
                    result.append(s1c[i]);
                }
            }
            return result.toString();
        }

    }
    //[非全空的情况下]去掉尾部空格
    public String myTrim(String s,int length){
        if (s == null || s.length()<1){
            return s;
        }
        char [] sc = s.toCharArray();
        int emptyFlag = sc.length-1;
        for (int i = emptyFlag; i >=0; i--) {
            if (sc[i] != ' '){
                emptyFlag = i;
                break;
            }
        }
        //字符串全是空白
        if (emptyFlag == sc.length-1 && length< sc.length){
            return s.substring(0,length);
        }else {
            //字符串不是全空白
            return s.substring(0,emptyFlag+1 > length ? emptyFlag+1 : length);
        }
    }

    public String rt(int size){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("%20");
        }
        return sb.toString();
    }

    /**
     > 2022/07/26 20:17:44
     解答成功:
     执行耗时:22 ms,击败了19.32% 的Java用户
     内存消耗:49.5 MB,击败了8.81% 的Java用户
     * */
}
