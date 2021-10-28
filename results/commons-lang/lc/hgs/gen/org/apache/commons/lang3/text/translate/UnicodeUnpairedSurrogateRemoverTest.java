/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.lang3.text.translate;

import static org.junit.Assert.*;
import java.io.CharArrayWriter;
import java.io.IOException;
import org.junit.Test;
import org.junit.Ignore;

/**
 * Unit tests for {@link org.apache.commons.lang3.text.translate.UnicodeUnpairedSurrogateRemover}.
 *
 * @version $Id$
 */
public class UnicodeUnpairedSurrogateRemoverTest {

    final UnicodeUnpairedSurrogateRemover subject = new UnicodeUnpairedSurrogateRemover();

    // nothing is ever written to it
    final CharArrayWriter writer = new CharArrayWriter();

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testValidCharacters() throws IOException {
        assertEquals(false, subject.translate(0xd7ff, writer));
        assertEquals(false, subject.translate(0xe000, writer));
        assertEquals(0, writer.size());
    }

    @Test
    @Ignore("Redundant Test Case (identified by JSR)")
    public void testInvalidCharacters() throws IOException {
        assertEquals(true, subject.translate(0xd800, writer));
        assertEquals(true, subject.translate(0xdfff, writer));
        assertEquals(0, writer.size());
    }
}
