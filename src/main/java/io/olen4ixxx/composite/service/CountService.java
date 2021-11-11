package io.olen4ixxx.composite.service;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.exception.CustomCompositeException;

public interface CountService {
    int count(CompositeComponent compositeComponent) throws CustomCompositeException;
}
