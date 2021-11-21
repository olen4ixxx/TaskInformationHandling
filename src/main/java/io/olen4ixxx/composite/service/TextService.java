package io.olen4ixxx.composite.service;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.exception.CustomCompositeException;

import java.util.List;

public interface TextService {
    int countRepeatedWords(CompositeComponent compositeComponent) throws CustomCompositeException;

    List<CompositeComponent> findRepeatedWords(CompositeComponent compositeComponent) throws CustomCompositeException;
}
