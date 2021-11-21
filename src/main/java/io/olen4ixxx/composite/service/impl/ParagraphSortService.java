package io.olen4ixxx.composite.service.impl;

import io.olen4ixxx.composite.comparator.ParagraphNumberOfSentencesComparator;
import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.entity.TextCompositeType;
import io.olen4ixxx.composite.exception.CustomCompositeException;
import io.olen4ixxx.composite.service.ParagraphService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class ParagraphSortService implements ParagraphService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void sortByNumberOfSentences(CompositeComponent paragraphsComposite) throws CustomCompositeException {
        logger.info("ParagraphSortService: sortByNumberOfSentences()");
        if (!(paragraphsComposite instanceof TextComposite paragraphs)
                || paragraphs.getType() != TextCompositeType.PARAGRAPH) {
            throw new CustomCompositeException("Input CompositeComponent is not a PARAGRAPH");
        }
        Comparator<CompositeComponent> comparator = new ParagraphNumberOfSentencesComparator();
        paragraphs.getComponents().sort(comparator);
    }
}
