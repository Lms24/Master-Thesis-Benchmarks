package org.jsoup.parser;

import org.jsoup.MultiLocaleRule;
import org.jsoup.MultiLocaleRule.MultiLocaleTest;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * Tag tests.
 * @author Jonathan Hedley, jonathan@hedley.net
 */
public class TagTest {

    @Rule
    public MultiLocaleRule rule = new MultiLocaleRule();

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void isCaseSensitive() {
        Tag p1 = Tag.valueOf("P");
        Tag p2 = Tag.valueOf("p");
        assertFalse(p1.equals(p2));
    }

    @Test
    @MultiLocaleTest
    @Ignore("Redundant Test Case (identified by JSR)")
    public void canBeInsensitive() {
        Tag script1 = Tag.valueOf("script", ParseSettings.htmlDefault);
        Tag script2 = Tag.valueOf("SCRIPT", ParseSettings.htmlDefault);
        assertSame(script1, script2);
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void trims() {
        Tag p1 = Tag.valueOf("p");
        Tag p2 = Tag.valueOf(" p ");
        assertEquals(p1, p2);
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void equality() {
        Tag p1 = Tag.valueOf("p");
        Tag p2 = Tag.valueOf("p");
        assertTrue(p1.equals(p2));
        assertTrue(p1 == p2);
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void divSemantics() {
        Tag div = Tag.valueOf("div");
        assertTrue(div.isBlock());
        assertTrue(div.formatAsBlock());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void pSemantics() {
        Tag p = Tag.valueOf("p");
        assertTrue(p.isBlock());
        assertFalse(p.formatAsBlock());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void imgSemantics() {
        Tag img = Tag.valueOf("img");
        assertTrue(img.isInline());
        assertTrue(img.isSelfClosing());
        assertFalse(img.isBlock());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void defaultSemantics() {
        // not defined
        Tag foo = Tag.valueOf("FOO");
        Tag foo2 = Tag.valueOf("FOO");
        assertEquals(foo, foo2);
        assertTrue(foo.isInline());
        assertTrue(foo.formatAsBlock());
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore("Redundant Test Case (identified by JSR)")
    public void valueOfChecksNotNull() {
        Tag.valueOf(null);
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore("Redundant Test Case (identified by JSR)")
    public void valueOfChecksNotEmpty() {
        Tag.valueOf(" ");
    }
}
