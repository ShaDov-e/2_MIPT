package com.example.a2_mipd;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WordCounterUnitTest {

    @Test
    public void testWordCount() {
        //paprastas testukas
        int result = Counter.getWordCount("This is a test sentence");
        assertEquals(5, result);

        result = Counter.getWordCount("");
        assertEquals(0, result);

    }

    @Test
    public void testCharacterCount() {
        int result = Counter.getCharacterCount("This is a test sentence");
        assertEquals(25, result);

        // tusciu string testas
        result = Counter.getCharacterCount("");
        assertEquals(0, result);
    }
}
