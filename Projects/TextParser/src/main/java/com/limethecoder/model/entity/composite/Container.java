package com.limethecoder.model.entity.composite;


import com.limethecoder.model.entity.LexicalComponent;

import java.util.List;

/**
 * Interface that describes container objects in composite pattern.
 * Stores list of {@link LexicalComponent} class objects.
 * Can store another composites.
 *
 * @version 1.0 05 Dec 2016
 * @author Taras Sakharchuk
 */
public interface Container extends LexicalComponent {
    void addComponent(LexicalComponent component);

    void removeComponent(LexicalComponent component);

    /**
     * @return number of children elements
     */
    int childCount();

    /**
     * Check is current composite object has any child.
     *
     * @return {@code true} if composite has no child, otherwise {@code false}
     */
    boolean isEmpty();

    List<LexicalComponent> getComponents();
}
