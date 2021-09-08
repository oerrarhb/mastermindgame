package com.teemo.mastermind;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SecretWordCheckerTest {
    @Test
    public void checkSecretWordTest() {
        // Secret Code 4040
        assertEquals("+++", SecretWordChecker.checkSimilarity("4041", "4040"));
        assertEquals("+-", SecretWordChecker.checkSimilarity("1441", "4040"));
        assertEquals("++", SecretWordChecker.checkSimilarity("4444", "4040"));
        assertEquals("+--", SecretWordChecker.checkSimilarity("1004", "4040"));
        assertEquals("+++", SecretWordChecker.checkSimilarity("5040", "4040"));
        assertEquals("+++", SecretWordChecker.checkSimilarity("4070", "4040"));
        assertEquals("++--", SecretWordChecker.checkSimilarity("4400", "4040"));
        assertEquals("+++", SecretWordChecker.checkSimilarity("4440", "4040"));


        // Secret Code 1225
        assertEquals("++", SecretWordChecker.checkSimilarity("1234", "1225"));
        assertEquals("+", SecretWordChecker.checkSimilarity("7775", "1225"));
        assertEquals("++", SecretWordChecker.checkSimilarity("2222", "1225"));
        assertEquals("+--", SecretWordChecker.checkSimilarity("5211", "1225"));
        assertEquals("++-", SecretWordChecker.checkSimilarity("2221", "1225"));
        assertEquals("+-", SecretWordChecker.checkSimilarity("8022", "1225"));
        assertEquals("+--", SecretWordChecker.checkSimilarity("6212", "1225"));

        // Secret Code 1234
        assertEquals("++++", SecretWordChecker.checkSimilarity("1234", "1234"));
        assertEquals("----", SecretWordChecker.checkSimilarity("4321", "1234"));
        assertEquals("---", SecretWordChecker.checkSimilarity("7123", "1234"));
        assertEquals("--", SecretWordChecker.checkSimilarity("5743", "1234"));
        assertEquals("----", SecretWordChecker.checkSimilarity("4321", "1234"));
        assertEquals("----", SecretWordChecker.checkSimilarity("3412", "1234"));
        assertEquals("", SecretWordChecker.checkSimilarity("7070", "1234"));
        assertEquals("-", SecretWordChecker.checkSimilarity("5051", "1234"));
        assertEquals("++--", SecretWordChecker.checkSimilarity("1432", "1234"));
        assertEquals("+---", SecretWordChecker.checkSimilarity("3241", "1234"));
        assertEquals("++--", SecretWordChecker.checkSimilarity("3214", "1234"));

        // Secret Code 7777
        assertEquals("+++", SecretWordChecker.checkSimilarity("7717", "7777"));
        assertEquals("++", SecretWordChecker.checkSimilarity("7897", "7777"));
        assertEquals("++", SecretWordChecker.checkSimilarity("7070", "7777"));
        assertEquals("+", SecretWordChecker.checkSimilarity("7111", "7777"));
        assertEquals("++", SecretWordChecker.checkSimilarity("1771", "7777"));
        assertEquals("+++", SecretWordChecker.checkSimilarity("1777", "7777"));
        assertEquals("+++", SecretWordChecker.checkSimilarity("7771", "7777"));
        assertEquals("+++", SecretWordChecker.checkSimilarity("7717", "7777"));
        assertEquals("+++", SecretWordChecker.checkSimilarity("7177", "7777"));
    }
}
