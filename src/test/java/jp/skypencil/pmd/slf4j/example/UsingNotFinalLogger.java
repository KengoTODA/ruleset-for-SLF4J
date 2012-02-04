package jp.skypencil.pmd.slf4j.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsingNotFinalLogger {
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(UsingNotFinalLogger.class);
}
