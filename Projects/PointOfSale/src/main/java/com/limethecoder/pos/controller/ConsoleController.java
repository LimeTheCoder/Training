package com.limethecoder.pos.controller;


import com.limethecoder.pos.view.View;

import java.util.Scanner;

public class ConsoleController implements Controller {


    /** By mean of scanner controller will get input information from user */
    private Scanner scanner;

    private View view;


    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Get integer value from user
     *
     * @return integer users input
     */
    private int readInteger() {
        while (!scanner.hasNextInt()) {
            view.displayMessage(View.WRONG_INPUT);
            view.displayMessage(View.INPUT_COIN);

            scanner.next();
        }

        return scanner.nextInt();
    }
}
