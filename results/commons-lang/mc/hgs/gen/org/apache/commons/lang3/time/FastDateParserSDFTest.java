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

import static org.junit.Assert.*;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Compare FastDateParser with SimpleDateFormat
 */
@RunWith(Parameterized.class)
public class FastDateParserSDFTest {

    @Parameters(name = "{index}: {0} {1} {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { // General Time zone tests
        // no offset specified, but this is allowed as a TimeZone name
        { "z yyyy", "GMT 2010", Locale.UK, true }, { "z yyyy", "GMT-123 2010", Locale.UK, false }, { "z yyyy", "GMT-1234 2010", Locale.UK, false }, { "z yyyy", "GMT-12:34 2010", Locale.UK, true }, { "z yyyy", "GMT-1:23 2010", Locale.UK, true }, // RFC 822 tests
        { "z yyyy", "-1234 2010", Locale.UK, true }, { "z yyyy", "-12:34 2010", Locale.UK, false }, { "z yyyy", "-123 2010", Locale.UK, false }, // year tests
        { "MM/dd/yyyy", "01/11/12", Locale.UK, true }, { "MM/dd/yy", "01/11/12", Locale.UK, true }, // LANG-1089
        // Hour in day (0-23)
        { "HH", "00", Locale.UK, true }, // Hour in am/pm (0-11)
        { "KK", "00", Locale.UK, true }, // Hour in am/pm (1-12), i.e. midday/midnight is 12, not 0
        { "hh", "00", Locale.UK, true }, // Hour in day (1-24), i.e. midnight is 24, not 0
        { "kk", "00", Locale.UK, true }, // Hour in day (0-23)
        { "HH", "01", Locale.UK, true }, // Hour in am/pm (0-11)
        { "KK", "01", Locale.UK, true }, // Hour in am/pm (1-12), i.e. midday/midnight is 12, not 0
        { "hh", "01", Locale.UK, true }, // Hour in day (1-24), i.e. midnight is 24, not 0
        { "kk", "01", Locale.UK, true }, // Hour in day (0-23)
        { "HH", "11", Locale.UK, true }, // Hour in am/pm (0-11)
        { "KK", "11", Locale.UK, true }, // Hour in am/pm (1-12), i.e. midday/midnight is 12, not 0
        { "hh", "11", Locale.UK, true }, // Hour in day (1-24), i.e. midnight is 24, not 0
        { "kk", "11", Locale.UK, true }, // Hour in day (0-23)
        { "HH", "12", Locale.UK, true }, // Hour in am/pm (0-11)
        { "KK", "12", Locale.UK, true }, // Hour in am/pm (1-12), i.e. midday/midnight is 12, not 0
        { "hh", "12", Locale.UK, true }, // Hour in day (1-24), i.e. midnight is 24, not 0
        { "kk", "12", Locale.UK, true }, // Hour in day (0-23)
        { "HH", "13", Locale.UK, true }, // Hour in am/pm (0-11)
        { "KK", "13", Locale.UK, true }, // Hour in am/pm (1-12), i.e. midday/midnight is 12, not 0
        { "hh", "13", Locale.UK, true }, // Hour in day (1-24), i.e. midnight is 24, not 0
        { "kk", "13", Locale.UK, true }, // Hour in day (0-23)
        { "HH", "23", Locale.UK, true }, // Hour in am/pm (0-11)
        { "KK", "23", Locale.UK, true }, // Hour in am/pm (1-12), i.e. midday/midnight is 12, not 0
        { "hh", "23", Locale.UK, true }, // Hour in day (1-24), i.e. midnight is 24, not 0
        { "kk", "23", Locale.UK, true }, // Hour in day (0-23)
        { "HH", "24", Locale.UK, true }, // Hour in am/pm (0-11)
        { "KK", "24", Locale.UK, true }, // Hour in am/pm (1-12), i.e. midday/midnight is 12, not 0
        { "hh", "24", Locale.UK, true }, // Hour in day (1-24), i.e. midnight is 24, not 0
        { "kk", "24", Locale.UK, true }, // Hour in day (0-23)
        { "HH", "25", Locale.UK, true }, // Hour in am/pm (0-11)
        { "KK", "25", Locale.UK, true }, // Hour in am/pm (1-12), i.e. midday/midnight is 12, not 0
        { "hh", "25", Locale.UK, true }, // Hour in day (1-24), i.e. midnight is 24, not 0
        { "kk", "25", Locale.UK, true }, // Hour in day (0-23)
        { "HH", "48", Locale.UK, true }, // Hour in am/pm (0-11)
        { "KK", "48", Locale.UK, true }, // Hour in am/pm (1-12), i.e. midday/midnight is 12, not 0
        { "hh", "48", Locale.UK, true }, // Hour in day (1-24), i.e. midnight is 24, not 0
        { "kk", "48", Locale.UK, true } });
    }

    private final String format;

    private final String input;

    private final Locale locale;

    private final boolean valid;

    private final TimeZone timeZone = TimeZone.getDefault();

    public FastDateParserSDFTest(String format, String input, Locale locale, boolean valid) {
        this.format = format;
        this.input = input;
        this.locale = locale;
        this.valid = valid;
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testOriginal() throws Exception {
        checkParse(input);
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testOriginalPP() throws Exception {
        checkParsePosition(input);
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testUpperCase() throws Exception {
        checkParse(input.toUpperCase(locale));
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testUpperCasePP() throws Exception {
        checkParsePosition(input.toUpperCase(locale));
    }

    @Test
    // not currently supported
    @Ignore
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testLowerCase() throws Exception {
        checkParse(input.toLowerCase(locale));
    }

    @Test
    // not currently supported
    @Ignore
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testLowerCasePP() throws Exception {
        checkParsePosition(input.toLowerCase(locale));
    }

    private void checkParse(final String formattedDate) throws ParseException {
        final SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
        sdf.setTimeZone(timeZone);
        final DateParser fdf = new FastDateParser(format, timeZone, locale);
        Date expectedTime = null;
        Class<?> sdfE = null;
        try {
            expectedTime = sdf.parse(formattedDate);
            if (!valid) {
                // Error in test data
                throw new RuntimeException("Test data error: expected SDF parse to fail, but got " + expectedTime);
            }
        } catch (ParseException e) {
            if (valid) {
                // Error in test data
                throw new RuntimeException("Test data error: expected SDF parse to succeed, but got " + e);
            }
            sdfE = e.getClass();
        }
        Date actualTime = null;
        Class<?> fdfE = null;
        try {
            actualTime = fdf.parse(formattedDate);
            if (!valid) {
                // failure in test
                fail("Expected FDP parse to fail, but got " + actualTime);
            }
        } catch (ParseException e) {
            if (valid) {
                // failure in test
                fail("Expected FDP parse to succeed, but got " + e);
            }
            fdfE = e.getClass();
        }
        if (valid) {
            assertEquals(locale.toString() + " " + formattedDate + "\n", expectedTime, actualTime);
        } else {
            assertEquals(locale.toString() + " " + formattedDate + " expected same Exception ", sdfE, fdfE);
        }
    }

    private void checkParsePosition(final String formattedDate) throws ParseException {
        final SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
        sdf.setTimeZone(timeZone);
        final DateParser fdf = new FastDateParser(format, timeZone, locale);
        ParsePosition sdfP = new ParsePosition(0);
        Date expectedTime = sdf.parse(formattedDate, sdfP);
        if (valid) {
            assertEquals("Expected SDF error index -1 ", -1, sdfP.getErrorIndex());
            final int endIndex = sdfP.getIndex();
            final int length = formattedDate.length();
            if (endIndex != length) {
                // Error in test data
                throw new RuntimeException("Test data error: expected SDF parse to consume entire string; endindex " + endIndex + " != " + length);
            }
        } else {
            final int errorIndex = sdfP.getErrorIndex();
            if (errorIndex == -1) {
                throw new RuntimeException("Test data error: expected SDF parse to fail, but got " + expectedTime);
            }
        }
        final ParsePosition fdfP = new ParsePosition(0);
        Date actualTime = fdf.parse(formattedDate, fdfP);
        final int fdferrorIndex = fdfP.getErrorIndex();
        if (valid) {
            assertEquals("Expected FDF error index -1 ", -1, fdferrorIndex);
            final int endIndex = fdfP.getIndex();
            final int length = formattedDate.length();
            assertEquals("Expected FDF to parse full string " + fdfP, length, endIndex);
            assertEquals(locale.toString() + " " + formattedDate + "\n", expectedTime, actualTime);
        } else {
            final int endIndex = fdfP.getIndex();
            if (endIndex != -0) {
                fail("Expected FDF parse to fail, but got " + fdfP);
            }
            if (fdferrorIndex != -1) {
                assertEquals("FDF error index should match SDF index (if it is set)", sdfP.getErrorIndex(), fdferrorIndex);
            }
        }
    }
}
