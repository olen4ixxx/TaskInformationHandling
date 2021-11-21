package io.olen4ixxx.composite.entity;

public interface CompositeComponent {

    boolean add(CompositeComponent component);

    boolean remove(CompositeComponent component);

    String toString();

    boolean equalsIgnoreCase(Object o);
}
