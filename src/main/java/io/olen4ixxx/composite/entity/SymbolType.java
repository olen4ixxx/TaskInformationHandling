package io.olen4ixxx.composite.entity;

public enum SymbolType { // TODO: 09.11.2021
    VOWEL("[aouieAOUIEаоуыэяёюиеАОУЫЭЯЁЮИЕ]"),
    CONSONANT("[A-zА-я&&[^aouieAOUIEаоуыэяёюиеАОУЫЭЯЁЮИЕ]]"),
    PUNCTUATION("[,.!?…]"),
    SPECIAL_SYMBOL("");

    private String regex;

    SymbolType(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
