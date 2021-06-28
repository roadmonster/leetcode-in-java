package com.java.optimal_utilization;

/*
 * Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and
 * the second integer represents a value.
 * Your task is to find an element from a and an element form b such that the sum of their values is less or equal to
 * target and as close to target as possible.
 * Return a list of ids of selected elements.
 * If no pair is possible, return an empty list.
 *
 * Example 1:
 *
 * Input:
 * a = [[1, 2], [2, 4], [3, 6]]
 * b = [[1, 2]]
 * target = 7
 *
 * Output: [[2, 1]]
 *
 * Explanation:
 * There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
 * Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
 */
import java.util.*;
public class Solution {
    public List<int[]> optimal(int[][]a, int[][]b, int target){
        List<int[]>ret = new ArrayList<>();
        if(a == null || b == null || a.length == 0 || b.length == 0){
            return ret;
        }
        Map<Integer, List<Integer>>map = new HashMap<>();
        for(int[]elem: a){
            List<Integer>temp = map.getOrDefault(elem[1], new ArrayList<>());
            temp.add(elem[0]);
            map.put(elem[1], temp);
        }
        int max = Integer.MIN_VALUE;
        for(int[] elem: b){
            for(int k: map.keySet()){
                int sum = k + elem[1];
                if(sum == target && max != target){
                    ret.clear();
                    max = target;
                    for(int i : map.get(k)){
                        ret.add(new int[]{elem[0],i });
                    }

                }
                else if(sum < target && max < target){
                    if(sum > max){
                        max = sum;
                        ret.clear();
                        for(int i : map.get(k)){
                            ret.add(new int[]{elem[0],i });
                        }

                    }else if( sum == max){
                        for(int i : map.get(k)){
                            ret.add(new int[]{elem[0],i });
                        }
                    }
                }
            }
        }
        return ret;
    }

    // O(N^2)
}
