package com.limethecoder.pos.view;

/**
 * Part of MVC pattern that responsible for displaying information
 * for user
 */
public interface View {

    /** View message templates */
    String WRONG_INPUT = "Incorrect input data. Please repeat.";
    String INPUT_COIN = "Please inject coin. " +
            "System supports only 1, 5, 10, 25, 50 coin values.";

    String CHOOSE_PRODUCT = "Enter product name you want to get:";
    String INPUT_PRODUCTS_CNT = "Enter quantity of product you want to buy:";
    String NO_SUCH_PRODUCT_ERROR = "No such product in machine";
    String NO_SUCH_COIN = "PoS doesn't support such coins";

    String ADD_MORE_ITEMS = "Do you want to add more items?(y/n)";
    String PAYMENT_INFO = "You payed %d/%d. Left to pay %d. ";
    String PAYMENT_SUCCESS = "Thx for your purchase. Your odd money: %d";

    /**
     * Displays message to user.
     *
     * @param message to display
     */
    void displayMessage(String message);

    /**
     * Performs formatting message with args and displays to user.
     *
     * @param message template for args substitution
     * @param args arguments to substitute in message
     */
    void displayMessage(String message, Object... args);
}
