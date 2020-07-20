package com.dscript.parser.visitors;

import com.dscript.parser.ast.*;

public final class FunctionAdder extends AbstractValidator {

	@Override
	public void visit(FunctionDefineStatement s) {
		super.visit(s);
		s.execute();
	}
}