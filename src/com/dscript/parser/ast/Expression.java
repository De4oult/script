package com.dscript.parser.ast;

import com.dscript.main.lib.Value;

public interface Expression extends Node {
	
	Value eval();
	
}
