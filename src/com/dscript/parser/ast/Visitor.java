package com.dscript.parser.ast;

public interface Visitor {
	
	void visit(ArrayAccessExpression s);
	void visit(ArrayAssignmentStatement s);
	void visit(ArrayExpression s);
	void visit(AssignmentStatement s);
	void visit(BinaryExpression s);
	void visit(BlockStatement s);
	void visit(BreakStatement s);
	void visit(ConditionalExpression s);
	void visit(ContinueStatement s);
	void visit(DoWhileStatement s);
	void visit(ForStatement s);
	void visit(FunctionalExpression s);
	void visit(FunctionDefineStatement s);
	void visit(FunctionStatement s);
	void visit(IfStatement s);
	void visit(InputStatement s);
	void visit(OutlineStatement s);
	void visit(OutStatement s);
	void visit(ReturnStatement s);
	void visit(UnaryExpression s);
	void visit(UsesStatement s);
	void visit(ValueExpression s);
	void visit(VariableExpression s);
	void visit(WhileStatement s);
}
