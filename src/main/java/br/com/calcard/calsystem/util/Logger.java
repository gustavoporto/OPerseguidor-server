package br.com.calcard.calsystem.util;

import org.apache.logging.log4j.LogManager;

public abstract class Logger<T> {

	protected org.apache.logging.log4j.Logger logger;

	public Logger(Class<T> entityClass) {
		logger = LogManager.getLogger(entityClass.getName());
	}

}
