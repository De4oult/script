package com.dscript.parser.ast;

import com.dscript.main.lib.NumberValue;
import com.dscript.main.lib.StringValue;
import com.dscript.main.lib.Value;

public final class ValueExpression implements Expression {
	
	public final Value value;
	
	public ValueExpression(double value) {
		this.value = new NumberValue(value);
	}
	
	public ValueExpression(String value) {
		this.value = new StringValue(value);
	}
	
	@Override
	public Value eval() {
		return value;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
		
	@Override
	public String toString() {
		return value.asString();
	}
}
