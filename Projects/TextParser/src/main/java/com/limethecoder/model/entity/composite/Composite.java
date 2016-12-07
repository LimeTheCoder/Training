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
    private ContainerType containerType;

    public Composite(ContainerType containerType) {
        this.containerType = containerType;
        this.components = new LinkedList<>();
    }

    public Composite(List<LexicalComponent> components, ContainerType containerType) {
        this.components = components;
        this.containerType = containerType;

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
    public ContainerType getContainerType() {
        return containerType;
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

        return containerType.equals(composite.containerType);
    }

    @Override
    public int hashCode() {
        int result = components.hashCode();
        result = 31 * result + containerType.hashCode();
        return result;
    }
}
