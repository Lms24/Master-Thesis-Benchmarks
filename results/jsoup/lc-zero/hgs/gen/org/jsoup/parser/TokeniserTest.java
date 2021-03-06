package org.jsoup.parser;

import static org.jsoup.parser.CharacterReader.maxBufferLen;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.CDataNode;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.Ignore;

public class TokeniserTest {

    @Test
    public void bufferUpInAttributeVal() {
        // https://github.com/jhy/jsoup/issues/967
        // check each double, singlem, unquoted impls
        String[] quotes = { "\"", "'", "" };
        for (String quote : quotes) {
            String preamble = "<img src=" + quote;
            String tail = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
            StringBuilder sb = new StringBuilder(preamble);
            final int charsToFillBuffer = maxBufferLen - preamble.length();
            for (int i = 0; i < charsToFillBuffer; i++) {
                sb.append('a');
            }
            // First character to cross character buffer boundary
            sb.append('X');
            sb.append(tail).append(quote).append(">\n");
            String html = sb.toString();
            Document doc = Jsoup.parse(html);
            String src = doc.select("img").attr("src");
            assertTrue("Handles for quote " + quote, src.contains("X"));
            assertTrue(src.contains(tail));
        }
    }

    @Test
    public void handleSuperLargeTagNames() {
        // unlikely, but valid. so who knows.
        StringBuilder sb = new StringBuilder(maxBufferLen);
        do {
            sb.append("LargeTagName");
        } while (sb.length() < maxBufferLen);
        String tag = sb.toString();
        String html = "<" + tag + ">One</" + tag + ">";
        Document doc = Parser.htmlParser().settings(ParseSettings.preserveCase).parseInput(html, "");
        Elements els = doc.select(tag);
        assertEquals(1, els.size());
        Element el = els.first();
        assertNotNull(el);
        assertEquals("One", el.text());
        assertEquals(tag, el.tagName());
    }

    @Test
    public void handleSuperLargeAttributeName() {
        StringBuilder sb = new StringBuilder(maxBufferLen);
        do {
            sb.append("LargAttributeName");
        } while (sb.length() < maxBufferLen);
        String attrName = sb.toString();
        String html = "<p " + attrName + "=foo>One</p>";
        Document doc = Jsoup.parse(html);
        Elements els = doc.getElementsByAttribute(attrName);
        assertEquals(1, els.size());
        Element el = els.first();
        assertNotNull(el);
        assertEquals("One", el.text());
        Attribute attribute = el.attributes().asList().get(0);
        assertEquals(attrName.toLowerCase(), attribute.getKey());
        assertEquals("foo", attribute.getValue());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void handleLargeText() {
        StringBuilder sb = new StringBuilder(maxBufferLen);
        do {
            sb.append("A Large Amount of Text");
        } while (sb.length() < maxBufferLen);
        String text = sb.toString();
        String html = "<p>" + text + "</p>";
        Document doc = Jsoup.parse(html);
        Elements els = doc.select("p");
        assertEquals(1, els.size());
        Element el = els.first();
        assertNotNull(el);
        assertEquals(text, el.text());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void handleLargeComment() {
        StringBuilder sb = new StringBuilder(maxBufferLen);
        do {
            sb.append("Quite a comment ");
        } while (sb.length() < maxBufferLen);
        String comment = sb.toString();
        String html = "<p><!-- " + comment + " --></p>";
        Document doc = Jsoup.parse(html);
        Elements els = doc.select("p");
        assertEquals(1, els.size());
        Element el = els.first();
        assertNotNull(el);
        Comment child = (Comment) el.childNode(0);
        assertEquals(" " + comment + " ", child.getData());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void handleLargeCdata() {
        StringBuilder sb = new StringBuilder(maxBufferLen);
        do {
            sb.append("Quite a lot of CDATA <><><><>");
        } while (sb.length() < maxBufferLen);
        String cdata = sb.toString();
        String html = "<p><![CDATA[" + cdata + "]]></p>";
        Document doc = Jsoup.parse(html);
        Elements els = doc.select("p");
        assertEquals(1, els.size());
        Element el = els.first();
        assertNotNull(el);
        TextNode child = (TextNode) el.childNode(0);
        assertEquals(cdata, el.text());
        assertEquals(cdata, child.getWholeText());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void handleLargeTitle() {
        StringBuilder sb = new StringBuilder(maxBufferLen);
        do {
            sb.append("Quite a long title");
        } while (sb.length() < maxBufferLen);
        String title = sb.toString();
        String html = "<title>" + title + "</title>";
        Document doc = Jsoup.parse(html);
        Elements els = doc.select("title");
        assertEquals(1, els.size());
        Element el = els.first();
        assertNotNull(el);
        TextNode child = (TextNode) el.childNode(0);
        assertEquals(title, el.text());
        assertEquals(title, child.getWholeText());
        assertEquals(title, doc.title());
    }

    @Test
    public void cp1252Entities() {
        assertEquals("\u20ac", Jsoup.parse("&#0128;").text());
        assertEquals("\u201a", Jsoup.parse("&#0130;").text());
        assertEquals("\u20ac", Jsoup.parse("&#x80;").text());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void cp1252EntitiesProduceError() {
        Parser parser = new Parser(new HtmlTreeBuilder());
        parser.setTrackErrors(10);
        assertEquals("\u20ac", parser.parseInput("<html><body>&#0128;</body></html>", "").text());
        assertEquals(1, parser.getErrors().size());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void cp1252SubstitutionTable() throws UnsupportedEncodingException {
        for (int i = 0; i < Tokeniser.win1252Extensions.length; i++) {
            String s = new String(new byte[] { (byte) (i + Tokeniser.win1252ExtensionsStart) }, "Windows-1252");
            assertEquals(1, s.length());
            // some of these characters are illegal
            if (s.charAt(0) == '\ufffd') {
                continue;
            }
            assertEquals("At: " + i, s.charAt(0), Tokeniser.win1252Extensions[i]);
        }
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void canParseVeryLongBogusComment() {
        StringBuilder commentData = new StringBuilder(maxBufferLen);
        do {
            commentData.append("blah blah blah blah ");
        } while (commentData.length() < maxBufferLen);
        String expectedCommentData = commentData.toString();
        String testMarkup = "<html><body><!" + expectedCommentData + "></body></html>";
        Parser parser = new Parser(new HtmlTreeBuilder());
        Document doc = parser.parseInput(testMarkup, "");
        Node commentNode = doc.body().childNode(0);
        assertTrue("Expected comment node", commentNode instanceof Comment);
        assertEquals(expectedCommentData, ((Comment) commentNode).getData());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void canParseCdataEndingAtEdgeOfBuffer() {
        String cdataStart = "<![CDATA[";
        String cdataEnd = "]]>";
        // also breaks with -2, but not with -3 or 0
        int bufLen = maxBufferLen - cdataStart.length() - 1;
        char[] cdataContentsArray = new char[bufLen];
        Arrays.fill(cdataContentsArray, 'x');
        String cdataContents = new String(cdataContentsArray);
        String testMarkup = cdataStart + cdataContents + cdataEnd;
        Parser parser = new Parser(new HtmlTreeBuilder());
        Document doc = parser.parseInput(testMarkup, "");
        Node cdataNode = doc.body().childNode(0);
        assertTrue("Expected CDATA node", cdataNode instanceof CDataNode);
        assertEquals(cdataContents, ((CDataNode) cdataNode).text());
    }
}
