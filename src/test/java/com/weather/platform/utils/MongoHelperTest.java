package com.weather.platform.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MongoHelperTest {

    @Test
    void prefixSearchForStringTest_withNullQuery() {
        MongoHelper underTest = new MongoHelper();
        String result = underTest.prefixSearchForString(null);

        assertEquals("^.*", result);
    }

    @Test
    void prefixSearchForStringTest_withEmptyQuery() {
        MongoHelper underTest = new MongoHelper();
        String result = underTest.prefixSearchForString("");

        assertEquals("^.*", result);
    }

    @Test
    void prefixSearchForStringTest_withNoSpecialCharacters() {
        MongoHelper underTest = new MongoHelper();
        String result = underTest.prefixSearchForString("test");

        assertEquals("^test.*", result);
    }

    @Test
    void prefixSearchForStringTest_withSpecialCharacters() {
        MongoHelper underTest = new MongoHelper();
        String result = underTest.prefixSearchForString("[-.\\+*?\\[^\\]$(){}=!<>|:\\\\]");

        assertEquals("^\\[\\-\\.\\\\\\+\\*\\?\\\\\\[\\^\\\\\\]\\$\\(\\)\\{\\}\\=\\!\\<\\>\\|\\:\\\\\\\\\\].*", result);
    }
}
