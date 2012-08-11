package jp.skypencil.pmd.slf4j.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsingFormatWithTooLongArrayAndException {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public void method() {
		Throwable t = new RuntimeException();
		logger.info("This format has only one parameter {}", new Object[]{"1st", "2nd"}, t);
	}
}
