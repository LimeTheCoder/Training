package com.limethecoder.patterns.decorator;


public class Printer implements PrinterInterface{
    private String value;

    public Printer(String value){this.value = value;}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}
