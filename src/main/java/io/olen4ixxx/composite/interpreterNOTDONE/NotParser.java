package io.olen4ixxx.composite.interpreterNOTDONE;

import java.util.List;

public class NotParser {
    public int parse(List<String> list) {
        int k = 0;
        Context c = new Context(list);
        while (k < c.getContextValue().size()) {
            String token = list.get(k);
            switch (token.substring(0,1)) {
                case BitwiseOperationType.NOT -> {
                            c.remove(k);
                            c.add(k, ~c.get(k));
                            c.remove(k + 1);
                        }
                case BitwiseOperationType.LEFT_SHIFT -> {
                        c.remove(k);
                        int number = c.get(k - 1) << c.get(k);
                        c.remove(k - 1);
                        c.remove(k - 1);
                        c.add(k - 1, number);
                    }
                case BitwiseOperationType.RIGHT_SHIFT -> {
                        c.remove(k);
                        int number = c.get(k - 1) >> c.get(k);
                        c.remove(k - 1);
                        c.remove(k - 1);
                        c.add(k - 1, number);
                    }
                case BitwiseOperationType.AND -> {
                        c.remove(k);
                        int number = c.get(k - 1) & c.get(k);
                        c.remove(k - 1);
                        c.remove(k - 1);
                        c.add(k - 1, number);
                    }
                case BitwiseOperationType.XOR -> {
                        c.remove(k);
                        int number = c.get(k - 1) ^ c.get(k);
                        c.remove(k - 1);
                        c.remove(k - 1);
                        c.add(k - 1, number);
                    }
                case BitwiseOperationType.OR -> {
                        c = new Context(list);
                        c.remove(k);
                        int number = c.get(k - 1) | c.get(k);
                        c.remove(k - 1);
                        c.remove(k - 1);
                        c.add(k - 1, number);
                    }
//                default -> k++;
            }
            k++;
        }
        return Integer.parseInt(c.getContextValue().get(0));
    }
}
