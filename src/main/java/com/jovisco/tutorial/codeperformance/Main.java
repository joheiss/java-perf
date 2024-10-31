package com.jovisco.tutorial.codeperformance;

public class Main {

	public static void main(String[] args) {
		// PrimitivesPerformance performance = new PrimitivesPerformance();
		// StringBuilderPerformance performance = new StringBuilderPerformance();
		// BigDecimalPerformance performance = new BigDecimalPerformance();
		LoopPerformance performance = new LoopPerformance();
		performance.run(1);
		performance.run(2);
	}
}
