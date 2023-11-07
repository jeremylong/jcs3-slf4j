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
import org.apache.commons.jcs3.log.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Log factory for JCS3 to bind to slf4j.
 *
 * @author Jeremy Long
 */
public class Slf4jLogFactory implements LogFactory {

    @Override
    public String getName() {
        return "slf4j";
    }

    @Override
    public void shutdown() {
        // empty
    }

    @Override
    public Log getLog(Class<?> type) {
        final Logger log = LoggerFactory.getLogger(type);
        return new Slf4jAdapter(log);
    }

    @Override
    public Log getLog(String type) {
        final Logger log = LoggerFactory.getLogger(type);
        return new Slf4jAdapter(log);
    }
}
