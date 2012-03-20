# a simple PMD ruleset for SLF4J
This ruleset helps you to code with SLF4J. We use DEV@cloud to host Jenkins.

![built and tested on DEV@cloud](http://static-www.cloudbees.com/images/badges/BuiltOnDEV.png)


# what this project contains
This project has 2 sub modules. To get their binary, please kick `mvn clean package` or visit [our Jenkins](https://skypencil.ci.cloudbees.com/job/ruleset-for-SLF4J/lastStableBuild/).

## ruleset
Simple PMD ruleset for SLF4J.
I recommend using sonar-plugin to use this ruleset for your project.

## sonar-plugin
An plugin for Sonar.
Please put this plugin (.jar) to your `${sonar.home}/extensions/plugin` directory.

# rules
Currently, we've provided 4 rules.

## Don't pass other class to LoggerFactory
You have to pass the Class which you're coding about to LoggerFactory#getLogger(Class).

```java
class Foo {
    // You have to avoid passing Bar.class in Foo.class
    private final Logger bad = LoggerFactory.getLogger(Bar.class);
    // This is OK
    private final Logger logger = LoggerFactory.getLogger(Foo.class);
}
```

## Don't publish Logger
You have to make your all logger to private.

```java
class Foo {
    // You have to avoid publishing Logger
    public final Logger bad = LoggerFactory.getLogger(Foo.class);
    // This is OK
    private final Logger logger = LoggerFactory.getLogger(Foo.class);
}
```

## Logger should be final
Your all logger should be final.

```java
class Foo {
    // Logger should be final
    private Logger bad = LoggerFactory.getLogger(Foo.class);
    // This is OK
    private final Logger logger = LoggerFactory.getLogger(Foo.class);
}
```

## Don't use static logger
The SLF4J community recommends to use non-static logger. See [official FAQ](http://www.slf4j.org/faq.html#declared_static).

```java
class Foo {
    // Logger has to be non-static
    private final static Logger bad = LoggerFactory.getLogger(Foo.class);
    // This is OK
    private final Logger logger = LoggerFactory.getLogger(Foo.class);
}
```

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
