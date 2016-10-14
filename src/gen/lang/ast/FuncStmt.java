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
 * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/lang.ast:15
 * @production FuncStmt : {@link Stmt} ::= <span class="component">{@link FuncUse}</span>;

 */
public class FuncStmt extends Stmt implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:125
   */
  public void genCode(PrintStream out) {
		getFuncUse().genCode(out);
	}
  /**
   * @aspect Interpreter
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:61
   */
  public void eval(ActivationRecord actrec){
		if(getFuncUse().getIdUse().getID().equals("print")){
			System.out.println(getFuncUse().getExpr(0).eval(actrec));
		} else {
			getFuncUse().eval(actrec);
		}
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/PrettyPrint.jrag:82
   */
  public void prettyPrint(PrintStream out, String ind) {
		getFuncUse().prettyPrint(out, ind);
		out.println(";");
	}
  /**
   * @aspect Visitor
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Visitor.jrag:73
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public FuncStmt() {
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
    children = new ASTNode[1];
  }
  /**
   * @declaredat ASTNode:13
   */
  public FuncStmt(FuncUse p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:17
   */
  protected int numChildren() {
    return 1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:21
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:25
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:29
   */
  public FuncStmt clone() throws CloneNotSupportedException {
    FuncStmt node = (FuncStmt) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:34
   */
  public FuncStmt copy() {
    try {
      FuncStmt node = (FuncStmt) clone();
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
   * @declaredat ASTNode:53
   */
  @Deprecated
  public FuncStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:63
   */
  public FuncStmt treeCopyNoTransform() {
    FuncStmt tree = (FuncStmt) copy();
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
   * @declaredat ASTNode:83
   */
  public FuncStmt treeCopy() {
    FuncStmt tree = (FuncStmt) copy();
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
   * @declaredat ASTNode:97
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the FuncUse child.
   * @param node The new node to replace the FuncUse child.
   * @apilevel high-level
   */
  public void setFuncUse(FuncUse node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the FuncUse child.
   * @return The current node used as the FuncUse child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="FuncUse")
  public FuncUse getFuncUse() {
    return (FuncUse) getChild(0);
  }
  /**
   * Retrieves the FuncUse child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the FuncUse child.
   * @apilevel low-level
   */
  public FuncUse getFuncUseNoTransform() {
    return (FuncUse) getChildNoTransform(0);
  }
}
