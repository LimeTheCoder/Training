package com.limethecoder.model.entity;

import com.limethecoder.model.entity.composite.Composite;
import com.limethecoder.model.entity.composite.ContainerType;

/**
 * Interface that describes component.
 * Part of composite pattern
 *
 * @version 1.0 05 Dec 2016
 * @author Taras Sakharchuk
 *
 * @see Composite
 */
public interface LexicalComponent {

    /**
     * @return content of lexical component
     */
    String getContent();

    /**
     * @return type of component
     */
    ContainerType getContainerType();

    /**
     * @return {@code true} if component is symbol else {@code false}
     */
    boolean isSymbol();
}
