package com.dscript.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import com.dscript.parser.*;
import com.dscript.parser.ast.Statement;
import com.dscript.parser.visitors.AssignValidator;
import com.dscript.parser.visitors.FunctionAdder;

public final class Main {
	
	public static void main(String[] args) throws IOException {
		final String input = new String(Files.readAllBytes(Paths.get("index.dst")), "UTF-8");
		final List<Token> tokens = new Lexer(input).tokenize();
		for(Token token : tokens) {
			System.out.println(token);
		}
		
		final Statement programm = new Parser(tokens).parse();
		System.out.println("------------------------------------------------------------------------\n");
		System.out.println(programm.toString());
		System.out.println("------------------------------------------------------------------------\n\n\n");
		programm.accept(new FunctionAdder());
		programm.accept(new AssignValidator());
		programm.execute();
	}
}
