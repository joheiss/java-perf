package com.jovisco.tutorial.codeperformance;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingExample {

	Logger logger = Logger.getLogger("My Logger");
		
	public void exampleMethod() {
		
		try {
			//some code
		}
		catch (NumberFormatException e) {
			if (logger.isLoggable(Level.INFO)) {
//				logger.log(Level.INFO, "NFE in exampleMethod. "
//					+ "error was : " + e.getMessage() +
//					" user was : " + currentUser + " " + currentUser.getName()) +
//					" system was : " + currentTerminal + " "  + currentTerminal.getLocationName());
			}
		}
	}
	
}
