package io.olen4ixxx.composite.interpreterNOTDONE;

import java.util.List;

public class Context {
//    private ArrayDeque<Integer> contextValue;
//
//    public Context(ArrayDeque<Integer> contextValue) {
//        this.contextValue = contextValue;
//    }
//
//    public Integer pop() {
//        return contextValue.pop();
//    }
//    public void push(int number) {
//        contextValue.push(number);
//    }

    private List<String> contextValue;

    public Context(List<String> contextValue) {
        this.contextValue = contextValue;
    }
    public int get(int index) {
        String stringValue = contextValue.get(index);
        return Integer.parseInt(stringValue);
    }
    public void add(int index, int number) {
        contextValue.add(index, String.valueOf(number));
    }

    public void remove(int index) {
        contextValue.remove(index);
    }

    public List<String> getContextValue() {
        return contextValue;
    }

    public void setContextValue(List<String> contextValue) {
        this.contextValue = contextValue;
    }
}
