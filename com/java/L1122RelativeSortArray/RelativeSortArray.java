package com.java.L1122RelativeSortArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2){
        int[] result = new int[arr1.length];
        Map<Integer, Integer>map = new HashMap<>();
        ArrayList<Integer> leftOver = new ArrayList<>();

        for(int i = 0; i < arr2.length; i++){
            map.put(arr2[i], 0);
        }

        for(int j = 0; j < arr1.length; j++){
            if(map.containsKey(arr1[j])){
                map.put(arr1[j], map.get(arr1[j]) + 1);
            }else{
                leftOver.add(arr1[j]);
            }
        }

        int i = 0, index = 0;
        while(i < result.length && index < arr2.length){
            int count = map.get(arr2[index]);
            while(count > 0){
                result[i++] = arr2[index];
                count--;
            }
            index++;
        };

        if(leftOver.size() > 0){
            int j = 0;
            while(j < leftOver.size()){
                result[i++] = leftOver.get(j++);
            }
        }

        return result;
    }

    public void printResult(int[] result){
        System.out.println("This is the result ");
        for(int res: result){
            System.out.print(res + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[]arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[]arr2 = {2,1,4,3,9,6};
        RelativeSortArray r = new RelativeSortArray();
        r.printResult(r.relativeSortArray(arr1, arr2));
    }
}
