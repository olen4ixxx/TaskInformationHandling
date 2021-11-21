package io.olen4ixxx.composite.interpreterNOTDONE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionParser {
    public static List<String> parseStringToExpressionList (String notation) {
        String regex = "(?<=[~<>&^|])";
        var list = Arrays.stream(notation.split(regex))
                .filter(e -> !e.isEmpty())
                .collect(Collectors.toList());
        int k = 0;
        while (k < list.size()) {
            String s1 = list.get(k);
            int length1 = s1.length();
            String lastSymbol = s1.substring(length1-1);
            if (length1 > 1 && lastSymbol.matches("[~&^|]")) {
                list.remove(k);
                list.add(k, s1.substring(0, length1-1));
                list.add(k+1, lastSymbol);
                k++;
            }
            if (length1 > 1 && lastSymbol.matches("[><]")) {
                list.remove(k);
                list.remove(k);
                list.add(k, s1.substring(0, length1-1));
                list.add(k+1, lastSymbol.repeat(2));
                k++;
            }
            k++;
        }
        k=0;
        while (k < list.size()) {
            String s1 = list.get(k);
            int length1 = s1.length();
            String lastSymbol = s1.substring(length1-1);
            String firstSymbol = s1.substring(0,1);
            if (length1 > 1 && lastSymbol.equals(")")) {
                list.remove(k);
                list.add(k, s1.substring(0, length1-1));
                list.add(k+1, lastSymbol);
                k++;
            }
            if (length1 > 1 && firstSymbol.equals("(")) {
                list.remove(k);
                list.add(k, firstSymbol);
                list.add(k+1, s1.substring(1, length1));
                k++;
            }
            k++;
        }
        return list;
    }
}
