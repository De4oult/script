package com.dscript.parser.ast;

import com.dscript.main.lib.Value;

@SuppressWarnings("serial")
public final class ReturnStatement extends RuntimeException implements Statement {
	
	public final Expression expression;
	public Value result;
	
	public ReturnStatement(Expression expression) {
		this.expression = expression;
	}
	
	public Value getResult() {
		return result;
	}
	
	@Override
	public void execute() {
		result = expression.eval();
		throw this;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
		
	@Override
	public String toString() {
		return "return";
	}
}
