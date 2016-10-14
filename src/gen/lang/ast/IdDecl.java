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
 * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/lang.ast:7
 * @production IdDecl : {@link ASTNode} ::= <span class="component">&lt;ID:String&gt;</span>;

 */
public class IdDecl extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:136
   */
  public void genCode(PrintStream out) {
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/PrettyPrint.jrag:46
   */
  public void prettyPrint(PrintStream out, String ind) {
		out.print("int " + getID());
	}
  /**
   * @aspect Visitor
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Visitor.jrag:55
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public IdDecl() {
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
  public IdDecl(String p0) {
    setID(p0);
  }
  /**
   * @declaredat ASTNode:15
   */
  public IdDecl(beaver.Symbol p0) {
    setID(p0);
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
  public IdDecl clone() throws CloneNotSupportedException {
    IdDecl node = (IdDecl) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public IdDecl copy() {
    try {
      IdDecl node = (IdDecl) clone();
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
  public IdDecl fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:65
   */
  public IdDecl treeCopyNoTransform() {
    IdDecl tree = (IdDecl) copy();
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
  public IdDecl treeCopy() {
    IdDecl tree = (IdDecl) copy();
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
    return super.is$Equal(node) && (tokenString_ID == ((IdDecl) node).tokenString_ID);    
  }
  /**
   * Replaces the lexeme ID.
   * @param value The new value for the lexeme ID.
   * @apilevel high-level
   */
  public void setID(String value) {
    tokenString_ID = value;
  }
  /** @apilevel internal 
   */
  protected String tokenString_ID;
  /**
   */
  public int IDstart;
  /**
   */
  public int IDend;
  /**
   * JastAdd-internal setter for lexeme ID using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme ID
   * @apilevel internal
   */
  public void setID(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setID is only valid for String lexemes");
    tokenString_ID = (String)symbol.value;
    IDstart = symbol.getStart();
    IDend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme ID.
   * @return The value for the lexeme ID.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="ID")
  public String getID() {
    return tokenString_ID != null ? tokenString_ID : "";
  }
/** @apilevel internal */
protected boolean address_visited = false;
  /**
   * Address of local variable variable in the current stack frame.
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:294
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:294")
  public String address() {
    if (address_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.address().");
    }
    address_visited = true;
    try {
    		if(isParam()){
    			for(int i = 0; i < enclosingFunc().getNumParam(); i++){
    				if(enclosingFunc().getParam(i) == this){
    					return (2 + i)*8 + "(%rbp)";
    				}
    			}
    			return "error";
    		}
    		return "-"+(localIndex()*8)+"(%rbp)";
    	}
    finally {
      address_visited = false;
    }
  }
/** @apilevel internal */
protected boolean localIndex_visited = false;
  /**
   * Local variable numbering.
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:314
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:314")
  public int localIndex() {
    if (localIndex_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.localIndex().");
    }
    localIndex_visited = true;
    try {
    		if(enclosingFunc().getFuncName() == this || isParam()){
    			//if idDecl is a parameter or function declaration
    			return prevNode().localIndex();
    		}	
    		return prevNode().localIndex() + 1;
    	}
    finally {
      localIndex_visited = false;
    }
  }
/** @apilevel internal */
protected boolean uniqueName_visited = false;
  /**
   * @attribute syn
   * @aspect UniqueName
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:145
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UniqueName", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:145")
  public String uniqueName() {
    if (uniqueName_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.uniqueName().");
    }
    uniqueName_visited = true;
    String uniqueName_value = indexString() + getID();
    uniqueName_visited = false;
    return uniqueName_value;
  }
/** @apilevel internal */
protected boolean isMultiplyDeclared_visited = false;
  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:80
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:80")
  public boolean isMultiplyDeclared() {
    if (isMultiplyDeclared_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isMultiplyDeclared().");
    }
    isMultiplyDeclared_visited = true;
    boolean isMultiplyDeclared_value = lookup(getID()) != this;
    isMultiplyDeclared_visited = false;
    return isMultiplyDeclared_value;
  }
/** @apilevel internal */
protected boolean isUnknown_visited = false;
  /**
   * @attribute syn
   * @aspect UnknownDecl
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/UnknownDecl.jrag:7
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/UnknownDecl.jrag:7")
  public boolean isUnknown() {
    if (isUnknown_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isUnknown().");
    }
    isUnknown_visited = true;
    boolean isUnknown_value = false;
    isUnknown_visited = false;
    return isUnknown_value;
  }
  /**
   * @attribute inh
   * @aspect CodeGen
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:286
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:286")
  public boolean isParam() {
    if (isParam_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isParam().");
    }
    isParam_visited = true;
    boolean isParam_value = getParent().Define_isParam(this, null);
    isParam_visited = false;
    return isParam_value;
  }
/** @apilevel internal */
protected boolean isParam_visited = false;
  /**
   * @attribute inh
   * @aspect FuncCall
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/FuncCall.jrag:4
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="FuncCall", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/FuncCall.jrag:4")
  public Func enclosingFunc() {
    if (enclosingFunc_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.enclosingFunc().");
    }
    enclosingFunc_visited = true;
    Func enclosingFunc_value = getParent().Define_enclosingFunc(this, null);
    enclosingFunc_visited = false;
    return enclosingFunc_value;
  }
/** @apilevel internal */
protected boolean enclosingFunc_visited = false;
  /**
   * @attribute inh
   * @aspect UniqueName
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:149
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="UniqueName", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:149")
  public String indexString() {
    if (indexString_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.indexString().");
    }
    indexString_visited = true;
    String indexString_value = getParent().Define_indexString(this, null);
    indexString_visited = false;
    return indexString_value;
  }
/** @apilevel internal */
protected boolean indexString_visited = false;
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:4
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:4")
  public IdDecl lookup(String name) {
    Object _parameters = name;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute IdDecl.lookup(String).");
    }
    lookup_String_visited.add(_parameters);
    IdDecl lookup_String_value = getParent().Define_lookup(this, null, name);
    lookup_String_visited.remove(_parameters);
    return lookup_String_value;
  }
/** @apilevel internal */
protected java.util.Set lookup_String_visited;
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:47
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:47")
  public Func function() {
    if (function_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.function().");
    }
    function_visited = true;
    Func function_value = getParent().Define_function(this, null);
    function_visited = false;
    return function_value;
  }
/** @apilevel internal */
protected boolean function_visited = false;
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Errors.jrag:38
    if (isMultiplyDeclared()) {
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
    if (isMultiplyDeclared()) {
      collection.add(error("symbol '" + getID() + "' is already declared!"));
    }
  }
}
