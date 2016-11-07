package com.training.validation;


import com.training.validation.controller.NotebookController;
import com.training.validation.controller.validator.ValidatorFactory;
import com.training.validation.model.NoteBook;
import com.training.validation.view.View;

public class Main {
    public static void main(String ... args) {
        View view = new View(System.out);
        ValidatorFactory factory = new ValidatorFactory();
        NoteBook noteBook = new NoteBook();

        NotebookController controller = new NotebookController(view, factory, noteBook);
        controller.run();
    }
}
