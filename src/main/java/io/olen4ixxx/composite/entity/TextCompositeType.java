package io.olen4ixxx.composite.entity;

public enum TextCompositeType {
    SYMBOL("\s"),
    LEXEME(""),
    SENTENCE("\r\n"),
    PARAGRAPH("");

    private String delimiter;

    TextCompositeType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
