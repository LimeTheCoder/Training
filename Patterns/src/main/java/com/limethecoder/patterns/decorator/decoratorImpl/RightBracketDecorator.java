package com.limethecoder.patterns.decorator.decoratorImpl;


import com.limethecoder.patterns.decorator.Decorator;
import com.limethecoder.patterns.decorator.PrinterInterface;

public class RightBracketDecorator extends Decorator {

    public RightBracketDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        super.print();
        System.out.print("]");
    }
}