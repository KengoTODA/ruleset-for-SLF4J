package jp.skypencil.pmd.slf4j.example;

import org.slf4j.LoggerFactory;

public class UsingFqcnToLogger {
	@SuppressWarnings("unused")
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(UsingFqcnToLogger.class);
}
