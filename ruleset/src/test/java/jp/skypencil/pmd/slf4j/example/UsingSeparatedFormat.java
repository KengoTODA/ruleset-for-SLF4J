package jp.skypencil.pmd.slf4j.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsingSeparatedFormat {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public void method() {
		String end = "}";
		logger.info("Hello, {" + end, "SLF4J");
	}
}
