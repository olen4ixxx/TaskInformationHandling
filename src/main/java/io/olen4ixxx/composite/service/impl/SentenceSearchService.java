package io.olen4ixxx.composite.service.impl;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.service.SearchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SentenceSearchService implements SearchService {
    private static final Logger logger = LogManager.getLogger();
    private static final String PUNCTUATION_REGEX = "[,.!?…]";

    @Override
    public List<CompositeComponent> find(CompositeComponent sentenceComposite) {
        var sentences = (TextComposite) sentenceComposite;
        List<CompositeComponent> sentenceComponents = sentences.getComponents();
        sentenceComponents.sort(new SentenceLongestWordComparator());
        int k = 0;
        CompositeComponent sentenceWithLongestWord;
        List<CompositeComponent> resultList = new ArrayList<>();
        do {
            sentenceWithLongestWord = sentenceComponents.get(k);
            resultList.add(sentenceComponents.get(k));
            k++;
            logger.info("maxWordLength:{}", maxWordLength(sentenceWithLongestWord));
        } while (k < sentenceComponents.size()
                && maxWordLength(sentenceWithLongestWord) == maxWordLength(sentenceComponents.get(k)));
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
        for (var lexeme : lexemes) {
            var symbols = (TextComposite) lexeme;
            int lexemeLength = symbols.getComponents().size();
            int wordLength = endsWithPunctuation(symbols) ? lexemeLength - 1 : lexemeLength;
            if (wordLength > maxWordLength) {
                maxWordLength = wordLength;
            }
        }
        return maxWordLength;
    }

    private boolean endsWithPunctuation(TextComposite symbols) {
        List<CompositeComponent> listOfSymbols = symbols.getComponents();
        return listOfSymbols.get(listOfSymbols.size() - 1).toString().matches(PUNCTUATION_REGEX);
    }
}
