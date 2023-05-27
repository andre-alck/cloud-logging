package com.me.cloudlogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLogger {
	
	private static Logger logger = LoggerFactory.getLogger(MyLogger.class);
	
	public static void log() {
		logger.info("mylog.logger.info");
	}
	
}
