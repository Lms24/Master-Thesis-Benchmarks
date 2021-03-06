package com.github.freva.asciitable;

import org.junit.Test;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.junit.Assert.assertEquals;

public class LineUtilsTest {

    @Test
    public void linesIteratorTest() {
        assertEquals(Arrays.asList("", "", "Some text", "", "more text", "text", "end"), LineUtils.lines("\n\nSome text\r\n\rmore text\rtext\nend").collect(Collectors.toList()));
    }
}
