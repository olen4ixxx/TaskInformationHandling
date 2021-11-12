package io.olen4ixxx.composite.main;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.exception.CustomCompositeException;
import io.olen4ixxx.composite.parser.impl.LexemeParser;
import io.olen4ixxx.composite.parser.impl.ParagraphParser;
import io.olen4ixxx.composite.parser.TextParser;
import io.olen4ixxx.composite.parser.impl.SentenceParser;
import io.olen4ixxx.composite.parser.impl.SymbolParser;
import io.olen4ixxx.composite.reader.CustomReader;
import io.olen4ixxx.composite.reader.impl.CompositeFileReader;

import java.util.List;

public class Main {
    public static void main(String[] args) throws CustomCompositeException {

        CustomReader reader = new CompositeFileReader();
        String s = reader.readLines("files/text.txt");
        TextParser parser1 = new ParagraphParser();
        TextParser parser2 = new SentenceParser();
        TextParser parser3 = new LexemeParser();
        TextParser parser4 = new SymbolParser();
        System.out.println(s);
        var p1 = (TextComposite) parser1.parse(s);
        var p2 = (TextComposite) parser2.parse(s);
        var p3 = (TextComposite) parser3.parse(s);
        var p4 = (TextComposite) parser4.parse(s);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        List<CompositeComponent> components = p1.getComponents();
        components.stream().forEach(System.out::println);

//        ParagraphSortService paragraphSortService = new ParagraphSortService();
//        paragraphSortService.sort(p);
//        System.out.println(p);

//        SearchService searchService = new SentenceSearchService();
//        for (var e:searchService.find(p2)) {
//            System.out.println(e);
//        }

//        DeleteService deleteService = new SentenceDeleteService();
//        deleteService.delete(p2, 18);
//        System.out.println(p2);
//        System.out.println(p2.getComponents().size());

//        WordSearchCountService countService = new WordSearchCountService();
//        System.out.println(countService.find(p3));
//        System.out.println(countService.count(p3));

//        List<CompositeComponent> sentences = p2.getComponents();
//        SymbolService symbolService = new SymbolCountService();
//        for (var sentence:sentences) {
//            System.out.printf("vowels:%d, consonants:%d | ",
//                    symbolService.count(sentence, SymbolType.VOWEL),
//                    symbolService.count(sentence, SymbolType.CONSONANT));
//        }

    }
}
