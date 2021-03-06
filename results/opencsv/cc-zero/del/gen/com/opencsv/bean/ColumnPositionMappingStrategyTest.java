package com.opencsv.bean;

/*
 Copyright 2007 Kyle Miller.

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
import com.opencsv.CSVReader;
import com.opencsv.bean.mocks.MockBean;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import java.io.StringReader;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class ColumnPositionMappingStrategyTest {

    private ColumnPositionMappingStrategy<MockBean> strat;

    @Before
    public void setUp() throws Exception {
        strat = new ColumnPositionMappingStrategy<MockBean>();
        strat.setType(MockBean.class);
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void getColumnIndexBeforeMappingSetReturnsNull() {
        assertNull(strat.getColumnIndex("name"));
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void getColumnIndexEmptyMappingReturnsNull() {
        strat.setColumnMapping(null);
        assertNull(strat.getColumnIndex("name"));
    }

    @Test
    public void getColumnIndex() {
        assertNull(strat.getColumnIndex("name"));
        String[] columns = new String[] { "name", "orderNumber", "id" };
        strat.setColumnMapping(columns);
        assertEquals(0, strat.getColumnIndex("name").intValue());
        assertEquals(1, strat.getColumnIndex("orderNumber").intValue());
        assertEquals(2, strat.getColumnIndex("id").intValue());
        assertNull(strat.getColumnIndex("name not mapped"));
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testParse() {
        String s = "" + "kyle,123456,emp123,1\n" + "jimmy,abcnum,cust09878,2";
        strat.setColumnMapping("name", "orderNumber", "id", "num");
        CsvToBean<MockBean> csv = new CsvToBean<MockBean>();
        List<MockBean> list = csv.parse(strat, new StringReader(s));
        assertNotNull(list);
        assertTrue(list.size() == 2);
        MockBean bean = list.get(0);
        assertEquals("kyle", bean.getName());
        assertEquals("123456", bean.getOrderNumber());
        assertEquals("emp123", bean.getId());
        assertEquals(1, bean.getNum());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testParseWithTrailingSpaces() {
        String s = "" + "kyle  ,123456  ,emp123  ,  1   \n" + "jimmy,abcnum,cust09878,2   ";
        String[] columns = new String[] { "name", "orderNumber", "id", "num" };
        strat.setColumnMapping(columns);
        CsvToBean<MockBean> csv = new CsvToBean<MockBean>();
        List<MockBean> list = csv.parse(strat, new StringReader(s));
        assertNotNull(list);
        assertTrue(list.size() == 2);
        MockBean bean = list.get(0);
        assertEquals("kyle  ", bean.getName());
        assertEquals("123456  ", bean.getOrderNumber());
        assertEquals("emp123  ", bean.getId());
        assertEquals(1, bean.getNum());
    }

    @Test
    public void testGetColumnMapping() {
        String[] columnMapping = strat.getColumnMapping();
        assertNotNull(columnMapping);
        assertEquals(0, columnMapping.length);
        String[] columns = new String[] { "name", "orderNumber", "id" };
        strat.setColumnMapping(columns);
        columnMapping = strat.getColumnMapping();
        assertNotNull(columnMapping);
        assertEquals(3, columnMapping.length);
        assertArrayEquals(columns, columnMapping);
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testGetColumnNames() {
        strat.setColumnMapping("name", null, "id");
        assertEquals("name", strat.getColumnName(0));
        assertEquals(null, strat.getColumnName(1));
        assertEquals("id", strat.getColumnName(2));
        assertEquals(null, strat.getColumnName(3));
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testGetColumnNamesArray() {
        strat.setColumnMapping("name", null, "id");
        String[] mapping = strat.getColumnMapping();
        assertEquals(3, mapping.length);
        assertEquals("name", mapping[0]);
        assertEquals(null, mapping[1]);
        assertEquals("id", mapping[2]);
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void getColumnNamesWhenNullArray() {
        strat.setColumnMapping((String[]) null);
        assertEquals(null, strat.getColumnName(0));
        assertEquals(null, strat.getColumnName(1));
        assertArrayEquals(new String[0], strat.getColumnMapping());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void getColumnNamesWhenNullColumnName() {
        String[] columns = { null };
        strat.setColumnMapping(columns);
        assertEquals(null, strat.getColumnName(0));
        assertEquals(null, strat.getColumnName(1));
        assertArrayEquals(columns, strat.getColumnMapping());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void getColumnNamesWhenEmptyMapping() {
        strat.setColumnMapping();
        assertEquals(null, strat.getColumnName(0));
        assertArrayEquals(new String[0], strat.getColumnMapping());
    }

    @Test
    public void throwsIllegalStateExceptionIfTypeNotSet() throws IOException {
        ColumnPositionMappingStrategy<MockBean> s = new ColumnPositionMappingStrategy<MockBean>();
        StringReader reader = new StringReader("doesnt,matter\nat,all");
        CSVReader csvReader = new CSVReader(reader);
        CsvToBean csvtb = new CsvToBean();
        try {
            csvtb.parse(s, csvReader);
        } catch (RuntimeException e) {
            assertEquals(IllegalStateException.class, e.getCause().getClass());
        }
    }
}
