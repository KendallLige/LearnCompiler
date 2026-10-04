// COMP 360-01 Programming Languages, Fall 2026
// Project 1: LearnCompiler
// Team: Kendall Lige and Taniyah Lockley
// TokenUtils.java - helper method that checks if a word is the keyword "float"

public final class TokenUtils {
    // This class only holds a static helper method, so nobody should create one.
    private TokenUtils() {}

    // True only for the word "float".
    public static boolean isKeyword(String word) {
        return word.equals("float");
    }
}