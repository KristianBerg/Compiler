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
 * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/lang.ast:24
 * @production Expr : {@link ASTNode};

 */
public abstract class Expr extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:184
   */
  public void genCode(PrintStream out) {
		out.println("        movq $0, %rax");
	}
  /**
   * @aspect Interpreter
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:90
   */
  public int eval(ActivationRecord actrec){
		return 0;
	}
  /**
   * @declaredat ASTNode:1
   */
  public Expr() {
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
  /** @apilevel low-level 
   * @declaredat ASTNode:13
   */
  protected int numChildren() {
    return 0;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:17
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:21
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:25
   */
  public Expr clone() throws CloneNotSupportedException {
    Expr node = (Expr) super.clone();
    return node;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:36
   */
  @Deprecated
  public abstract Expr fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:44
   */
  public abstract Expr treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:52
   */
  public abstract Expr treeCopy();
/** @apilevel internal */
protected boolean type_visited = false;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:23
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:23")
  public Type type() {
    if (type_visited) {
      throw new RuntimeException("Circular definition of attribute Expr.type().");
    }
    type_visited = true;
    try {
    		return intType();
    	}
    finally {
      type_visited = false;
    }
  }
/** @apilevel internal */
protected boolean isUnexpected_visited = false;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:45
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:45")
  public boolean isUnexpected() {
    if (isUnexpected_visited) {
      throw new RuntimeException("Circular definition of attribute Expr.isUnexpected().");
    }
    isUnexpected_visited = true;
    boolean isUnexpected_value = !type().compatibleWith(expectedType());
    isUnexpected_visited = false;
    return isUnexpected_value;
  }
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:36
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:36")
  public Type expectedType() {
    if (expectedType_visited) {
      throw new RuntimeException("Circular definition of attribute Expr.expectedType().");
    }
    expectedType_visited = true;
    Type expectedType_value = getParent().Define_expectedType(this, null);
    expectedType_visited = false;
    return expectedType_value;
  }
/** @apilevel internal */
protected boolean expectedType_visited = false;
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:36
   * @apilevel internal
   */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return intType();
  }
  protected boolean canDefine_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Errors.jrag:46
    if (isUnexpected()) {
      {
        Program target = (Program) (program());
        java.util.Set<ASTNode> contributors = _map.get(target);
        if (contributors == null) {
          contributors = new java.util.LinkedHashSet<ASTNode>();
          _map.put((ASTNode) target, contributors);
        }
        contributors.add(this);
      }
    }
    super.collect_contributors_Program_errors(_root, _map);
  }
  protected void contributeTo_Program_errors(Set<ErrorMessage> collection) {
    super.contributeTo_Program_errors(collection);
    if (isUnexpected()) {
      collection.add(error("expression " + prettyPrint() + ": expected type " + expectedType() + " but was " + type()));
    }
  }
}
