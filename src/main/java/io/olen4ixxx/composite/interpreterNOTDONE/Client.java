package io.olen4ixxx.composite.interpreterNOTDONE;

import java.util.List;

public class Client {
    private AbstractOperation expression;
    private Context context;

    public int handleExpression(List<MathOperation> expression) {
        for (MathOperation terminal:expression) {
            terminal.interpret(context);
        }
        return context.get(0);
    }
}
