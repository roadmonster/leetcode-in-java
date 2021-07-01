package com.java.L1TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[]nums = {2, 3, 4, 5};
        int target = 9;
        printArr(twoSum(nums, target));
    }

    public static void printArr(int[]nums){
        if(nums.length == 0)
            System.out.println("no result");
        for(int i: nums){
            System.out.print(i + " ");
        }
    }

    public static int[] twoSum(int[]nums, int target){
        Map<Integer, Integer>map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];

    }


}
