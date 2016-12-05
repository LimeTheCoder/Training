package com.limethecoder.model.entity;


public class Symbol implements LexicalComponent {
    private char symbol;
    private SymbolType symbolType;

    public Symbol(char symbol) {
        setSymbol(symbol);
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;

        for(SymbolType type : SymbolType.values()) {
            if(type.getPattern().matcher(String.valueOf(symbol)).matches()) {
                symbolType = type;
                break;
            }
        }
    }

    public char getSymbol() {
        return symbol;
    }

    public SymbolType getSymbolType() {
        return symbolType;
    }

    public boolean isWhitespace() {
        return symbolType == SymbolType.WHITESPACE;
    }

    public boolean isSentenceSeparator() {
        return symbolType == SymbolType.SENTENCE_SEPARATOR;
    }

    public boolean isPunctuation() {
        return symbolType == SymbolType.PUNCTUATION;
    }

    @Override
    public String getContent() {
        return String.valueOf(symbol);
    }

    @Override
    public String getContentType() {
        return ContentType.SYMBOL;
    }

    @Override
    public boolean isSymbol() {
        return true;
    }
}
