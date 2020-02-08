package com.ht.algorithms.chapter1;

public class Factorial {
    public static int factIterative(int n) {
        if(n > 30) return -1;

        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }

    public static int factRecursive(int n) {
        if(n > 20) return -1;
        if(n <= 0) return 0;
        if(n == 1) return 1;

        return n * factRecursive(n-1);
    }


}
