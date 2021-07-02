package com.java.L56MergeInterval;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        int[][]intervals = {{1,3},{2,6},{8,10},{15,18}};
        for(int[]r: merge(intervals)){
            System.out.println("["+ r[0]+ " "+ r[1]+"]");
        }
    }

    public static int[][] merge(int[][]intervals) {
        PriorityQueue<int[]>pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
        for(int[]i:intervals){
            pq.offer(i);
        }
        List<int[]> ret = new ArrayList<>();
        while(!pq.isEmpty()){
            int[]first = pq.poll();
            int[]second = pq.peek();
            if(second != null && first[1] >= second[0]){
                pq.poll();
                pq.offer(new int[]{first[0], Math.max(first[1], second[1])});
            }else{
                ret.add(first);
            }
        }
        return ret.toArray(new int[ret.size()][]);

    }

}
