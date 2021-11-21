package io.olen4ixxx.composite.interpreterNOTDONE;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class BitwiseParser {
    private static final Logger logger = LogManager.getLogger();
    public List<MathOperation> parse (List<String> list) {
        List<MathOperation> expression = new ArrayList<>();
        int i = 0;
        logger.info("list.size({})",list.size());
        while (i < list.size()) {
            final int k = i;
            String token = list.get(k);
//            list.forEach(t -> {
                switch (token.substring(0,1)) {
                    case BitwiseOperationType.NOT ->
                        expression.add(c -> {
                            logger.info("NOT");
                            c = new Context(list);
                            c.remove(k);
                            c.add(k, ~c.get(k));
                            c.remove(k + 1);
                        });
//                    i++;

                    case BitwiseOperationType.LEFT_SHIFT -> {
                        expression.add(c -> {
                            logger.info("LEFT_SHIFT");
                            c.remove(k);
                            int number = c.get(k - 1) << c.get(k);
                            c.remove(k - 1);
                            c.remove(k - 1);
                            c.add(k - 1, number);
                        });
//                    i++;
                    }
                    case BitwiseOperationType.RIGHT_SHIFT -> {
                        expression.add(c -> {
                            logger.info("RIGHT_SHIFT");
                            c.remove(k);
                            int number = c.get(k - 1) >> c.get(k);
                            c.remove(k - 1);
                            c.remove(k - 1);
                            c.add(k - 1, number);
                        });
//                    i++;
                    }
                    case BitwiseOperationType.AND -> {
                        expression.add(c -> {
                            logger.info("AND");
                            c.remove(k);
                            int number = c.get(k - 1) & c.get(k);
                            c.remove(k - 1);
                            c.remove(k - 1);
                            c.add(k - 1, number);
                        });
//                    i++;
                    }
                    case BitwiseOperationType.XOR -> {
                        expression.add(c -> {
                            logger.info("XOR");
                            c.remove(k);
                            int number = c.get(k - 1) ^ c.get(k);
                            c.remove(k - 1);
                            c.remove(k - 1);
                            c.add(k - 1, number);
                        });
//                    i++;
                    }
                    case BitwiseOperationType.OR -> {
                        expression.add(c -> {
                            logger.info("OR");
                            c = new Context(list);
                            c.remove(k);
                            int number = c.get(k - 1) | c.get(k);
                            c.remove(k - 1);
                            c.remove(k - 1);
                            c.add(k - 1, number);
                        });
//                    i++;
                    }
//                default -> i++;
                }
//            });
            i++;
            logger.info("i={}",i);
        }
//        list.forEach(token -> {
//            switch (token.substring(0,1)) {
//                case BitwiseOperationType.NOT -> {
//
//                    expression.add(c -> c.push(~c.pop()));
//                }
//                case BitwiseOperationType.LEFT_SHIFT -> expression.add(c -> c.push(c.pop()<<(c.pop())));
//                case BitwiseOperationType.RIGHT_SHIFT -> expression.add(c -> c.push(c.pop()>>(c.pop())));
//                case BitwiseOperationType.AND -> expression.add(c -> c.push(c.pop()&c.pop()));
//                case BitwiseOperationType.XOR -> expression.add(c -> c.push(c.pop()^c.pop()));
//                case BitwiseOperationType.OR -> expression.add(c -> c.push(c.pop()|c.pop()));
//                default -> expression.add(c -> c.push(Integer.parseInt(token)));
//            }
//        });
        return expression;
    }
}
