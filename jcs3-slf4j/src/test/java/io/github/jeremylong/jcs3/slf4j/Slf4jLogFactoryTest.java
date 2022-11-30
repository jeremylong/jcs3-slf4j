/*
 *  Copyright 2022 Jeremy Long
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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Slf4jLogFactoryTest {

    @Test
    void getName() {
        Slf4jLogFactory factory = new Slf4jLogFactory();
        String expected = "slf4j";
        String actual = factory.getName();
        assertTrue(expected.equals(actual));
    }

    @Test
    void shutdown() {
        Slf4jLogFactory factory = new Slf4jLogFactory();
        factory.shutdown();
    }

    @Test
    void getLog() {
        Slf4jLogFactory factory = new Slf4jLogFactory();
        assertNotNull(factory.getLog(Slf4jLogFactoryTest.class));
    }

    @Test
    void testGetLog() {
        Slf4jLogFactory factory = new Slf4jLogFactory();
        assertNotNull(factory.getLog("io.github.jeremylong.jcs3.slf4j.Slf4jLogFactoryTest"));
    }
}