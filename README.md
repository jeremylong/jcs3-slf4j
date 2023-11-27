# jcs3-slf4j

A [logging abstraction for JCS3](https://commons.apache.org/proper/commons-jcs/UpgradingFrom2x.html#Logging_Abstraction)
to bind JCS3 logging to slf4j. Useful when using JCS3 with an application that uses slf4j.

Add the jcs3-slf4j library to your JCS3 project and set:

```shell
-Djcs.logSystem=slf4j
```

## Maven

```xml
<dependency>
    <groupId>io.github.jeremylong</groupId>
    <artifactId>jcs3-slf4j</artifactId>
    <version>1.0.5</version>
</dependency>
```

## Gradle

```groovy
implementation 'io.github.jeremylong:jcs3-slf4j:1.0.5'
```
