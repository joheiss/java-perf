package com.jovisco.tutorial;

import java.util.concurrent.TimeUnit;

public class App 
{
    public static void main( String[] args ) {

        // get start time
        long start = System.currentTimeMillis();

        // TimeUnit.SECONDS.sleep(20);
        System.out.println("Starting ...");
        PrimeNumbers primeNumbers = new PrimeNumbers();
        Integer max = Integer.parseInt(args[0]);
        primeNumbers.generateNumbers(max);

        // get end time and calculate elapsed
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (end - start));
    }
}
