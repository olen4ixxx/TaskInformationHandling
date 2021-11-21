package io.olen4ixxx.composite.parser.impl;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.Symbol;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.entity.TextCompositeType;
import io.olen4ixxx.composite.parser.TextParser;

public class SymbolParser implements TextParser {
    @Override
    public CompositeComponent parse(String text) {
        char[] symbols = text.toCharArray();
        CompositeComponent symbolComposite = new TextComposite(TextCompositeType.SYMBOL);
        for (char symbol : symbols) {
            CompositeComponent symbolComponent = new Symbol(symbol);
            symbolComposite.add(symbolComponent);
        }
        return symbolComposite;
    }
}
