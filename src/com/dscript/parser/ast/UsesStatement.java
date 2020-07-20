package com.dscript.parser.ast;

import com.dscript.module.Module;

public final class UsesStatement implements Statement {

	private static final String PACKAGE = "com.dscript.module.";
	
	public final Expression expression;
	
	public UsesStatement(Expression expression) {
		this.expression = expression;
	}
	
	@Override
	public void execute() {
		try {
			final String moduleName = expression.eval().asString();
			final Module module = (Module) Class.forName(PACKAGE + moduleName).getDeclaredConstructor().newInstance();
			module.init();
		} 
		catch(Exception ex) {
			
		}
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "uses " + expression;
	}
}
