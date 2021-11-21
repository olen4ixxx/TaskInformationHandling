package io.olen4ixxx.composite.parser.impl;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.entity.TextCompositeType;
import io.olen4ixxx.composite.parser.TextParser;

import java.util.Arrays;
import java.util.List;

public class LexemeParser implements TextParser {
    private static final String LEXEME_DELIMITER = "(?<=\s)";
    public final TextParser parser;

    public LexemeParser() {
        parser = new SymbolParser();
    }

    @Override
    public CompositeComponent parse(String text) {
        List<String> lexemes = Arrays
                .stream(text.split(LEXEME_DELIMITER))
                .filter(o -> !o.isBlank())
                .map(String::strip)
                .toList();
        CompositeComponent lexemeComposite = new TextComposite(TextCompositeType.LEXEME);
        for (String lexeme : lexemes) {
            CompositeComponent lexemeComponent = parser.parse(lexeme);
            lexemeComposite.add(lexemeComponent);
        }
        return lexemeComposite;
    }
}
