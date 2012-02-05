package jp.skypencil.pmd.slf4j.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsingStaticLogger {
	@SuppressWarnings("unused")
	private final static Logger LOGGER = LoggerFactory.getLogger(UsingStaticLogger.class);
}
