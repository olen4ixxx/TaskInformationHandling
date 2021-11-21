package io.olen4ixxx.composite.entity;

public class Symbol implements CompositeComponent {
    private char symbolValue;
    private SymbolType symbolType;

    public Symbol(char symbol) {
        this.symbolValue = symbol;
        boolean isVowel = String.valueOf(symbol).matches(SymbolType.VOWEL.getRegex());
        boolean isConsonant = String.valueOf(symbol).matches(SymbolType.CONSONANT.getRegex());
        boolean isPunctuation = String.valueOf(symbol).matches(SymbolType.PUNCTUATION.getRegex());
        if (isVowel) {
            symbolType = SymbolType.VOWEL;
        } else if (isConsonant) {
            symbolType = SymbolType.CONSONANT;
        } else if (isPunctuation) {
            symbolType = SymbolType.PUNCTUATION;
        } else {
            symbolType = SymbolType.SPECIAL_SYMBOL;
        }
    }

    public char getSymbolValue() {
        return symbolValue;
    }

    public void setSymbolValue(char symbolValue) {
        this.symbolValue = symbolValue;
    }

    public SymbolType getSymbolType() {
        return symbolType;
    }

    public void setSymbolType(SymbolType symbolType) {
        this.symbolType = symbolType;
    }

    @Override
    public boolean add(CompositeComponent component) {
        throw new UnsupportedOperationException("Not for symbols");
    }

    @Override
    public boolean remove(CompositeComponent component) {
        throw new UnsupportedOperationException("Not for symbols");
    }

    @Override
    public String toString() {
        return String.valueOf(symbolValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Symbol s = (Symbol) o;
        return s.getSymbolValue() == symbolValue;
    }

    @Override
    public boolean equalsIgnoreCase(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Symbol s = (Symbol) o;
        String sValue = String.valueOf(s.getSymbolValue());
        return sValue.equalsIgnoreCase(String.valueOf(symbolValue));
    }

    @Override
    public int hashCode() {
        return symbolValue;
    }
}
