package jp.skypencil.pmd.slf4j.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsingFormatWithArray {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public void method() {
		logger.info("{}", new Object[]{ "Hello, world" });
		logger.info("{}, {}", new Object[]{ "Hello", "SLF4J" });
	}
}
