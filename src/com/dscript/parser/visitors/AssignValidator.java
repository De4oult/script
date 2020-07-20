package com.dscript.parser.visitors;

import com.dscript.main.lib.Variables;
import com.dscript.parser.ast.AssignmentStatement;

public final class AssignValidator extends AbstractValidator {

	@Override
	public void visit(AssignmentStatement s) {
		super.visit(s);
		if(Variables.isExists(s.variable)) {
			throw new RuntimeException("Error: cannot assign value to constant!");
		}
	}
}
