package com.me.cloudlogging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

public class MyLoggerTest {
	
	ListAppender<ILoggingEvent> appenders = new ListAppender<>();
	Logger logger = (Logger) LoggerFactory.getLogger(MyLogger.class);
	List<ILoggingEvent> logs = appenders.list;
	
	@Before
	public void setup() {
		appenders.clearAllFilters();
		appenders.start();
		
		logger.detachAndStopAllAppenders();
		logger.addAppender(appenders);
		
		logs.clear();
	}
	
	@Test
	public void givenMyLoggerWhenCalledInfoLogThenShouldLogAnInformationAndVerifyItThroughAnAppender() {
		MyLogger.infoLog();
		
		assertEquals("mylog.logger.info", logs.get(0).getMessage());
		assertEquals(Level.INFO, logs.get(0).getLevel());
	}
	
	@Test
	public void givenMyLoggerWhenCalledErrorLogThenShouldLogAnInformationAndVerifyItThroughAnAppender() {
		MyLogger.errorLog();
	
		assertEquals("mylog.logger.error", logs.get(0).getMessage());
		assertEquals(Level.ERROR, logs.get(0).getLevel());
	}
	
	@Test
	public void givenMyLoggerWhenCalledDebugLogThenShouldNotLogAsItIsBelowThreshold() {
		MyLogger.debugLog();
		
		assertTrue(logs.isEmpty());
	}
	
}
