package com.diguage.algorithm.codinginterviews.fibonacci;

public class Fibonacci {
    public static long fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static long fibonacci_loop(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long first = 0;
        long second = 1;
        long result = -1;
        for (int i = 2; i <= n; i++) {
            result = first + second;
            first =  second;
            second = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibonacci(n));
        System.out.println(fibonacci_loop(n));
    }
}
