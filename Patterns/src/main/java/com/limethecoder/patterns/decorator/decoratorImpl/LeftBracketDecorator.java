package com.limethecoder.patterns.decorator.decoratorImpl;


import com.limethecoder.patterns.decorator.Decorator;
import com.limethecoder.patterns.decorator.PrinterInterface;

public class LeftBracketDecorator extends Decorator {

    public LeftBracketDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("[");
        super.print();
    }
}