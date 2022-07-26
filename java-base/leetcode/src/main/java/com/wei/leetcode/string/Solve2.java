package com.wei.leetcode.string;


import java.util.Arrays;

public class Solve2 {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bca";
        Solve2 solve1 = new Solve2();
        Boolean result = solve1.CheckPermutation(s1,s2);
        System.out.println(result);
    }

    public boolean CheckPermutation(String s1, String s2) {
        char [] s1c = s1.toCharArray();
        char [] s2c = s2.toCharArray();
        Arrays.sort(s1c);
        Arrays.sort(s2c);
        if (s1c.length != s2c.length){
            return false;
        }
        for (int i = 0; i < s1c.length; i++) {
            if (s1c[i] != s2c[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * > 2022/07/26 10:21:24
     * 解答成功:
     * 	执行耗时:0 ms,击败了100.00% 的Java用户
     * 	内存消耗:39.5 MB,击败了10.33% 的Java用户
     * */
}
