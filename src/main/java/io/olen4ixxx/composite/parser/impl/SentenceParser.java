package io.olen4ixxx.composite.parser.impl;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.entity.TextCompositeType;
import io.olen4ixxx.composite.parser.TextParser;

import java.util.Arrays;
import java.util.List;

public class SentenceParser implements TextParser {
    private static final String SENTENCE_DELIMITER = "(?<=[.!?…]\s|$)";
    public final TextParser parser;

    public SentenceParser() {
        parser = new LexemeParser();
    }

    @Override
    public CompositeComponent parse(String text) {
        List<String> sentences = Arrays
                .stream(text.split(SENTENCE_DELIMITER))
                .filter(o -> !o.isBlank())
                .map(String::strip)
                .toList();
        CompositeComponent sentenceComposite = new TextComposite(TextCompositeType.SENTENCE);
        for (String sentence : sentences) {
            CompositeComponent sentenceComponent = parser.parse(sentence);
            sentenceComposite.add(sentenceComponent);
        }
        return sentenceComposite;
    }
}
