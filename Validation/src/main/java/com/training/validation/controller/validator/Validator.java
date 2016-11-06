package com.training.validation.controller.validator;

/**
 * Interface that describes validator.
 * Validator interface provides methods to perform validation of input data and
 * for getting error message in case if input is not valid.
 *
 * @version 1.0 06 Nov 2016
 * @author Taras Sakharchuk
 */
public interface Validator {
    /**
     * Method that get error status of validation process
     *
     * @return error message in case if input isn't valid,
     *         otherwise return {@code null}
     */
    String getError();

    /**
     * Check is input message is valid
     *
     * @param input message, that need to check
     * @return {@code true} if input is valid
     *         {@code false} if input is not valid
     */
    boolean isValid(String input);

    /**
     * Set error state to initial value.
     */
    void reset();
}
