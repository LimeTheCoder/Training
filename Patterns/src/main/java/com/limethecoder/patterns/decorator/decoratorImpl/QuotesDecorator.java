package com.limethecoder.patterns.decorator.decoratorImpl;


import com.limethecoder.patterns.decorator.Decorator;
import com.limethecoder.patterns.decorator.PrinterInterface;

public class QuotesDecorator extends Decorator {

    public QuotesDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("\"");
        super.print();
        System.out.print("\"");
    }
}
