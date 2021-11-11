package io.olen4ixxx.composite.service;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.SymbolType;

public interface SymbolService {
    int count(CompositeComponent sentenceComponent, SymbolType symbolType);

}
