package com.limethecoder;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CoolClassITest {
    private CoolClass coolClass;

    @Before
    public void setUp() {
        coolClass = new CoolClass();
    }

    @Test
    public void testAge() {
        assertEquals(15, coolClass.getAge());
    }

    @Test
    public void testHeight() {
        assertEquals(183, coolClass.getHeight());
    }
}
