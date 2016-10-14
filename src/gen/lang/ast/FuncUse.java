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
 * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/lang.ast:45
 * @production FuncUse : {@link Expr} ::= <span class="component">{@link IdUse}</span> <span class="component">{@link Expr}*</span>;

 */
public class FuncUse extends Expr implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:260
   */
  public void genCode(PrintStream out) {
		for(int i = getNumExpr() - 1; i >= 0; i--){
			Expr e = getExpr(i);
			e.genCode(out);
			out.println("        pushq %rax"); //push argument
		}
		out.println("        call " + getIdUse().getID());
		out.println("        addq $" + getNumExpr()*8 + ", %rsp"); //pop arguments
	}
  /**
   * @aspect Interpreter
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:122
   */
  public int eval(ActivationRecord actrec){
		ActivationRecord ar = new ActivationRecord();
		Func f = getIdUse().decl().enclosingFunc();
		for(int i = 0; i < getNumExpr(); i++){
			ar.put(f.getParam(i).uniqueName(), getExpr(i).eval(actrec));
		}
		try{
			f.eval(ar);
		} catch (ReturnException e){
			return e.getValue();
		}
		return 0;
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/PrettyPrint.jrag:177
   */
  public void prettyPrint(PrintStream out, String ind) {
		getIdUse().prettyPrint(out, ind);
		out.print("(");
		for(int i = 0; i < getNumExpr(); i++){
			getExpr(i).prettyPrint(out, ind);
			if(i < getNumExpr() - 1){
				out.print(", ");
			}
		}
		out.print(")");
	}
  /**
   * @aspect Visitor
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Visitor.jrag:121
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public FuncUse() {
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
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  public FuncUse(IdUse p0, List<Expr> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:19
   */
  protected int numChildren() {
    return 2;
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
  public FuncUse clone() throws CloneNotSupportedException {
    FuncUse node = (FuncUse) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public FuncUse copy() {
    try {
      FuncUse node = (FuncUse) clone();
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
  public FuncUse fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:65
   */
  public FuncUse treeCopyNoTransform() {
    FuncUse tree = (FuncUse) copy();
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
  public FuncUse treeCopy() {
    FuncUse tree = (FuncUse) copy();
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
    return super.is$Equal(node);    
  }
  /**
   * Replaces the IdUse child.
   * @param node The new node to replace the IdUse child.
   * @apilevel high-level
   */
  public void setIdUse(IdUse node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the IdUse child.
   * @return The current node used as the IdUse child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="IdUse")
  public IdUse getIdUse() {
    return (IdUse) getChild(0);
  }
  /**
   * Retrieves the IdUse child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the IdUse child.
   * @apilevel low-level
   */
  public IdUse getIdUseNoTransform() {
    return (IdUse) getChildNoTransform(0);
  }
  /**
   * Replaces the Expr list.
   * @param list The new list node to be used as the Expr list.
   * @apilevel high-level
   */
  public void setExprList(List<Expr> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the Expr list.
   * @return Number of children in the Expr list.
   * @apilevel high-level
   */
  public int getNumExpr() {
    return getExprList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Expr list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Expr list.
   * @apilevel low-level
   */
  public int getNumExprNoTransform() {
    return getExprListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Expr list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Expr list.
   * @apilevel high-level
   */
  public Expr getExpr(int i) {
    return (Expr) getExprList().getChild(i);
  }
  /**
   * Check whether the Expr list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasExpr() {
    return getExprList().getNumChild() != 0;
  }
  /**
   * Append an element to the Expr list.
   * @param node The element to append to the Expr list.
   * @apilevel high-level
   */
  public void addExpr(Expr node) {
    List<Expr> list = (parent == null) ? getExprListNoTransform() : getExprList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addExprNoTransform(Expr node) {
    List<Expr> list = getExprListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Expr list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setExpr(Expr node, int i) {
    List<Expr> list = getExprList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Expr list.
   * @return The node representing the Expr list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Expr")
  public List<Expr> getExprList() {
    List<Expr> list = (List<Expr>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Expr list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Expr list.
   * @apilevel low-level
   */
  public List<Expr> getExprListNoTransform() {
    return (List<Expr>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the Expr list without
   * triggering rewrites.
   */
  public Expr getExprNoTransform(int i) {
    return (Expr) getExprListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Expr list.
   * @return The node representing the Expr list.
   * @apilevel high-level
   */
  public List<Expr> getExprs() {
    return getExprList();
  }
  /**
   * Retrieves the Expr list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Expr list.
   * @apilevel low-level
   */
  public List<Expr> getExprsNoTransform() {
    return getExprListNoTransform();
  }
/** @apilevel internal */
protected boolean enclosingFunc_visited = false;
  /**
   * @attribute syn
   * @aspect FuncCall
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/FuncCall.jrag:5
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="FuncCall", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/FuncCall.jrag:5")
  public Func enclosingFunc() {
    if (enclosingFunc_visited) {
      throw new RuntimeException("Circular definition of attribute FuncUse.enclosingFunc().");
    }
    enclosingFunc_visited = true;
    Func enclosingFunc_value = getIdUse().decl().enclosingFunc();
    enclosingFunc_visited = false;
    return enclosingFunc_value;
  }
/** @apilevel internal */
protected boolean correctNumParam_visited = false;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:51
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:51")
  public boolean correctNumParam() {
    if (correctNumParam_visited) {
      throw new RuntimeException("Circular definition of attribute FuncUse.correctNumParam().");
    }
    correctNumParam_visited = true;
    try {
    		if(getIdUse().decl() == unknownDecl()){
    			return true;
    		}
    		return getIdUse().decl().function().getNumParam() == getNumExpr();
    	}
    finally {
      correctNumParam_visited = false;
    }
  }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:8
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:8")
  public IdDecl funcLookup(String name) {
    Object _parameters = name;
    if (funcLookup_String_visited == null) funcLookup_String_visited = new java.util.HashSet(4);
    if (funcLookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute FuncUse.funcLookup(String).");
    }
    funcLookup_String_visited.add(_parameters);
    IdDecl funcLookup_String_value = getParent().Define_funcLookup(this, null, name);
    funcLookup_String_visited.remove(_parameters);
    return funcLookup_String_value;
  }
/** @apilevel internal */
protected java.util.Set funcLookup_String_visited;
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:3
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getIdUseNoTransform()) {
      // @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:31
      {
      		return funcLookup(name);
      	}
    }
    else {
      return getParent().Define_lookup(this, _callerNode, name);
    }
  }
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:36
   * @apilevel internal
   */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getIdUseNoTransform()) {
      // @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:42
      return unknownType();
    }
    else {
      return super.Define_expectedType(_callerNode, _childNode);
    }
  }
  protected boolean canDefine_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Errors.jrag:50
    if (!correctNumParam()) {
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
  protected void collect_contributors_Func_functionCalls(Func _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/FuncCall.jrag:13
    {
      java.util.Set<ASTNode> contributors = _map.get(_root);
      if (contributors == null) {
        contributors = new java.util.LinkedHashSet<ASTNode>();
        _map.put((ASTNode) _root, contributors);
      }
      contributors.add(this);
    }
    super.collect_contributors_Func_functionCalls(_root, _map);
  }
  protected void contributeTo_Program_errors(Set<ErrorMessage> collection) {
    super.contributeTo_Program_errors(collection);
    if (!correctNumParam()) {
      collection.add(error("incorrect number of parameters, expected " + getIdUse().decl().function().getNumParam() + " but was " + getNumExpr()));
    }
  }
  protected void contributeTo_Func_functionCalls(Set<Func> collection) {
    super.contributeTo_Func_functionCalls(collection);
    collection.add(getIdUse().decl().enclosingFunc());
  }
}
