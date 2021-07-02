package com.java.L42TrappingRain;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        int[]cols = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(cols));
    }

    public static int trap(int[]cols){
        if(cols.length < 3)
            return -1;
        int total = 0;
        Deque<Integer>st = new ArrayDeque<>();
        // calculate volumne of water vertically, line by line, single out 2 cols each time
        // pop one then peek the other one, if empty after popping, add the current index
        // works like erase the left bars
        // each round total += (current index - 1 - peeked index)*(min(current col, left col) - col[popped col])

        for(int i = 0; i < cols.length; i++){
            while(!st.isEmpty() && cols[st.peek()] < cols[i]){
                int curr = st.pop();
                if(st.isEmpty())
                    break;
                int left = st.peek();
                total += (i - 1 - left) * (Math.min(cols[i], cols[left]) - cols[curr]);

            }
            st.push(i);
        }
        return total;

    }
}
