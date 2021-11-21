package io.olen4ixxx.composite.service;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.SymbolType;
import io.olen4ixxx.composite.exception.CustomCompositeException;

import java.util.List;

public interface SentenceService {
    int countSymbols(CompositeComponent sentenceComponent, SymbolType symbolType) throws CustomCompositeException;

    void deleteSentencesShorterThan(CompositeComponent sentenceComposite, int wordNumber) throws CustomCompositeException;

    List<CompositeComponent> findSentencesWithLongestWord(CompositeComponent sentenceComposite) throws CustomCompositeException;
}
