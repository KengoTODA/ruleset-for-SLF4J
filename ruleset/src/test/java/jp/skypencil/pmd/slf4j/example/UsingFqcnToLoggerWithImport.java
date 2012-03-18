package jp.skypencil.pmd.slf4j.example;

import org.slf4j.Logger;	// don't delete this line
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class UsingFqcnToLoggerWithImport {
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(UsingFqcnToLoggerWithImport.class);
}
