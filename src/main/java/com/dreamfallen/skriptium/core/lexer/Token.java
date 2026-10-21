package com.dreamfallen.skriptium.core.lexer;

public record Token(TokenType type, String lexeme, int position) {
    @Override
    public String toString() {
        return type + ":" + lexeme;
    }
}
