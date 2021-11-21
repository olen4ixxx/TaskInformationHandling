package io.olen4ixxx.composite.service;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.exception.CustomCompositeException;

public interface ParagraphService {
    void sortByNumberOfSentences(CompositeComponent compositeComponent) throws CustomCompositeException;
}
