package jp.skypencil.pmd.slf4j.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsingFormatWithException {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public void method() {
		logger.info("Hello, {}", "World", new RuntimeException());
	}
}
