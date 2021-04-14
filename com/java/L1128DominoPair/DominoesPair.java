package com.java.L1128DominoPair;

import java.util.HashMap;
import java.util.Map;

public class DominoesPair {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int[]domino: dominoes){
            int min = Math.min(domino[0], domino[1]);
            int max = Math.max(domino[0], domino[1]);
            int res = min * 10 + max;
            count.put(res, count.getOrDefault(res, 0) + 1);
        }
        int result = 0;
        for(int num: count.values()){
            result += num * (num - 1) / 2;
        }
        return result;
    }

    public void printResult(int num){
        System.out.println("The result is " + num);
    }

    public static void main(String[] args) {
        int[][] dominoes= new int[4][2];
        dominoes[0] = new int[]{1, 2};
        dominoes[1] = new int[]{2, 1};
        dominoes[2] = new int[]{3, 4};
        dominoes[3] = new int[]{5, 6};

        DominoesPair d = new DominoesPair();
        d.printResult(d.numEquivDominoPairs(dominoes));
    }
}
