package io.olen4ixxx.composite.comparator;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.TextComposite;

import java.util.Comparator;

public class ParagraphNumberOfSentencesComparator implements Comparator<CompositeComponent> {

    @Override
    public int compare(CompositeComponent o1, CompositeComponent o2) {
        var tc1 = (TextComposite) o1;
        var tc2 = (TextComposite) o2;
        return tc1.getComponents().size() - tc2.getComponents().size();
    }
}
