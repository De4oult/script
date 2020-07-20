package com.dscript.parser.ast;

import com.dscript.main.lib.Value;
import com.dscript.main.lib.Variables;

public final class VariableExpression implements Expression {
	
	public final String name;
	
	public VariableExpression(String name) {
		this.name = name;
	}
	
	@Override
	public Value eval() {
		if(!Variables.isExists(name)) throw new RuntimeException("Error: variable does not exists!");
		return Variables.get(name);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
		
	@Override
	public String toString() {
		return String.format("%s", name);
	}
}
