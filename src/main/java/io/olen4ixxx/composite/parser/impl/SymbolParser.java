package io.olen4ixxx.composite.parser.impl;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.Symbol;
import io.olen4ixxx.composite.entity.TextCompositeType;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SymbolParser implements TextParser {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public CompositeComponent parse(String text) {
//        logger.info("SymbolParser: parse()");
        char[] symbols = text.toCharArray();
        CompositeComponent symbolComposite = new TextComposite(TextCompositeType.SYMBOL);
        for (char symbol : symbols) {
            CompositeComponent symbolComponent = new Symbol(symbol);
            symbolComposite.add(symbolComponent);
        }
        return symbolComposite;
    }
}
