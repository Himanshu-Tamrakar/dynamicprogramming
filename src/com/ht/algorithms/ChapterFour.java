package com.ht.algorithms;

public class ChapterFour {
    /**
     * There are N stations in a route, starting from 0 to N-1 .
     * A train moves from first station (0) to last station (N-1) in only forward direction.
     * The cost of ticket between any two stations is given,
     * Find the minimum cost of travel from station 0 to station N-1 .
     * @return minimum cost
     */
    public static int costBetweenStation(int[][] cost) {
        return calculateMinCost(cost, 0, cost[0].length-1);
    }

    public static int calculateMinCost(int[][] cost, int s, int d) {
        if(s == d || s == d-1) return cost[s][d];

        int minCost = cost[s][d];

        for (int i = s+1; i < d; i++) {
            int temp = calculateMinCost(cost, s, i) + calculateMinCost(cost, i, d);
            if(temp < minCost) minCost = temp;
        }

        return minCost;
    }


    /**
     * Given a matrix of order N*N .
     * What are the total number of ways in which we can move from the top-left cell ( arr[0][0] ) to
     * the bottom-right cell ( arr[N-1][N-1] ), given that we can only move either downward or rightward?
     */
}

