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
 * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/lang.ast:14
 * @production WhileStmt : {@link Stmt} ::= <span class="component">{@link Expr}</span> <span class="component">{@link Block}</span>;

 */
public class WhileStmt extends Stmt implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:171
   */
  public void genCode(PrintStream out) {
		String whileStartLabel = "While_" + Program.nextLabelIndex() + "_start";
		String whileEndLabel = "While_" + Program.nextLabelIndex() + "_end";
		out.println("//while");
		out.println(whileStartLabel + ":");
		getExpr().genCode(out);
		out.println("        cmpq $0, %rax");
		out.println("        je " + whileEndLabel);
		getBlock().genCode(out);
		out.println("        jmp " + whileStartLabel);
		out.println(whileEndLabel + ":");
	}
  /**
   * @aspect Interpreter
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:74
   */
  public void eval(ActivationRecord actrec){
		while(getExpr().eval(actrec) == 1){
			getBlock().eval(actrec);
		}
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/PrettyPrint.jrag:75
   */
  public void prettyPrint(PrintStream out, String ind) {
		out.print("while (");
		getExpr().prettyPrint(out, ind);
		out.print(") ");
		getBlock().prettyPrint(out, ind);
	}
  /**
   * @aspect Visitor
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Visitor.jrag:70
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public WhileStmt() {
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
    children = new ASTNode[2];
  }
  /**
   * @declaredat ASTNode:13
   */
  public WhileStmt(Expr p0, Block p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:18
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:22
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:26
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:30
   */
  public WhileStmt clone() throws CloneNotSupportedException {
    WhileStmt node = (WhileStmt) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:35
   */
  public WhileStmt copy() {
    try {
      WhileStmt node = (WhileStmt) clone();
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
   * @declaredat ASTNode:54
   */
  @Deprecated
  public WhileStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:64
   */
  public WhileStmt treeCopyNoTransform() {
    WhileStmt tree = (WhileStmt) copy();
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
   * @declaredat ASTNode:84
   */
  public WhileStmt treeCopy() {
    WhileStmt tree = (WhileStmt) copy();
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
   * @declaredat ASTNode:98
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
/** @apilevel internal */
protected boolean uniqueName_visited = false;
  /**
   * @attribute syn
   * @aspect UniqueName
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:143
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UniqueName", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:143")
  public String uniqueName() {
    if (uniqueName_visited) {
      throw new RuntimeException("Circular definition of attribute WhileStmt.uniqueName().");
    }
    uniqueName_visited = true;
    String uniqueName_value = indexString() + "while";
    uniqueName_visited = false;
    return uniqueName_value;
  }
  /**
   * @attribute inh
   * @aspect UniqueName
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:148
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="UniqueName", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:148")
  public String indexString() {
    if (indexString_visited) {
      throw new RuntimeException("Circular definition of attribute WhileStmt.indexString().");
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
      // @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:38
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
