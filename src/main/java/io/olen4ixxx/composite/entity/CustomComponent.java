package io.olen4ixxx.composite.entity;

public interface CustomComponent {
    void operation();

    boolean add(CustomComponent component);

    boolean remove(CustomComponent component);
}
