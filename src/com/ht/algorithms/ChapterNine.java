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

    /**
     * Given a 2-dim grid where there is a horizontal and a vertical road after each kilo meter as shown in Picture 9.7.
     * Dotted lines show the roads. You are at the origin (0,0) , and want to go to a point (x,y) .
     * @return
     */
    public static int totalUniqueWays(int row, int col, boolean[][] workInProgress) {
        if(row == 0 && col == 0) return 0;
        if(row == 0 || col ==0) return 1;

        return totalUniqueWays(row-1, col, workInProgress) + totalUniqueWays(row, col-1, workInProgress);
    }

    /**
     * Given a 2-dim grid where there is a horizontal and a vertical road after each kilo meter as shown in Picture 9.7.
     * Dotted lines show the roads. You are at the origin (0,0) , and want to go to a point (x,y) .
     *
     * Include diagonal path too
     * @return
     */
    public static int totalUniqueWays(int row, int col) {
        if(row == 0 && col == 0) return 0;
        if(row == 0 || col == 0) return 1;
        if(row == 1 && col == 1) return 3;

        return totalUniqueWays(row-1, col) + totalUniqueWays(row, col-1) + totalUniqueWays(row-1, col-1);
    }


    /**
     * This method is incplete only covers for king move in chess
     * @param sr
     * @param sc
     * @param dr
     * @param dc
     * @return
     */
    public static int minMoves(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc) return 0;
        if(sr < 0 || sc < 0 || sr > 7 || sc > 7) return 0;
        if(dr > sr) {
            return 1 + min(minMoves(sr+1, sc-1, dr, dc), minMoves(sr+1, sc, dr, dc), minMoves(sr+1, sc+1, dr,dc));
        } else if(dr < sr) {
            return 1 + min(minMoves(sr-1, sc-1, dr, dc), minMoves(sr-1, sc, dr, dc), minMoves(sr-1, sc+1, dr, dc));
        } else {
            if(sc > dc) return 1 + minMoves(sr, sc-1, dr, dc);
            else return 1 + minMoves(sr, sc+1, dr, dc);
        }
    }

    /*------------------------------------------------------------------------------------------------------------------------------*/

    /**
     * String C is said to be interleaving of string A and B if it contains all the characters of A and B and
     * the relative order of characters of both the strings is preserved in C .
     * For example, if values of A , B and C are as given below.
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static boolean checkInterleave(String a, String b, String c, int l1, int l2, int l3) {
        if(c.length()-l3 != ((a.length()-l1) + (b.length()-l2))) return false;
        if(l1 == a.length() && l2 == b.length() && l3 == c.length()) return true;

        boolean resultA = false;
        boolean resultB = false;
        if(l1 < a.length() && a.charAt(l1) == c.charAt(l3)) resultA =  checkInterleave(a,b,c, l1+1, l2, l3+1);
        if(l2 < b.length() && b.charAt(l2) == c.charAt(l3)) resultB =  checkInterleave(a,b,c,l1,l2+1, l3+1);
        return resultA || resultB;
    }


    public static boolean isSubset(int[] arr, int i, int x) {
        if(x==0) return true;
        if(i == arr.length) return false;

        if(arr[i] > x) return isSubset(arr, i+1, x);

        return isSubset(arr, i+1, x) || isSubset(arr, i+1, x-arr[i]);
    }

    public static boolean isSubsetDP(int[] arr, int n, int x) {
        boolean[][] MAT = new boolean[n][x+1];

        for (int i = 0; i < n; i++) {
            MAT[i][0] = true;
        }

        if(arr[0] <= x) MAT[0][arr[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= x; j++) {
                if(arr[i] == j || MAT[i-1][j]) MAT[i][j] = true;
                else if(j > arr[i] && MAT[i-1][j-arr[i]]) MAT[i][j] = true; //tricky one means go and check one above row with currrent col-arr[i]
            }
        }
        return MAT[n-1][x];
    }

    public static int longestCommonSubsequence(String s1, String s2, int m, int n) {
//        if(m == 0 || n == 0) return 0;
//        if(s1.charAt(m-1) == s2.charAt(n-1)) return 1 + longestCommonSubsequence(s1, s2, m-1, n-1);
//        else return Math.max(longestCommonSubsequence(s1, s2, m, n-1), longestCommonSubsequence(s1,s2, m-1, n));

            int[][] mem = new int[m+1][n+1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    mem[i][j] = -1;
                }
            }

            return lcs(s1,s2,mem,m, n);
    }

    public static int lcs(String s1, String s2, int[][] MEM, int m, int n) {
        if(m == 0 || n == 0) return 0;

        if(MEM[m][n] != -1) {
            return MEM[m][n];
        }

        if(s1.charAt(m-1) == s2.charAt(n-1)) MEM[m][n] = 1 + lcs(s1, s2, MEM, m-1, n-1);
        else MEM[m][n] = Math.max(lcs(s1,s2,MEM, m, n-1), lcs(s1,s2, MEM, m-1, n));

        return MEM[m][n];
    }

    public static int lcsDP(String s1, String s2, int m ,int n) {
        if( m == 0 || n == 0) return 0;

        int[][] lscCount = new int[m+1][n+1];
        // 000
        // 0
        // 0
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) lscCount[i][j] = 1 + lscCount[i-1][j-1];
                else lscCount[i][j] = Math.max(lscCount[i][j-1], lscCount[i-1][j]);
            }
        }

        printlcsDP(lscCount, s1, s2, s1.length(), s2.length());
        System.out.println();
        return lscCount[m][n];
    }

    private static void printlcsDP(int[][] lcsCount, String s1, String s2,  int m, int n) {
        int i = m;
        int j = n;

        while( i > 0 && j > 0) {
            if(s1. charAt(i-1) == s2.charAt(j-1))  {
                System.out.print(s1.charAt(i-1) );
                i--;
                j--;
            } else {
                if(lcsCount[i-1][j] > lcsCount[i][j-1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
    }
}
