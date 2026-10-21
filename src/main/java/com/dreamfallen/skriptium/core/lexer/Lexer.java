package com.dreamfallen.skriptium.core.lexer;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    private final String source;
    private int index = 0;
    private int line = 1;
    private int column = 1;

    public Lexer(String source) {
        this.source = source;
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();

        while (!isAtEnd()) {
            char ch = peek();

            if (Character.isWhitespace(ch)) {
                if (ch == '\n') {
                    tokens.add(new Token(TokenType.NEWLINE, "\n", index));
                    index++;
                    line++;
                    column = 1;
                    continue;
                }

                index++;
                column++;
                continue;
            }

            if (Character.isLetter(ch) || ch == '_') {
                tokens.add(readIdentifier());
                continue;
            }

            if (Character.isDigit(ch)) {
                tokens.add(readNumber());
                continue;
            }

            if (ch == '"' || ch == '\'') {
                tokens.add(readString());
                continue;
            }

            tokens.add(new Token(TokenType.SYMBOL, String.valueOf(ch), index));
            index++;
            column++;
        }

        tokens.add(new Token(TokenType.EOF, "", index));
        return tokens;
    }

    private Token readIdentifier() {
        int start = index;
        while (!isAtEnd() && (Character.isLetterOrDigit(peek()) || peek() == '_')) {
            index++;
            column++;
        }

        String text = source.substring(start, index);
        return new Token(TokenType.IDENTIFIER, text, start);
    }

    private Token readNumber() {
        int start = index;
        while (!isAtEnd() && Character.isDigit(peek())) {
            index++;
            column++;
        }

        return new Token(TokenType.NUMBER, source.substring(start, index), start);
    }

    private Token readString() {
        char quote = peek();
        int start = index;
        index++;
        column++;

        StringBuilder sb = new StringBuilder();

        while (!isAtEnd()) {
            char current = peek();

            if (current == quote) {
                index++;
                column++;
                break;
            }

            if (current == '\\') {
                index++;
                column++;
                if (!isAtEnd()) {
                    sb.append(peek());
                    index++;
                    column++;
                }
                continue;
            }

            sb.append(current);
            index++;
            column++;
        }

        return new Token(TokenType.STRING, sb.toString(), start);
    }

    private boolean isAtEnd() {
        return index >= source.length();
    }

    private char peek() {
        if (isAtEnd()) {
            return '\0';
        }
        return source.charAt(index);
    }
}
