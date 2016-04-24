package com.kubadziworski.domain.expression;

import com.kubadziworski.bytecodegenerator.StatementGenerator;
import com.kubadziworski.domain.scope.Scope;
import com.kubadziworski.domain.statement.Statement;
import com.kubadziworski.domain.type.BultInType;
import com.kubadziworski.domain.type.Type;
import com.kubadziworski.exception.UnsupportedRangedLoopTypes;

/**
 * Created by kuba on 23.04.16.
 */
public class RangedForStatement implements Statement {
    private final Statement iteratorVariable;
    private final Expression startExpression;
    private final Expression endExpression;
    private final Statement statement;
    private final String iteratorVarName;
    private Scope scope;

    public RangedForStatement(Statement iteratorVariable, Expression startExpression, Expression endExpression, Statement statement, String iteratorVarName, Scope scope) {
        this.scope = scope;
        if(startExpression.getType() != BultInType.INT || endExpression.getType() != BultInType.INT) {
            throw new UnsupportedRangedLoopTypes(startExpression,endExpression);
        }
        this.iteratorVariable = iteratorVariable;
        this.startExpression = startExpression;
        this.endExpression = endExpression;
        this.statement = statement;
        this.iteratorVarName = iteratorVarName;
    }

    public Statement getIteratorVariableStatement() {
        return iteratorVariable;
    }

    public Expression getStartExpression() {
        return startExpression;
    }

    public Expression getEndExpression() {
        return endExpression;
    }

    public Statement getStatement() {
        return statement;
    }

    public String getIteratorVarName() {
        return iteratorVarName;
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }

    public Scope getScope() {
        return scope;
    }

    public Type getType() {
        return startExpression.getType();
    }
}
