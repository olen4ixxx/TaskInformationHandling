package io.olen4ixxx.composite.service.impl;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.Symbol;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.entity.TextCompositeType;
import io.olen4ixxx.composite.exception.CustomCompositeException;
import io.olen4ixxx.composite.parser.TextParser;
import io.olen4ixxx.composite.parser.impl.ParagraphParser;
import io.olen4ixxx.composite.reader.CustomReader;
import io.olen4ixxx.composite.reader.impl.CompositeFileReader;
import io.olen4ixxx.composite.service.ParagraphService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ParagraphSortServiceTest {
    ParagraphService service;

    @BeforeMethod
    public void setUp() {
        service = new ParagraphSortService();
    }

    @Test(timeOut = 10000)
    public void testSortByNumberOfSentences() throws CustomCompositeException {
        CustomReader reader = new CompositeFileReader();
        String text = reader.readLines("files/testUnsortedText.txt");
        String textSorted = reader.readLines("files/testSortedText.txt");
        TextParser parser = new ParagraphParser();
        var actual = (TextComposite) parser.parse(text);
        service.sortByNumberOfSentences(actual);
        var expected = (TextComposite) parser.parse(textSorted);
        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = CustomCompositeException.class,
            expectedExceptionsMessageRegExp = "Input CompositeComponent is not a PARAGRAPH")
    public void testSortByNumberOfSentencesExceptionWrongTextCompositeType() throws CustomCompositeException {
        CompositeComponent component = new TextComposite(TextCompositeType.LEXEME);
        service.sortByNumberOfSentences(component);
    }

    @Test(expectedExceptions = CustomCompositeException.class,
            expectedExceptionsMessageRegExp = "Input CompositeComponent is not a PARAGRAPH")
    public void testSortByNumberOfSentencesExceptionNotTextComposite() throws CustomCompositeException {
        CompositeComponent component = new Symbol('a');
        service.sortByNumberOfSentences(component);
    }
}