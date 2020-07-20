package com.dscript.parser.ast;

public final class OutlineStatement implements Statement {
	
	public final Expression expression;
	
	public OutlineStatement(Expression expression) {
		this.expression = expression;
	}
	
	@Override
	public void execute() {
		System.out.println(expression.eval().asString());
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "outline " + expression;
	}
	
}
