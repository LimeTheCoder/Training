package com.training.validation.controller;


import com.training.validation.controller.validator.ValidatorFactory;
import com.training.validation.model.NoteBook;
import com.training.validation.model.Record;
import com.training.validation.view.View;

/**
 * Controller that manages notebook objects
 * NotebookController is central controller, cause he manages
 * of central entity in model - {@code NoteBook} entity.
 *
 * @version 1.0 07 Nov 2016
 * @author Taras Sakharchuk
 * @see com.training.validation.model.NoteBook
 */
public class NotebookController extends AbstractController<NoteBook> {

    /** Controller, that will be manage record objects */
    private RecordController recordController;

    /**
     * Constructor, that delegate initialization to the parent constructor
     * with same arguments
     *
     * @param view view, that provides ability to display information for user
     * @param factory factory, that provides different kind of validators
     * @param entity object, that will be managed by controller
     */
    public NotebookController(View view, ValidatorFactory factory, NoteBook entity) {
        super(view, factory);
        this.entity = entity;
        recordController = new RecordController(view, factory);
    }

    @Override
    public NoteBook processEntity() {
        entity.addRecord(recordController.processEntity());
        return entity;
    }

    /**
     * Method, that should be invoked by client of this controller.
     * Add new record entities created from information, that user provided,
     * to the {@code NoteBook}.
     */
    public void run() {
        String choice;

        do {
            processEntity();
            choice = getInput(View.ADD_ANOTHER_OPTION,
                    factory.getValidator(ValidatorFactory.OPTIONAL_VALIDATOR));
        } while (choice.equals("y"));
    }
}
