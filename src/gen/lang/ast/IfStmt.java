/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.2 */
package lang.ast;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.HashMap;
/**
 * @ast node
 * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/lang.ast:16
 * @production IfStmt : {@link Stmt} ::= <span class="component">{@link Expr}</span> <span class="component">{@link Block}</span> <span class="component">[{@link ElseStmt}]</span>;

 */
public class IfStmt extends Stmt implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:151
   */
  public void genCode(PrintStream out) {
		getExpr().genCode(out);
		String ifEndLabel = "If_" + Program.nextLabelIndex() + "_end";
		String elseLabel = "Else_" + Program.nextLabelIndex() + "_end";
		out.println("//if");
		out.println("        cmpq $1, %rax");
		out.println("        jne " + ifEndLabel );
		getBlock().genCode(out);
		if(hasElseStmt()){
			out.println("        jmp " + elseLabel);
			out.println(ifEndLabel + ":");
			getElseStmt().genCode(out);
			out.println(elseLabel + ":");
		} else {
			out.println(ifEndLabel + ":");
		}
	}
  /**
   * @aspect Interpreter
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:78
   */
  public void eval(ActivationRecord actrec){
		if(getExpr().eval(actrec) == 1){
			getBlock().eval(actrec);
		} else if(hasElseStmt()){
			getElseStmt().eval(actrec);
		}
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/PrettyPrint.jrag:87
   */
  public void prettyPrint(PrintStream out, String ind) {
		out.print("if (");
		getExpr().prettyPrint(out, ind);
		out.print(") ");
		getBlock().prettyPrint(out, ind);
		if(hasElseStmt()){
			out.print(ind);
			getElseStmt().prettyPrint(out, ind);
		}
	}
  /**
   * @aspect Visitor
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Visitor.jrag:76
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public IfStmt() {
    super();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:10
   */
  public void init$Children() {
    children = new ASTNode[3];
    setChild(new Opt(), 2);
  }
  /**
   * @declaredat ASTNode:14
   */
  public IfStmt(Expr p0, Block p1, Opt<ElseStmt> p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:20
   */
  protected int numChildren() {
    return 3;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:24
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:28
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:32
   */
  public IfStmt clone() throws CloneNotSupportedException {
    IfStmt node = (IfStmt) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public IfStmt copy() {
    try {
      IfStmt node = (IfStmt) clone();
      node.parent = null;
      if (children != null) {
        node.children = (ASTNode[]) children.clone();
      }
      return node;
    } catch (CloneNotSupportedException e) {
      throw new Error("Error: clone not supported for " + getClass().getName());
    }
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:56
   */
  @Deprecated
  public IfStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:66
   */
  public IfStmt treeCopyNoTransform() {
    IfStmt tree = (IfStmt) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) children[i];
        if (child != null) {
          child = child.treeCopyNoTransform();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:86
   */
  public IfStmt treeCopy() {
    IfStmt tree = (IfStmt) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) getChild(i);
        if (child != null) {
          child = child.treeCopy();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:100
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Expr child.
   * @param node The new node to replace the Expr child.
   * @apilevel high-level
   */
  public void setExpr(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Expr child.
   * @return The current node used as the Expr child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Expr")
  public Expr getExpr() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the Expr child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Expr child.
   * @apilevel low-level
   */
  public Expr getExprNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * Replaces the Block child.
   * @param node The new node to replace the Block child.
   * @apilevel high-level
   */
  public void setBlock(Block node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Block child.
   * @return The current node used as the Block child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Block")
  public Block getBlock() {
    return (Block) getChild(1);
  }
  /**
   * Retrieves the Block child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Block child.
   * @apilevel low-level
   */
  public Block getBlockNoTransform() {
    return (Block) getChildNoTransform(1);
  }
  /**
   * Replaces the optional node for the ElseStmt child. This is the <code>Opt</code>
   * node containing the child ElseStmt, not the actual child!
   * @param opt The new node to be used as the optional node for the ElseStmt child.
   * @apilevel low-level
   */
  public void setElseStmtOpt(Opt<ElseStmt> opt) {
    setChild(opt, 2);
  }
  /**
   * Replaces the (optional) ElseStmt child.
   * @param node The new node to be used as the ElseStmt child.
   * @apilevel high-level
   */
  public void setElseStmt(ElseStmt node) {
    getElseStmtOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional ElseStmt child exists.
   * @return {@code true} if the optional ElseStmt child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasElseStmt() {
    return getElseStmtOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) ElseStmt child.
   * @return The ElseStmt child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public ElseStmt getElseStmt() {
    return (ElseStmt) getElseStmtOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the ElseStmt child. This is the <code>Opt</code> node containing the child ElseStmt, not the actual child!
   * @return The optional node for child the ElseStmt child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="ElseStmt")
  public Opt<ElseStmt> getElseStmtOpt() {
    return (Opt<ElseStmt>) getChild(2);
  }
  /**
   * Retrieves the optional node for child ElseStmt. This is the <code>Opt</code> node containing the child ElseStmt, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child ElseStmt.
   * @apilevel low-level
   */
  public Opt<ElseStmt> getElseStmtOptNoTransform() {
    return (Opt<ElseStmt>) getChildNoTransform(2);
  }
/** @apilevel internal */
protected boolean uniqueName_visited = false;
  /**
   * @attribute syn
   * @aspect UniqueName
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:142
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UniqueName", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:142")
  public String uniqueName() {
    if (uniqueName_visited) {
      throw new RuntimeException("Circular definition of attribute IfStmt.uniqueName().");
    }
    uniqueName_visited = true;
    String uniqueName_value = indexString() + "if";
    uniqueName_visited = false;
    return uniqueName_value;
  }
  /**
   * @attribute inh
   * @aspect UniqueName
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:146
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="UniqueName", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:146")
  public String indexString() {
    if (indexString_visited) {
      throw new RuntimeException("Circular definition of attribute IfStmt.indexString().");
    }
    indexString_visited = true;
    String indexString_value = getParent().Define_indexString(this, null);
    indexString_visited = false;
    return indexString_value;
  }
/** @apilevel internal */
protected boolean indexString_visited = false;
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:36
   * @apilevel internal
   */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getExprNoTransform()) {
      // @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:39
      return boolType();
    }
    else {
      return getParent().Define_expectedType(this, _callerNode);
    }
  }
  protected boolean canDefine_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
}
