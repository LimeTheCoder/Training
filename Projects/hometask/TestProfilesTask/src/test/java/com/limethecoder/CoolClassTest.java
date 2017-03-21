package com.limethecoder;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class CoolClassTest {
    private CoolClass coolClass;

    @Before
    public void setUp() {
        coolClass = new CoolClass();
    }

    @Test
    public void testCity() {
        assertEquals("London", coolClass.getCity());
    }

    @Test
    public void testName() {
        assertEquals("Terry", coolClass.getName());
    }

    @Test
    public void testCountry() {
        assertEquals("England", coolClass.getCountry());
    }
}
