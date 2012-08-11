package jp.skypencil.pmd.slf4j.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsingFormatWithNotEnoughArgument {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public void method() {
		logger.info("1st is {}, 2nd is {}.", new Object[]{ "only 1st" });
	}
}
