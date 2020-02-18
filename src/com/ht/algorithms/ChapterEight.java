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

    /**
     * Given an empty plot of size 2 x n . We want to place tiles such that the entire plot is covered. Each tile is of size
     * 2 x 1 and can be placed either horizontally or vertically. If n is 5 , then one way to cover the plot
     * Write a function that accept n as input and return the total number of ways in which we can place the tiles (without breaking any tile).
     *
     * https://math.stackexchange.com/questions/664113/count-the-ways-to-fill-a-4-times-n-board-with-dominoes
     * @param n
     * @return
     */
    public static int countWays(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        return countWays(n-1) + countWays(n-2);
    }

    public static int countWaysFor3Row(int n) {
        if(n == 0) return 0;
        if(n == 1) return 0;
        if(n == 2) return 3;

        return countWaysFor3Row(n-2) * 3;
    }

    /**
     * Consider a game where a player can score 3, 5 or 10 points in one move. Given a total score N ,
     * find the total number of unique ways to reach a score of N .
     * @param n
     * @return
     */
    public static int waysToScore(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        return waysToScore(n-3) + waysToScore(n-5) + waysToScore(n-10);
    }

    public static int waysToScoreDP(int n) {
        int[] count = new int[n+1];
        count[0] = 1;
        for (int i = 1; i < count.length; i++) {
            if(i-3 >= 0) count[i] += count[i-3];
            if(i-5 >= 0) count[i] += count[i-5];
            if(i-10 >= 0) count[i] += count[i-10];
        }
        return count[count.length-1];
    }

    /**
     * What is the total number of ways to reach a particular score if (10, 3) and (3, 10) same
     * @param n
     * @return
     */
    public static int waysToScoreDPUnique(int n) {
        int[] count = new int[n+1];

        count[0] =  1;
        for (int i = 3; i < count.length; i++) {
            count[i] += count[i-3];
        }
        for (int i = 5; i < count.length; i++) {
            count[i] += count[i-5];
        }

        for (int i = 10; i < count.length; i++) {
            count[i] += count[i-10];
        }

        return count[count.length-1];
    }


    /**
     * Given an array of integers, write a function that
     * returns the maximum sum of sub array, such that elements are contiguous.
     */

    public static int maxSubArraySum(int[] a) {
        int max = Integer.MIN_VALUE;
        int tempMax;
        for (int i = 0; i < a.length; i++) {
            tempMax = a[i];
            for (int j = i+1; j < a.length; j++) {
                tempMax += a[j];
                if(tempMax > max) max = tempMax;
            }
        }
        return max;
    }

    public static int maxSubArraySumDP(int[] a) {
        int maxSum = 0;
        int maxSumSoFar = 0;
        for (int i = 0; i < a.length; i++) {
            maxSumSoFar += a[i];
            if(maxSumSoFar < 0) maxSumSoFar = 0;
            if(maxSum < maxSumSoFar) maxSum = maxSumSoFar;
        }

        return maxSum;
    }


}
