package com.training.validation.controller;

/**
 * Interface, that store regex constants
 *
 * @version 1.0 06 Nov 2016
 * @author Taras Sakharchuk
 */
public interface RegexConstants {
    String PHONE = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$";
    String EMAIL = "^(.+\\@.+\\..+)$";
    String POSTAL_CODE = "^[0-9]{5}$";
    String GROUP = "^([Ff]amily|[Ff]riends|[Ww]ork)$";
    String SKYPE = "^[a-zA-Z][a-zA-Z0-9\\.,\\-_]{5,32}$";
    String USERNAME = "^[a-zA-Z0-9-_]{4,15}$";
    String BUILDING = "^\\d{1,4}[A-Za-z]?$";
    String APARTMENT = "^\\d{1,4}$";
    String COMMENT = "^.{1,100}$";
    String DATE = "^\\d{2}-\\d{2}-\\d{2}$";
    String STRING = "^[a-zA-Z]{3,30}$";
    String OPTIONAL = "^(y|n)$";
}
