package io.olen4ixxx.composite.service.impl;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.SymbolType;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.entity.TextCompositeType;
import io.olen4ixxx.composite.exception.CustomCompositeException;
import io.olen4ixxx.composite.service.SentenceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SentenceCountDeleteSearchService implements SentenceService {
    private static final Logger logger = LogManager.getLogger();
    private static final String DASH_REGEX = "\u2014";

    @Override
    public int countSymbols(CompositeComponent sentencesComposite, SymbolType symbolType)
            throws CustomCompositeException {
        logger.info("SentenceCountDeleteSearchService: countSymbols()");
        if (!(sentencesComposite instanceof TextComposite sentences)
                || sentences.getType() != TextCompositeType.LEXEME) {
            throw new CustomCompositeException("Input CompositeComponent is not a SENTENCE");
        }
        int consonantsNumber = 0;
        List<CompositeComponent> lexemes = sentences.getComponents();
        for (var lexeme : lexemes) {
            var lexemeComponent = (TextComposite) lexeme;
            List<CompositeComponent> symbols = lexemeComponent.getComponents();
            for (var symbol : symbols) {
                if (symbol.toString().matches(symbolType.getRegex())) {
                    consonantsNumber++;
                }
            }
        }
        return consonantsNumber;
    }

    @Override
    public void deleteSentencesShorterThan(CompositeComponent sentencesComposite, int wordNumber) throws CustomCompositeException {
        logger.info("SentenceCountDeleteSearchService: deleteSentencesShorterThan()");
        if (!(sentencesComposite instanceof TextComposite sentences)
                || sentences.getType() != TextCompositeType.SENTENCE) {
            throw new CustomCompositeException("Input CompositeComponent is not a SENTENCE");
        }
        List<CompositeComponent> sentenceComponents = sentences.getComponents();
        int k = 0;
        while (k < sentenceComponents.size()) {
            CompositeComponent lexemeComposite = sentenceComponents.get(k);
            var lexemes = (TextComposite) lexemeComposite;
            List<CompositeComponent> lexemeComponents = lexemes.getComponents();
            int lexemeNumber = lexemeComponents.size() - dashCount(lexemeComponents);
            if (lexemeNumber < wordNumber) {
                sentenceComponents.remove(k);
                k--;
            }
            k++;
        }
    }

    private int dashCount(List<CompositeComponent> lexemeComponents) {
        int k = 0;
        for (var lexeme : lexemeComponents) {
            if (lexeme.toString().strip().equals(DASH_REGEX)) {
                k++;
            }
        }
        return k;
    }

    @Override
    public List<CompositeComponent> findSentencesWithLongestWord(CompositeComponent sentencesComposite) throws CustomCompositeException {
        logger.info("SentenceCountDeleteSearchService: findSentencesWithLongestWord()");
        if (!(sentencesComposite instanceof TextComposite sentences)
                || sentences.getType() != TextCompositeType.SENTENCE) {
            throw new CustomCompositeException("Input CompositeComponent is not a SENTENCE");
        }
        List<CompositeComponent> sentenceComponents = sentences.getComponents();
        sentenceComponents.sort(new SentenceLongestWordComparator());
        int k = 0;
        CompositeComponent sentenceWithLongestWord;
        List<CompositeComponent> resultList = new ArrayList<>();
        int max;
        do {
            sentenceWithLongestWord = sentenceComponents.get(k);
            resultList.add(sentenceComponents.get(k));
            k++;
            max = maxWordLength(sentenceWithLongestWord);
            logger.info("maxWordLength:{}", max);
        } while (k < sentenceComponents.size() && max == maxWordLength(sentenceComponents.get(k)));
        return resultList;
    }

    private class SentenceLongestWordComparator implements Comparator<CompositeComponent> {
        @Override
        public int compare(CompositeComponent o1, CompositeComponent o2) {
            return maxWordLength(o2) - maxWordLength(o1);
        }
    }

    private int maxWordLength(CompositeComponent sentenceComponent) {
        var sentence = (TextComposite) sentenceComponent;
        List<CompositeComponent> lexemes = sentence.getComponents();
        int maxWordLength = 0;
        for (CompositeComponent lexeme : lexemes) {
            var symbols = (TextComposite) lexeme;
            int lexemeLength = symbols.getComponents().size();
            int wordLength = lexemeLength - numberOfPunctuation(symbols);
            if (wordLength > maxWordLength) {
                maxWordLength = wordLength;
            }
        }
        return maxWordLength;
    }

    private int numberOfPunctuation(TextComposite symbols) {
        String lexeme = symbols.toString();
        String lexemeStrip = lexeme.strip();
        int lexemeStripLength = lexemeStrip.length();
        boolean endsWithPunctuation = lexemeStrip.substring(lexemeStripLength - 1)
                .matches(SymbolType.PUNCTUATION.getRegex());
        return endsWithPunctuation ? 1 : 0;
    }
}
