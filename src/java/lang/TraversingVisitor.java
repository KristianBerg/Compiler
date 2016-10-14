package lang;

import lang.ast.*;

/**
 * Traverses each node, passing the data to the children.
 * Returns the data unchanged.
 * Overriding methods may change the data passed and the data returned.
 */
public abstract class TraversingVisitor implements lang.ast.Visitor {

	protected Object visitChildren(ASTNode node, Object data) {
		for (int i = 0; i < node.getNumChild(); ++i) {
			node.getChild(i).accept(this, data);
		}
		return data;
	}
	
	public Object visit(List node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Opt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Program node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Func node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Block node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(IdDecl node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(IdDeclStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(IdDeclAss node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Assign node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(ReturnStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(WhileStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(FuncStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(IfStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(ElseStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Equals node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(NotEquals node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(LessThan node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(LessEqual node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(GreaterThan node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(GreaterEqual node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Add node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Sub node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Mul node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Div node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Mod node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Numeral node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(IdUse node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(FuncUse node, Object data) {
		return visitChildren(node, data);
	}
}
