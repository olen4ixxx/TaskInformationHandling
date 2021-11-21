package io.olen4ixxx.composite.service.impl;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.SymbolType;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.exception.CustomCompositeException;
import io.olen4ixxx.composite.parser.TextParser;
import io.olen4ixxx.composite.parser.impl.SentenceParser;
import io.olen4ixxx.composite.reader.CustomReader;
import io.olen4ixxx.composite.reader.impl.CompositeFileReader;
import io.olen4ixxx.composite.service.SentenceService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class SentenceCountDeleteSearchServiceTest {
    SentenceService sentenceService;
    List<CompositeComponent> sentences;
    TextComposite parsedComposite;

    @BeforeMethod
    public void setUp() throws CustomCompositeException {
        CustomReader reader = new CompositeFileReader();
        String text = reader.readLines("files/testSortedText.txt");
        TextParser parser = new SentenceParser();
        parsedComposite = (TextComposite) parser.parse(text);
        sentenceService = new SentenceCountDeleteSearchService();
        sentences = parsedComposite.getComponents();
    }

    @Test(timeOut = 10000)
    public void testCountSymbolsVowels() throws CustomCompositeException {
        int actual = 0;
        for (var sentence : sentences) {
            actual += sentenceService.countSymbols(sentence, SymbolType.VOWEL);
        }
        var expected = 43;
        assertEquals(actual, expected);
    }

    @Test(timeOut = 10000)
    public void testCountSymbolsConsonants() throws CustomCompositeException {
        int actual = 0;
        for (var sentence : sentences) {
            actual += sentenceService.countSymbols(sentence, SymbolType.CONSONANT);
        }
        var expected = 66;
        assertEquals(actual, expected);
    }

    @Test(timeOut = 10000)
    public void testDeleteSentencesShorterThan() throws CustomCompositeException {
        sentenceService.deleteSentencesShorterThan(parsedComposite, 11);
        String actual = sentences.get(0).toString();
        String expected = "That a reader will be of a page when looking at its layout. ";
        assertEquals(actual, expected);
    }

    @Test(timeOut = 10000)
    public void testFindSentencesWithLongestWord() throws CustomCompositeException {
        List<CompositeComponent> sentences1 = sentenceService.findSentencesWithLongestWord(parsedComposite);
        String actual = sentences1.get(0).toString();
        String expected = "It is established fact. ";
        assertEquals(actual, expected);
    }


}