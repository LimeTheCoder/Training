package com.limethecoder.service;


import com.limethecoder.model.Text;
import com.limethecoder.model.source.Source;

/**
 * Provides service to perform operations on text.
 *
 * @version 1.0 05 Dec 2016
 * @author Taras Sakharchuk
 *
 * @see Text
 */
public interface TextService {
    /**
     * Loads text from {@link Source}
     *
     * @return loaded text
     */
    Text load();

    /**
     * Store text into source.
     *
     * @param text to save
     */
    void save(Text text);

    /**
     * Replace all words in the text with length equals {@param length}
     * to another string {@param word} argument
     *
     * @param length words, who have that length of characters will be replaced
     * @param word string, that will be instead replaced words
     */
    void replace(int length, Text text, String word);
}
