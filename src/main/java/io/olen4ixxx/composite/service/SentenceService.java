package io.olen4ixxx.composite.service;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.SymbolType;

import java.util.List;

public interface SentenceService {
    int countSymbols(CompositeComponent sentenceComponent, SymbolType symbolType);
    void deleteSentencesShorterThan(CompositeComponent sentenceComposite, int wordNumber);
    List<CompositeComponent> findSentencesWithLongestWord(CompositeComponent sentenceComposite);
}
