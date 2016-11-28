package com.limethecoder.patterns.decorator;


public abstract class Decorator implements PrinterInterface {
    private PrinterInterface component;

    public Decorator(PrinterInterface component) {
        this.component = component;
    }

    public PrinterInterface getComponent() {
        return component;
    }

    public void setComponent(PrinterInterface component) {
        this.component = component;
    }

    public void print() {
        component.print();
    }
}
