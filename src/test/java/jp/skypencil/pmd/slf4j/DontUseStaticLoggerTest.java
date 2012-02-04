package jp.skypencil.pmd.slf4j;

import java.util.Arrays;
import java.util.Collection;

import net.sourceforge.pmd.Rule;

public class DontUseStaticLoggerTest extends ExampleBasedTest {

	@Override
	protected Rule createRule() {
		return new DontUseStaticLogger();
	}

	@Override
	protected Collection<String> getExpectedExampleNames() {
		return Arrays.asList(new String[]{
				"UsingStaticLogger"
		});
	}
}
