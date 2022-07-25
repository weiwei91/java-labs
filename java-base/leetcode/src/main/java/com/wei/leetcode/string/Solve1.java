package com.wei.leetcode.string;


import java.util.Arrays;

public class Solve1 {

    public static void main(String[] args) {
        String test = "wdgoiws";
        Solve1 solve1 = new Solve1();
        Boolean result = solve1.isUnique(test);
        System.out.println(result);
    }

    public  boolean isUnique(String astr) {
        char [] temp = astr.toCharArray();
        Arrays.sort(temp);
        int length = temp.length;
        if (length < 2){
            return true;
        }

        for (int i = 0; i < temp.length-1; i++) {
            if (temp[i] == temp[i+1]){
                return false;
            }
        }
        return true;
    }

    /**
     * > 2022/07/25 21:11:05
     * 解答成功:
     * 	执行耗时:0 ms,击败了100.00% 的Java用户
     * 	内存消耗:39.3 MB,击败了33.18% 的Java用户
     * */
}
