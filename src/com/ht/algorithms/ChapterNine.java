package com.ht.algorithms;

public class ChapterNine {

    public static int editDistance(String s1, String s2, int m, int n) {
        if(m == 0) return n;
        if(n == 0) return m;

        if(s1.charAt(m-1) == s2.charAt(n-1)) return editDistance(s1, s2, m-1, n-1);

        return 1 + min(editDistance(s1, s2, m, n-1), editDistance(s1, s2, m-1, n), editDistance(s1, s2, m-1, n-1));
    }

    static int min(int a, int b, int c) {
        if(a <= b && a <= c) return a;
        else if(b <= a && b <= c) return b;
        else return c;
    }
    
    public static int editDistanceDP(String s1, String s2, int m, int n) {
        int[][] mem = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            mem[i][0]=i;
        }

        for (int i = 0; i <= n; i++) {
            mem[0][i]=i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) mem[i][j]=mem[i-1][j-1];
                else mem[i][j] = 1 + min(mem[i][j-1], mem[i-1][j], mem[i-1][j-1]);
            }
        }

        return mem[m][n];
    }


    public static int editDistanceDPMemImprovement(String s1, String s2, int m, int n) {
        int[][] MEM = new int[2][n+1];

        for (int i = 0; i <= n; i++) {
            MEM[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(j == 0) MEM[0][i] = i;
                else if(s1.charAt(i-1) == s2.charAt(j-1)) MEM[i%2][j] = MEM[(i-1)%2][j-1];
                else MEM[i % 2][j] = 1 + min(MEM[i % 2][j-1], MEM[(i - 1) % 2][j], MEM[(i - 1) % 2][j-1]);
            }
        }
        return MEM[m%2][n];
    }

    /**
     * Given a two dimensional array, find total number of paths possible from top-left cell to bottom-right cell
     * if we are allowed to move only rightward and downward. For example,
     * if matrix is of order 2*2 , then only two paths are possible
     * @param r
     * @param c
     * @return
     */
    public static int numberOfPaths(int r, int c) {
        if(r == 0 && c == 0) return 0;
        if(r == 0 || c == 0) return 1;

        return numberOfPaths(r-1, c) + numberOfPaths(r, c-1);
    }

    public static int numberOfPathsDP(int r, int c) {
        int[][] a = new int[r+1][c+1];

        for (int i = 0; i <= c; i++) {
            a[0][i] = 1;
        }

        for (int i = 0; i <= r; i++) {
            a[i][0] = 1;
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                a[i][j] = a[i-1][j] + a[i][j-1];
            }
        }
        return a[r][c];
    }
}
