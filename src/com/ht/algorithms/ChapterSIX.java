package com.ht.algorithms;

public class ChapterSIX {
    public static int costBetweenStation(int[][] cost){
        int N = cost.length;
        int[] minCost = new int[N];
        minCost[1] = cost[0][1];

        for (int i = 2; i < N; i++) {
            minCost[i] = cost[0][i];

            for (int j = 1; j < i; j++) {
                if(minCost[i] > minCost[j] + cost[j][i]) minCost[i] = minCost[j] + cost[j][i];
            }
        }

        return minCost[N-1];
    }

    public static boolean isSame(String s) {
        int firstHalfSum = 0;
        int secondHalfSum = 0;
        for (int i = 0, j = s.length()-1; i < j; i++, j--) {
            firstHalfSum += Character.getNumericValue(s.charAt(i));
            secondHalfSum += Character.getNumericValue(s.charAt(j));
        }

        return firstHalfSum == secondHalfSum;
    }

    /**
     * Find length of longest substring of a given string of digits,
     * such that sum of digits in the first half and second half of the substring is same.
     * @param s
     * @return
     */
    public static int bruteForceMaxSubstringLength(String s) {
        int step = 2;
        int length = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+step; j <= s.length(); j += step) {
                if(length < (j-i) && isSame(s.substring(i, j))) {
                    length = j-i;
                    step = length;
                }
            }
        }
        return length;
    }

    public static int maxSubStringLengthDP(String s) {
        int n = s.length();
        int[] arr = new int[n];
        arr[0] = Character.getNumericValue(s.charAt(0));
        for (int i = 1; i < n; i++) arr[i] = Character.getNumericValue(s.charAt(i)) + arr[i-1];

        for (int i = s.length(); i > 1; i--) {
            if(i % 2 == 0) {
                for (int j = 0; j <= n-i; j++) {
                        int mid = j + i / 2 - 1;
                        int last = i + j -1;
                        int firstHalfSum = 0;
                        if(j == 0) firstHalfSum = arr[mid];
                        else firstHalfSum = arr[mid] - arr[j-1];
                        int secondHalfSum = arr[last] - arr[mid];

                        if(firstHalfSum == secondHalfSum) return i;
                }
            }

        }
        return -1;
    }


}
