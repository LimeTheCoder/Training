package com.limethecoder.pos.view;


import java.io.PrintStream;


public class ConsoleView implements View {

    /** Stream to output information for user */
    private PrintStream stream;

    public ConsoleView(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void displayMessage(String message) {
        stream.println(message);
    }

    @Override
    public void displayMessage(String message, Object... args) {
        stream.println(String.format(message, args));
    }
}
