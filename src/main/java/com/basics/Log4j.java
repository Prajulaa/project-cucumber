package com.basics;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j {

   static Logger log = LogManager.getLogger(Log4j.class);

	public static void main(String[] args) {

		String name = "Prajula Ravichandran";
		String userName = "Prajula";

		/* 1. debug
		 * 2. info
		 * 3. warn
		 * 4. error
		 * 5. fatal
		 */ 
		log.info("ok");
		//browser
		log.error("dividing the number by 0");

		log.fatal("ok");
		log.error("ok");


	}

}
