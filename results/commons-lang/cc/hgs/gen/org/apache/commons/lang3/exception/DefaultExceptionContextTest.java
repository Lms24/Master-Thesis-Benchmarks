/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.lang3.exception;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

/**
 * JUnit tests for DefaultExceptionContext.
 */
public class DefaultExceptionContextTest extends AbstractExceptionContextTest<DefaultExceptionContext> {

    @Override
    @Before
    public void setUp() throws Exception {
        exceptionContext = new DefaultExceptionContext();
        super.setUp();
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testFormattedExceptionMessageNull() {
        exceptionContext = new DefaultExceptionContext();
        exceptionContext.getFormattedExceptionMessage(null);
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testAddContextValue() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testSetContextValue() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testGetContextValues() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testGetContextLabels() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testGetContextEntries() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testJavaSerialization() {
    }
}
