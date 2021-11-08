package com.opencsv;

import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Ignore;

public class CSVIteratorTest {

    private static final String[] STRINGS = { "test1", "test2" };

    private CSVIterator iterator;

    private CSVReader mockReader;

    @Before
    public void setUp() throws IOException {
        mockReader = mock(CSVReader.class);
        when(mockReader.readNext()).thenReturn(STRINGS);
        iterator = new CSVIterator(mockReader);
    }

    @Test(expected = NoSuchElementException.class)
    public void readerExceptionCausesRunTimeException() throws IOException {
        when(mockReader.readNext()).thenThrow(new IOException("reader threw test exception"));
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removethrowsUnsupportedOperationException() {
        iterator.remove();
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void initialReadReturnsStrings() {
        assertArrayEquals(STRINGS, iterator.next());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void hasNextWorks() throws IOException {
        when(mockReader.readNext()).thenReturn(null);
        // initial read from constructor
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }
}
