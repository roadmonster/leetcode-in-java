package com.java.demolition_robot;


import java.util.*;

/**
 * Demolition Robot
 * Given a matrix with values 0 (trenches) , 1 (flat) , and 9 (obstacle) you have to find minimum distance to reach 9 (obstacle). If not possible then return -1.
 * The demolition robot must start at the top left corner of the matrix, which is always flat, and can move on block up, down, right, left.
 * The demolition robot cannot enter 0 trenches and cannot leave the matrix.
 * Sample Input :
 * [1, 0, 0],
 * [1, 0, 0],
 * [1, 9, 1]]
 * Sample Output :
 * 3
 */
public class Solution {
    int[][]matrix;
    public int findMinDistance(int[][]matrix){
        if(matrix == null || matrix.length == 0 )
            return -1;
        this.matrix = matrix;
        int[][]neighbors = new int[][]{{0,1}, {0, -1},{1, 0}, {-1, 0}};
        Queue<int[]>q = new LinkedList<>();
        q.offer(new int[]{0,0,0});


        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(matrix[curr[0]][curr[1]] == 9)
                return curr[2];
            else
                matrix[curr[0]][curr[1]] = 0;
            for(int[]n: neighbors){
                int x = curr[0] + n[0];
                int y = curr[1] + n[1];
                if(isValidNeighbor(x, y)){
                    q.offer(new int[]{curr[0] + n[0], curr[1] + n[1], curr[2] + 1});
                }
            }
        }

        return -1;
    }
    private boolean isValidNeighbor(int i, int j){
        int m = matrix.length;
        int n = matrix[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] == 0){
            return false;
        }
        return true;

    }

    public static void main(String... args) {
        int[][] maze = {
                {1,1,0,0,0},
                {0,1,0,0,0},
                {0,1,0,0,0},
                {0,1,1,9,0},
                {0,0,0,0,0},
        };
        System.out.println(new Solution().findMinDistance(maze));
    }




}
