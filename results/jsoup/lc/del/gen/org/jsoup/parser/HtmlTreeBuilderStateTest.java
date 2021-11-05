package org.jsoup.parser;

import org.jsoup.parser.HtmlTreeBuilderState.Constants;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Ignore;

public class HtmlTreeBuilderStateTest {

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void ensureArraysAreSorted() {
        String[][] arrays = { Constants.InBodyStartToHead, Constants.InBodyStartPClosers, Constants.Headings, Constants.InBodyStartPreListing, Constants.InBodyStartLiBreakers, Constants.DdDt, Constants.Formatters, Constants.InBodyStartApplets, Constants.InBodyStartEmptyFormatters, Constants.InBodyStartMedia, Constants.InBodyStartInputAttribs, Constants.InBodyStartOptions, Constants.InBodyStartRuby, Constants.InBodyStartDrop, Constants.InBodyEndClosers, Constants.InBodyEndAdoptionFormatters, Constants.InBodyEndTableFosters, Constants.InCellNames, Constants.InCellBody, Constants.InCellTable, Constants.InCellCol };
        for (String[] array : arrays) {
            String[] copy = Arrays.copyOf(array, array.length);
            Arrays.sort(array);
            assertArrayEquals(array, copy);
        }
    }
}
