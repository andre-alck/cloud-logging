package com.me.cloudlogging;

import org.junit.Test;

public class MyLoggerTest {
	
	@Test
	public void givenMyLoggerWhenCalledLogThenShouldLog() {
		MyLogger myLogger = new MyLogger();
        myLogger.log();
	}

}
