package io.olen4ixxx.composite.entity;

public enum SymbolType {
    VOWEL("[aouieAOUIEаоуыэяёюиеАОУЫЭЯЁЮИЕ]"),
    CONSONANT("[A-zА-я&&[^aouieAOUIEаоуыэяёюиеАОУЫЭЯЁЮИЕ]]"),
    PUNCTUATION("[,.!?…]"),
    SPECIAL_SYMBOL("");

    private final String regex;

    SymbolType(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
