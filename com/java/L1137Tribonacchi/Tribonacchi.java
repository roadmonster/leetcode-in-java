package com.java.L1137Tribonacchi;

public class Tribonacchi {
    public int tribonacchi(int n){
        if(n <=2){
            return n == 0? 0:1;
        }
        int t0 = 0, t1 = 1, t2 = 1;
        int temp = 0;
        for(int i = 3; i < n + 1; i++){
            temp = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        Tribonacchi t = new Tribonacchi();
        System.out.println(t.tribonacchi(5));
    }
}
