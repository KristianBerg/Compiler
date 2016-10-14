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
 * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/lang.ast:4
 * @production UnknownFunc : {@link Func};

 */
public class UnknownFunc extends Func implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public UnknownFunc() {
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
  public UnknownFunc(IdDecl p0, List<IdDecl> p1, Block p2) {
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
  public UnknownFunc clone() throws CloneNotSupportedException {
    UnknownFunc node = (UnknownFunc) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public UnknownFunc copy() {
    try {
      UnknownFunc node = (UnknownFunc) clone();
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
  public UnknownFunc fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:66
   */
  public UnknownFunc treeCopyNoTransform() {
    UnknownFunc tree = (UnknownFunc) copy();
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
  public UnknownFunc treeCopy() {
    UnknownFunc tree = (UnknownFunc) copy();
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
    boolean isUnknown_value = true;
    isUnknown_visited = false;
    return isUnknown_value;
  }
}
