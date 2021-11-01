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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.File;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import org.junit.Test;
import org.junit.Ignore;

/**
 * Test case for the PatternOptionBuilder class.
 */
// tests some deprecated classes
@SuppressWarnings("deprecation")
public class PatternOptionBuilderTest {

    @Test
    public void testSimplePattern() throws Exception {
        Options options = PatternOptionBuilder.parsePattern("a:b@cde>f+n%t/m*z#");
        String[] args = new String[] { "-c", "-a", "foo", "-b", "java.util.Vector", "-e", "build.xml", "-f", "java.util.Calendar", "-n", "4.5", "-t", "http://commons.apache.org", "-z", "Thu Jun 06 17:48:57 EDT 2002", "-m", "test*" };
        CommandLineParser parser = new PosixParser();
        CommandLine line = parser.parse(options, args);
        assertEquals("flag a", "foo", line.getOptionValue("a"));
        assertEquals("string flag a", "foo", line.getOptionObject("a"));
        assertEquals("object flag b", new Vector<Object>(), line.getOptionObject("b"));
        assertTrue("boolean true flag c", line.hasOption("c"));
        assertFalse("boolean false flag d", line.hasOption("d"));
        assertEquals("file flag e", new File("build.xml"), line.getOptionObject("e"));
        assertEquals("class flag f", Calendar.class, line.getOptionObject("f"));
        assertEquals("number flag n", new Double(4.5), line.getOptionObject("n"));
        assertEquals("url flag t", new URL("http://commons.apache.org"), line.getOptionObject("t"));
        // tests the char methods of CommandLine that delegate to the String methods
        assertEquals("flag a", "foo", line.getOptionValue('a'));
        assertEquals("string flag a", "foo", line.getOptionObject('a'));
        assertEquals("object flag b", new Vector<Object>(), line.getOptionObject('b'));
        assertTrue("boolean true flag c", line.hasOption('c'));
        assertFalse("boolean false flag d", line.hasOption('d'));
        assertEquals("file flag e", new File("build.xml"), line.getOptionObject('e'));
        assertEquals("class flag f", Calendar.class, line.getOptionObject('f'));
        assertEquals("number flag n", new Double(4.5), line.getOptionObject('n'));
        assertEquals("url flag t", new URL("http://commons.apache.org"), line.getOptionObject('t'));
        // FILES NOT SUPPORTED YET
        try {
            assertEquals("files flag m", new File[0], line.getOptionObject('m'));
            fail("Multiple files are not supported yet, should have failed");
        } catch (UnsupportedOperationException uoe) {
            // expected
        }
        // DATES NOT SUPPORTED YET
        try {
            assertEquals("date flag z", new Date(1023400137276L), line.getOptionObject('z'));
            fail("Date is not supported yet, should have failed");
        } catch (UnsupportedOperationException uoe) {
            // expected
        }
    }

    @Test
    public void testEmptyPattern() throws Exception {
        Options options = PatternOptionBuilder.parsePattern("");
        assertTrue(options.getOptions().isEmpty());
    }

    @Test
    public void testUntypedPattern() throws Exception {
        Options options = PatternOptionBuilder.parsePattern("abc");
        CommandLineParser parser = new PosixParser();
        CommandLine line = parser.parse(options, new String[] { "-abc" });
        assertTrue(line.hasOption('a'));
        assertNull("value a", line.getOptionObject('a'));
        assertTrue(line.hasOption('b'));
        assertNull("value b", line.getOptionObject('b'));
        assertTrue(line.hasOption('c'));
        assertNull("value c", line.getOptionObject('c'));
    }

    @Test
    public void testNumberPattern() throws Exception {
        Options options = PatternOptionBuilder.parsePattern("n%d%x%");
        CommandLineParser parser = new PosixParser();
        CommandLine line = parser.parse(options, new String[] { "-n", "1", "-d", "2.1", "-x", "3,5" });
        assertEquals("n object class", Long.class, line.getOptionObject("n").getClass());
        assertEquals("n value", new Long(1), line.getOptionObject("n"));
        assertEquals("d object class", Double.class, line.getOptionObject("d").getClass());
        assertEquals("d value", new Double(2.1), line.getOptionObject("d"));
        assertNull("x object", line.getOptionObject("x"));
    }

    @Test
    public void testClassPattern() throws Exception {
        Options options = PatternOptionBuilder.parsePattern("c+d+");
        CommandLineParser parser = new PosixParser();
        CommandLine line = parser.parse(options, new String[] { "-c", "java.util.Calendar", "-d", "System.DateTime" });
        assertEquals("c value", Calendar.class, line.getOptionObject("c"));
        assertNull("d value", line.getOptionObject("d"));
    }

    @Test
    public void testObjectPattern() throws Exception {
        Options options = PatternOptionBuilder.parsePattern("o@i@n@");
        CommandLineParser parser = new PosixParser();
        CommandLine line = parser.parse(options, new String[] { "-o", "java.lang.String", "-i", "java.util.Calendar", "-n", "System.DateTime" });
        assertEquals("o value", "", line.getOptionObject("o"));
        assertNull("i value", line.getOptionObject("i"));
        assertNull("n value", line.getOptionObject("n"));
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testURLPattern() throws Exception {
        Options options = PatternOptionBuilder.parsePattern("u/v/");
        CommandLineParser parser = new PosixParser();
        CommandLine line = parser.parse(options, new String[] { "-u", "http://commons.apache.org", "-v", "foo://commons.apache.org" });
        assertEquals("u value", new URL("http://commons.apache.org"), line.getOptionObject("u"));
        assertNull("v value", line.getOptionObject("v"));
    }

    @Test
    public void testExistingFilePattern() throws Exception {
        Options options = PatternOptionBuilder.parsePattern("f<");
        CommandLineParser parser = new PosixParser();
        CommandLine line = parser.parse(options, new String[] { "-f", "test.properties" });
        assertEquals("f value", new File("test.properties"), line.getOptionObject("f"));
        // todo test if an error is returned if the file doesn't exists (when it's implemented)
    }

    @Test
    public void testRequiredOption() throws Exception {
        Options options = PatternOptionBuilder.parsePattern("!n%m%");
        CommandLineParser parser = new PosixParser();
        try {
            parser.parse(options, new String[] { "" });
            fail("MissingOptionException wasn't thrown");
        } catch (MissingOptionException e) {
            assertEquals(1, e.getMissingOptions().size());
            assertTrue(e.getMissingOptions().contains("n"));
        }
    }
}
