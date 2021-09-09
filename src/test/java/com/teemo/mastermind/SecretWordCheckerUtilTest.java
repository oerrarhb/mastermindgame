package com.teemo.mastermind;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SecretWordCheckerUtilTest {

    private static final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    @Test
    public void checkSecretWordTest() {
        // Secret Code 4040
        assertEquals("+++", SecretWordCheckerUtil.checkSimilarity("4041", "4040"));
        assertEquals("+-", SecretWordCheckerUtil.checkSimilarity("1441", "4040"));
        assertEquals("++", SecretWordCheckerUtil.checkSimilarity("4444", "4040"));
        assertEquals("+--", SecretWordCheckerUtil.checkSimilarity("1004", "4040"));
        assertEquals("+++", SecretWordCheckerUtil.checkSimilarity("5040", "4040"));
        assertEquals("+++", SecretWordCheckerUtil.checkSimilarity("4070", "4040"));
        assertEquals("++--", SecretWordCheckerUtil.checkSimilarity("4400", "4040"));
        assertEquals("+++", SecretWordCheckerUtil.checkSimilarity("4440", "4040"));


        // Secret Code 1225
        assertEquals("++", SecretWordCheckerUtil.checkSimilarity("1234", "1225"));
        assertEquals("+", SecretWordCheckerUtil.checkSimilarity("7775", "1225"));
        assertEquals("++", SecretWordCheckerUtil.checkSimilarity("2222", "1225"));
        assertEquals("+--", SecretWordCheckerUtil.checkSimilarity("5211", "1225"));
        assertEquals("++-", SecretWordCheckerUtil.checkSimilarity("2221", "1225"));
        assertEquals("+-", SecretWordCheckerUtil.checkSimilarity("8022", "1225"));
        assertEquals("+--", SecretWordCheckerUtil.checkSimilarity("6212", "1225"));

        // Secret Code 1234
        assertEquals("++++", SecretWordCheckerUtil.checkSimilarity("1234", "1234"));
        assertEquals("----", SecretWordCheckerUtil.checkSimilarity("4321", "1234"));
        assertEquals("---", SecretWordCheckerUtil.checkSimilarity("7123", "1234"));
        assertEquals("--", SecretWordCheckerUtil.checkSimilarity("5743", "1234"));
        assertEquals("----", SecretWordCheckerUtil.checkSimilarity("4321", "1234"));
        assertEquals("----", SecretWordCheckerUtil.checkSimilarity("3412", "1234"));
        assertEquals("", SecretWordCheckerUtil.checkSimilarity("7070", "1234"));
        assertEquals("-", SecretWordCheckerUtil.checkSimilarity("5051", "1234"));
        assertEquals("++--", SecretWordCheckerUtil.checkSimilarity("1432", "1234"));
        assertEquals("+---", SecretWordCheckerUtil.checkSimilarity("3241", "1234"));
        assertEquals("++--", SecretWordCheckerUtil.checkSimilarity("3214", "1234"));

        // Secret Code 7777
        assertEquals("+++", SecretWordCheckerUtil.checkSimilarity("7717", "7777"));
        assertEquals("++", SecretWordCheckerUtil.checkSimilarity("7897", "7777"));
        assertEquals("++", SecretWordCheckerUtil.checkSimilarity("7070", "7777"));
        assertEquals("+", SecretWordCheckerUtil.checkSimilarity("7111", "7777"));
        assertEquals("++", SecretWordCheckerUtil.checkSimilarity("1771", "7777"));
        assertEquals("+++", SecretWordCheckerUtil.checkSimilarity("1777", "7777"));
        assertEquals("+++", SecretWordCheckerUtil.checkSimilarity("7771", "7777"));
        assertEquals("+++", SecretWordCheckerUtil.checkSimilarity("7717", "7777"));
        assertEquals("+++", SecretWordCheckerUtil.checkSimilarity("7177", "7777"));

        // Secret Code 4422
        assertEquals("----", SecretWordCheckerUtil.checkSimilarity("2244", "4422"));
        assertEquals("++--", SecretWordCheckerUtil.checkSimilarity("4242", "4422"));
        assertEquals("++--", SecretWordCheckerUtil.checkSimilarity("2442", "4422"));
    }

    @Test
    public void randomSecretWordGeneratorTest() {
        // Test the length of secret code
        assertEquals(4, SecretWordCheckerUtil.randomSecretWordGenerator().length());
        // Test that generated secret code is always numaric
        assertTrue(pattern.matcher(SecretWordCheckerUtil.randomSecretWordGenerator()).matches());
        assertTrue(pattern.matcher(SecretWordCheckerUtil.randomSecretWordGenerator()).matches());
        assertTrue(pattern.matcher(SecretWordCheckerUtil.randomSecretWordGenerator()).matches());
    }
}
