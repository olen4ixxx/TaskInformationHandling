package io.olen4ixxx.composite.service.impl;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.SymbolType;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.entity.TextCompositeType;
import io.olen4ixxx.composite.exception.CustomCompositeException;
import io.olen4ixxx.composite.service.TextService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TextSearchCountService implements TextService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<CompositeComponent> findRepeatedWords(CompositeComponent lexemesComposite) throws CustomCompositeException {
        logger.info("TextSearchCountService: findRepeatedWords()");
        if (!(lexemesComposite instanceof TextComposite lexemes)
                || lexemes.getType() != TextCompositeType.LEXEME) {
            throw new CustomCompositeException("Input CompositeComponent is not a LEXEME");
        }
        List<CompositeComponent> lexemeComponents = lexemes.getComponents();
        List<CompositeComponent> repeatedWords = new ArrayList<>();
        for (int i = 0; i < lexemeComponents.size(); i++) {
            CompositeComponent word = lexemeToWord(lexemeComponents.get(i));
            for (int j = i + 1; j < lexemeComponents.size(); j++) {
                boolean containsWord = repeatedWords.stream().anyMatch(word::equalsIgnoreCase);
                if (word.equalsIgnoreCase(lexemeComponents.get(j)) && !containsWord) {
                    repeatedWords.add(word);
                }
            }
        }
        return repeatedWords;
    }

    @Override
    public int countRepeatedWords(CompositeComponent compositeComponent) throws CustomCompositeException {
        logger.info("TextSearchCountService: countRepeatedWords()");
        return findRepeatedWords(compositeComponent).size();
    }

    private CompositeComponent lexemeToWord(CompositeComponent lexeme) {
        var symbols = (TextComposite) lexeme;
        List<CompositeComponent> symbolComponents = symbols.getComponents();
        int lastElementIndex = symbolComponents.size() - 1;
        boolean endsWithPunctuation = symbolComponents
                .get(lastElementIndex)
                .toString()
                .matches(SymbolType.PUNCTUATION.getRegex());
        if (endsWithPunctuation) {
            List<CompositeComponent> list = new ArrayList<>(List.copyOf(symbolComponents));
            list.remove(lastElementIndex);
            TextComposite word = new TextComposite(TextCompositeType.SYMBOL);
            word.setComponents(list);
            return word;
        }
        return lexeme;
    }
}
