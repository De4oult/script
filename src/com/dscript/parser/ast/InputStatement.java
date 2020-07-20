package com.dscript.parser.ast;

import java.util.Scanner;
import com.dscript.main.lib.StringValue;
import com.dscript.main.lib.Value;

public class InputStatement implements Expression, Statement {

	@Override
	public void execute() {
		eval();
	}
	
	@Override
	public Value eval() {
		try(Scanner sc = new Scanner(System.in)) {
			return new StringValue(sc.nextLine());
		}
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "in";
	}
}
