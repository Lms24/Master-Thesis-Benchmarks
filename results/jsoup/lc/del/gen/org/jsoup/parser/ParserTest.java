package org.jsoup.parser;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;

public class ParserTest {

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void unescapeEntities() {
        String s = Parser.unescapeEntities("One &amp; Two", false);
        assertEquals("One & Two", s);
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void unescapeEntitiesHandlesLargeInput() {
        StringBuilder longBody = new StringBuilder(500000);
        do {
            longBody.append("SomeNonEncodedInput");
        } while (longBody.length() < 64 * 1024);
        String body = longBody.toString();
        assertEquals(body, Parser.unescapeEntities(body, false));
    }
}
