package com.training.validation.view;

import java.io.PrintStream;

/**
 * Part of MVC pattern that responsible for displaying information
 * for user
 *
 * @version 1.0 06 Nov 2016
 * @author Taras Sakharchuk
 */
public class View {

    public static final String PROMT_NAME = "Enter first name:(3-30)";

    public static final String PROMT_SURNAME = "Enter surname name:(3-30)";

    public static final String PROMT_PATRONYMIC = "Enter patronymic:(3-30)";

    public static final String PROMT_USERNAME =
            "Enter username(4-15 chars):";

    public static final String PROMT_COMMENT =
            "Enter comment(100 chars):";

    public static final String PROMT_GROUP =
            "Enter group (Family - 0, Work - 1, Friends - 2):";

    public static final String PROMT_HOME_PHONE =
            "Enter home phone number(+** (***) ***-****):";

    public static final String PROMT_CELL_PHONE =
            "Enter cell phone number(+** (***) ***-****):";

    public static final String PROMT_OPTIONAL_PHONE =
            "Enter additional cell phone number(+** (***) ***-****)\n " +
                    "Or skip question if you don't want.";
    public static final String PROMT_EMAIL =
            "Enter email(mail@domain):";

    public static final String PROMT_SKYPE =
            "Enter skype username(5-32 chars):";

    public static final String PROMT_POSTAL = "Enter postal code(xxxxx):";

    public static final String PROMT_CITY = "Enter city:(3-30)";

    public static final String PROMT_STREET = "Enter street:(3-30)";

    public static final String PROMT_BUILDING = "Enter building number:";

    public static final String PROMT_APARTMENT = "Apartment number:";

    public static final String PROMT_CREATION_DATE =
            "Enter creation date(yy/mm/dd):";

    public static final String ERROR_MSG = "Incorrect input. Try again.";

    /** Stream to output information for user */
    private PrintStream stream;

    public View(PrintStream stream) {
        this.stream = stream;
    }

    /**
     * By mean of {@link #stream} print message, that passed as argument
     *
     * @param message information to print
     */
    public void printMessage(String message) {
        stream.println(message);
    }

}