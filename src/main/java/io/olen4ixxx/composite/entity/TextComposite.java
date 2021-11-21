package io.olen4ixxx.composite.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextComposite implements CompositeComponent {
    private List<CompositeComponent> components;
    private final TextCompositeType type;

    public TextComposite(TextCompositeType textCompositeType) {
        components = new ArrayList<>();
        type = textCompositeType;
    }

    public List<CompositeComponent> getComponents() {
        return components;
    }

    public void setComponents(List<CompositeComponent> components) {
        this.components = components;
    }

    public TextCompositeType getType() {
        return type;
    }

    @Override
    public boolean add(CompositeComponent component) {
        return components.add(component);
    }

    @Override
    public boolean remove(CompositeComponent component) {
        return components.remove(component);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TextComposite composite = (TextComposite) o;
        Object[] array = components.toArray();
        Object[] array1 = composite.components.toArray();
        return type == composite.type && Arrays.deepEquals(array, array1);
    }

    @Override
    public boolean equalsIgnoreCase(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TextComposite composite = (TextComposite) o;
        return toString().equalsIgnoreCase(composite.toString());
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        for (CompositeComponent component : components) {
            result = prime * result + (component == null ? 0 : component.hashCode());
        }
        return result + type.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (this.type == TextCompositeType.SENTENCE) {
            builder.append("\t");
        }
        for (CompositeComponent component : components) {
            builder.append(component);
        }
        if (this.type == TextCompositeType.SYMBOL) {
            builder.append("\s");
        }
        if (this.type == TextCompositeType.SENTENCE) {
            builder.append("\r\n");
        }
        return builder.toString();
    }
}
