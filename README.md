# a simple PMD ruleset for SLF4J
This ruleset helps you to code with SLF4J.

[![Build Status](https://secure.travis-ci.org/eller86/ruleset-for-SLF4J.png?branch=master)](http://travis-ci.org/eller86/ruleset-for-SLF4J)

# what this project contains
This project has 2 sub modules.

## ruleset
Simple PMD rules and default ruleset for SLF4J. You can use default ruleset easily with Maven like below.

```xml
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-pmd-plugin</artifactId>
	<version>2.7.1</version>
	<dependencies>
		<dependency>
			<groupId>jp.skypencil</groupId>
			<artifactId>RuleSet-for-SLF4J</artifactId>
			<version>0.4</version>
		</dependency>
	</dependencies>
	<configuration>
		<linkXRef>false</linkXRef>
		<sourceEncoding>UTF-8</sourceEncoding>
		<targetJdk>1.6</targetJdk>
		<rulesets>
			<ruleset>slf4j.xml</ruleset><!-- to use default ruleset for SLF4J -->
		</rulesets>
	</configuration>
</plugin>
```

If you want to use a part of these rules, you have to create your ruleset XML file.
Sample ruleset XML file is [here](https://raw.github.com/eller86/ruleset-for-SLF4J/master/ruleset/src/main/resources/slf4j.xml).

## sonar-plugin
An plugin for Sonar.
Please put this plugin (.jar) to your `${sonar.home}/extensions/plugin` directory.
You can command `mvn package` to build jar file, or download it from [Maven central](http://central.maven.org/maven2/jp/skypencil/sonar-pmd-for-SLF4J-plugin/).

# rules
Currently, we've provided 5 rules.

## Don't pass other class to LoggerFactory
Given argument for LoggerFactory#getLogger(Class) is wrong. You have to provide the Class which you're coding.
```java
class Foo {
    // You have to avoid passing Bar.class in Foo.class
    private final Logger bad = LoggerFactory.getLogger(Bar.class);
    // This is OK
    private final Logger logger = LoggerFactory.getLogger(Foo.class);
}
```

## Don't publish Logger
Logger should be private.

```java
class Foo {
    // You have to avoid publishing Logger
    public final Logger bad = LoggerFactory.getLogger(Foo.class);
    // This is OK
    private final Logger logger = LoggerFactory.getLogger(Foo.class);
}
```

## Logger should be final
Logger should be final.

```java
class Foo {
    // Logger should be final
    private Logger bad = LoggerFactory.getLogger(Foo.class);
    // This is OK
    private final Logger logger = LoggerFactory.getLogger(Foo.class);
}
```

## Don't use static logger
Sometimes using non-static logger is better than using static one. See [official FAQ](http://www.slf4j.org/faq.html#declared_static) for detail.
If you want to keep your logger static, please use [default logging rule](http://pmd.sourceforge.net/pmd-5.0.0/rules/java/logging-java.html#LoggerIsNotStaticFinal) instead.

```java
class Foo {
    // Logger has to be non-static
    private final static Logger bad = LoggerFactory.getLogger(Foo.class);
    // This is OK
    private final Logger logger = LoggerFactory.getLogger(Foo.class);
}
```

## Number of placeholder should be equal to number of argument

```java
class Foo {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    void method() {
        // this logging method has 2 placeholders, but only 1 parameter
        logger.info("{}, {}.", new Object[]{ "Hello" });
        // this is OK
        logger.info("{}, {}.", new Object[]{ "Hello", "World" });
    }
}
```

- supported from version 0.2
- [this rule has a trouble](https://github.com/eller86/ruleset-for-SLF4J/issues/4), please try [findbugs-slf4j](https://github.com/eller86/findbugs-slf4j) instead.

### limitation to parse
- the 1st argument of logging method should be a `literal`
- if the 2nd argument is array, it should be an array initializer like `new Object[]{ ... }`

# history
## 0.1
- first release

## 0.2
- added `Number of placeholder should be equal to number of argument` rule

## 0.3
- refactored
- downgrade XML schema to avoid warning in Eclipse (issue #1)
- added a test case and fixed a bug about exception which is out of CLASSPATH (issue #2)

## 0.4
- fixed wrong description for `Don't use static logger` rule
- fixed NPE (issue #3)

# copyright and license
Copyright 2012 Kengo TODA (eller86)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
