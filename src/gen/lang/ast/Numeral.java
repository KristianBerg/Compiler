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
 * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/lang.ast:43
 * @production Numeral : {@link Expr} ::= <span class="component">&lt;NUM:String&gt;</span>;

 */
public class Numeral extends Expr implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:257
   */
  public void genCode(PrintStream out) {
		out.println("        movq $" + getNUM() + ", %rax");
	}
  /**
   * @aspect Interpreter
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:136
   */
  public int eval(ActivationRecord actrec){
		return Integer.parseInt(getNUM());
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/PrettyPrint.jrag:169
   */
  public void prettyPrint(PrintStream out, String ind) {
		out.print(getNUM());
	}
  /**
   * @aspect Visitor
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Visitor.jrag:115
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public Numeral() {
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
  }
  /**
   * @declaredat ASTNode:12
   */
  public Numeral(String p0) {
    setNUM(p0);
  }
  /**
   * @declaredat ASTNode:15
   */
  public Numeral(beaver.Symbol p0) {
    setNUM(p0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:19
   */
  protected int numChildren() {
    return 0;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:23
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:31
   */
  public Numeral clone() throws CloneNotSupportedException {
    Numeral node = (Numeral) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public Numeral copy() {
    try {
      Numeral node = (Numeral) clone();
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
   * @declaredat ASTNode:55
   */
  @Deprecated
  public Numeral fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:65
   */
  public Numeral treeCopyNoTransform() {
    Numeral tree = (Numeral) copy();
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
   * @declaredat ASTNode:85
   */
  public Numeral treeCopy() {
    Numeral tree = (Numeral) copy();
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
   * @declaredat ASTNode:99
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node) && (tokenString_NUM == ((Numeral) node).tokenString_NUM);    
  }
  /**
   * Replaces the lexeme NUM.
   * @param value The new value for the lexeme NUM.
   * @apilevel high-level
   */
  public void setNUM(String value) {
    tokenString_NUM = value;
  }
  /** @apilevel internal 
   */
  protected String tokenString_NUM;
  /**
   */
  public int NUMstart;
  /**
   */
  public int NUMend;
  /**
   * JastAdd-internal setter for lexeme NUM using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme NUM
   * @apilevel internal
   */
  public void setNUM(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setNUM is only valid for String lexemes");
    tokenString_NUM = (String)symbol.value;
    NUMstart = symbol.getStart();
    NUMend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme NUM.
   * @return The value for the lexeme NUM.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="NUM")
  public String getNUM() {
    return tokenString_NUM != null ? tokenString_NUM : "";
  }
}
