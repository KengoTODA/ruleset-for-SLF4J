package jp.skypencil.pmd.slf4j.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsingProtectedLogger {
	final protected Logger logger = LoggerFactory.getLogger(getClass());
}
