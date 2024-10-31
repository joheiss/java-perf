package com.jovisco.tutorial.benchmarking;

public class BenchmarkingApp {

    public static void main(String[] args) {
        var numberChecker = new NumberChecker();
        // warming up
        for (int i = 0; i < 20_000; i++) {
            numberChecker.isPrime1(i);
        }

        // benchmarking ...
        long start = System.currentTimeMillis();
        for (int i = 1_001; i < 50_000; i++) {
            numberChecker.isPrime1(i);
        }
        long end = System.currentTimeMillis();

        System.out.println("Elapsed Time: " + (end - start));

        // warming up
        for (int i = 0; i < 20_000; i++) {
            numberChecker.isPrime2(i);
        }
        // benchmarking ...
        start = System.currentTimeMillis();
        for (int i = 1_001; i < 50_000; i++) {
            numberChecker.isPrime2(i);
        }
        end = System.currentTimeMillis();

        System.out.println("Elapsed Time: " + (end - start));}
}
