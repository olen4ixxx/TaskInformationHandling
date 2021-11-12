package io.olen4ixxx.composite.service.impl;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.service.TextService;

import java.util.ArrayList;
import java.util.List;

public class TextSearchCountService implements TextService {

    @Override
    public List<CompositeComponent> findRepeatedWords(CompositeComponent compositeComponent) {
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
    public int countRepeatedWords(CompositeComponent compositeComponent) {
        return findRepeatedWords(compositeComponent).size();
    }
}
