package com.example.a2_mipd; // Replace with your actual package name

public class Counter {
    public static int getWordCount(String text) {
        // Implement word counting logic here
        String[] words = text.split("\\s+"); // Split by whitespace
        return words.length;
    }

    public static int getCharacterCount(String text) {
        // Implement character counting logic here
        return text.length();
    }
}
