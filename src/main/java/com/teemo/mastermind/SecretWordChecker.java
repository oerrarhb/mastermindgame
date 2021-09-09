package com.teemo.mastermind;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SecretWordChecker {

    private static final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static void main(String[] argv) {
        var args = new Args();
        JCommander.newBuilder()
                .addObject(args)
                .build()
                .parse(argv);
        try (var scanner = new Scanner(System.in)) {
            var secretCode = args.secretCode;
            if (secretCode.isEmpty()) {
                throw new IncorrectInputLength("Secret Code must not be empty !");
            }
            if (!pattern.matcher(secretCode).matches()) {
                throw new NumberFormatException("Secret Code must contain only numbers !");
            }
            if (secretCode.length() != 4) {
                throw new IncorrectInputLength("Secret Code Must contain 4 numbers !");
            }
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println("Try guess secret word ?");
                    var userEntry = scanner.nextLine();
                    if (userEntry.isEmpty()) {
                        throw new IncorrectInputLength("Try not Empty Entry !");
                    }
                    if (!pattern.matcher(userEntry).matches()) {
                        throw new NumberFormatException("Input Should Contain Only Numbers !");
                    }
                    if (userEntry.length() != 4) {
                        throw new IncorrectInputLength("Try entry with 4 numbers !");
                    }
                    var resultOfCheck = SecretWordCheckerUtil.checkSimilarity(userEntry, secretCode);
                    System.out.println(resultOfCheck);
                    if (resultOfCheck.equals("++++")) {
                        System.out.println("You Won ! ");
                        scanner.close();
                        Thread.currentThread().interrupt();
                    }
                } catch (IncorrectInputLength | NumberFormatException userEntryError) {
                    userEntryError.printStackTrace();
                }
            }
        } catch (IncorrectInputLength | NumberFormatException userEntryError) {
            userEntryError.printStackTrace();
        }
    }


    static class Args {
        @Parameter(names = "--secret-word")
        String secretCode = "1234";
    }
}
