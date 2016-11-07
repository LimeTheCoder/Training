package com.training.validation.model;

import java.util.ArrayList;

/**
 * Part of MVC pattern that store data and provides business logic
 * to operate on that data.
 * Also model knows nothing about other components like View and Controller
 *
 * @version 1.0 29 Oct 2016
 * @author Taras Sakharchuk
 *
 * @see com.training.validation.view.View
 * @see com.training.validation.controller.AbstractController
 */
public class NoteBook {
    /**
     * List that store all records
     */
    private ArrayList<Record> notebook = new ArrayList<>();

    /**
     * Add new record to the records list
     *
     * @param record record to add
     */
    public void addRecord(Record record){
        notebook.add(record);
    }

    public ArrayList<Record> getNotebook() {
        return notebook;
    }
}
