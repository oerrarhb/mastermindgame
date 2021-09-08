package com.teemo.mastermind;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.Scanner;

public class SecretWordChecker {

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

    public static void main(String[] argv) {
        var args = new Args();
        JCommander.newBuilder()
                .addObject(args)
                .build()
                .parse(argv);

        var scanner = new Scanner(System.in);
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Try guess secret word ?");
            var userEntry = scanner.nextLine();
            var resultOfCheck = checkSimilarity(userEntry, args.secretCode);
            System.out.println(resultOfCheck);
            if (resultOfCheck.equals("++++")) {
                System.out.println("You Won ! ");
                scanner.close();
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Args {
        @Parameter(names = "--secret-word")
        String secretCode = "1234";
    }
}
