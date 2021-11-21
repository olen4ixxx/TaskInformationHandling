package io.olen4ixxx.composite.interpreterNOTDONE;

import java.util.Arrays;

public class Str {
    public String str(String expression) {
//        expression.split("(>>)|(<<)|~|&|(^)|(|)");
        var numbers = Arrays.stream(expression.split("[~<>&^|]"))
                .filter(String::isEmpty)
                .map(Integer::parseInt)
                .toList();
        var signs = Arrays.stream(expression.split("[0-9]"))
                .filter(String::isEmpty)
                .toList();
        StringBuilder builderNumbers = new StringBuilder();
        StringBuilder builderSigns = new StringBuilder();
        int k = 0;
        if (signs.get(0).equals("~")) {
            numbers.set(0, ~numbers.get(0));
            signs.remove(0);
        }
        while (k < numbers.size()-1) {
            String sign = signs.get(k);
            int number = numbers.get(k);
            if (sign.equals(">>") || sign.equals("<<")) {
                builderSigns.append(sign).append(" ");
                builderNumbers.append(numbers.get(k)).append(" ").append(numbers.get(k+1)).append(" ");
            }
            k++;
        }
        return null;
    }
}
