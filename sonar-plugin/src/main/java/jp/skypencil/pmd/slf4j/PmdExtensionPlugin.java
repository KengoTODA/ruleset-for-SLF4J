package jp.skypencil.pmd.slf4j;

import java.util.Arrays;
import java.util.List;

import org.sonar.api.SonarPlugin;

public class PmdExtensionPlugin extends SonarPlugin {

	@SuppressWarnings("unchecked")
	@Override
	public List<?> getExtensions() {
		return Arrays.asList(PmdExtensionRepository.class);
	}

}
