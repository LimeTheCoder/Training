package com.limethecoder.model.entity.symbol;


import com.limethecoder.model.entity.composite.ContainerType;
import com.limethecoder.model.entity.LexicalComponent;


/**
 * Stores original char and {@link SymbolType} of that char.
 * Represents leaf in composite pattern.
 *
 * @version 1.0 05 Dec 2016
 * @author Taras Sakharchuk
 *
 * @see com.limethecoder.model.entity.composite.Composite
 */
public class Symbol implements LexicalComponent {
    private final char symbol;
    private final SymbolType symbolType;

    public Symbol(char symbol) {
        this.symbol = symbol;

        for(SymbolType type : SymbolType.values()) {
            if(type.getPattern().matcher(String.valueOf(symbol)).matches()) {
                symbolType = type;
                return;
            }
        }

        symbolType = SymbolType.CHARACTER;
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

    public boolean isCharacter() {
        return symbolType == SymbolType.CHARACTER;
    }

    @Override
    public String getContent() {
        return String.valueOf(symbol);
    }

    @Override
    public ContainerType getContainerType() {
        return ContainerType.SYMBOL;
    }

    @Override
    public boolean isSymbol() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol1 = (Symbol) o;

        return symbol == symbol1.symbol;
    }

    @Override
    public int hashCode() {
        return (int) symbol;
    }
}
