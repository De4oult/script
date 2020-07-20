package com.dscript.parser.ast;

import java.util.List;

import com.dscript.main.lib.Functions;
import com.dscript.main.lib.UserDefineFunction;

public final class FunctionDefineStatement implements Statement {
	
	public final String name;
	public final List<String> argNames;
	public final Statement body;
	
	public FunctionDefineStatement(String name, List<String> argNames, Statement body) {
		this.name = name;
		this.argNames = argNames;
		this.body = body;
	}
	
	@Override
	public void execute() {
		Functions.set(name, new UserDefineFunction(argNames, body));
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "func (" + argNames.toString() + ") " + body.toString();
	}
}
