package io.olen4ixxx.composite.entity;

public class Symbol implements CustomComponent {
    @Override
    public void operation() {
        System.out.println(this.getClass());
    }

    @Override
    public boolean add(CustomComponent component) {
        return false;
    }

    @Override
    public boolean remove(CustomComponent component) {
        return false;
    }
}
