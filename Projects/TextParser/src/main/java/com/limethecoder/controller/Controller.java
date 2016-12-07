package com.limethecoder.controller;


import com.limethecoder.model.Text;
import com.limethecoder.model.entity.composite.Container;
import com.limethecoder.model.entity.LexicalComponent;
import com.limethecoder.model.entity.composite.Composite;
import com.limethecoder.model.entity.composite.ContainerType;
import com.limethecoder.model.entity.symbol.Symbol;
import com.limethecoder.service.TextService;
import com.limethecoder.view.View;

import java.util.List;

/**
 * Part of MVC pattern that accepts input and converts it
 * to commands for the Model or View.
 *
 * @version 1.0 05 Dec 2016
 * @author Taras Sakharchuk
 *
 * @see TextService
 * @see View
 */
public class Controller {
    private View view;
    private TextService textService;

    public Controller(TextService textService, View view) {
        this.textService = textService;
        this.view = view;
    }

    /**
     * Loads text by means of {@link #textService}, after that
     * perform some operations with text and stores it back.
     */
    public void process() {
        Text text = textService.load();
        view.printMessage(text.getContent());
        textService.replace(5, text, "Test");
        textService.save(text);
    }
}
