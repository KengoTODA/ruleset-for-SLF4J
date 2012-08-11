package jp.skypencil.pmd.slf4j;

import java.util.Arrays;
import java.util.Collection;

import net.sourceforge.pmd.Rule;

public class DontPassOtherClassToLoggerFactoryTest extends ExampleBasedTest {

	public DontPassOtherClassToLoggerFactoryTest(String exampleName) {
		super(exampleName);
	}

	@Override
	protected Rule createRule() {
		return new DontPassOtherClassToLoggerFactory();
	}

	@Override
	protected Collection<String> getExpectedExampleNames() {
		return Arrays.asList(new String[]{
				"GivingOtherClassToFactory"
		});
	}
}
