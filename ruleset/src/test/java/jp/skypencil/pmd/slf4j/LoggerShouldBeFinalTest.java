package jp.skypencil.pmd.slf4j;

import java.util.Arrays;
import java.util.Collection;

import net.sourceforge.pmd.Rule;

public class LoggerShouldBeFinalTest extends ExampleBasedTest {

	@Override
	protected Rule createRule() {
		return new LoggerShouldBeFinal();
	}

	@Override
	protected Collection<String> getExpectedExampleNames() {
		return Arrays.asList(new String[]{
				"UsingNotFinalLogger"
		});
	}
}
