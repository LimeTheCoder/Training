package com.limethecoder.source;

import com.limethecoder.model.source.DummySource;
import com.limethecoder.model.source.Source;
import com.limethecoder.model.source.SourceException;
import com.limethecoder.model.source.SourceType;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class SourceTest {
    private static final String TEST_DATA = "Yo!";
    private Source source;

    @Before
    public void init() {
        source = Source.getInstance(SourceType.DUMMY, TEST_DATA);
    }

    @Test
    public void testReadNextChar() throws SourceException {
        assertEquals(source.hasNext(), true);
        for(int i = 0; i < TEST_DATA.length(); i++) {
            assertEquals(source.readNextCharacter(), TEST_DATA.charAt(i));
        }
        assertEquals(source.hasNext(), false);
    }

    @Test(expected = SourceException.class)
    public void testSourceException() throws SourceException {
        source = new DummySource("");
        source.readNextCharacter();
    }
}
