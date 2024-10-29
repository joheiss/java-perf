package com.jovisco.tutorial;

import com.jovisco.tutorial.customer.CustomerRecord;
import com.jovisco.tutorial.customer.CustomerRecords;

import java.util.concurrent.TimeUnit;

public class ExploringGarbageCollection {

    public static void main(String[] args) {
        var runtime = Runtime.getRuntime();
        var freeMemory = runtime.freeMemory();
        System.out.println("Free Memory at start: " + freeMemory);

        var customers = new CustomerRecords();
        for (int i = 0; i < 1_000_000; i++) {
            customers.addCustomer(new CustomerRecord("John-" + i));
        }

        freeMemory = runtime.freeMemory();
        System.out.println("Free Memory after adding 1M customers: " + freeMemory);

        // clear list of customers and check free memory
        customers.clear();
        freeMemory = runtime.freeMemory();
        System.out.println("Free Memory after clearing customers: " + freeMemory);

        // wait to give the GC time to clean up ... and check memory again
        wait(1);
        freeMemory = runtime.freeMemory();
        System.out.println("Free Memory after waiting: " + freeMemory);

        // ask to run GC ... and check memory again ... free memory can be less now
        // since JVM may have returned some freed up memory to the OS
        runtime.gc();
        freeMemory = runtime.freeMemory();
        System.out.println("Free Memory after GC: " + freeMemory);
    }

    private static void wait(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
