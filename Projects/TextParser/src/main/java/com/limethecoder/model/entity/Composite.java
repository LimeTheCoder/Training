package com.limethecoder.model.entity;


import java.util.ArrayList;
import java.util.List;

public class Composite implements LexicalComponent {

    private List<LexicalComponent> components;
    private String contentType;

    public Composite(List<LexicalComponent> components, String contentType) {
        this.components = components;
        this.contentType = contentType;

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
    public String getContentType() {
        return contentType;
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
        return contentType.equals(composite.contentType);
    }

    @Override
    public int hashCode() {
        int result = components.hashCode();
        result = 31 * result + contentType.hashCode();
        return result;
    }
}
