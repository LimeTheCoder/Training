package com.limethecoder.model.entity.symbol;


import java.util.HashMap;
import java.util.Map;

/**
 * Factory that consumes for client symbol objects.
 * Realization based on flyweight and singleton patterns.
 *
 * @version 1.0 05 Dec 2016
 * @author Taras Sakharchuk
 *
 * @see Symbol
 */
public class SymbolFactory {
    /**
     * Factory object, that one per session.
     */
    private final static SymbolFactory factory = new SymbolFactory();

    /**
     * Cache for symbols.
     */
    private Map<Character, Symbol> map = new HashMap<>();

    private SymbolFactory() {}

    public static SymbolFactory getInstance() {
        return factory;
    }

    /**
     * Returns object from cache if exists or create new {@link Symbol} object,
     * add that object to cache and returns it.
     *
     * @param c bases on char returns {@link Symbol} object
     * @return converted char to Symbol object
     */
    public Symbol getSymbol(char c) {
        if(map.containsKey(c)) {
            return map.get(c);
        }

        Symbol s = new Symbol(c);
        map.put(c, s);
        return s;
    }
}