package com.ht.algorithms;

public class ChapterEight {
    public static int minCost(int[][] cost) {
        int r = cost.length-1;
        int c = cost[0].length-1;
        return minCost(cost, r,c, new int[r+1][c+1]);
    }
    public static int minCost(int[][] cost, int m, int n, int[][] MEM) {
        if(MEM[m][n] != 0) return MEM[m][n];
        if(m == 0 && n == 0) MEM[m][n] =  cost[m][n];
        else if(m == 0) MEM[m][n] = cost[0][n] + minCost(cost, m, n - 1, MEM);
        else if(n == 0) MEM[m][n] = cost[m][0] + minCost(cost, m-1, n, MEM);
        else {
            int b = minCost(cost, m-1, n, MEM);
            int a = minCost(cost, m, n-1, MEM);

            MEM[m][n] = cost[m][n] + getMin(a,b);
        }
        return MEM[m][n];
    }

    static int getMin(int a, int b) {
        return a < b ? a : b;
    }

    public static int minPathCost(int[][] cost) {
        for (int i = 1; i < cost[0].length; i++) {
            cost[0][i] += cost[0][i-1];
        }

        for (int i = 1; i < cost.length; i++) {
            cost[i][0] += cost[i-1][0];
        }

        for (int i = 1; i < cost.length; i++) {
            for (int j = 1; j < cost[0].length; j++) {
                cost[i][j] += getMin(cost[i-1][j], cost[i][j-1]);
            }
        }
        return cost[cost.length-1][cost[0].length-1];
    }

    static int getMin(int a, int b, int c) {
        if(a <= b && a <= c) return a;
        else if(b <= a && b <= c) return b;
        else return c;
    }
    public static int minPathCost3Way(int[][] cost) {
        for (int i = 1; i < cost[0].length; i++) {
            cost[0][i] += cost[0][i-1];
        }

        for (int i = 1; i < cost.length; i++) {
            cost[i][0] += cost[i-1][0];
        }

        for (int i = 1; i < cost.length; i++) {
            for (int j = 1; j < cost[0].length; j++) {
                cost[i][j] += getMin(cost[i-1][j], cost[i][j-1], cost[i-1][j-1]);
            }
        }
        return cost[cost.length-1][cost[0].length-1];
    }
}
