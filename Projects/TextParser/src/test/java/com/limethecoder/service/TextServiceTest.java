package com.limethecoder.service;

import com.limethecoder.model.Text;
import com.limethecoder.model.source.Source;
import com.limethecoder.model.source.SourceType;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TextServiceTest {
    private final static String INPUT =
            "Hello,,,,,,        Jinny! I like to see you. Good luck! Bye?";
    private final static String EXPECTED_CONTENT = "Hello, Jinny! " +
            "I like to see you. Good luck! Bye?";
    private final static int EXPECTED_CHILD_COUNT = 11;
    private Text text;

    @Before
    public void init() {
        Source source = Source.getInstance(SourceType.DUMMY, INPUT);
        TextService textService = new TextServiceImpl(source, source);
        text = textService.load();
    }

    @Test
    public void testContent() {
        assertEquals(text.getContent(), EXPECTED_CONTENT);
    }

    @Test
    public void testChildCount() {
        assertEquals(text.getText().childCount(), EXPECTED_CHILD_COUNT);
    }
}
