package com.jovisco.tutorial;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

    private List<Integer> primes;

    public void generateNumbers(Integer max) {
        primes = new ArrayList<Integer>();
        primes.add(2);

        Integer next = 2;
        while (primes.size() <= max) {
            next = getNextPrimeAbove(next);
            primes.add(next);
        }
        System.out.println(primes);
    }

    private Boolean isPrime(Integer number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private Integer getNextPrimeAbove(Integer previous) {
        Integer number = previous + 1;
        while (!isPrime(number)) {
            number++;
        }
        return number;
    }
}
