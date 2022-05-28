package com.example.taskitmed.service;

public class RandomIdentifier {
    public static String randomIdentifaier(){
        long timeSeed = System.nanoTime(); // to get the current date time value

        double randSeed = Math.random() * 1000; // random number generation

        long midSeed = (long) (timeSeed * randSeed); // mixing up the time and

        String s = midSeed + "";
        String subStr = s.substring(0, 9);

        return subStr;
    }
}
