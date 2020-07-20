package com.dscript.parser.ast;

public final class OutStatement implements Statement {
	
	public final Expression expression;
	
	public OutStatement(Expression expression) {
		this.expression = expression;
	}
	
	@Override
	public void execute() {
		System.out.print(expression.eval().asString());
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "out " + expression;
	}
	
}
