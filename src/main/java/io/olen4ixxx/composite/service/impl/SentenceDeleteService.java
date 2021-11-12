package io.olen4ixxx.composite.service.impl;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.service.SentenceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SentenceDeleteService {
    private static final Logger logger = LogManager.getLogger();
    private static final String DASH_REGEX = "\u2014\s";

    public void delete(CompositeComponent sentenceComposite, int wordNumber) {
        var sentences = (TextComposite) sentenceComposite;
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
        for (var lexeme:lexemeComponents) {
            k = lexeme.toString().equals(DASH_REGEX) ? ++k : k;
        }
        return k;
    }
}
