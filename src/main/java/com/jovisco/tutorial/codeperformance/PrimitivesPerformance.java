package com.jovisco.tutorial.codeperformance;

public class PrimitivesPerformance {

	private long addNumbers1(long howMany){
		long result = 0;
		for (long l = 0; l<=howMany; l++) {
			result = result + 17L;
		}
		return (result);
	}
	
	private long addNumbers2(Long howMany){
		Long result = 0L;
		Long adder = 17L;
		for (long l = 0; l<=howMany; l++) {
			result = result + adder;
		}
		return (result);
	}
	
public void run(int whichOne)  {
				
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
			System.out.println(("calculate with primitive types ..."));
			addNumbers1(1000000L);
		} else {
			System.out.println(("calculate with boxed types ..."));
			addNumbers2(1000000L);
		}

		long end = System.currentTimeMillis();
		System.out.println("measurement period done");
		System.out.println("time taken to add 1,000,000 longs: " + (end - start) + " milliseconds");
	}
}

