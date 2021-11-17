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
package org.apache.commons.lang3.time;

import java.util.Locale;
import java.util.TimeZone;
import org.junit.Test;
import org.junit.Ignore;

/**
 * Unit tests for the parse methods of FastDateFormat
 *
 * @since 3.2
 */
public class FastDateFormat_ParserTest extends FastDateParserTest {

    @Override
    protected DateParser getInstance(final String format, final TimeZone timeZone, final Locale locale) {
        return FastDateFormat.getInstance(format, timeZone, locale);
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testLocales_Short_BC() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testLocales_Short_AD() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void test_Equality_Hash() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testLocales_Long_BC() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testLocales_Long_AD() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testLocales_LongNoEra_BC() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testLocales_LongNoEra_AD() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testShortDateStyleWithLocales() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testTimeZoneMatches() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testParseLongShort() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testLang996() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testLang538() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testMilleniumBug() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testLANG_831() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testLocaleMatches() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testParseNumerics() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testParseZone() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testPatternMatches() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testLocales_ShortNoEra_BC() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testLocales_ShortNoEra_AD() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testQuotes() {
    }

    @Override
    @Test
    @Ignore("Redundant Test Case (identified and added to concrete class by JSR)")
    public void testLowYearPadding() {
    }
}