package io.olen4ixxx.composite.entity;

public enum TextCompositeType {

    LEXEME("\s"),
    SENTENCE(""),
    PARAGRAPH("\t", "\r\n");

    private String prefix;
    private String postfix;

    TextCompositeType(String prefix, String postfix) {
        this.prefix = prefix;
        this.postfix = postfix;
    }

    //    SYMBOL("\s"),
//    LEXEME(""),
//    SENTENCE("\r\n"),
//    PARAGRAPH("");

//    private String delimiter;
//
//    TextCompositeType(String delimiter) {
//        this.delimiter = delimiter;
//    }
//
//    public String getDelimiter() {
//        return delimiter;
//    }
}
