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
}
