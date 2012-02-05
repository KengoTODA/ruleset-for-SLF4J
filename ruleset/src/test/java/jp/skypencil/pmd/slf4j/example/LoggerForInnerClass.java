package jp.skypencil.pmd.slf4j.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerForInnerClass {
	public class InnerClass {
		@SuppressWarnings("unused")
		private final Logger logger = LoggerFactory.getLogger(InnerClass.class);
	}

	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(LoggerForInnerClass.class);
}
