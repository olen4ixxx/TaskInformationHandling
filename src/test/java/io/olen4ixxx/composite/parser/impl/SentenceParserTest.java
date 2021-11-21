package io.olen4ixxx.composite.parser.impl;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.exception.CustomCompositeException;
import io.olen4ixxx.composite.parser.TextParser;
import io.olen4ixxx.composite.reader.CustomReader;
import io.olen4ixxx.composite.reader.impl.CompositeFileReader;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class SentenceParserTest {

    @Test(timeOut = 10000)
    public void testParse() throws CustomCompositeException {
        CustomReader reader = new CompositeFileReader();
        String text = reader.readLines("files/testSortedText.txt");
        TextParser parser = new SentenceParser();
        var parsedComposite = (TextComposite) parser.parse(text);
        List<CompositeComponent> sentences = parsedComposite.getComponents();
        int actual = sentences.size();
        int expected = 10;
        assertEquals(actual, expected);
    }
}