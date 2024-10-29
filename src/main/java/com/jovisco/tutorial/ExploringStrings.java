package com.jovisco.tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExploringStrings {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        // start time
        long start = System.currentTimeMillis();

        // String generation
        for (int i = 0; i < 10_000_000; i++) {
            // create string and INTERN it in the string pool
            String s = String.valueOf(i).intern();
            // to make sure, the strings are not garbage collected, we store them in a list
            list.add(s);
        }

        // end time and calculate elapsed
        long end = System.currentTimeMillis();

        System.out.println("Elapsed Time: " + (end - start));

        // wait in order to be able to calculate the string pool statistics
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
