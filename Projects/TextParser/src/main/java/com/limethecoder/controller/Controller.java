package com.limethecoder.controller;


import com.limethecoder.model.Text;
import com.limethecoder.model.entity.LexicalComponent;
import com.limethecoder.model.entity.composite.Composite;
import com.limethecoder.model.entity.composite.CompositeType;
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
        replace(5, text, "Test");
        textService.save(text);
    }

    /**
     * Replace all words in the text with length equals {@param length}
     * to another string {@param word} argument
     *
     * @param length words, who have that length of characters will be replaced
     * @param word string, that will be instead replaced words
     */
    private void replace(int length, Text text, String word) {
        Composite wordComposite = new Composite(CompositeType.WORD);
        for(char c : word.toCharArray()) {
            wordComposite.addComponent(new Symbol(c));
        }

        List<LexicalComponent> sentences = text.getText().getComponents();
        for(int i = 0; i < sentences.size(); i++) {
            if(sentences.get(i).isSymbol()) {
                continue;
            }

            List<LexicalComponent> words = ((Composite)sentences.get(i)).getComponents();
            words.replaceAll(w -> !w.isSymbol() &&
                    ((Composite)w).childCount() ==
                            length ? wordComposite : w);
        }
    }
}
