package com.dscript.parser;

public enum TokenType {
	
	NUMBER,
	HEX_NUMBER,
	WORD,
	TEXT,
	
	OUT,
	OUTLINE,
	IF,
	ELSE,
	WHILE,
	FOR,
	DO,
	BREAK,
	CONTINUE,
	FUNC,
	RETURN,
	USES,
	IN,
	
	PLUS, // +
	PLUSPLUS, // ++
	MINUSMINUS, // --
	MINUS, // -
	STAR, // *
	SLASH, // /
	PERCENT, // %
	EQ, // =
	EQEQ, // ==
	EXCL, // !
	EXCLEQ, // !=
	LT, // <
	LTEQ, // <=
	GT, // >
	GTEQ, // >=
	
	BAR, // |
	BARBAR, // ||
	AMP, // &
	AMPAMP, // &&

	LPAREN, // (
	RPAREN, // )
	LBRACE, // {
	RBRACE, // }
	LBRACKET, // [
	RBRACKET, // ]
	COMMA, // ,
	DOTCOMMA, // ;
	
	EOF
}