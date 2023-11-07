/*
 *  Copyright 2022-2023 Jeremy Long
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.github.jeremylong.jcs3.slf4j;

import org.apache.commons.jcs3.log.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class Slf4jAdapterTest {

    public static final String TEST_LOG = "build/test-logs/test.log";
    public static final String LOG_FORMAT = "%s i.g.j.jcs3.slf4j.Slf4jAdapterTest - %s";
    private static Slf4jLogFactory factory;
    private static Log log;

    @BeforeAll
    static void beforeAll() {
        File f = new File(TEST_LOG);
        if (f.isFile() && !f.delete()) {
            fail("Unable to delete existing log file: " + f.getPath());
        }
        factory = new Slf4jLogFactory();
        log = factory.getLog(Slf4jAdapterTest.class);
    }

    @AfterAll
    static void afterAll() {
        factory.shutdown();
    }

    @Test
    void debug() {
        String message = "test-debug";
        String expected = String.format(LOG_FORMAT, "DEBUG", message);
        log.debug(message);
        Object message1 = "test-debug-1";
        String expected1 = String.format(LOG_FORMAT, "DEBUG", message);
        log.debug(message1);
        String message2 = "test-debug-2-{0}";
        String formatted2 = "test-debug-2-test";
        String expected2 = String.format(LOG_FORMAT, "DEBUG", formatted2);
        log.debug(message2, "test");
        String message3 = "test-debug-3";
        String expected3 = String.format(LOG_FORMAT, "DEBUG", message);
        log.debug(message3);
        String message4 = "test-debug-4-{0}";
        String formatted4 = "test-debug-4-test";
        String expected4 = String.format(LOG_FORMAT, "DEBUG", formatted4);
        log.debug(message4, () -> "test");

        String s = readLog();
        assertTrue(s.contains(expected));
        assertTrue(s.contains(expected1));
        assertTrue(s.contains(expected2));
        assertTrue(s.contains(expected3));
        assertTrue(s.contains(expected4));
    }

    @Test
    void error() throws IOException {
        String message = "test-error";
        String expected = String.format(LOG_FORMAT, "ERROR", message);
        log.error(message);
        Object message1 = "test-error-1";
        String expected1 = String.format(LOG_FORMAT, "ERROR", message);
        log.error(message1);
        String message2 = "test-error-2-{0}";
        String formatted2 = "test-error-2-test";
        String expected2 = String.format(LOG_FORMAT, "ERROR", formatted2);
        log.error(message2, "test");
        String message3 = "test-error-3";
        String expected3 = String.format(LOG_FORMAT, "ERROR", message);
        log.error(message3);
        String message4 = "test-error-4-{0}";
        String formatted4 = "test-error-4-test";
        String expected4 = String.format(LOG_FORMAT, "ERROR", formatted4);
        log.error(message4, () -> "test");

        String s = readLog();
        assertTrue(s.contains(expected));
        assertTrue(s.contains(expected1));
        assertTrue(s.contains(expected2));
        assertTrue(s.contains(expected3));
        assertTrue(s.contains(expected4));
    }

    @Test
    void trace() {
        String message = "test-trace";
        String expected = String.format(LOG_FORMAT, "TRACE", message);
        log.trace(message);
        Object message1 = "test-trace-1";
        String expected1 = String.format(LOG_FORMAT, "TRACE", message);
        log.trace(message1);
        String message2 = "test-trace-2-{0}";
        String formatted2 = "test-trace-2-test";
        String expected2 = String.format(LOG_FORMAT, "TRACE", formatted2);
        log.trace(message2, "test");
        String message3 = "test-trace-3";
        String expected3 = String.format(LOG_FORMAT, "TRACE", message);
        log.trace(message3);
        String message4 = "test-trace-4-{0}";
        String formatted4 = "test-trace-4-test";
        String expected4 = String.format(LOG_FORMAT, "TRACE", formatted4);
        log.trace(message4, () -> "test");

        String s = readLog();
        // trace is not enabled
        assertFalse(s.contains(expected));
        assertFalse(s.contains(expected1));
        assertFalse(s.contains(expected2));
        assertFalse(s.contains(expected3));
        assertFalse(s.contains(expected4));
    }

    @Test
    void warn() {
        String message = "test-warn";
        String expected = String.format(LOG_FORMAT, "WARN ", message);
        log.warn(message);
        Object message1 = "test-warn-1";
        String expected1 = String.format(LOG_FORMAT, "WARN ", message);
        log.warn(message1);
        String message2 = "test-warn-2-{0}";
        String formatted2 = "test-warn-2-test";
        String expected2 = String.format(LOG_FORMAT, "WARN ", formatted2);
        log.warn(message2, "test");
        String message3 = "test-warn-3";
        String expected3 = String.format(LOG_FORMAT, "WARN ", message);
        log.warn(message3);
        String message4 = "test-warn-4-{0}";
        String formatted4 = "test-warn-4-test";
        String expected4 = String.format(LOG_FORMAT, "WARN ", formatted4);
        log.warn(message4, () -> "test");

        String s = readLog();
        assertTrue(s.contains(expected));
        assertTrue(s.contains(expected1));
        assertTrue(s.contains(expected2));
        assertTrue(s.contains(expected3));
        assertTrue(s.contains(expected4));
    }

    @Test
    void fatal() {
        String message = "test-fatal";
        String expected = String.format(LOG_FORMAT, "ERROR", message);
        log.fatal(message);
        Object message1 = "test-fatal-1";
        String expected1 = String.format(LOG_FORMAT, "ERROR", message);
        log.fatal(message1);
        String message2 = "test-fatal-2-{0}";
        String formatted2 = "test-fatal-2-test";
        String expected2 = String.format(LOG_FORMAT, "ERROR", formatted2);
        log.fatal(message2, "test");
        String message3 = "test-fatal-3";
        String expected3 = String.format(LOG_FORMAT, "ERROR", message);
        log.fatal(message3);
        String message4 = "test-fatal-4-{0}";
        String formatted4 = "test-fatal-4-test";
        String expected4 = String.format(LOG_FORMAT, "ERROR", formatted4);
        log.fatal(message4, () -> "test");

        String s = readLog();
        assertTrue(s.contains(expected));
        assertTrue(s.contains(expected1));
        assertTrue(s.contains(expected2));
        assertTrue(s.contains(expected3));
        assertTrue(s.contains(expected4));
    }

    @Test
    void info() {
        String message = "test-info";
        String expected = String.format(LOG_FORMAT, "INFO ", message);
        log.info(message);
        Object message1 = "test-info-1";
        String expected1 = String.format(LOG_FORMAT, "INFO ", message);
        log.info(message1);
        String message2 = "test-info-2-{0}";
        String formatted2 = "test-info-2-test";
        String expected2 = String.format(LOG_FORMAT, "INFO ", formatted2);
        log.info(message2, "test");
        String message3 = "test-info-3";
        String expected3 = String.format(LOG_FORMAT, "INFO ", message);
        log.info(message3);
        String message4 = "test-info-4-{0}";
        String formatted4 = "test-info-4-test";
        String expected4 = String.format(LOG_FORMAT, "INFO ", formatted4);
        log.info(message4, () -> "test");

        String s = readLog();
        assertTrue(s.contains(expected));
        assertTrue(s.contains(expected1));
        assertTrue(s.contains(expected2));
        assertTrue(s.contains(expected3));
        assertTrue(s.contains(expected4));
    }

    @Test
    void getName() {
        assertTrue("io.github.jeremylong.jcs3.slf4j.Slf4jAdapterTest".equals(log.getName()));
    }

    @Test
    void isDebugEnabled() {
        assertTrue(log.isDebugEnabled());
    }

    @Test
    void isErrorEnabled() {
        assertTrue(log.isErrorEnabled());
    }

    @Test
    void isFatalEnabled() {
        assertTrue(log.isFatalEnabled());
    }

    @Test
    void isInfoEnabled() {
        assertTrue(log.isInfoEnabled());
    }

    @Test
    void isTraceEnabled() {
        assertFalse(log.isTraceEnabled());
    }

    @Test
    void isWarnEnabled() {
        assertTrue(log.isWarnEnabled());
    }

    private String readLog() {
        try {
            return new String(Files.readAllBytes(Paths.get(TEST_LOG)));
        } catch (IOException e) {
            fail("Unable to read log file");
        }
        return "";
    }
}