package com.opencsv;

/*
 Copyright 2005 Bytecode Pty Ltd.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class CSVReaderTest {

    CSVReader csvr;

    @Before
    public void setUp() throws Exception {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        // standard case
        sb.append("a,b,c").append("\n");
        // quoted elements
        sb.append("a,\"b,b,b\",c").append("\n");
        // empty elements
        sb.append(",,").append("\n");
        sb.append("a,\"PO Box 123,\nKippax,ACT. 2615.\nAustralia\",d.\n");
        // Test quoted quote chars
        sb.append("\"Glen \"\"The Man\"\" Smith\",Athlete,Developer\n");
        // """""","test"  representing:  "", test
        sb.append("\"\"\"\"\"\",\"test\"\n");
        sb.append("\"a\nb\",b,\"\nd\",e\n");
        csvr = new CSVReader(new StringReader(sb.toString()));
    }

    /**
     * Tests iterating over a reader.
     *
     * @throws IOException if the reader fails.
     */
    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testParseLine() throws IOException {
        // test normal case
        String[] nextLine = csvr.readNext();
        assertEquals("a", nextLine[0]);
        assertEquals("b", nextLine[1]);
        assertEquals("c", nextLine[2]);
        // test quoted commas
        nextLine = csvr.readNext();
        assertEquals("a", nextLine[0]);
        assertEquals("b,b,b", nextLine[1]);
        assertEquals("c", nextLine[2]);
        // test empty elements
        nextLine = csvr.readNext();
        assertEquals(3, nextLine.length);
        // test multiline quoted
        nextLine = csvr.readNext();
        assertEquals(3, nextLine.length);
        // test quoted quote chars
        nextLine = csvr.readNext();
        assertEquals("Glen \"The Man\" Smith", nextLine[0]);
        nextLine = csvr.readNext();
        // check the tricky situation
        assertEquals("\"\"", nextLine[0]);
        // make sure we didn't ruin the next field..
        assertEquals("test", nextLine[1]);
        nextLine = csvr.readNext();
        assertEquals(4, nextLine.length);
        // test end of stream
        assertNull(csvr.readNext());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void readerCanHandleNullInString() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        sb.append("a,\0b,c");
        StringReader reader = new StringReader(sb.toString());
        CSVReaderBuilder builder = new CSVReaderBuilder(reader);
        CSVReader defaultReader = builder.build();
        String[] nextLine = defaultReader.readNext();
        assertEquals(3, nextLine.length);
        assertEquals("a", nextLine[0]);
        assertEquals("\0b", nextLine[1]);
        assertEquals(0, nextLine[1].charAt(0));
        assertEquals("c", nextLine[2]);
    }

    @Test
    public void testParseLineStrictQuote() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        // standard case
        sb.append("a,b,c").append("\n");
        // quoted elements
        sb.append("a,\"b,b,b\",c").append("\n");
        // empty elements
        sb.append(",,").append("\n");
        sb.append("a,\"PO Box 123,\nKippax,ACT. 2615.\nAustralia\",d.\n");
        // Test quoted quote chars
        sb.append("\"Glen \"\"The Man\"\" Smith\",Athlete,Developer\n");
        // """""","test"  representing:  "", test
        sb.append("\"\"\"\"\"\",\"test\"\n");
        sb.append("\"a\nb\",b,\"\nd\",e\n");
        csvr = new CSVReader(new StringReader(sb.toString()), ',', '\"', true);
        // test normal case
        String[] nextLine = csvr.readNext();
        assertEquals("", nextLine[0]);
        assertEquals("", nextLine[1]);
        assertEquals("", nextLine[2]);
        // test quoted commas
        nextLine = csvr.readNext();
        assertEquals("", nextLine[0]);
        assertEquals("b,b,b", nextLine[1]);
        assertEquals("", nextLine[2]);
        // test empty elements
        nextLine = csvr.readNext();
        assertEquals(3, nextLine.length);
        // test multiline quoted
        nextLine = csvr.readNext();
        assertEquals(3, nextLine.length);
        // test quoted quote chars
        nextLine = csvr.readNext();
        assertEquals("Glen \"The Man\" Smith", nextLine[0]);
        nextLine = csvr.readNext();
        // check the tricky situation
        assertTrue(nextLine[0].equals("\"\""));
        // make sure we didn't ruin the next field..
        assertTrue(nextLine[1].equals("test"));
        nextLine = csvr.readNext();
        assertEquals(4, nextLine.length);
        assertEquals("a\nb", nextLine[0]);
        assertEquals("", nextLine[1]);
        assertEquals("\nd", nextLine[2]);
        assertEquals("", nextLine[3]);
        // test end of stream
        assertNull(csvr.readNext());
    }

    /**
     * Test parsing to a list.
     *
     * @throws IOException if the reader fails.
     */
    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testParseAll() throws IOException {
        assertEquals(7, csvr.readAll().size());
    }

    /**
     * Tests constructors with optional delimiters and optional quote char.
     *
     * @throws IOException if the reader fails.
     */
    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testOptionalConstructors() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        // tab separated case
        sb.append("a\tb\tc").append("\n");
        // single quoted elements
        sb.append("a\t'b\tb\tb'\tc").append("\n");
        CSVReader c = new CSVReader(new StringReader(sb.toString()), '\t', '\'');
        String[] nextLine = c.readNext();
        assertEquals(3, nextLine.length);
        nextLine = c.readNext();
        assertEquals(3, nextLine.length);
    }

    @Test
    public void parseQuotedStringWithDefinedSeperator() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        // tab separated case
        sb.append("a\tb\tc").append("\n");
        CSVReader c = new CSVReader(new StringReader(sb.toString()), '\t');
        String[] nextLine = c.readNext();
        assertEquals(3, nextLine.length);
    }

    /**
     * Tests option to skip the first few lines of a file.
     *
     * @throws IOException if bad things happen
     */
    @Test
    public void testSkippingLines() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        // should skip this
        sb.append("Skip this line\t with tab").append("\n");
        // and this
        sb.append("And this line too").append("\n");
        // single quoted elements
        sb.append("a\t'b\tb\tb'\tc").append("\n");
        CSVReader c = new CSVReader(new StringReader(sb.toString()), '\t', '\'', 2);
        String[] nextLine = c.readNext();
        assertEquals(3, nextLine.length);
        assertEquals("a", nextLine[0]);
    }

    /**
     * Tests methods to get the number of lines and records read.
     *
     * @throws IOException if bad things happen
     */
    @Test
    public void linesAndRecordsRead() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        // should skip this
        sb.append("Skip this line\t with tab").append("\n");
        // and this
        sb.append("And this line too").append("\n");
        // second line
        sb.append("a,b,c").append("\n");
        // no data here just a blank line
        sb.append("\n");
        sb.append("a,\"b\nb\",c");
        CSVReaderBuilder builder = new CSVReaderBuilder(new StringReader(sb.toString()));
        CSVReader c = builder.withCSVParser(new CSVParser()).withSkipLines(2).build();
        assertEquals(0, c.getLinesRead());
        assertEquals(0, c.getRecordsRead());
        String[] nextLine = c.readNext();
        assertEquals(3, nextLine.length);
        assertEquals(3, c.getLinesRead());
        assertEquals(1, c.getRecordsRead());
        nextLine = c.readNext();
        assertEquals(1, nextLine.length);
        assertEquals(0, nextLine[0].length());
        assertEquals(4, c.getLinesRead());
        // A blank line is considered a record with a single element
        assertEquals(2, c.getRecordsRead());
        nextLine = c.readNext();
        assertEquals(3, nextLine.length);
        assertEquals(6, c.getLinesRead());
        // two lines read to get a single record.
        assertEquals(3, c.getRecordsRead());
        // reading after all the data has been read.
        nextLine = c.readNext();
        assertNull(nextLine);
        assertEquals(6, c.getLinesRead());
        assertEquals(3, c.getRecordsRead());
    }

    /**
     * Tests option to skip the first few lines of a file.
     *
     * @throws IOException if bad things happen
     */
    @Test
    public void testSkippingLinesWithDifferentEscape() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        // should skip this
        sb.append("Skip this line?t with tab").append("\n");
        // and this
        sb.append("And this line too").append("\n");
        // single quoted elements
        sb.append("a\t'b\tb\tb'\t'c'").append("\n");
        CSVReader c = new CSVReader(new StringReader(sb.toString()), '\t', '\'', '?', 2);
        String[] nextLine = c.readNext();
        assertEquals(3, nextLine.length);
        assertEquals("a", nextLine[0]);
        assertEquals("b\tb\tb", nextLine[1]);
        assertEquals("c", nextLine[2]);
    }

    /**
     * Test a normal non quoted line with three elements
     *
     * @throws IOException But not really
     */
    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testNormalParsedLine() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        // a,1234,c
        sb.append("a,1234567,c").append("\n");
        CSVReader c = new CSVReader(new StringReader(sb.toString()));
        String[] nextLine = c.readNext();
        assertEquals(3, nextLine.length);
        assertEquals("a", nextLine[0]);
        assertEquals("1234567", nextLine[1]);
        assertEquals("c", nextLine[2]);
    }

    /**
     * Same as testADoubleQuoteAsDataElement but I changed the quotechar to a
     * single quote.
     *
     * @throws IOException But not really
     */
    @Test
    public void testASingleQuoteAsDataElement() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        // a,',c
        sb.append("a,'''',c").append("\n");
        CSVReader c = new CSVReader(new StringReader(sb.toString()), ',', '\'');
        String[] nextLine = c.readNext();
        assertEquals(3, nextLine.length);
        assertEquals("a", nextLine[0]);
        assertEquals(1, nextLine[1].length());
        assertEquals("\'", nextLine[1]);
        assertEquals("c", nextLine[2]);
    }

    /**
     * Same as testADoubleQuoteAsDataElement but I changed the quotechar to a
     * single quote.  Also the middle field is empty.
     *
     * @throws IOException But not really
     */
    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testASingleQuoteAsDataElementWithEmptyField() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        // a,,c
        sb.append("a,'',c").append("\n");
        CSVReader c = new CSVReader(new StringReader(sb.toString()), ',', '\'');
        String[] nextLine = c.readNext();
        assertEquals(3, nextLine.length);
        assertEquals("a", nextLine[0]);
        assertEquals(0, nextLine[1].length());
        assertEquals("", nextLine[1]);
        assertEquals("c", nextLine[2]);
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testSpacesAtEndOfString() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        sb.append("\"a\",\"b\",\"c\"   ");
        CSVReader c = new CSVReader(new StringReader(sb.toString()), ICSVParser.DEFAULT_SEPARATOR, ICSVParser.DEFAULT_QUOTE_CHARACTER, true);
        String[] nextLine = c.readNext();
        assertEquals(3, nextLine.length);
        assertEquals("a", nextLine[0]);
        assertEquals("b", nextLine[1]);
        assertEquals("c", nextLine[2]);
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testEscapedQuote() throws IOException {
        StringBuilder sb = new StringBuilder();
        // a,123"4",c
        sb.append("a,\"123\\\"4567\",c").append("\n");
        CSVReader c = new CSVReader(new StringReader(sb.toString()));
        String[] nextLine = c.readNext();
        assertEquals(3, nextLine.length);
        assertEquals("123\"4567", nextLine[1]);
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testEscapedEscape() throws IOException {
        StringBuilder sb = new StringBuilder();
        // a,123"4",c
        sb.append("a,\"123\\\\4567\",c").append("\n");
        CSVReader c = new CSVReader(new StringReader(sb.toString()));
        String[] nextLine = c.readNext();
        assertEquals(3, nextLine.length);
        assertEquals("123\\4567", nextLine[1]);
    }

    /**
     * Test a line where one of the elements is two single quotes and the
     * quote character is the default double quote.  The expected result is two
     * single quotes.
     *
     * @throws IOException But not really
     */
    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testSingleQuoteWhenDoubleQuoteIsQuoteChar() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        // a,'',c
        sb.append("a,'',c").append("\n");
        CSVReader c = new CSVReader(new StringReader(sb.toString()));
        String[] nextLine = c.readNext();
        assertEquals(3, nextLine.length);
        assertEquals("a", nextLine[0]);
        assertEquals(2, nextLine[1].length());
        assertEquals("''", nextLine[1]);
        assertEquals("c", nextLine[2]);
    }

    /**
     * Test a normal line with three elements and all elements are quoted
     *
     * @throws IOException But not really
     */
    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testQuotedParsedLine() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        // "a","1234567","c"
        sb.append("\"a\",\"1234567\",\"c\"").append("\n");
        CSVReader c = new CSVReader(new StringReader(sb.toString()), ICSVParser.DEFAULT_SEPARATOR, ICSVParser.DEFAULT_QUOTE_CHARACTER, true);
        String[] nextLine = c.readNext();
        assertEquals(3, nextLine.length);
        assertEquals("a", nextLine[0]);
        assertEquals(1, nextLine[0].length());
        assertEquals("1234567", nextLine[1]);
        assertEquals("c", nextLine[2]);
    }

    @Test
    public void bug106ParseLineWithCarriageReturnNewLineStrictQuotes() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        // "a","123\r\n4567","c"
        sb.append("\"a\",\"123\r\n4567\",\"c\"").append("\n");
        // public CSVReader(Reader reader, char separator, char quotechar, char escape, int line, boolean strictQuotes,
        // boolean ignoreLeadingWhiteSpace, boolean keepCarriageReturn)
        CSVReader c = new CSVReader(new StringReader(sb.toString()), ICSVParser.DEFAULT_SEPARATOR, ICSVParser.DEFAULT_QUOTE_CHARACTER, ICSVParser.DEFAULT_ESCAPE_CHARACTER, CSVReader.DEFAULT_SKIP_LINES, true, ICSVParser.DEFAULT_IGNORE_LEADING_WHITESPACE, true);
        String[] nextLine = c.readNext();
        assertEquals(3, nextLine.length);
        assertEquals("a", nextLine[0]);
        assertEquals(1, nextLine[0].length());
        assertEquals("123\r\n4567", nextLine[1]);
        assertEquals("c", nextLine[2]);
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testIssue2992134OutOfPlaceQuotes() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        sb.append("a,b,c,ddd\\\"eee\nf,g,h,\"iii,jjj\"");
        CSVReader c = new CSVReader(new StringReader(sb.toString()));
        String[] nextLine = c.readNext();
        assertEquals("a", nextLine[0]);
        assertEquals("b", nextLine[1]);
        assertEquals("c", nextLine[2]);
        assertEquals("ddd\"eee", nextLine[3]);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void quoteAndEscapeMustBeDifferent() {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        sb.append("a,b,c,ddd\\\"eee\nf,g,h,\"iii,jjj\"");
        new CSVReader(new StringReader(sb.toString()), ICSVParser.DEFAULT_SEPARATOR, ICSVParser.DEFAULT_QUOTE_CHARACTER, ICSVParser.DEFAULT_QUOTE_CHARACTER, CSVReader.DEFAULT_SKIP_LINES, ICSVParser.DEFAULT_STRICT_QUOTES, ICSVParser.DEFAULT_IGNORE_LEADING_WHITESPACE);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void separatorAndEscapeMustBeDifferent() {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        sb.append("a,b,c,ddd\\\"eee\nf,g,h,\"iii,jjj\"");
        new CSVReader(new StringReader(sb.toString()), ICSVParser.DEFAULT_SEPARATOR, ICSVParser.DEFAULT_QUOTE_CHARACTER, ICSVParser.DEFAULT_SEPARATOR, CSVReader.DEFAULT_SKIP_LINES, ICSVParser.DEFAULT_STRICT_QUOTES, ICSVParser.DEFAULT_IGNORE_LEADING_WHITESPACE);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void separatorAndQuoteMustBeDifferent() {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        sb.append("a,b,c,ddd\\\"eee\nf,g,h,\"iii,jjj\"");
        new CSVReader(new StringReader(sb.toString()), ICSVParser.DEFAULT_SEPARATOR, ICSVParser.DEFAULT_SEPARATOR, ICSVParser.DEFAULT_ESCAPE_CHARACTER, CSVReader.DEFAULT_SKIP_LINES, ICSVParser.DEFAULT_STRICT_QUOTES, ICSVParser.DEFAULT_IGNORE_LEADING_WHITESPACE);
    }

    /**
     * Tests iterating over a reader.
     *
     * @throws IOException if the reader fails.
     */
    @Test
    public void testIteratorFunctionality() throws IOException {
        String[][] expectedResult = new String[7][];
        expectedResult[0] = new String[] { "a", "b", "c" };
        expectedResult[1] = new String[] { "a", "b,b,b", "c" };
        expectedResult[2] = new String[] { "", "", "" };
        expectedResult[3] = new String[] { "a", "PO Box 123,\nKippax,ACT. 2615.\nAustralia", "d." };
        expectedResult[4] = new String[] { "Glen \"The Man\" Smith", "Athlete", "Developer" };
        expectedResult[5] = new String[] { "\"\"", "test" };
        expectedResult[6] = new String[] { "a\nb", "b", "\nd", "e" };
        int idx = 0;
        for (String[] line : csvr) {
            String[] expectedLine = expectedResult[idx++];
            assertArrayEquals(expectedLine, line);
        }
    }

    @Test
    public void canCloseReader() throws IOException {
        csvr.close();
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void canCreateIteratorFromReader() {
        assertNotNull(csvr.iterator());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void attemptToReadCloseStreamReturnsNull() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new StringReader(""));
        bufferedReader.close();
        CSVReader csvReader = new CSVReader(bufferedReader);
        assertNull(csvReader.readNext());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testIssue102() throws IOException {
        CSVReader csvReader = new CSVReader(new StringReader("\"\",a\n\"\",b\n"));
        String[] firstRow = csvReader.readNext();
        assertEquals(2, firstRow.length);
        assertTrue(firstRow[0].isEmpty());
        assertEquals("a", firstRow[1]);
        String[] secondRow = csvReader.readNext();
        assertEquals(2, secondRow.length);
        assertTrue(secondRow[0].isEmpty());
        assertEquals("b", secondRow[1]);
    }

    @Test
    public void issue108ReaderPlaysWellWithChannels() throws IOException {
        byte[] bytes = "name\r\nvalue\r\n".getBytes("UTF-8");
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ReadableByteChannel ch = Channels.newChannel(bais);
        InputStream in = Channels.newInputStream(ch);
        InputStreamReader reader = new InputStreamReader(in, Charset.forName("UTF-8"));
        CSVReaderBuilder builder = new CSVReaderBuilder(reader);
        CSVReader csv = builder.withVerifyReader(false).build();
        assertEquals(2, csv.readAll().size());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void featureRequest60ByDefaultEmptyFieldsAreBlank() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        sb.append(",,,\"\",");
        StringReader stringReader = new StringReader(sb.toString());
        CSVReaderBuilder builder = new CSVReaderBuilder(stringReader);
        CSVReader csvReader = builder.build();
        String[] row = csvReader.readNext();
        assertEquals(5, row.length);
        assertEquals("", row[0]);
        assertEquals("", row[1]);
        assertEquals("", row[2]);
        assertEquals("", row[3]);
        assertEquals("", row[4]);
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void featureRequest60TreatEmptyFieldsAsNull() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        sb.append(",,,\"\",");
        StringReader stringReader = new StringReader(sb.toString());
        CSVReaderBuilder builder = new CSVReaderBuilder(stringReader);
        CSVReader csvReader = builder.withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS).build();
        String[] item = csvReader.readNext();
        assertEquals(5, item.length);
        assertNull(item[0]);
        assertNull(item[1]);
        assertNull(item[2]);
        assertEquals("", item[3]);
        assertNull(item[4]);
    }

    @Test
    public void featureRequest60TreatEmptyDelimitedFieldsAsNull() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        sb.append(",,,\"\",");
        StringReader stringReader = new StringReader(sb.toString());
        CSVReaderBuilder builder = new CSVReaderBuilder(stringReader);
        CSVReader csvReader = builder.withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_QUOTES).build();
        String[] item = csvReader.readNext();
        assertEquals(5, item.length);
        assertEquals("", item[0]);
        assertEquals("", item[1]);
        assertEquals("", item[2]);
        assertNull(item[3]);
        assertEquals("", item[4]);
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void featureRequest60TreatEmptyFieldsDelimitedOrNotAsNull() throws IOException {
        StringBuilder sb = new StringBuilder(ICSVParser.INITIAL_READ_SIZE);
        sb.append(",,,\"\",");
        StringReader stringReader = new StringReader(sb.toString());
        CSVReaderBuilder builder = new CSVReaderBuilder(stringReader);
        CSVReader csvReader = builder.withFieldAsNull(CSVReaderNullFieldIndicator.BOTH).build();
        String[] item = csvReader.readNext();
        assertEquals(5, item.length);
        assertNull(item[0]);
        assertNull(item[1]);
        assertNull(item[2]);
        assertNull(item[3]);
        assertNull(item[4]);
    }
}
