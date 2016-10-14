package lang;

import lang.ast.*;

/**
 * Checks depth of statements in a SimpliC program.
 */
public class depthCheckVisitor extends TraversingVisitor {
	// client method
	public static int result(ASTNode n) {
		depthCheckVisitor v = new depthCheckVisitor();
		n.accept(v, null);
		return v.deepest;
	}

	// state variables
	private int depth = 0;
	private int deepest = 0;
	
	public Object visit(Func node, Object data) {
		depth++;
		if(depth > deepest){
			deepest = depth;
		}
		Object d = visitChildren(node, data);
		depth--;
		return d;
	}
		

	public Object visit(WhileStmt node, Object data) {
		depth++;
		if(depth > deepest){
			deepest = depth;
		}
		Object d = visitChildren(node, data);
		depth--;
		return d;
	}

	public Object visit(IfStmt node, Object data) {
		depth++;
		if(depth > deepest){
			deepest = depth;
		}
		Object d = visitChildren(node, data);
		depth--;
		return d;	
	}
}
