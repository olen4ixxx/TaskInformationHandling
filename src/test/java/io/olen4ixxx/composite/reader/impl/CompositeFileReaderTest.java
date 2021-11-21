package io.olen4ixxx.composite.reader.impl;

import io.olen4ixxx.composite.exception.CustomCompositeException;
import io.olen4ixxx.composite.reader.CustomReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CompositeFileReaderTest {
    CustomReader reader;

    @BeforeMethod
    public void setUp() {
        reader = new CompositeFileReader();
    }

    @Test(timeOut = 1000)
    public void testReadLines() throws CustomCompositeException {
        StringBuilder builder = new StringBuilder("    Bye бандерлоги.    It is established fact. ");
        String expected = builder.append("That a reader will be of a page when looking at its layout.")
                .append("    It. Is. English?")
                .append("    It. Has. Survived. Not only.")
                .toString();
        String actual = reader.readLines("files/testSortedText.txt");
        assertEquals(actual, expected);
    }
}