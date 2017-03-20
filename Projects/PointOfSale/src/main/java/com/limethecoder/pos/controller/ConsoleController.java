package com.limethecoder.pos.controller;


import com.limethecoder.pos.controller.validator.CoinValidator;
import com.limethecoder.pos.controller.validator.ProductValidator;
import com.limethecoder.pos.controller.validator.Validator;
import com.limethecoder.pos.model.*;
import com.limethecoder.pos.view.View;

import java.util.Scanner;

public class ConsoleController implements Controller {

    private final static String CONTINUE_CHOICE = "y";

    private Scanner scanner;

    private View view;
    private PointOfSale pointOfSale;
    private Validator<String> productValidator;
    private Validator<Integer> coinValidator;

    public ConsoleController(View view, PointOfSale pointOfSale) {
        this.view = view;
        this.pointOfSale = pointOfSale;

        this.scanner = new Scanner(System.in);

        this.productValidator = new ProductValidator();
        this.coinValidator = new CoinValidator();
    }

    public void setProductValidator(Validator<String> productValidator) {
        this.productValidator = productValidator;
    }

    public void setCoinValidator(Validator<Integer> coinValidator) {
        this.coinValidator = coinValidator;
    }

    @Override
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        PaymentRequest paymentRequest = new PaymentRequest();
        readSaleItems(paymentRequest);
        payRequest(paymentRequest);
        int oddMoney = pointOfSale.processRequest(paymentRequest);
        view.displayMessage(View.PAYMENT_SUCCESS, oddMoney);
    }

    private void readSaleItems(PaymentRequest request) {
        Product product;
        int cnt;

        do {
            product = readProduct();
            cnt = readInteger(View.INPUT_PRODUCTS_CNT);
            request.addItemToBasket(new SalesLineItem(product, cnt));
        } while (isContinue());
    }

    private boolean isContinue() {
        view.displayMessage(View.ADD_MORE_ITEMS);
        String choice = scanner.next();
        return choice.equals(CONTINUE_CHOICE);
    }

    private Product readProduct() {
        String product;

        view.displayMessage(View.CHOOSE_PRODUCT);

        while (true) {
            product = scanner.next();

            if (productValidator.isValid(product)) {
                return Product.valueOf(product.toUpperCase());
            }

            view.displayMessage(View.NO_SUCH_PRODUCT_ERROR);
            view.displayMessage(View.CHOOSE_PRODUCT);
        }
    }

    private Coin readCoin() {
        int coinValue;

        while (true){
            coinValue = readInteger(View.INPUT_COIN);

            if(coinValidator.isValid(coinValue)) {
                return Coin.valueOf(coinValue);
            }

            view.displayMessage(View.NO_SUCH_COIN);
        }
    }

    private int readInteger(String inputMessage) {
        view.displayMessage(inputMessage);

        while (!scanner.hasNextInt()) {
            view.displayMessage(View.WRONG_INPUT);
            view.displayMessage(inputMessage);

            scanner.next();
        }

        return scanner.nextInt();
    }

    private void payRequest(PaymentRequest request) {
        while (!request.isPayed()) {
            view.displayMessage(View.PAYMENT_INFO, request.getCoinsPayed(),
                    request.getTotalInvoice(), request.getMoneyLeftToPay());
            request.putCoin(readCoin());
        }
    }
}
