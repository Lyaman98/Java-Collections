package com.example.junit;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {

    Utilities utilities;

    @Before
    public void init(){
        utilities = new Utilities();
    }
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class");
    }

    @org.junit.Test
    public void removePairs() {
        assertEquals("ABCDEF",utilities.removePairs("AABBCCDDEEF"));
    }

    @Test
    public void isEven(){
        assertTrue(utilities.isEven(12));
        assertNull(null,null);
        assertSame(12,12);
    }
}
