package com.limethecoder.model;


import com.limethecoder.model.entity.Composite;
import com.limethecoder.model.entity.CompositeType;
import com.limethecoder.model.entity.LexicalComponent;
import com.limethecoder.model.entity.Symbol;
import com.limethecoder.model.source.Source;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Model {
    private Composite text;


    public void loadText(Source source) {
        Objects.requireNonNull(source);

        text = new Composite(CompositeType.TEXT);
        Composite currWord = new Composite(CompositeType.WORD);
        Composite currSentence = new Composite(CompositeType.SENTENCE);

        try {
            source.connect();
            while (source.hasNext()) {
                char c = (char)source.readNextCharacter();
                Symbol s = new Symbol(c);

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
                        continue;
                    }

                    currSentence.addComponent(s);
                } else {
                    currWord.addComponent(s);
                }
            }
        } catch (IOException exception) {
            System.out.println("[ERROR]: " + exception.getMessage());
        } finally {
            try {
                source.close();
            } catch (IOException exception) {
                System.out.println("[Closing ERROR]: " + exception.getMessage());
            }
        }

        if(!currWord.isEmpty()) {
            currSentence.addComponent(currWord);
        }

        if(!currSentence.isEmpty()) {
            text.addComponent(currSentence);
        }
    }

    public void saveText(Source source) {
        try {
            source.connect();
            source.save(text.getContent());
        } catch (IOException exception) {
            System.out.println("[ERROR]: " + exception.getMessage());
        } finally {
            try {
                source.close();
            } catch (IOException exception) {
                System.out.println("[Closing error]: " + exception.getMessage());
            }
        }
    }

    /**
     * Replace all words in the text with length equals {@param length}
     * to another string {@param word} argument
     *
     * @param length words, who have that length of characters will be replaced
     * @param word string, that will be instead replaced words
     */
    public void replace(int length, String word) {
        Composite wordComposite = new Composite(CompositeType.WORD);
        for(char c : word.toCharArray()) {
            wordComposite.addComponent(new Symbol(c));
        }

        List<LexicalComponent> sentences = text.getComponents();
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

    public String getContent() {
        return text.getContent();
    }
}
