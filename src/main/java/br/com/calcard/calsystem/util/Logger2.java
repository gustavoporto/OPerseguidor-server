package br.com.calcard.calsystem.util;

import org.apache.logging.log4j.LogManager;

public class Logger2 {

	protected org.apache.logging.log4j.Logger logger;

	@SuppressWarnings("rawtypes")
	public Logger2(Class entityClass) {
		logger = LogManager.getLogger(entityClass.getName());
	}

}
