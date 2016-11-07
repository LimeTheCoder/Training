package com.training.validation.controller;

import com.training.validation.controller.validator.ValidatorFactory;
import com.training.validation.model.Address;
import com.training.validation.view.View;


/**
 * Controller that manages address objects
 *
 * @version 1.0 07 Nov 2016
 * @author Taras Sakharchuk
 */
public class AddressController extends AbstractController<Address> {

    /**
     * Constructor, that delegate initialization to the parent constructor
     * with same arguments
     *
     * @param view view, that provides ability to display information for user
     * @param factory factory, that provides different kind of validators
     */
    public AddressController(View view, ValidatorFactory factory) {
        super(view, factory);
    }

    @Override
    public Address processEntity() {
        entity = new Address();

        entity.setPostalCode(getInput(View.PROMT_POSTAL,
                factory.getValidator(ValidatorFactory.POSTAL_VALIDATOR)));

        entity.setCity(getInput(View.PROMT_CITY,
                factory.getValidator(ValidatorFactory.STRING_VALIDATOR)));

        entity.setStreet(getInput(View.PROMT_STREET,
                factory.getValidator(ValidatorFactory.STRING_VALIDATOR)));

        entity.setBuilding(getInput(View.PROMT_BUILDING,
                factory.getValidator(ValidatorFactory.BUILDING_VALIDATOR)));

        String apartment = getInput(View.PROMT_APARTMENT,
                factory.getValidator(ValidatorFactory.APARTMENT_VALIDATOR));
        entity.setApartment(Integer.valueOf(apartment));

        return entity;
    }
}
