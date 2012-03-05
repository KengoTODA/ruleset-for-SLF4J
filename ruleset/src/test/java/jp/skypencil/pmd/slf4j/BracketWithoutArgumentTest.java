package jp.skypencil.pmd.slf4j;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import net.sourceforge.pmd.Rule;

public class BracketWithoutArgumentTest extends ExampleBasedTest {

	@Override
	protected Rule createRule() {
		return new BracketWithoutArgument();
	}

	@Override
	protected Collection<String> getExpectedExampleNames() {
		return Arrays.asList(new String[]{
				"UsingFormatWithoutArgument",
				"UsingFormatWithoutArgumentButWithException"
		});
	}

	@Test
	public void testCountDelimiter() {
		assertThat(new BracketWithoutArgument().countDelimiter(""), is(0));
		assertThat(new BracketWithoutArgument().countDelimiter("{}"), is(1));
		assertThat(new BracketWithoutArgument().countDelimiter("a{}"), is(1));
		assertThat(new BracketWithoutArgument().countDelimiter("{}a"), is(1));
		assertThat(new BracketWithoutArgument().countDelimiter("a{}a"), is(1));
		assertThat(new BracketWithoutArgument().countDelimiter("{}{}"), is(2));
		assertThat(new BracketWithoutArgument().countDelimiter("\\{}"), is(0));
		assertThat(new BracketWithoutArgument().countDelimiter("\\\\{}"), is(1));
	}

	@Test
	public void testIsThrowable() {
		assertTrue(new BracketWithoutArgument().isThrowable(Throwable.class));
		assertTrue(new BracketWithoutArgument().isThrowable(Exception.class));
		assertTrue(new BracketWithoutArgument().isThrowable(RuntimeException.class));
		assertTrue(new BracketWithoutArgument().isThrowable(NullPointerException.class));
		assertFalse(new BracketWithoutArgument().isThrowable(Object.class));
	}
}
