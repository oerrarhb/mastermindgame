package com.teemo.mastermind;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SecretWordCheckerTest {
    @Test
    public void checkSecretWordTest() {
        // Secret Code 4040
        assertEquals("+++", SecretWordChecker.check("4041", "4040"));
        assertEquals("+-", SecretWordChecker.check("1441", "4040"));
        assertEquals("++", SecretWordChecker.check("4444", "4040"));
        assertEquals("+--", SecretWordChecker.check("1004", "4040"));
        assertEquals("+++", SecretWordChecker.check("5040", "4040"));
        assertEquals("+++", SecretWordChecker.check("4070", "4040"));
        assertEquals("++--", SecretWordChecker.check("4400", "4040"));
        assertEquals("+++", SecretWordChecker.check("4440", "4040"));


        // Secret Code 1225
        assertEquals("++", SecretWordChecker.check("1234", "1225"));
        assertEquals("+", SecretWordChecker.check("7775", "1225"));
        assertEquals("++", SecretWordChecker.check("2222", "1225"));
        assertEquals("+--", SecretWordChecker.check("5211", "1225"));
        assertEquals("++-", SecretWordChecker.check("2221", "1225"));
        assertEquals("+-", SecretWordChecker.check("8022", "1225"));
        assertEquals("+--", SecretWordChecker.check("6212", "1225"));

        // Secret Code 1234
        assertEquals("++++", SecretWordChecker.check("1234", "1234"));
        assertEquals("----", SecretWordChecker.check("4321", "1234"));
        assertEquals("---", SecretWordChecker.check("7123", "1234"));
        assertEquals("--", SecretWordChecker.check("5743", "1234"));
        assertEquals("----", SecretWordChecker.check("4321", "1234"));
        assertEquals("----", SecretWordChecker.check("3412", "1234"));
        assertEquals("", SecretWordChecker.check("7070", "1234"));
        assertEquals("-", SecretWordChecker.check("5051", "1234"));
        assertEquals("++--", SecretWordChecker.check("1432", "1234"));
        assertEquals("+---", SecretWordChecker.check("3241", "1234"));
        assertEquals("++--", SecretWordChecker.check("3214", "1234"));

        // Secret Code 7777
        assertEquals("+++", SecretWordChecker.check("7717", "7777"));
        assertEquals("++", SecretWordChecker.check("7897", "7777"));
        assertEquals("++", SecretWordChecker.check("7070", "7777"));
        assertEquals("+", SecretWordChecker.check("7111", "7777"));
        assertEquals("++", SecretWordChecker.check("1771", "7777"));
        assertEquals("+++", SecretWordChecker.check("1777", "7777"));
        assertEquals("+++", SecretWordChecker.check("7771", "7777"));
        assertEquals("+++", SecretWordChecker.check("7717", "7777"));
        assertEquals("+++", SecretWordChecker.check("7177", "7777"));
    }
}
