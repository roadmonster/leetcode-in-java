package com.java.L4MedianOfTwoSortedArray;

public class Solution {
    public static void main(String[] args) {
        System.out.println("median is : " + findMedian(new int[]{1,3}, new int[]{2}));

    }
    public static double findMedian(int[]nums1, int[]nums2){
        int lo = 0, hi = nums1.length, combinedLen = nums1.length + nums2.length;
        while(lo <= hi){
            int part1 = (lo + hi) / 2;
            int part2 = (combinedLen + 1) / 2 - part1;

            int left1 = part1 == 0 ? Integer.MIN_VALUE: nums1[part1-1];
            int left2 = part2 == 0 ? Integer.MIN_VALUE: nums2[part2-1];
            int right1 = part1 == nums1.length ? Integer.MAX_VALUE:nums1[part1];
            int right2 = part2 == nums2.length ? Integer.MAX_VALUE:nums2[part2];

            if(left1 <= right2 && right1 >= left2){
                if(combinedLen % 2 == 0){
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }else{
                    return (double)Math.max(left1, left2);
                }
            }else if(left1 > right2){
                hi = part1-1;
            }else if(right1 < left2){
                lo = part1 + 1;
            }
        }
        return -1.0;
    }
}
