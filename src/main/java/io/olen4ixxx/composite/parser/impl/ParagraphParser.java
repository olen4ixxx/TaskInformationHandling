package io.olen4ixxx.composite.parser.impl;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.TextCompositeType;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class ParagraphParser implements TextParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String PARAGRAPH_DELIMITER = "(?=\t|\s{4})";
    public final TextParser parser;

    public ParagraphParser() {
        parser = new SentenceParser();
    }

    @Override
    public CompositeComponent parse(String text) {
//        logger.info("ParagraphParser: parse()");
//        String[] paragraphs = text.split(PARAGRAPH_DELIMITER);
        List<String> paragraphs = Arrays
                .stream(text.split(PARAGRAPH_DELIMITER))
                .filter(o -> !o.isBlank())
//                .map(String::strip)
                .toList();
        CompositeComponent paragraphComposite = new TextComposite(TextCompositeType.PARAGRAPH);
        for (String paragraph : paragraphs) {
            CompositeComponent paragraphComponent = parser.parse(paragraph);
            paragraphComposite.add(paragraphComponent);
        }
        return paragraphComposite;
    }
}
