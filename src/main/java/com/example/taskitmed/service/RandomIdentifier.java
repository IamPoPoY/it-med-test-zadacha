package com.example.taskitmed.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomIdentifier {
    public static String randomIdentifaier(){
        long timeSeed = System.nanoTime(); // to get the current date time value

        double randSeed = Math.random() * 1000; // random number generation

        long midSeed = (long) (timeSeed * randSeed); // mixing up the time and

        String s = midSeed + "";
        String subStr = s.substring(0, 9);
        if (IsNineNumber(subStr)){
            return subStr;
        }
        return randomIdentifaier();
    }
    private static boolean IsNineNumber(String numbers) {
        String pattern="^\\d{9}$";
        try {
            Pattern pattern1 = Pattern.compile(pattern);
            Matcher matcher = pattern1.matcher(numbers);
            return matcher.matches();
        } catch (RuntimeException e) {
            return false;
        }
    }
}
