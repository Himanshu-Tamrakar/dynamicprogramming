package com.ht.algorithms.chapter1;

public class ChapterOne {
    public static int[] sumPreviousIndex(int[] arr) {
        return sumPreviousIndex(arr, 1);
    }
    public static int[] sumPreviousIndex(int[] arr, int index) {
        if(arr.length <= index || index < 0)  return arr;
        arr[index] += arr[index-1];
        sumPreviousIndex(arr, ++index);
        return arr;
    }

    public static void toworOfHanoi(char S, char D, char E, int N) {
        if(N <= 0) return;
        toworOfHanoi(S, E, D, N-1);
        System.out.printf("Move %d from %c to %c \n", N, S, D);
        toworOfHanoi(E, D, S, N-1);
    }

    public static void  printTable(int n) {
        printTable(n, 10);
    }
    public static void printTable(int n, int i) {
        if(i > 0) {
            printTable(n, i-1);
            System.out.printf("%d * %d = %d \n", n, i, n*i);
        }
    }

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
