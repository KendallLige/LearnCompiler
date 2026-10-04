// COMP 360-01 Programming Languages, Fall 2026
// Project 1: LearnCompiler
// Team: Kendall Lige and Taniyah Lockley
// Lexer.java - lexical analyzer; breaks the sample program into tokens

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private String input;     // the whole program text
    private int position;     // which character we are looking at
    private int lineNumber;   // current line, starts at 1

    public Lexer(String input) {
        this.input = input;
        this.position = 0;
        this.lineNumber = 1;
    }

    // Reads a run of letters starting at position and returns one Token
    private Token readWord() {
        int start = position;   // remember where the word begins

         // keep moving forward while the character is a letter a-z
    while (position < input.length()
            && input.charAt(position) >= 'a'
            && input.charAt(position) <= 'z') {
        position++;
    }

    String word = input.substring(start, position);   // cut out the word

    // "float" is a keyword, any other word is an identifier
    if (TokenUtils.isKeyword(word)) {
        return new Token(word, TokenType.KEYWORD, lineNumber);
    } else {
        return new Token(word, TokenType.IDENTIFIER, lineNumber);
    }
    }
    private Token readSymbol() {
    char c = input.charAt(position);
    position++;   // move past this character

    if (c == '(') {
        return new Token("(", TokenType.LEFT_PAREN, lineNumber);
    } else if (c == ')') {
        return new Token(")", TokenType.RIGHT_PAREN, lineNumber);
    } else if (c == '{') {
        return new Token("{", TokenType.LEFT_BRACE, lineNumber);
    } else if (c == '}') {
        return new Token("}", TokenType.RIGHT_BRACE, lineNumber);
    } else if (c == ';') {
        return new Token(";", TokenType.SEMICOLON, lineNumber);
    } else if (c == '=') {
        return new Token("=", TokenType.ASSIGN, lineNumber);
    } else if (c == '*') {
        return new Token("*", TokenType.MULTIPLY, lineNumber);
    } else if (c == '/') {
        return new Token("/", TokenType.DIVIDE, lineNumber);
    } else {
        // digits, @, uppercase letters, anything not in the grammar
        return new Token(String.valueOf(c), TokenType.UNKNOWN, lineNumber);
    }
}
// Goes through the whole input and returns the list of tokens
public List<Token> tokenize() {
    List<Token> tokens = new ArrayList<>();

    while (position < input.length()) {
        char c = input.charAt(position);

        if (c == '\n') {
            lineNumber++;      // new line, so count it
            position++;
        } else if (c == ' ' || c == '\t' || c == '\r') {
            position++;        // skip spaces and tabs
        } else if (c >= 'a' && c <= 'z') {
            tokens.add(readWord());
        } else {
            tokens.add(readSymbol());
        }
    }

    // add a token at the end so the parser knows the file is finished
    tokens.add(new Token("EOF", TokenType.END_OF_FILE, lineNumber));
    return tokens;
}
}
