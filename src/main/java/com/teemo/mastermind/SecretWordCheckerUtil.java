package com.teemo.mastermind;

import java.util.Random;

public class SecretWordCheckerUtil {


    //Method to check the similarity of userEntry and secret code
    public static String checkSimilarity(String userEntry, String secretCode) {
        // If User Entry matches the secret code, we skip the processing
        if (userEntry.equals(secretCode)) {
            return "++++";
        } else {
            // Here we use StringBuilder to benefit from its useful tools
            StringBuilder outPut = new StringBuilder();
            var userEntryTemp = new StringBuilder(userEntry);
            var secretCodeTemp = new StringBuilder(secretCode);
            for (var i = 0; i < userEntry.length(); i++) {
                if (secretCode.charAt(i) == userEntry.charAt(i)) {
                    // If we have an exact match, we insert '+' to the output
                    outPut.insert(0, "+");
                    // We replace this by another symbol so it won't be seen again.
                    // we don't pop out the characters to keep track of the indexes.
                    // we use different symbols to avoid errors
                    userEntryTemp.replace(i, i + 1, "$");
                    secretCodeTemp.replace(i, i + 1, "#");
                }
            }
            return outPut + checkPartialSimilarity(userEntryTemp, secretCodeTemp);
        }
    }

    // This Method checks the partial similarities
    public static String checkPartialSimilarity(StringBuilder userEntryStringBuilder, StringBuilder secretCodeStringBuilder) {
        StringBuilder outPut = new StringBuilder();
        for (var i = 0; i < userEntryStringBuilder.length(); i++) {
            var currentChar = userEntryStringBuilder.charAt(i);
            // We skip processing already matching characters
            if (currentChar == '$') continue;
            // We check if the secret code after retrieving elements exactly matching still contains some characters of user entry but not in the right index.
            if (secretCodeStringBuilder.toString().contains(String.valueOf(currentChar))) {
                // If so, we append '-' to our output
                outPut.append("-");
                // The index is not important, we are allowed to pop out characters to avoid having duplicate matching.
                secretCodeStringBuilder.deleteCharAt(secretCodeStringBuilder.indexOf(String.valueOf(currentChar)));
            }
        }
        return outPut.toString();
    }

    // This method is used to generate random secret code
    public static String randomSecretWordGenerator() {
        var leftLimit = 48; // 0 (From ASCII TABLE)
        var rightLimit = 57; // 9 (From ASCII TABLE)
        var secretCodeLength = 4; // Secret Code must contain only 4 numbers
        var random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(secretCodeLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
}
