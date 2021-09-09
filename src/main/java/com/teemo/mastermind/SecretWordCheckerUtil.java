package com.teemo.mastermind;

public class SecretWordCheckerUtil {
    public static String checkSimilarity(String userEntry, String secretCode) {
        if (userEntry.equals(secretCode)) {
            return "++++";
        } else {
            var outPut = "";
            var userEntryTemp = new StringBuilder(userEntry);
            var secretCodeTemp = new StringBuilder(secretCode);
            for (var i = 0; i < userEntry.length(); i++) {
                if (secretCode.charAt(i) == userEntry.charAt(i)) {
                    outPut = "+" + outPut;
                    userEntryTemp.replace(i, i + 1, "/");
                    secretCodeTemp.replace(i, i + 1, "*");
                }
            }
            return outPut + checkPartialSimilarity(userEntryTemp, secretCodeTemp);
        }
    }

    public static String checkPartialSimilarity(StringBuilder userEntryStringBuilder, StringBuilder secretCodeStringBuilder) {
        var outPut = "";
        for (var i = 0; i < userEntryStringBuilder.length(); i++) {
            char currentChar = userEntryStringBuilder.charAt(i);
            if (secretCodeStringBuilder.toString().contains(String.valueOf(currentChar))) {
                outPut += "-";
                secretCodeStringBuilder.deleteCharAt(secretCodeStringBuilder.indexOf(String.valueOf(currentChar)));
            }
        }
        return outPut;
    }
}
