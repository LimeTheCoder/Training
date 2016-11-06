package com.training.validation;


import com.training.validation.controller.Controller;
import com.training.validation.controller.validator.ValidatorFactory;
import com.training.validation.view.View;

public class Main {
    public static void main(String ... args) {
        View view = new View(System.out);
        ValidatorFactory factory = new ValidatorFactory();

        Controller controller = new Controller(view, factory);
        controller.run();
    }
}
