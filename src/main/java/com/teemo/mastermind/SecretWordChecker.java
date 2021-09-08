package com.teemo.mastermind;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.Scanner;

public class SecretWordChecker {

    public static String check(String str, String secret) {
        if (str.equals(secret)) {
            return "++++";
        } else {
            var res = "";
            var strTemp = new StringBuilder(str);
            var secretTemp = new StringBuilder(secret);
            for (var i = 0; i < str.length(); i++) {
                if (secret.charAt(i) == str.charAt(i)) {
                    res = "+" + res;
                    strTemp.replace(i, i + 1, "/");
                    secretTemp.replace(i, i + 1, "*");
                }
            }
            return res + addMOptOpt(strTemp, secretTemp);
        }
    }

    public static String addMOptOpt(StringBuilder sb1, StringBuilder sb2) {
        var res = "";
        for (var i = 0; i < sb1.length(); i++) {
            char currentChar = sb1.charAt(i);
            if (sb2.toString().contains(String.valueOf(currentChar))) {
                res += "-";
                sb2.deleteCharAt(sb2.indexOf(String.valueOf(currentChar)));
            }
        }
        return res;
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
            var resultOfCheck = check(userEntry, args.secret);
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
        String secret = "1234";
    }
}
