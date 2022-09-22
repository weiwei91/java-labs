package com.wei.leetcode.string;


import java.util.Arrays;

public class Solve4 {

    public static void main(String[] args) {
        int [] a = {0,0,1,1,1,2,2,3,3,4};
        Solve4 solve1 = new Solve4();
        int result = solve1.removeDuplicates(a);
        System.out.println(result);
    }

    public int removeDuplicates(int[] nums) {
        int duplicates = 0;
        for (int i = 0; i < nums.length-1; i++) {
            int flagBegin = nums[i];
            for (int j = i+1; j < nums.length ; j++) {
                int flagEnd = nums[j];
                if (flagEnd!=-1){
                    if (flagEnd == flagBegin){
                        nums[j] = -1;
                        duplicates++;
                    }
                }
            }
        }
        movePosition(nums);
        return nums.length-duplicates;
    }

    public void movePosition(int[] nums){
        int beginIndex = 0;
        int endIndex = nums.length-1;
        while (beginIndex<=endIndex){
            if(nums[beginIndex]==-1){
                int t = nums[beginIndex];
                nums[beginIndex]=nums[endIndex];
                nums[endIndex]=t;
                endIndex--;
            }else {
                beginIndex++;
            }
        }

    }


    /**
     * 	优秀的算法确实能成倍的提高运行效率
     *
     * */
}
