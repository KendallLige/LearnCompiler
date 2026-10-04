// COMP 360-01 Programming Languages, Fall 2026
// Project 1: LearnCompiler
// Team: Kendall Lige and Taniyah Lockley
// TokenType.java - All token types

public enum TokenType {
    KEYWORD,        // float
    IDENTIFIER,     // letters a-z only
    LEFT_PAREN,     // (
    RIGHT_PAREN,    // )
    LEFT_BRACE,     // {
    RIGHT_BRACE,    // }
    SEMICOLON,      // ;
    ASSIGN,         // =
    MULTIPLY,       // *
    DIVIDE,         // /
    END_OF_FILE,    // marks the end of the token list
    UNKNOWN         // anything the grammar does not allow (digits, @, etc.)
}