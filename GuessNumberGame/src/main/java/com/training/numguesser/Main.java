package com.training.numguesser;

public class Main {
    public static void main(String ... args) {
        Model model = new Model();
        View view = new View(System.out);
        Controller controller = new Controller(model, view);
        controller.run();
    }
}
