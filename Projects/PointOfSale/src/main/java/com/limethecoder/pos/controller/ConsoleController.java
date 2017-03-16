package com.limethecoder.pos.controller;


import com.limethecoder.pos.controller.validator.Validator;
import com.limethecoder.pos.model.PointOfSale;
import com.limethecoder.pos.view.View;

import java.util.Scanner;

public class ConsoleController implements Controller {

    private Scanner scanner;

    private View view;
    private PointOfSale pointOfSale;
    private Validator<String> productValidator;
    private Validator<Integer> coinValidator;

    public ConsoleController(View view, PointOfSale pointOfSale) {
        this.view = view;
        this.pointOfSale = pointOfSale;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        view.displayMessage(View.CHOOSE_PRODUCT);
        String product = scanner.next();

        if(!productValidator.isValid(product)) {
            view.displayMessage(View.NO_SUCH_PRODUCT_ERROR);
        }


    }

    private int readInteger() {
        while (!scanner.hasNextInt()) {
            view.displayMessage(View.WRONG_INPUT);
            view.displayMessage(View.INPUT_COIN);

            scanner.next();
        }

        return scanner.nextInt();
    }
}
