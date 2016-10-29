package com.training.numguesser;


import java.io.InputStream;
import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    private Scanner scanner;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        setScanner(System.in);
    }

    public void setScanner(InputStream stream) {
        scanner = new Scanner(stream);
    }

    public int handleInput() {
        view.printMessage(View.INPUT_NUMBER);
        view.printRangeMessage(View.RANGE_HINT,
                model.getMin(), model.getMax());

        while(!scanner.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT);
            view.printMessage(View.INPUT_NUMBER);
            scanner.next();
        }

        return scanner.nextInt();
    }

    public void run() {
        int n = handleInput();

        while(n != -1 && !model.checkGuess(n)) {
            n = handleInput();
        }

        view.printMessage((n == -1) ? View.LOOSE_CASE : View.WIN_CASE);
        view.printHistory(model.getHistory(), model.getValue());
    }
}
