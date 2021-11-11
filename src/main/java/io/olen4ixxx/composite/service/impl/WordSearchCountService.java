package io.olen4ixxx.composite.service.impl;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.exception.CustomCompositeException;
import io.olen4ixxx.composite.service.CountService;
import io.olen4ixxx.composite.service.SearchService;

import java.util.ArrayList;
import java.util.List;

public class WordSearchCountService implements SearchService, CountService {

    @Override
    public List<CompositeComponent> find(CompositeComponent compositeComponent) {
        var lexemes = (TextComposite) compositeComponent;
        List<CompositeComponent> lexemeComponents = lexemes.getComponents();
        List<CompositeComponent> repeatedWords = new ArrayList<>();
        for (int i = 0; i < lexemeComponents.size(); i++) {
            CompositeComponent component = lexemeComponents.get(i);
            for (int j = i + 1; j < lexemeComponents.size(); j++) {
                if (component.equalsIgnoreCase(lexemeComponents.get(j)) && !repeatedWords.contains(component)) {
                    repeatedWords.add(component);
                }
            }
        }
        int k = 0;
        while (k < repeatedWords.size()) {
            CompositeComponent word = repeatedWords.get(k);
            for (int i = k + 1; i < repeatedWords.size(); i++) {
                if (word.equalsIgnoreCase(repeatedWords.get(i))) {
                    repeatedWords.remove(word);
                    k--;
                }
            }
            k++;
        }
        return repeatedWords;
    }

    @Override
    public int count(CompositeComponent compositeComponent) {
        return find(compositeComponent).size();
    }
}
