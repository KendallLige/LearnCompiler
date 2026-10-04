// COMP 360-01 Programming Languages, Fall 2026
// Project 1: LearnCompiler
// Team: Kendall Lige and Taniyah Lockley
// Token.java - The token: its text, its type, and the line it appears on

public class Token {
    private final String lexeme;        // the exact text
    private final TokenType tokenType;  // what kind of token it is
    private final int lineNumber;       // line of the input file it appeared on

    public Token(String lexeme, TokenType tokenType, int lineNumber) {
        this.lexeme = lexeme;
        this.tokenType = tokenType;
        this.lineNumber = lineNumber;
    }

    public String getLexeme() {
        return lexeme;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public String toString() {
        return lexeme + "  " + tokenType + "  (line " + lineNumber + ")";
    }
}