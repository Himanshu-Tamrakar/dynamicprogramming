package com.ht.algorithms;

import com.ht.algorithms.chapter1.Factorial;

public class Main {

    public static void main(String[] args) {
        printTable(5);
    }

    static int[] sumPreviousIndex(int[] arr) {
        return sumPreviousIndex(arr, 1);
    }
    static int[] sumPreviousIndex(int[] arr, int index) {
        if(arr.length <= index || index < 0)  return arr;
        arr[index] += arr[index-1];
        sumPreviousIndex(arr, ++index);
        return arr;
    }

    static void toworOfHanoi(char S, char D, char E, int N) {
        if(N <= 0) return;
        toworOfHanoi(S, E, D, N-1);
        System.out.printf("Move %d from %c to %c \n", N, S, D);
        toworOfHanoi(E, D, S, N-1);
    }

    static void  printTable(int n) {
        printTable(n, 10);
    }
    static void printTable(int n, int i) {
        if(i > 0) {
            printTable(n, i-1);
            System.out.printf("%d * %d = %d \n", n, i, n*i);
        }
    }
}
