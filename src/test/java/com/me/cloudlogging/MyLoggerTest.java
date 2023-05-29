package com.me.cloudlogging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

public class MyLoggerTest {
	
	@Test
	public void givenMyLoggerWhenCalledInfoLogThenShouldLogAnInformationAndVerifyItThroughAnAppender() {
		// preparation
		ListAppender<ILoggingEvent> appenders = new ListAppender<>();
		appenders.start();
		
		Logger logger = (Logger) LoggerFactory.getLogger(MyLogger.class);
		logger.addAppender(appenders);
		
		// action
		MyLogger.infoLog();
		
		List<ILoggingEvent> logs = appenders.list;
		
		// verification
		assertEquals("mylog.logger.info", logs.get(0).getMessage());
		assertEquals(Level.INFO, logs.get(0).getLevel());
	}
	
	@Test
	public void givenMyLoggerWhenCalledErrorLogThenShouldLogAnInformationAndVerifyItThroughAnAppender() {
		// preparation
		ListAppender<ILoggingEvent> appenders = new ListAppender<>();
		appenders.start();
		
		Logger logger = (Logger) LoggerFactory.getLogger(MyLogger.class);
		logger.addAppender(appenders);
		
		// action
		MyLogger.errorLog();
		
		List<ILoggingEvent> logs = appenders.list;
		
		// verification
		assertEquals("mylog.logger.error", logs.get(0).getMessage());
		assertEquals(Level.ERROR, logs.get(0).getLevel());
	}
	
	@Test
	public void givenMyLoggerWhenCalledDebugLogThenShouldNotLogAsItIsBelowThreshold() {
		// preparation
		ListAppender<ILoggingEvent> appenders = new ListAppender<>();
		appenders.start();
		
		Logger logger = (Logger) LoggerFactory.getLogger(MyLogger.class);
		logger.addAppender(appenders);
		
		// action
		MyLogger.debugLog();
		
		List<ILoggingEvent> logs = appenders.list;
		
		// verification
		assertTrue(logs.isEmpty());
	}
	

}
