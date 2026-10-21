package com.dreamfallen.skriptium.core.ast;

import java.util.ArrayList;
import java.util.List;

public class ProgramNode extends ASTNode {
    private final List<StatementNode> statements = new ArrayList<>();

    public void addStatement(StatementNode statement) {
        statements.add(statement);
    }

    public List<StatementNode> getStatements() {
        return statements;
    }
}
