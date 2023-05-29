package com.me.cloudlogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLogger {
	
	static final Logger logger = LoggerFactory.getLogger(MyLogger.class);
	
	public static void infoLog() {
		logger.info("mylog.logger.info");
	}
	
	public static void errorLog() {
		logger.error("mylog.logger.error");
		
	}
	
	public static void debugLog() {
		logger.debug("mylog.logger.debug");
	}
	
}
