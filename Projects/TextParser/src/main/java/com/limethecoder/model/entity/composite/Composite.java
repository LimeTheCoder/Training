package com.limethecoder.model.entity.composite;


import com.limethecoder.model.entity.LexicalComponent;

import java.util.LinkedList;
import java.util.List;

/**
 * Class that describes container objects in composite pattern.
 * Stores list of {@link LexicalComponent} class objects.
 * Can store another composites.
 *
 * @version 1.0 05 Dec 2016
 * @author Taras Sakharchuk
 */
public class Composite implements Container {

    private List<LexicalComponent> components;
    private String compositeType;

    public Composite(String compositeType) {
        this.compositeType = compositeType;
        this.components = new LinkedList<>();
    }

    public Composite(List<LexicalComponent> components, String compositeType) {
        this.components = components;
        this.compositeType = compositeType;

        if(components == null) {
            this.components = new LinkedList<>();
        }
    }

    @Override
    public List<LexicalComponent> getComponents() {
        return components;
    }

    @Override
    public void addComponent(LexicalComponent component) {
        components.add(component);
    }

    @Override
    public void removeComponent(LexicalComponent component) {
        components.remove(component);
    }


    @Override
    public int childCount() {
        return components.size();
    }

    @Override
    public boolean isEmpty() {
        return components.isEmpty();
    }

    @Override
    public String getContent() {
        StringBuilder stringBuilder = new StringBuilder();

        for(LexicalComponent component : components) {
            stringBuilder.append(component.getContent());
        }

        return stringBuilder.toString();
    }

    @Override
    public String getContainerType() {
        return compositeType;
    }

    @Override
    public boolean isSymbol() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Composite composite = (Composite) o;

        if(!components.equals(composite.components)) return false;

        return compositeType.equals(composite.compositeType);
    }

    @Override
    public int hashCode() {
        int result = components.hashCode();
        result = 31 * result + compositeType.hashCode();
        return result;
    }
}
