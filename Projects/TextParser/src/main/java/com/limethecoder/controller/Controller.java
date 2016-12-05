package com.limethecoder.controller;


import com.limethecoder.model.Model;
import com.limethecoder.model.source.Source;
import com.limethecoder.view.View;

public class Controller {
    private Model model;
    private View view;
    private Source input;
    private Source output;

    public Controller(Model model, View view, Source input, Source output) {
        this.model = model;
        this.view = view;
        this.input = input;
        this.output = output;
    }

    public void process() {
        model.loadText(input);
        view.printMessage(model.getContent());
        model.replace(2, "Test");
        model.saveText(output);
    }
}
