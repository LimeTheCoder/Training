package com.training.validation.controller.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that implements validator interface.
 * Perform validation of input data.
 *
 * @version 1.0 07 Nov 2016
 * @author Taras Sakharchuk
 */
public class InputValidator implements Validator {
    /**
     * Default error message, that will shown in case
     * when {@link #isError} equals {@code true}
     */
    private final String ERROR_MESSAGE;
    /**
     * Indicates if error occurs in validation process
     */
    private boolean isError;
    /**
     * Pattern, that will be used to perform input validation
     */
    private Pattern pattern;

    /**
     * Constructor, that create initial state of Validator object
     *
     * @param regex regex pattern, that will be used to create pattern object
     *              and perform input validation
     * @param error default error message
     */
    public InputValidator(String regex, String error) {
        pattern = Pattern.compile(regex);
        ERROR_MESSAGE = error;
    }

    @Override
    public String getError() {
        return isError ? ERROR_MESSAGE : null;
    }

    @Override
    public boolean isValid(String input) {
        Matcher matcher = pattern.matcher(input);
        if(!matcher.matches()) {
            isError = true;
        }

        return matcher.matches();
    }

    @Override
    public void reset() {
        isError = false;
    }

}
