/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.cli;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test case for the PosixParser.
 */
public class PosixParserTest extends ParserTestCase {

    @SuppressWarnings("deprecation")
    @Before
    public void setUp() {
        super.setUp();
        parser = new PosixParser();
    }

    @Override
    @Test
    @Ignore("not supported by the PosixParser")
    public void testDoubleDash2() throws Exception {
    }

    @Override
    @Test
    @Ignore("not supported by the PosixParser")
    public void testLongWithoutEqualSingleDash() throws Exception {
    }

    @Override
    @Test
    @Ignore("not supported by the PosixParser")
    public void testAmbiguousLongWithoutEqualSingleDash() throws Exception {
    }

    @Override
    @Test
    @Ignore("not supported by the PosixParser (CLI-184)")
    public void testNegativeOption() throws Exception {
    }

    @Override
    @Test
    @Ignore("not supported by the PosixParser")
    public void testLongWithUnexpectedArgument1() throws Exception {
    }

    @Override
    @Test
    @Ignore("not supported by the PosixParser")
    public void testLongWithEqualSingleDash() throws Exception {
    }

    @Override
    @Test
    @Ignore("not supported by the PosixParser")
    public void testShortWithEqual() throws Exception {
    }

    @Override
    @Test
    @Ignore("not supported by the PosixParser")
    public void testUnambiguousPartialLongOption4() throws Exception {
    }

    @Override
    @Test
    @Ignore("not supported by the PosixParser")
    public void testAmbiguousPartialLongOption4() throws Exception {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testSimpleShort() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testSimpleLong() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testMultiple() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testMultipleWithLong() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testUnrecognizedOption() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testMissingArg() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testDoubleDash1() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testSingleDash() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testStopAtUnexpectedArg() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testStopAtExpectedArg() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testStopAtNonOptionShort() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testStopAtNonOptionLong() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testNegativeArgument() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testArgumentStartingWithHyphen() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testShortWithoutEqual() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testLongWithEqualDoubleDash() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testLongWithoutEqualDoubleDash() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testLongWithUnexpectedArgument2() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testShortWithUnexpectedArgument() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testPropertiesOption1() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testPropertiesOption2() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testUnambiguousPartialLongOption1() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testUnambiguousPartialLongOption2() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testUnambiguousPartialLongOption3() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testAmbiguousPartialLongOption1() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testAmbiguousPartialLongOption2() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testAmbiguousPartialLongOption3() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testPartialLongOptionSingleDash() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testWithRequiredOption() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testOptionAndRequiredOption() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testMissingRequiredOption() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testMissingRequiredOptions() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testMissingRequiredGroup() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testOptionGroup() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testOptionGroupLong() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testReuseOptionsTwice() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testBursting() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testUnrecognizedOptionWithBursting() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testMissingArgWithBursting() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testStopBursting() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testStopBursting2() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testUnlimitedArgs() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testPropertyOptionSingularValue() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testPropertyOptionFlags() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testPropertyOptionMultipleValues() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testPropertyOverrideValues() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testPropertyOptionRequired() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testPropertyOptionUnexpected() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testPropertyOptionGroup() {
    }
}
