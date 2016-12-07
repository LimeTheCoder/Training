package com.limethecoder.model;


import com.limethecoder.model.entity.composite.Composite;

/**
 * Model object, that describes text.
 *
 * @version 1.0 05 Dec 2016
 * @author Taras Sakharchuk
 */
public class Text {
    private Composite text;

    public Text() {}

    public Text(Composite text) {
        this.text = text;
    }

    public Composite getText() {
        return text;
    }

    public void setText(Composite text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text.getContent();
    }

    public String getContent() {
        return text.getContent();
    }
}