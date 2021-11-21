package io.olen4ixxx.composite.main;

import io.olen4ixxx.composite.entity.CompositeComponent;
import io.olen4ixxx.composite.entity.SymbolType;
import io.olen4ixxx.composite.entity.TextComposite;
import io.olen4ixxx.composite.exception.CustomCompositeException;
import io.olen4ixxx.composite.interpreterNOTDONE.ExpressionParser;
import io.olen4ixxx.composite.interpreterNOTDONE.NotParser;
import io.olen4ixxx.composite.parser.TextParser;
import io.olen4ixxx.composite.parser.impl.LexemeParser;
import io.olen4ixxx.composite.parser.impl.ParagraphParser;
import io.olen4ixxx.composite.parser.impl.SentenceParser;
import io.olen4ixxx.composite.parser.impl.SymbolParser;
import io.olen4ixxx.composite.reader.CustomReader;
import io.olen4ixxx.composite.reader.impl.CompositeFileReader;
import io.olen4ixxx.composite.service.ParagraphService;
import io.olen4ixxx.composite.service.SentenceService;
import io.olen4ixxx.composite.service.TextService;
import io.olen4ixxx.composite.service.impl.ParagraphSortService;
import io.olen4ixxx.composite.service.impl.SentenceCountDeleteSearchService;
import io.olen4ixxx.composite.service.impl.TextSearchCountService;

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
//        var p4 = (TextComposite) parser4.parse(s);

        TextService textService = new TextSearchCountService();
        System.out.println(textService.findRepeatedWords(p3));
        System.out.println(textService.countRepeatedWords(p3));

        ParagraphService paragraphService = new ParagraphSortService();
        paragraphService.sortByNumberOfSentences(p1);
        p1.getComponents().forEach(System.out::println);

        SentenceService sentenceService = new SentenceCountDeleteSearchService();
        List<CompositeComponent> sentences = p2.getComponents();
        for (var sentence:sentences) {
            System.out.printf("vowels:%d, consonants:%d | ",
                    sentenceService.countSymbols(sentence, SymbolType.VOWEL),
                    sentenceService.countSymbols(sentence, SymbolType.CONSONANT));
            System.out.println();
        }
        List<CompositeComponent> sentences1 = sentenceService.findSentencesWithLongestWord(p2);
        sentences1.stream().forEach(System.out::println); // FIXME: 12.11.2021

        sentenceService.deleteSentencesShorterThan(p2, 19);
        p2.getComponents().forEach(System.out::println);
        System.out.println(p2.getComponents().size());

        String regex = "(?<=[~<>&^|])";
//        String notation = "~2|5>>2&71^3&44<<1";
        String notation = "5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1)";

        List<String> expressionList = ExpressionParser.parseStringToExpressionList(notation);
        NotParser interpeter = new NotParser();

//        var list = interpeter.parse(expressionList);
//        Client client = new Client();
//        int result = client.handleExpression(list);
//        System.out.println("for real = " + (~2 | 5 >> 2 & 71 ^ 3 & 44 << 1));
//        System.out.printf("~2|5>>2&71^3&44<<1 = %d", interpeter.parse(expressionList));
        System.out.println("for real = " + (5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1)));
//        System.out.printf("~2|5>>2&71^3&44<<1 = %d", interpeter.parse(expressionList));
    }


}
