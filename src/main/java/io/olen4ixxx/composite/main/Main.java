package io.olen4ixxx.composite.main;

import io.olen4ixxx.composite.entity.CustomComponent;
import io.olen4ixxx.composite.entity.Symbol;
import io.olen4ixxx.composite.entity.TextComponent;

public class Main {
    public static void main(String[] args) {
        CustomComponent component1 = new Symbol();
        CustomComponent component2 = new Symbol();
        CustomComponent component3 = new TextComponent();
        CustomComponent component4 = new TextComponent();
        component3.add(component1);
        component3.add(component2);
        component4.add(component1);
        component4.add(component3);
        component4.operation();
    }
}
