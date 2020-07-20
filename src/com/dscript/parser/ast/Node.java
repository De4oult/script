package com.dscript.parser.ast;

public interface Node {

	void accept(Visitor visitor);
}
