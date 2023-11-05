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
import org.slf4j.Logger;
import org.slf4j.event.Level;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Log adapter for JCS3 logging to slf4j.
 *
 * @author Jeremy Long
 */
public class Slf4jAdapter implements Log {

    private final Logger logger;

    public Slf4jAdapter(Logger log) {
        this.logger = log;
    }

    @Override
    public void debug(String string) {
        logger.debug(string);
    }

    @Override
    public void debug(Object o) {
        logger.debug(o.toString());
    }

    @Override
    public void debug(String string, Object... os) {
        String msg = MessageFormat.format(string, os);
        logger.debug(msg);
    }

    @Override
    public void debug(String string, Supplier<?>... splrs) {
        List<String> args = Arrays.stream(splrs).map(it -> it.get().toString()).collect(Collectors.toList());
        String msg = MessageFormat.format(string, args.toArray());
        // log(Level.DEBUG, string, splrs);
        logger.debug(msg);
    }

    @Override
    public void debug(String string, Throwable thrwbl) {
        logger.debug(string, thrwbl);
    }

    @Override
    public void error(String string) {
        logger.error(string);
    }

    @Override
    public void error(Object o) {
        logger.error(o.toString());
    }

    @Override
    public void error(String string, Object... os) {
        String msg = MessageFormat.format(string, os);
        logger.error(msg);
    }

    @Override
    public void error(String string, Supplier<?>... splrs) {
        List<String> args = Arrays.stream(splrs).map(it -> it.get().toString()).collect(Collectors.toList());
        String msg = MessageFormat.format(string, args.toArray());
        logger.error(msg);
        // log(Level.ERROR, string, splrs);
    }

    @Override
    public void error(String string, Throwable thrwbl) {
        logger.error(string, thrwbl);
    }

    @Override
    public void fatal(String string) {
        logger.error(string);
    }

    @Override
    public void fatal(Object o) {
        logger.error(o.toString());
    }

    @Override
    public void fatal(String string, Object... os) {
        String msg = MessageFormat.format(string, os);
        logger.error(msg);
    }

    @Override
    public void fatal(String string, Supplier<?>... splrs) {
        List<String> args = Arrays.stream(splrs).map(it -> it.get().toString()).collect(Collectors.toList());
        String msg = MessageFormat.format(string, args.toArray());
        logger.error(msg);
        // log(Level.ERROR, string, splrs);
    }

    @Override
    public void fatal(String string, Throwable thrwbl) {
        logger.error(string, thrwbl);
    }

    @Override
    public String getName() {
        return logger.getName();
    }

    @Override
    public void info(String string) {
        logger.info(string);
    }

    @Override
    public void info(Object o) {
        logger.info(o.toString());
    }

    @Override
    public void info(String string, Object... os) {
        String msg = MessageFormat.format(string, os);
        logger.info(msg);
    }

    @Override
    public void info(String string, Supplier<?>... splrs) {
        List<String> args = Arrays.stream(splrs).map(it -> it.get().toString()).collect(Collectors.toList());
        String msg = MessageFormat.format(string, args.toArray());
        logger.info(msg);
        // log(Level.INFO, string, splrs);
    }

    @Override
    public void info(String string, Throwable thrwbl) {
        logger.info(string, thrwbl);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    @Override
    public boolean isFatalEnabled() {
        return logger.isErrorEnabled();
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    @Override
    public void trace(String string) {
        logger.trace(string);
    }

    @Override
    public void trace(Object o) {
        logger.trace(o.toString());
    }

    @Override
    public void trace(String string, Object... os) {
        String msg = MessageFormat.format(string, os);
        logger.trace(msg);
    }

    @Override
    public void trace(String string, Supplier<?>... splrs) {
        List<String> args = Arrays.stream(splrs).map(it -> it.get().toString()).collect(Collectors.toList());
        String msg = MessageFormat.format(string, args.toArray());
        logger.trace(msg);
        // log(Level.TRACE, string, splrs);
    }

    @Override
    public void trace(String string, Throwable thrwbl) {
        logger.trace(string, thrwbl);
    }

    @Override
    public void warn(String string) {
        logger.warn(string);
    }

    @Override
    public void warn(Object o) {
        logger.warn(o.toString());
    }

    @Override
    public void warn(String string, Object... os) {
        String msg = MessageFormat.format(string, os);
        logger.warn(msg);
    }

    @Override
    public void warn(String string, Supplier<?>... splrs) {
        List<String> args = Arrays.stream(splrs).map(it -> it.get().toString()).collect(Collectors.toList());
        String msg = MessageFormat.format(string, args.toArray());
        logger.warn(msg);
        // log(Level.WARN, string, splrs);
    }

    @Override
    public void warn(String string, Throwable thrwbl) {
        logger.warn(string, thrwbl);
    }

    private void log(Level level, String string, Supplier<?>[] splrs) {
        if (isEnabled(level)) {
            Object[] o = null;
            if (splrs != null) {
                o = Arrays.stream(splrs).map(s -> s.get()).toArray();
            }
            switch (level) {
                case ERROR:
                    logger.error(string, o);
                    break;
                case WARN:
                    logger.warn(string, o);
                    break;
                case INFO:
                    logger.info(string, o);
                    break;
                case TRACE:
                    logger.trace(string, o);
                    break;
                case DEBUG:
                    logger.debug(string, o);
                    break;
            }
        }
    }

    private boolean isEnabled(Level level) {
        return (Level.DEBUG == level && logger.isDebugEnabled()) || (Level.INFO == level && logger.isInfoEnabled())
                || (Level.TRACE == level && logger.isTraceEnabled()) || (Level.WARN == level && logger.isWarnEnabled())
                || (Level.ERROR == level && logger.isErrorEnabled());
    }

}
