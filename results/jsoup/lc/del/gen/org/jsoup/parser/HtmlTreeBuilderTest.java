package org.jsoup.parser;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Ignore;

public class HtmlTreeBuilderTest {

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void ensureSearchArraysAreSorted() {
        String[][] arrays = { HtmlTreeBuilder.TagsSearchInScope, HtmlTreeBuilder.TagSearchList, HtmlTreeBuilder.TagSearchButton, HtmlTreeBuilder.TagSearchTableScope, HtmlTreeBuilder.TagSearchSelectScope, HtmlTreeBuilder.TagSearchEndTags, HtmlTreeBuilder.TagSearchSpecial };
        for (String[] array : arrays) {
            String[] copy = Arrays.copyOf(array, array.length);
            Arrays.sort(array);
            assertArrayEquals(array, copy);
        }
    }
}
