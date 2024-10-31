package com.jovisco.tutorial.codeperformance;
import java.math.BigDecimal;

public class BigDecimalPerformance {

	private BigDecimal addNumbers1(long howMany){
		BigDecimal result = BigDecimal.ZERO;
		BigDecimal adder = new BigDecimal("17.31");
		for (long l = 0; l<=howMany; l++) {
			result = result.add(adder);
		}
		return (result);
	}
	
	private BigDecimal addNumbers2(long howMany){
		Double result = 0d;
		Double adder = 17.31;
		for (long l = 0; l<=howMany; l++) {
			result = result + adder;
		}
		return (new BigDecimal(result));
	}
	
public void run(int whichOne) {
				
		System.out.println("warm up period starting");
		if (whichOne == 1) {
			addNumbers1(1000L);
		} else {
			addNumbers2(1000L);
		}

		System.out.println("warm up period done");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException _) {
		}
		System.out.println("measurement period starting");
		
		long start = System.currentTimeMillis();

		if (whichOne == 1) {
			System.out.println(("calculate with big decimals ..."));
			addNumbers1(1000000L);
		} else {
			System.out.println(("calculate with doubles ..."));
			addNumbers2(1000000L);
		}
		addNumbers1(1000000L);

		long end = System.currentTimeMillis();

		System.out.println("measurement period done");
		System.out.println("time taken to add 1,000,000 numbers: " + (end - start) + " milliseconds");
	}
}

