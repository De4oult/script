package com.dscript.parser.ast;

import java.util.ArrayList;
import java.util.List;

import com.dscript.main.lib.Function;
import com.dscript.main.lib.Functions;
import com.dscript.main.lib.UserDefineFunction;
import com.dscript.main.lib.Value;
import com.dscript.main.lib.Variables;

public final class FunctionalExpression implements Expression {
	
	public final String name;
	public List<Expression> arguments;
	
	public FunctionalExpression(String name) {
		this.name = name;
		arguments = new ArrayList<>();
	}
	
	public FunctionalExpression(String name, List<Expression> arguments) {
		this.name = name;
		this.arguments = arguments;
	}
	
	public void addArgument(Expression arg) {
		arguments.add(arg);
	}
	
	@Override
	public Value eval() {
		final int size = arguments.size();
		final Value[] values = new Value[size];
		for (int i = 0; i < size; i++) {
			values[i] = arguments.get(i).eval();
		}
		
		final Function function = Functions.get(name);
		if (function instanceof UserDefineFunction) {
			UserDefineFunction userFunction = (UserDefineFunction) function;
			if(size != userFunction.getArgsCount()) throw new RuntimeException("Error: args count mismatch!");
			
			Variables.push();
			for(int i = 0; i < size; i++) {
				Variables.set(userFunction.getArgsName(i), values[i]);
			}
			final Value result = userFunction.execute(values);
			Variables.pop();
			return result;
		}
		return function.execute(values);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return name + "(" + arguments.toString() + ")";
	}
}
