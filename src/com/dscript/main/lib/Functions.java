package com.dscript.main.lib;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class Functions {
	
	private static final Map<String, Function> functions;
	
	static {
		functions =  new HashMap<>();
		/* functions.put("sin", new Function() {
			@Override
			public Value execute(Value... args) {
				if(args.length != 1) throw new RuntimeException("Error: one args expected!");
				return new NumberValue(Math.sin(args[0].asNumber()));
			}
		});
		
		functions.put("cos", new Function() {
			@Override
			public Value execute(Value... args) {
				if(args.length != 1) throw new RuntimeException("Error: one args expected!");
				return new NumberValue(Math.cos(args[0].asNumber()));
			}
		}); */
		functions.put("write", args -> {
			for(Value arg : args) {
				System.out.println(arg.asString());
			}
			return NumberValue.ZERO;
		});
		
		functions.put("read", (Function) (Value[] args) -> {
			try(Scanner sc = new Scanner(System.in)) {
				return new StringValue(sc.nextLine());
			}
			
		});
	}
	
	public static boolean isExists(String key) {
		return functions.containsKey(key);
	}
	
	public static Function get(String key) {
		if(!isExists(key)) throw new RuntimeException("Error: unknown function " + key + "!");
		return functions.get(key);
	}

	public static void set(String key, Function function) {
		functions.put(key, function);
	}

}
