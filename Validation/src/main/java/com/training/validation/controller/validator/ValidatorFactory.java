package com.training.validation.controller.validator;

import com.training.validation.controller.RegexConstants;
import com.training.validation.view.View;

/**
 * Validators factory that consume for user different
 * kind of validators for different situations
 *
 * @version 1.0 07 Nov 2016
 * @author Taras Sakharchuk
 */
public class ValidatorFactory {

    /* String constants for different types of validators */

    public static final String PHONE_VALIDATOR = "phone";
    public static final String EMAIL_VALIDATOR = "email";
    public static final String POSTAL_VALIDATOR = "postal";
    public static final String GROUP_VALIDATOR = "group";
    public static final String SKYPE_VALIDATOR = "skype";
    public static final String USERNAME_VALIDATOR = "username";
    public static final String BUILDING_VALIDATOR = "building";
    public static final String APARTMENT_VALIDATOR = "apartment";
    public static final String COMMENT_VALIDATOR = "comment";
    public static final String DATE_VALIDATOR = "date";
    public static final String STRING_VALIDATOR = "string";
    public static final String OPTIONAL_VALIDATOR = "optional";

    /**
     * Methods that choose correct initialization of validator based
     * on method argument
     *
     * @param type validator's type,
     *             based on which return properly initialized validator
     * @return properly initialized validator based on method argument
     */
    public Validator getValidator(String type) {
        switch (type) {
            case PHONE_VALIDATOR:
                return new InputValidator(RegexConstants.PHONE,
                        View.PHONE_ERROR);
            case EMAIL_VALIDATOR:
                return new InputValidator(RegexConstants.EMAIL,
                        View.EMAIL_ERROR);
            case POSTAL_VALIDATOR:
                return new InputValidator(RegexConstants.POSTAL_CODE,
                        View.POSTAL_ERROR);
            case GROUP_VALIDATOR:
                return new InputValidator(RegexConstants.GROUP,
                        View.GROUP_ERROR);
            case SKYPE_VALIDATOR:
                return new InputValidator(RegexConstants.SKYPE,
                        View.SKYPE_ERROR);
            case USERNAME_VALIDATOR:
                return new InputValidator(RegexConstants.USERNAME,
                        View.USERNAME_ERROR);
            case BUILDING_VALIDATOR:
                return new InputValidator(RegexConstants.BUILDING,
                        View.BUILDING_ERROR);
            case APARTMENT_VALIDATOR:
                return new InputValidator(RegexConstants.APARTMENT,
                        View.APARTMENT_ERROR);
            case COMMENT_VALIDATOR:
                return new InputValidator(RegexConstants.COMMENT,
                        View.COMMENT_ERROR);
            case DATE_VALIDATOR:
                return new InputValidator(RegexConstants.DATE,
                        View.DATE_ERROR);
            case OPTIONAL_VALIDATOR:
                return new InputValidator(RegexConstants.OPTIONAL,
                        View.OPTIONAL_ERROR);
            case STRING_VALIDATOR:
            default:
                return new InputValidator(RegexConstants.STRING,
                        View.STRING_ERROR);
        }
    }
}
