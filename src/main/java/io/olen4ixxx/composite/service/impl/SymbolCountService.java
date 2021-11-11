package io.olen4ixxx.composite.service.impl;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.SymbolType;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.service.SymbolService;

import java.util.List;

public class SymbolCountService implements SymbolService {

    @Override
    public int count(CompositeComponent sentenceComponent, SymbolType symbolType) {
        var sentence = (TextComposite) sentenceComponent;
        List<CompositeComponent> lexemes = sentence.getComponents();
        int consonantsNumber = 0;
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
}
