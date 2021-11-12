package io.olen4ixxx.composite.service;

import io.olen4ixxx.composite.entity.CompositeComponent;

import java.util.List;

public interface TextService {
    int countRepeatedWords(CompositeComponent compositeComponent);
    List<CompositeComponent> findRepeatedWords(CompositeComponent compositeComponent);
}
