package io.olen4ixxx.composite.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComponent implements CustomComponent {

    private List<CustomComponent> components = new ArrayList<>();

    @Override
    public void operation() {
        for (var e:components) {
            e.operation();
        }
    }

    @Override
    public boolean add(CustomComponent component) {
        return components.add(component);
    }

    @Override
    public boolean remove(CustomComponent component) {
        return components.remove(component);
    }
}
