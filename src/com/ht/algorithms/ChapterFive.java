package com.ht.algorithms;

public class ChapterFive {
    public static int nthFabonacci(int n) {
        return memoizedNthFabonacci(n, new int[n+1]);
    }

    static int memoizedNthFabonacci(int n, int[] cache) {

        if(cache[n] != 0) return cache[n];
        if(n == 1 || n == 2) cache[n] = 1;
        else cache[n] = memoizedNthFabonacci(n-1, cache) + memoizedNthFabonacci(n-2, cache);
        return cache[n];
    }

    public static int costBetweenStation(int[][] cost){
        return calculateMinCost(cost, 0, cost[0].length-1, new int[cost.length][cost[0].length]);
    }

    public static int calculateMinCost(int[][] cost, int s, int d, int[][] cache) {
        if(s == d || s == d-1) return cost[s][d];


        if(cache[s][d] == 0) {
            int minCost = cost[s][d];

            for (int i = s+1; i < d; i++) {
                int temp = calculateMinCost(cost, s, i, cache) + calculateMinCost(cost, i, d, cache);
                if(temp < minCost) minCost = temp;
            }

            cache[s][d] = minCost;
        }
        return cache[s][d];
    }
}
