package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoLoggingSlf4j {
	
	private static Logger logger=LoggerFactory.getLogger(DemoLoggingSlf4j.class);
	
	public static void main(String[] args) {
		logger.info("logging hello world");
	}

}
