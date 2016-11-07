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
            "Enter group (Family, Work, Friends):";

    public static final String PROMT_HOME_PHONE =
            "Enter home phone number(+** (***) ***-****):";

    public static final String PROMT_CELL_PHONE =
            "Enter cell phone number(+** (***) ***-****):";

    public static final String PROMT_OPTIONAL =
            "Enter additional cell phone number?(y/n)";

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
            "Enter creation date(yy-mm-dd):";

    public static final String PROMT_EDIT_DATE =
            "Enter edit date(yy-mm-dd):";

    public static final String ADD_ANOTHER_OPTION =
            "Do you want to add another record? (y/n)";

    /* Validation errors */

    public static final String ERROR_TAG = "[Error]";

    public static final String TRY_AGAIN = "Please try again.";

    public static final String STRING_ERROR =
            "String must be in range (3-30) chars";

    public static final String USERNAME_ERROR =
            "Username must be in range (4-15) chars";

    public static final String GROUP_ERROR =
            "No such group. Choose from the list!";

    public static final String COMMENT_ERROR =
            "Comment must have no more 100 chars";

    public static final String DATE_ERROR =
            "Date must be in following format(yy-mm-dd)";

    public static final String PHONE_ERROR =
            "Phone number must be following format (+** (***) ***-****)";

    public static final String EMAIL_ERROR =
            "Email must be following format (mail@domain)";

    public static final String SKYPE_ERROR =
            "Skype username must be between (5-32 chars)";

    public static final String BUILDING_ERROR =
            "Incorrect building format";

    public static final String APARTMENT_ERROR =
            "Apartment number can store only 1-4 digits";

    public static final String POSTAL_ERROR =
            "Postal code must store 5 digits";

    public static final String OPTIONAL_ERROR =
            "Answer must be (y/n)";

    /* Delimiters */
    public static final String SPACE_DELIMITER = " ";
    public static final String POINT_DELIMITER = ".";

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

    public void printError(String error) {
        stream.println(ERROR_TAG + error);
        stream.println(TRY_AGAIN);
    }
}