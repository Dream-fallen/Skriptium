package com.dreamfallen.skriptium.core.parser;

import com.dreamfallen.skriptium.core.ast.ProgramNode;
import com.dreamfallen.skriptium.core.lexer.Lexer;
import com.dreamfallen.skriptium.core.lexer.Token;

import java.util.List;

public class Parser {

    private final List<Token> tokens;
    private int index = 0;

    public Parser(String source) {
        this.tokens = new Lexer(source).tokenize();
    }

    public ProgramNode parse() {
        ProgramNode program = new ProgramNode();

        while (!isAtEnd()) {
            Token token = peek();
            if (token.type() == com.dreamfallen.skriptium.core.lexer.TokenType.EOF) {
                break;
            }

            // TODO: parse actual grammar
            advance();
        }

        return program;
    }

    private boolean isAtEnd() {
        return peek().type() == com.dreamfallen.skriptium.core.lexer.TokenType.EOF;
    }

    private Token peek() {
        return tokens.get(index);
    }

    private Token advance() {
        return tokens.get(index++);
    }
}
