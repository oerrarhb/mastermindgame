package com.teemo.mastermind;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SecretWordCheckerTest {
    @Test
    public void testCutList() {
        assertEquals("", SecretWordChecker.check("1234", "5555"));

    }


}
