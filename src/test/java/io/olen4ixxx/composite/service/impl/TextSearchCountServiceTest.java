package io.olen4ixxx.composite.service.impl;

import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.exception.CustomCompositeException;
import io.olen4ixxx.composite.parser.TextParser;
import io.olen4ixxx.composite.parser.impl.LexemeParser;
import io.olen4ixxx.composite.reader.CustomReader;
import io.olen4ixxx.composite.reader.impl.CompositeFileReader;
import io.olen4ixxx.composite.service.TextService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextSearchCountServiceTest {
    TextComposite parsedComposite;
    TextService textService;

    @BeforeMethod
    public void setUp() throws CustomCompositeException {
        CustomReader reader = new CompositeFileReader();
        String text = reader.readLines("files/testText.txt");
        TextParser parser = new LexemeParser();
        parsedComposite = (TextComposite) parser.parse(text);
        textService = new TextSearchCountService();
    }

    @Test(timeOut = 10000)
    public void testFindRepeatedWords() throws CustomCompositeException {
        StringBuilder builder = new StringBuilder("[It , has , the , with , of , Lorem , Ipsum , like , is , a , ");
        String expected = builder.append("established , fact , that , reader , will , be , readable , content , ")
                .append("page , when , looking , at , its , using ]").toString();
        String actual = textService.findRepeatedWords(parsedComposite).toString();
        assertEquals(actual, expected);
    }

    @Test(timeOut = 10000)
    public void testCountRepeatedWords() throws CustomCompositeException {
        int actual = textService.countRepeatedWords(parsedComposite);
        int expected = 24;
        assertEquals(actual, expected);
    }
}