package com.java.L15ThreeSum;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[]nums ={-1,0,1,2,-1,-4};
        for(List<Integer>ls: threeSum(nums)){
            System.out.println(ls.toString());
        }
    }

    public static List<List<Integer>> threeSum(int[]nums){
        if(nums.length < 3)
            return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>>ret = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
                break;
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            helper(i, nums, ret);
        }
        return ret;

    }

    private static void helper(int i, int[] nums, List<List<Integer>>ret){
        Set<Integer>mySet = new HashSet<>();
        for(int j = i + 1; j < nums.length; j++){
            int sum = nums[i] + nums[j];
            if(mySet.contains(-(sum))){
                ret.add(Arrays.asList(nums[i], nums[j], -(sum)));
                // fixed bug here, make sure the repeats detection within the
                // already test triplet
                while(j < nums.length-1 && nums[j] == nums[j+1]){
                    j++;
                }
            }

            mySet.add(nums[j]);
        }
    }

}
