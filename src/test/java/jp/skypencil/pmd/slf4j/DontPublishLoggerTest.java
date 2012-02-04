package jp.skypencil.pmd.slf4j;

import java.util.Arrays;
import java.util.Collection;

import net.sourceforge.pmd.Rule;

public final class DontPublishLoggerTest extends ExampleBasedTest {

	@Override
	protected Rule createRule() {
		return new DontPublishLogger();
	}

	@Override
	protected Collection<String> getExpectedExampleNames() {
		return Arrays.asList(new String[]{
				"UsingPublicLogger",
				"UsingProtectedLogger",
				"UsingPackagePrivateLogger"
		});
	}
}
