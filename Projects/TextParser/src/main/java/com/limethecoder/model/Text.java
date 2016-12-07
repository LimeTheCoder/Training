package com.limethecoder.model;


import com.limethecoder.model.entity.composite.Container;
import com.limethecoder.model.entity.LexicalComponent;
import com.limethecoder.model.entity.composite.ContainerType;

import java.util.List;

/**
 * Model object, that describes text.
 *
 * @version 1.0 05 Dec 2016
 * @author Taras Sakharchuk
 */
public class Text implements Container {
    private Container text;

    public Text() {}

    public Text(Container text) {
        this.text = text;
    }

    public Container getText() {
        return text;
    }

    public void setText(Container text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text.getContent();
    }

    public String getContent() {
        return text.getContent();
    }

    @Override
    public ContainerType getContainerType() {
        return text.getContainerType();
    }

    @Override
    public boolean isSymbol() {
        return false;
    }

    @Override
    public void addComponent(LexicalComponent component) {
        text.addComponent(component);
    }

    @Override
    public void removeComponent(LexicalComponent component) {
        text.removeComponent(component);
    }

    @Override
    public int childCount() {
        return text.childCount();
    }

    @Override
    public boolean isEmpty() {
        return text.isEmpty();
    }

    @Override
    public List<LexicalComponent> getComponents() {
        return text.getComponents();
    }
}