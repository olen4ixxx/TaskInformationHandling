package io.olen4ixxx.composite.service.impl;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.service.ParagraphService;
import io.olen4ixxx.composite.comparator.ParagraphNumberOfSentencesComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class ParagraphSortService implements ParagraphService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void sortByNumberOfSentences(CompositeComponent compositeComponent) {
        Comparator<CompositeComponent> comparator = new ParagraphNumberOfSentencesComparator();
        var paragraphs = (TextComposite) compositeComponent;
        paragraphs.getComponents().sort(comparator);
    }
}
