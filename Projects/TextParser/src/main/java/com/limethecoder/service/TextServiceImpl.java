package com.limethecoder.service;

import com.limethecoder.model.Text;
import com.limethecoder.model.entity.composite.Composite;
import com.limethecoder.model.entity.composite.CompositeType;
import com.limethecoder.model.entity.symbol.Symbol;
import com.limethecoder.model.entity.symbol.SymbolFactory;
import com.limethecoder.model.entity.symbol.SymbolType;
import com.limethecoder.model.source.Source;
import com.limethecoder.model.source.SourceException;
import com.limethecoder.view.View;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of {@link TextService}
 *
 * @version 1.0 05 Dec 2016
 * @author Taras Sakharchuk
 */
public class TextServiceImpl implements TextService {
    private static Logger logger =
            Logger.getLogger(TextServiceImpl.class.getName());

    /** Input source to load information */
    private Source input;
    /** Output source to store information */
    private Source output;

    public TextServiceImpl(Source input, Source output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public Text load() {
        Objects.requireNonNull(input);

        Composite text = new Composite(CompositeType.TEXT);
        Composite currWord = new Composite(CompositeType.WORD);
        Composite currSentence = new Composite(CompositeType.SENTENCE);

        SymbolType lastType = null;

        try {
            input.connect();
            while (input.hasNext()) {
                char c = (char)input.readNextCharacter();
                Symbol s = SymbolFactory.getInstance().getSymbol(c);

                if(!s.isCharacter()) {
                    if (!currWord.isEmpty()) {
                        currSentence.addComponent(currWord);
                        currWord = new Composite(CompositeType.WORD);
                    }

                    if(s.isSentenceSeparator()) {
                        if(!currSentence.isEmpty()) {
                            text.addComponent(currSentence);
                            currSentence = new Composite(CompositeType.SENTENCE);
                        }

                        text.addComponent(s);
                        lastType = s.getSymbolType();
                        continue;
                    }

                    if(lastType != s.getSymbolType()) {
                        if(!currSentence.isEmpty()) {
                            currSentence.addComponent(s);
                        } else {
                            text.addComponent(s);
                        }
                    }

                } else {
                    currWord.addComponent(s);
                }

                lastType = s.getSymbolType();
            }
        } catch (SourceException exception) {
            logger.log(Level.SEVERE, View.LOAD + exception.getMessage());
        } finally {
            try {
                input.close();
            } catch (SourceException exception) {
                logger.log(Level.SEVERE, View.LOAD + exception.getMessage());
            }
        }

        if(!currWord.isEmpty()) {
            currSentence.addComponent(currWord);
        }

        if(!currSentence.isEmpty()) {
            text.addComponent(currSentence);
        }

        return new Text(text);
    }

    @Override
    public void save(Text text) {
        try {
            output.save(text.getContent());
        } catch (SourceException exception) {
            logger.log(Level.SEVERE, View.SAVE + exception.getMessage());
        }
    }
}
