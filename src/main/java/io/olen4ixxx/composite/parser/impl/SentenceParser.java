package io.olen4ixxx.composite.parser.impl;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.TextCompositeType;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class SentenceParser implements TextParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String SENTENCE_DELIMITER = "(?=[.!?…]\s|$)"; // fixme: 09.11.2021
    public final TextParser parser;

    public SentenceParser() {
        parser = new LexemeParser();
    }

    @Override
    public CompositeComponent parse(String text) {
//        logger.info("SentenceParser: parse()");
        List<String> sentences = Arrays
                .stream(text.split(SENTENCE_DELIMITER))
                .filter(o -> !o.isBlank())
//                .map(String::trim)
                .toList();
        CompositeComponent sentenceComposite = new TextComposite(TextCompositeType.SENTENCE);
        for (String sentence : sentences) {
            CompositeComponent sentenceComponent = parser.parse(sentence);
            sentenceComposite.add(sentenceComponent);
        }
        return sentenceComposite;
    }
}
