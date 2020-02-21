package com.ht.algorithms;

import netscape.security.UserTarget;

public class Main {

    public static void main(String[] args) {
//        int[][] cost = {
//                {1,3,5,8},
//                {4,2,1,7},
//                {4,3,2,3}
//        };
//        System.out.println(ChapterEight.minPathCost3Way(cost));
//        System.out.println(ChapterSIX.maxSubStringLengthDP("142124"));

//        int[][] arr = new int[][] {
//                {0, 10, 75, 94},
//                {-1, 0, 35, 50},
//                {-1, -1, 0, 80},
//                {-1, -1, -1, 0}
//        };
//        System.out.println(ChapterSIX.costBetweenStation(arr));
//        System.out.println(ChapterEight.waysToScoreDPUnique(13));
//            int[] a = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};
//            System.out.println(ChapterEight.maxSubArraySumDP(a));

//        System.out.println(ChapterNine.numberOfPathsDP(2, 3));
//        boolean[][] workInProgress = new boolean[][] {
//                {false, false},
//                {false, false}
//        };
//        System.out.println(ChapterNine.totalUniqueWays(2, 1, workInProgress));

//        System.out.println(ChapterNine.minMoves(3, 4,3,6));
//          System.out.println(ChapterNine.checkInterleave("bcc", "bbca", "bbcbcac", 0,0,0));
        System.out.println(ChapterNine.lcsDP("AAACCGTGAGTTATTCGTTCTAGAA", "CACCCCTAAGGTACCTTTGGTTC", "AAACCGTGAGTTATTCGTTCTAGAA".length(), "CACCCCTAAGGTACCTTTGGTTC".length()));
//        System.out.println(ChapterNine.lcsDP("ABCD", "AEBD", 4, 4));
    }







}
