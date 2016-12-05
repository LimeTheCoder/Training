package com.limethecoder.model.entity;


import java.util.ArrayList;
import java.util.List;

public class Composite implements LexicalComponent {

    private List<LexicalComponent> components;
    private String compositeType;

    public Composite(String compositeType) {
        this.compositeType = compositeType;
        this.components = new ArrayList<>();
    }

    public Composite(List<LexicalComponent> components, String compositeType) {
        this.components = components;
        this.compositeType = compositeType;

        if(components == null) {
            this.components = new ArrayList<>();
        }
    }

    public List<LexicalComponent> getComponents() {
        return components;
    }

    public void addComponent(LexicalComponent component) {
        components.add(component);
    }

    public void removeComponent(LexicalComponent component) {
        components.remove(component);
    }

    public LexicalComponent getLast() {
        return components.get(-1);
    }

    public int childCount() {
        return components.size();
    }

    public boolean isEmpty() {
        return components.isEmpty();
    }

    @Override
    public String getContent() {
        StringBuilder stringBuilder = new StringBuilder();

        components.forEach(el ->
                stringBuilder
                        .append(el.getContent())
        );

        return stringBuilder.toString();
    }

    @Override
    public String getCompositeType() {
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

        if (!components.equals(composite.components)) return false;
        return compositeType.equals(composite.compositeType);
    }

    @Override
    public int hashCode() {
        int result = components.hashCode();
        result = 31 * result + compositeType.hashCode();
        return result;
    }
}
