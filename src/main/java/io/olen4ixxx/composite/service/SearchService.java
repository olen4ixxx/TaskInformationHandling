package io.olen4ixxx.composite.service;

import io.olen4ixxx.composite.entity.CompositeComponent;

import java.util.List;

public interface SearchService {
    List<CompositeComponent> find(CompositeComponent compositeComponent);
}
