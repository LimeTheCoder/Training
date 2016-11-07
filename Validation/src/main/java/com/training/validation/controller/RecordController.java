package com.training.validation.controller;


import com.training.validation.controller.validator.Validator;
import com.training.validation.controller.validator.ValidatorFactory;
import com.training.validation.model.Address;
import com.training.validation.model.Group;
import com.training.validation.model.Record;
import com.training.validation.view.View;

/**
 * Controller that manages record objects
 *
 * @version 1.0 07 Nov 2016
 * @author Taras Sakharchuk
 */
public class RecordController extends AbstractController<Record> {

    /** Controller, that will be manage record objects */
    private AddressController addressController;

    /**
     * Constructor, that delegate initialization to the parent constructor
     * with same arguments
     *
     * @param view view, that provides ability to display information for user
     * @param factory factory, that provides different kind of validators
     */
    public RecordController(View view, ValidatorFactory factory) {
        super(view, factory);
        addressController = new AddressController(view, factory);
    }

    @Override
    public Record processEntity() {
        entity = new Record();

        Validator validator = factory.getValidator(ValidatorFactory.STRING_VALIDATOR);

        entity.setSurname(getInput(View.PROMT_SURNAME, validator));
        validator.reset();

        entity.setName(getInput(View.PROMT_NAME, validator));
        validator.reset();

        entity.setPatronymic(getInput(View.PROMT_PATRONYMIC, validator));
        validator.reset();

        entity.setUsername(getInput(View.PROMT_USERNAME,
                factory.getValidator(ValidatorFactory.USERNAME_VALIDATOR)));

        entity.setComment(getInput(View.PROMT_COMMENT,
                factory.getValidator(ValidatorFactory.COMMENT_VALIDATOR)));

        entity.setGroup(Group.valueOf(getInput(
                View.PROMT_GROUP,
                factory.getValidator(ValidatorFactory.GROUP_VALIDATOR)).toUpperCase()
        ));

        entity.setHomePhone(getInput(View.PROMT_HOME_PHONE,
                factory.getValidator(ValidatorFactory.PHONE_VALIDATOR)));

        entity.setCellPhone(getInput(View.PROMT_CELL_PHONE,
                factory.getValidator(ValidatorFactory.PHONE_VALIDATOR)));

        if(getInput(View.PROMT_OPTIONAL,
                factory.getValidator(ValidatorFactory.OPTIONAL_VALIDATOR))
                .equals("y")) {

            entity.setCellPhoneOptional(getInput(View.PROMT_CELL_PHONE,
                    factory.getValidator(ValidatorFactory.PHONE_VALIDATOR)));
        }

        entity.setEmail(getInput(View.PROMT_EMAIL,
                factory.getValidator(ValidatorFactory.EMAIL_VALIDATOR)));

        entity.setSkype(getInput(View.PROMT_SKYPE,
                factory.getValidator(ValidatorFactory.SKYPE_VALIDATOR)));

        Address address = addressController.processEntity();

        entity.setAddress(address);

        entity.setCreateDate(getInput(View.PROMT_CREATION_DATE,
                factory.getValidator(ValidatorFactory.DATE_VALIDATOR)));

        entity.setEditDate(getInput(View.PROMT_EDIT_DATE,
                factory.getValidator(ValidatorFactory.DATE_VALIDATOR)));

        return entity;
    }
}
