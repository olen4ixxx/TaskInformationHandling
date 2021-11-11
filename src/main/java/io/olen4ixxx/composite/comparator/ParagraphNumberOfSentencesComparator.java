package io.olen4ixxx.composite.comparator;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.TextComposite;

import java.util.Comparator;

public class ParagraphNumberOfSentencesComparator implements Comparator<CompositeComponent> {

    @Override
    public int compare(CompositeComponent o1, CompositeComponent o2) {
        var c1 = (TextComposite) o1; // TODO: 11.11.2021  
        var c2 = (TextComposite) o2;
        return c1.getComponents().size() - c2.getComponents().size();
    }
}
