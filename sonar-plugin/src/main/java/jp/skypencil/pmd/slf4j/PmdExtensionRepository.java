package jp.skypencil.pmd.slf4j;

import org.apache.commons.io.IOUtils;
import org.sonar.api.resources.Java;
import org.sonar.api.rules.Rule;
import org.sonar.api.rules.RuleRepository;
import org.sonar.api.rules.XMLRuleParser;

import java.io.InputStream;
import java.util.List;

public class PmdExtensionRepository extends RuleRepository {
	// Must be the same than the PMD plugin
	private static final String REPOSITORY_KEY = "pmd";
	private XMLRuleParser ruleParser;

	public PmdExtensionRepository(XMLRuleParser ruleParser) {
		super(REPOSITORY_KEY, Java.KEY);
		this.ruleParser = ruleParser;
	}

	@Override
	public List<Rule> createRules() {
		InputStream input = getClass().getResourceAsStream(
				"/jp/skypencil/sonar/slf4j/extensions.xml");
		try {
			return ruleParser.parse(input);

		} finally {
			IOUtils.closeQuietly(input);
		}
	}
}
