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
 * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/lang.ast:3
 * @production Func : {@link ASTNode} ::= <span class="component">FuncName:{@link IdDecl}</span> <span class="component">Param:{@link IdDecl}*</span> <span class="component">{@link Block}</span>;

 */
public class Func extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:101
   */
  public void genCode(PrintStream out) {
		// your code here
		out.println(getFuncName().getID() + ":");
		int vars = numLocals();
		out.println("        pushq %rbp");
		out.println("        movq %rsp, %rbp");
		out.println("        subq $" + vars*8 + ", %rsp");
		getBlock().genCode(out);
		//default return value 0
		out.println("        //default return");
		out.println("        movq $0, %rax");
		out.println("        movq %rbp, %rsp");
		out.println("        popq %rbp");
		out.println("        ret");
	}
  /**
   * @aspect Interpreter
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:45
   */
  public int eval(ActivationRecord actrec){
		getBlock().eval(actrec);
		return 0;
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/PrettyPrint.jrag:23
   */
  public void prettyPrint(PrintStream out, String ind) {
		getFuncName().prettyPrint(out, ind);
		out.print("(");
		for(int i = 0; i < getNumParam(); i++){
			getParam(i).prettyPrint(out, ind);
			if(i < getNumParam() - 1){			
				out.print(", ");
			}
		}
		out.print(") ");
		getBlock().prettyPrint(out, ind);
		out.println();
	}
  /**
   * @aspect Visitor
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Visitor.jrag:49
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public Func() {
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
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  public Func(IdDecl p0, List<IdDecl> p1, Block p2) {
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
    reachable_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:29
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    Func_functionCalls_visited = false;
    Func_functionCalls_computed = false;
    
    Func_functionCalls_value = null;
    contributorMap_Func_functionCalls = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public Func clone() throws CloneNotSupportedException {
    Func node = (Func) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public Func copy() {
    try {
      Func node = (Func) clone();
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
   * @declaredat ASTNode:62
   */
  @Deprecated
  public Func fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public Func treeCopyNoTransform() {
    Func tree = (Func) copy();
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
   * @declaredat ASTNode:92
   */
  public Func treeCopy() {
    Func tree = (Func) copy();
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
   * @declaredat ASTNode:106
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the FuncName child.
   * @param node The new node to replace the FuncName child.
   * @apilevel high-level
   */
  public void setFuncName(IdDecl node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the FuncName child.
   * @return The current node used as the FuncName child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="FuncName")
  public IdDecl getFuncName() {
    return (IdDecl) getChild(0);
  }
  /**
   * Retrieves the FuncName child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the FuncName child.
   * @apilevel low-level
   */
  public IdDecl getFuncNameNoTransform() {
    return (IdDecl) getChildNoTransform(0);
  }
  /**
   * Replaces the Param list.
   * @param list The new list node to be used as the Param list.
   * @apilevel high-level
   */
  public void setParamList(List<IdDecl> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the Param list.
   * @return Number of children in the Param list.
   * @apilevel high-level
   */
  public int getNumParam() {
    return getParamList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Param list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Param list.
   * @apilevel low-level
   */
  public int getNumParamNoTransform() {
    return getParamListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Param list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Param list.
   * @apilevel high-level
   */
  public IdDecl getParam(int i) {
    return (IdDecl) getParamList().getChild(i);
  }
  /**
   * Check whether the Param list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasParam() {
    return getParamList().getNumChild() != 0;
  }
  /**
   * Append an element to the Param list.
   * @param node The element to append to the Param list.
   * @apilevel high-level
   */
  public void addParam(IdDecl node) {
    List<IdDecl> list = (parent == null) ? getParamListNoTransform() : getParamList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addParamNoTransform(IdDecl node) {
    List<IdDecl> list = getParamListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Param list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setParam(IdDecl node, int i) {
    List<IdDecl> list = getParamList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Param list.
   * @return The node representing the Param list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Param")
  public List<IdDecl> getParamList() {
    List<IdDecl> list = (List<IdDecl>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Param list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Param list.
   * @apilevel low-level
   */
  public List<IdDecl> getParamListNoTransform() {
    return (List<IdDecl>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the Param list without
   * triggering rewrites.
   */
  public IdDecl getParamNoTransform(int i) {
    return (IdDecl) getParamListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Param list.
   * @return The node representing the Param list.
   * @apilevel high-level
   */
  public List<IdDecl> getParams() {
    return getParamList();
  }
  /**
   * Retrieves the Param list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Param list.
   * @apilevel low-level
   */
  public List<IdDecl> getParamsNoTransform() {
    return getParamListNoTransform();
  }
  /**
   * Replaces the Block child.
   * @param node The new node to replace the Block child.
   * @apilevel high-level
   */
  public void setBlock(Block node) {
    setChild(node, 2);
  }
  /**
   * Retrieves the Block child.
   * @return The current node used as the Block child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Block")
  public Block getBlock() {
    return (Block) getChild(2);
  }
  /**
   * Retrieves the Block child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Block child.
   * @apilevel low-level
   */
  public Block getBlockNoTransform() {
    return (Block) getChildNoTransform(2);
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/FuncCall.jrag:11
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_Func_functionCalls = null;

  protected void survey_Func_functionCalls() {
    if (contributorMap_Func_functionCalls == null) {
      contributorMap_Func_functionCalls = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_Func_functionCalls(this, contributorMap_Func_functionCalls);
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
    int localIndex_value = 0;
    localIndex_visited = false;
    return localIndex_value;
  }
/** @apilevel internal */
protected ASTNode$State.Cycle reachable_cycle = null;
  /** @apilevel internal */
  private void reachable_reset() {
    reachable_computed = false;
    reachable_initialized = false;
    reachable_value = null;
    reachable_cycle = null;
  }
  /** @apilevel internal */
  protected boolean reachable_computed = false;

  /** @apilevel internal */
  protected HashSet<Func> reachable_value;
  /** @apilevel internal */
  protected boolean reachable_initialized = false;
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="Reachability", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/FuncCall.jrag:17")
  public HashSet<Func> reachable() {
    if (reachable_computed) {
      return reachable_value;
    }
    ASTNode$State state = state();
    if (!reachable_initialized) {
      reachable_initialized = true;
      reachable_value = new HashSet<Func>();
    }
    if (!state.inCircle() || state.calledByLazyAttribute()) {
      state.enterCircle();
      do {
        reachable_cycle = state.nextCycle();
        HashSet<Func> new_reachable_value = reachable_compute();
        if ((new_reachable_value == null && reachable_value != null) || (new_reachable_value != null && !new_reachable_value.equals(reachable_value))) {
          state.setChangeInCycle();
        }
        reachable_value = new_reachable_value;
      } while (state.testAndClearChangeInCycle());
      reachable_computed = true;
      state.startLastCycle();
      HashSet<Func> $tmp = reachable_compute();

      state.leaveCircle();
    } else if (reachable_cycle != state.cycle()) {
      reachable_cycle = state.cycle();
      if (state.lastCycle()) {
        reachable_computed = true;
        HashSet<Func> new_reachable_value = reachable_compute();
        return new_reachable_value;
      }
      HashSet<Func> new_reachable_value = reachable_compute();
      if ((new_reachable_value == null && reachable_value != null) || (new_reachable_value != null && !new_reachable_value.equals(reachable_value))) {
        state.setChangeInCycle();
      }
      reachable_value = new_reachable_value;
    } else {
    }
    return reachable_value;
  }
  /** @apilevel internal */
  private HashSet<Func> reachable_compute() {
  		HashSet<Func> reach = new HashSet<Func>();
  		for(Func f: functionCalls()){
  			reach.add(f);
  			reach.addAll(f.reachable());
  		}
  		return reach;
  	}
/** @apilevel internal */
protected boolean isUnknown_visited = false;
  /**
   * @attribute syn
   * @aspect UnknownFunc
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/UnknownFunc.jrag:7
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UnknownFunc", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/UnknownFunc.jrag:7")
  public boolean isUnknown() {
    if (isUnknown_visited) {
      throw new RuntimeException("Circular definition of attribute Func.isUnknown().");
    }
    isUnknown_visited = true;
    boolean isUnknown_value = false;
    isUnknown_visited = false;
    return isUnknown_value;
  }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:7
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:7")
  public IdDecl funcLookup(String name) {
    Object _parameters = name;
    if (funcLookup_String_visited == null) funcLookup_String_visited = new java.util.HashSet(4);
    if (funcLookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute Func.funcLookup(String).");
    }
    funcLookup_String_visited.add(_parameters);
    IdDecl funcLookup_String_value = getParent().Define_funcLookup(this, null, name);
    funcLookup_String_visited.remove(_parameters);
    return funcLookup_String_value;
  }
/** @apilevel internal */
protected java.util.Set funcLookup_String_visited;
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:286
   * @apilevel internal
   */
  public boolean Define_isParam(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getParamListNoTransform()) {
      // @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:287
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return true;
    }
    else {
      int childIndex = this.getIndexOfChild(_callerNode);
      return false;
    }
  }
  protected boolean canDefine_isParam(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/FuncCall.jrag:4
   * @apilevel internal
   */
  public Func Define_enclosingFunc(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return this;
  }
  protected boolean canDefine_enclosingFunc(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:147
   * @apilevel internal
   */
  public String Define_indexString(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getParamListNoTransform()) {
      // @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:154
      int i = _callerNode.getIndexOfChild(_childNode);
      {
      		return "param" + i + "_";
      	}
    }
    else {
      return getParent().Define_indexString(this, _callerNode);
    }
  }
  protected boolean canDefine_indexString(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:3
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getFuncNameNoTransform()) {
      // @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:35
      {
      		return funcLookup(name);
      	}
    }
    else if (_callerNode == getBlockNoTransform()) {
      // @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:22
      {
      		for(int i = 0; i < getNumParam(); i++){
      			if(getParam(i).getID().equals(name)){
      				return getParam(i);
      			}
      		}
      		return unknownDecl();
      	}
    }
    else if (_callerNode == getParamListNoTransform()) {
      // @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:14
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      {
      		for(int i = 0; i < getNumParam(); i++){
      			if(getParam(i).getID().equals(name)){
      				return getParam(i);
      			}
      		}
      		return unknownDecl();
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
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:47
   * @apilevel internal
   */
  public Func Define_function(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getFuncNameNoTransform()) {
      // @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:48
      return this;
    }
    else {
      return getParent().Define_function(this, _callerNode);
    }
  }
  protected boolean canDefine_function(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
/** @apilevel internal */
protected boolean Func_functionCalls_visited = false;
  /**
   * @attribute coll
   * @aspect FuncCall
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/FuncCall.jrag:11
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="FuncCall", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/FuncCall.jrag:11")
  public Set<Func> functionCalls() {
    ASTNode$State state = state();
    if (Func_functionCalls_computed) {
      return Func_functionCalls_value;
    }
    if (Func_functionCalls_visited) {
      throw new RuntimeException("Circular definition of attribute Func.functionCalls().");
    }
    Func_functionCalls_visited = true;
    state().enterLazyAttribute();
    Func_functionCalls_value = functionCalls_compute();
    Func_functionCalls_computed = true;
    state().leaveLazyAttribute();
    Func_functionCalls_visited = false;
    return Func_functionCalls_value;
  }
  /** @apilevel internal */
  private Set<Func> functionCalls_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof Func)) {
      node = node.getParent();
    }
    Func root = (Func) node;
    root.survey_Func_functionCalls();
    Set<Func> _computedValue = new HashSet<Func>();
    if (root.contributorMap_Func_functionCalls.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_Func_functionCalls.get(this)) {
        contributor.contributeTo_Func_functionCalls(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected boolean Func_functionCalls_computed = false;

  /** @apilevel internal */
  protected Set<Func> Func_functionCalls_value;

}
