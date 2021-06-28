package com.java.optimal_utilization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReviseSolution {
    public List<int[]> optimizedPair(List<int[]>a, List<int[]>b, int target){
        Collections.sort(a, (i,j) -> i[1] - j[1]);
        Collections.sort(b, (i,j) -> i[1] - j[1]);
        int m = a.size(), n = b.size();
        int i = 0, j = n -1, max = Integer.MIN_VALUE;
        List<int[]>ret = new ArrayList<>();
        while(i < m && j >= 0){
            int sum = a.get(i)[1] + b.get(i)[1];
            if(sum > target){
                j--;
            }
            else{
                if(sum < target) {
                    if (sum > max) {
                        max = sum;
                        ret.clear();

                    }
                }
                ret.add(new int[]{a.get(i)[0], b.get(j)[0]});
                int index = j -1;
                while(index >=0 && b.get(j)[1] == b.get(index)[1]){
                    ret.add(new int[]{a.get(i)[0], b.get(index)[0]});
                    index--;
                }
                i++;
            }
        }
        return ret;
    }
}
