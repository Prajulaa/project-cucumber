package com.basics1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTesting {
	
	static Logger log = LogManager.getLogger(LogTesting.class);

	public static void main(String[] args) {

		log.info("LogTesting c class");
		log.debug("LogTesting cc class");


		log.fatal("LogTesting sed class");
		log.error("LogTesting class");

		log.error("LogTesting class class class");
		log.error("LogTesting class");

	}

}
