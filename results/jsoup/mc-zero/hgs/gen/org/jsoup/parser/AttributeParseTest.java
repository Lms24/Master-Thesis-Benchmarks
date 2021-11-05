package org.jsoup.parser;

import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.BooleanAttribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * Test suite for attribute parser.
 *
 * @author Jonathan Hedley, jonathan@hedley.net
 */
public class AttributeParseTest {

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void parsesRoughAttributeString() {
        String html = "<a id=\"123\" class=\"baz = 'bar'\" style = 'border: 2px'qux zim foo = 12 mux=18 />";
        // should be: <id=123>, <class=baz = 'bar'>, <qux=>, <zim=>, <foo=12>, <mux.=18>
        Element el = Jsoup.parse(html).getElementsByTag("a").get(0);
        Attributes attr = el.attributes();
        assertEquals(7, attr.size());
        assertEquals("123", attr.get("id"));
        assertEquals("baz = 'bar'", attr.get("class"));
        assertEquals("border: 2px", attr.get("style"));
        assertEquals("", attr.get("qux"));
        assertEquals("", attr.get("zim"));
        assertEquals("12", attr.get("foo"));
        assertEquals("18", attr.get("mux"));
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void handlesNewLinesAndReturns() {
        String html = "<a\r\nfoo='bar\r\nqux'\r\nbar\r\n=\r\ntwo>One</a>";
        Element el = Jsoup.parse(html).select("a").first();
        assertEquals(2, el.attributes().size());
        // currently preserves newlines in quoted attributes. todo confirm if should.
        assertEquals("bar\r\nqux", el.attr("foo"));
        assertEquals("two", el.attr("bar"));
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void parsesEmptyString() {
        String html = "<a />";
        Element el = Jsoup.parse(html).getElementsByTag("a").get(0);
        Attributes attr = el.attributes();
        assertEquals(0, attr.size());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void canStartWithEq() {
        String html = "<a =empty />";
        Element el = Jsoup.parse(html).getElementsByTag("a").get(0);
        Attributes attr = el.attributes();
        assertEquals(1, attr.size());
        assertTrue(attr.hasKey("=empty"));
        assertEquals("", attr.get("=empty"));
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void strictAttributeUnescapes() {
        String html = "<a id=1 href='?foo=bar&mid&lt=true'>One</a> <a id=2 href='?foo=bar&lt;qux&lg=1'>Two</a>";
        Elements els = Jsoup.parse(html).select("a");
        assertEquals("?foo=bar&mid&lt=true", els.first().attr("href"));
        assertEquals("?foo=bar<qux&lg=1", els.last().attr("href"));
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void moreAttributeUnescapes() {
        String html = "<a href='&wr_id=123&mid-size=true&ok=&wr'>Check</a>";
        Elements els = Jsoup.parse(html).select("a");
        assertEquals("&wr_id=123&mid-size=true&ok=&wr", els.first().attr("href"));
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void parsesBooleanAttributes() {
        String html = "<a normal=\"123\" boolean empty=\"\"></a>";
        Element el = Jsoup.parse(html).select("a").first();
        assertEquals("123", el.attr("normal"));
        assertEquals("", el.attr("boolean"));
        assertEquals("", el.attr("empty"));
        List<Attribute> attributes = el.attributes().asList();
        assertEquals("There should be 3 attribute present", 3, attributes.size());
        // Assuming the list order always follows the parsed html
        assertFalse("'normal' attribute should not be boolean", attributes.get(0) instanceof BooleanAttribute);
        assertTrue("'boolean' attribute should be boolean", attributes.get(1) instanceof BooleanAttribute);
        assertFalse("'empty' attribute should not be boolean", attributes.get(2) instanceof BooleanAttribute);
        assertEquals(html, el.outerHtml());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void dropsSlashFromAttributeName() {
        String html = "<img /onerror='doMyJob'/>";
        Document doc = Jsoup.parse(html);
        assertTrue("SelfClosingStartTag ignores last character", !doc.select("img[onerror]").isEmpty());
        assertEquals("<img onerror=\"doMyJob\">", doc.body().html());
        doc = Jsoup.parse(html, "", Parser.xmlParser());
        assertEquals("<img onerror=\"doMyJob\" />", doc.html());
    }
}
