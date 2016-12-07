package com.limethecoder.controller;

import com.limethecoder.model.Text;
import com.limethecoder.model.source.Source;
import com.limethecoder.model.source.SourceType;
import com.limethecoder.service.TextService;
import com.limethecoder.service.TextServiceImpl;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ControllerTest {

    private final static String SOURCE_INPUT =
            "Hello,,,,,,        Jinny! I like to see you. Good luck! Bye?";
    private final static String REPLACED_CONTENT = "Test, Test! " +
            "I like to see you. Good luck! Bye?";

    private final String wordToReplace = "Test";
    private final int lengthReplaced = 5;

    private Text text;

    @Before
    public void init() {
        Source source = Source.getInstance(SourceType.DUMMY, SOURCE_INPUT);
        TextService textService = new TextServiceImpl(source, source);
        text = textService.load();
    }

    @Test
    public void testReplace() {
        Controller.replace(lengthReplaced, text, wordToReplace);
        assertEquals(text.getContent(), REPLACED_CONTENT);
    }
}