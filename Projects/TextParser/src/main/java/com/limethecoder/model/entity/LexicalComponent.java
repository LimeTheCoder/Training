package com.limethecoder.model.entity;

/**
 * Interface that describes component.
 * Part of composite pattern
 *
 * @version 1.0 05 Dec 2016
 * @author Taras Sakharchuk
 */
public interface LexicalComponent {

    /**
     * @return content of lexical component
     */
    String getContent();

    /**
     * @return type of content that represented by lexical component
     */
    String getContentType();

    /**
     * @return {@code true} if component is symbol else {@code false}
     */
    boolean isSymbol();
}