package io.olen4ixxx.composite.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TextComposite implements CompositeComponent {
    private static final Logger logger = LogManager.getLogger();
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
        Object[] array1 = composite.components.toArray(); // FIXME: 10.11.2021
        return Arrays.deepEquals(array, array1) && type == composite.type;
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
    public int hashCode() { // TODO: 09.11.2021  
        return Objects.hash(components);
    }

    @Override
    public String toString() { // TODO: 09.11.2021
//        logger.info("TextComposite: toString()");
        StringBuilder builder = new StringBuilder();
        if (this.type == TextCompositeType.SENTENCE) { // FIXME: 10.11.2021
            builder.append("\t");
        }
        for (var e:components) {
            builder.append(e);
        }
        builder.append(getType().getDelimiter());
        return builder.toString();
    }
}
