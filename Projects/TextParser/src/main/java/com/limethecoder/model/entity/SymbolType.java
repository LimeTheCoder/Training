package com.limethecoder.model.entity;


import java.util.regex.Pattern;

/**
 * Enum that stores different types of characters
 *
 * @version 1.0 05 Dec 2016
 * @author Taras Sakharchuk
 */
public enum SymbolType {
    PUNCTUATION("[-`~@#$%^&*()_+=/|{}\\['\":;,<>]"),
    SENTENCE_SEPARATOR("[.!?]"),
    WHITESPACE("\\s"),
    CHARACTER("[a-zA-Z0-9]");

    private Pattern pattern;

    SymbolType(String regex) {
        pattern = Pattern.compile(regex);
    }

    public Pattern getPattern() {
        return pattern;
    }
}
