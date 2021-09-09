package com.teemo.mastermind;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SecretWordChecker {

    // This regex is used to check if entry user contains only numbers
    private static final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static void main(String... argv) {

        // Jcommander is used here if the user wants to play the easy mode
        var args = new Args();
        JCommander.newBuilder()
                .addObject(args)
                .build()
                .parse(argv);

        // We use try with resources so Scanner will be closed at the end
        try (var scanner = new Scanner(System.in)) {
            // Wet set the hard mode if no secret code is generated by the user
            if (Objects.equals(args.secretCode, null) || args.secretCode.isEmpty()) {
                args.secretCode = SecretWordCheckerUtil.randomSecretWordGenerator();
            }
            var secretCode = args.secretCode;
            // Errors handling for secret code in the easy mode: numeric and length
            if (!pattern.matcher(secretCode).matches()) {
                throw new NumberFormatException("Secret Code must contain only numbers !");
            }
            if (secretCode.length() != 4) {
                throw new IncorrectInputLength("Secret Code Must contain 4 numbers !");
            }
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println("Try guess secret word ?");
                    // We store user entry in this variable for processing
                    var userEntry = scanner.nextLine();
                    // Errors handling for user entry: numeric and length
                    if (userEntry.isEmpty()) {
                        throw new IncorrectInputLength("Try not Empty Entry !");
                    }
                    if (!pattern.matcher(userEntry).matches()) {
                        throw new NumberFormatException("Input Should Contain Only Numbers !");
                    }
                    if (userEntry.length() != 4) {
                        throw new IncorrectInputLength("Try entry with 4 numbers !");
                    }
                    // Checking similarity
                    var resultOfCheck = SecretWordCheckerUtil.checkSimilarity(userEntry, secretCode);
                    // Outputing the result of similarity to the user
                    System.out.println(resultOfCheck);
                    // Game is over if the user won
                    if (resultOfCheck.equals("++++")) {
                        System.out.println("You Won ! ");
                        scanner.close();
                        System.exit(0);
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
        String secretCode;
    }
}
