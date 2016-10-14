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
 * @production ASTNode;

 */
public class ASTNode<T extends ASTNode> extends beaver.Symbol implements Cloneable {
  /**
   * @aspect DumpTree
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/DumpTree.jrag:9
   */
  private String DUMP_TREE_INDENT = "  ";
  /**
   * @aspect DumpTree
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/DumpTree.jrag:11
   */
  public String dumpTree() {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		dumpTree(new PrintStream(bytes));
		return bytes.toString();
	}
  /**
   * @aspect DumpTree
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/DumpTree.jrag:17
   */
  public void dumpTree(PrintStream out) {
		dumpTree(out, "");
		out.flush();
	}
  /**
   * @aspect DumpTree
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/DumpTree.jrag:22
   */
  public void dumpTree(PrintStream out, String indent) {
		out.print(indent + getClass().getSimpleName());
		out.println(getTokens());
		String childIndent = indent + DUMP_TREE_INDENT;
		for (ASTNode child : astChildren()) {
			if (child == null)  {
				out.println(childIndent + "null");
			} else {
				child.dumpTree(out, childIndent);
			}
		}
	}
  /**
   * @aspect DumpTree
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/DumpTree.jrag:35
   */
  public String getTokens() {
		StringBuilder sb = new StringBuilder();
		java.lang.reflect.Method[] methods = getClass().getMethods();
		for (java.lang.reflect.Method method : getClass().getMethods()) {
			ASTNodeAnnotation.Token token = method.getAnnotation(ASTNodeAnnotation.Token.class);
			if (token != null) {
				try {
					sb.append(" " + token.name() + "=\"" + method.invoke(this) + "\"");
				} catch (IllegalAccessException e) {
				} catch (InvocationTargetException e) {
				}
			}
		}
		return sb.toString();
	}
  /**
   * @aspect Errors
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Errors.jrag:22
   */
  protected ErrorMessage error(String message) {
		return new ErrorMessage(message, getLine(getStart()));
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/PrettyPrint.jrag:5
   */
  public String prettyPrint() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		prettyPrint(out);
		return stream.toString();
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/PrettyPrint.jrag:12
   */
  public void prettyPrint(PrintStream out) {
		prettyPrint(out, "");
		out.println();
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/PrettyPrint.jrag:17
   */
  public void prettyPrint(PrintStream out, String ind) {
		for (int i = 0; i < getNumChild(); ++i) {
			getChild(i).prettyPrint(out, ind);
		}
	}
  /**
   * @aspect Visitor
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Visitor.jrag:37
   */
  public Object accept(Visitor visitor, Object data) {
		throw new Error("Visitor: accept method not available for " + getClass().getName());
	}
  /**
   * @declaredat ASTNode:1
   */
  public ASTNode() {
    super();
    init$Children();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:11
   */
  public void init$Children() {
  }
  /**
   * Cached child index. Child indices are assumed to never change (AST should
   * not change after construction).
   * @apilevel internal
   * @declaredat ASTNode:18
   */
  private int childIndex = -1;
  /** @apilevel low-level 
   * @declaredat ASTNode:21
   */
  public int getIndexOfChild(ASTNode node) {
    if (node == null) {
      return -1;
    }
    if (node.childIndex >= 0) {
      return node.childIndex;
    }
    for (int i = 0; children != null && i < children.length; i++) {
      if (children[i] == node) {
        node.childIndex = i;
        return i;
      }
    }
    return -1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public static final boolean generatedWithCacheCycle = true;
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public static final boolean generatedWithComponentCheck = false;
  /** @apilevel low-level 
   * @declaredat ASTNode:44
   */
  protected ASTNode parent;
  /** @apilevel low-level 
   * @declaredat ASTNode:47
   */
  protected ASTNode[] children;
  /** @apilevel internal 
   * @declaredat ASTNode:51
   */
  private static ASTNode$State state = new ASTNode$State();
  /** @apilevel internal 
   * @declaredat ASTNode:54
   */
  public final ASTNode$State state() {
    return state;
  }
  /**
   * @return an iterator that can be used to iterate over the children of this node.
   * The iterator does not allow removing children.
   * @declaredat ASTNode:63
   */
  public java.util.Iterator<T> astChildIterator() {
    return new java.util.Iterator<T>() {
      private int index = 0;

      @Override
      public boolean hasNext() {
        return index < getNumChild();
      }

      @Override
      public T next() {
        return hasNext() ? (T) getChild(index++) : null;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
  /** @return an object that can be used to iterate over the children of this node 
   * @declaredat ASTNode:85
   */
  public Iterable<T> astChildren() {
    return new Iterable<T>() {
      @Override
      public java.util.Iterator<T> iterator() {
        return astChildIterator();
      }
    };
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:95
   */
  public T getChild(int i) {
    ASTNode child = getChildNoTransform(i);
    return (T) child;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:100
   */
  public void addChild(T node) {
    setChild(node, getNumChildNoTransform());
  }
  /**
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @apilevel low-level
   * @declaredat ASTNode:107
   */
  public final T getChildNoTransform(int i) {
    if (children == null) {
      return null;
    }
    T child = (T)children[i];
    return child;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:115
   */
  protected int numChildren;
  /** @apilevel low-level 
   * @declaredat ASTNode:118
   */
  protected int numChildren() {
    return numChildren;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:123
   */
  public int getNumChild() {
    return numChildren();
  }
  /**
   * Behaves like getNumChild, but does not invoke AST transformations (rewrites).
   * @apilevel low-level
   * @declaredat ASTNode:131
   */
  public final int getNumChildNoTransform() {
    return numChildren();
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:135
   */
  public void setChild(ASTNode node, int i) {
    if (children == null) {
      children = new ASTNode[(i + 1 > 4 || !(this instanceof List)) ? i + 1 : 4];
    } else if (i >= children.length) {
      ASTNode c[] = new ASTNode[i << 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = node;
    if (i >= numChildren) {
      numChildren = i+1;
    }
    if (node != null) {
      node.setParent(this);
      node.childIndex = i;
    }
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:153
   */
  public void insertChild(ASTNode node, int i) {
    if (children == null) {
      children = new ASTNode[(i + 1 > 4 || !(this instanceof List)) ? i + 1 : 4];
      children[i] = node;
    } else {
      ASTNode c[] = new ASTNode[children.length + 1];
      System.arraycopy(children, 0, c, 0, i);
      c[i] = node;
      if (i < children.length) {
        System.arraycopy(children, i, c, i+1, children.length-i);
        for(int j = i+1; j < c.length; ++j) {
          if (c[j] != null) {
            c[j].childIndex = j;
          }
        }
      }
      children = c;
    }
    numChildren++;
    if (node != null) {
      node.setParent(this);
      node.childIndex = i;
    }
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:178
   */
  public void removeChild(int i) {
    if (children != null) {
      ASTNode child = (ASTNode) children[i];
      if (child != null) {
        child.parent = null;
        child.childIndex = -1;
      }
      // Adding a check of this instance to make sure its a List, a move of children doesn't make
      // any sense for a node unless its a list. Also, there is a problem if a child of a non-List node is removed
      // and siblings are moved one step to the right, with null at the end.
      if (this instanceof List || this instanceof Opt) {
        System.arraycopy(children, i+1, children, i, children.length-i-1);
        children[children.length-1] = null;
        numChildren--;
        // fix child indices
        for(int j = i; j < numChildren; ++j) {
          if (children[j] != null) {
            child = (ASTNode) children[j];
            child.childIndex = j;
          }
        }
      } else {
        children[i] = null;
      }
    }
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:205
   */
  public ASTNode getParent() {
    return (ASTNode) parent;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:209
   */
  public void setParent(ASTNode node) {
    parent = node;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:265
   */
  public void flushTreeCache() {
    flushCache();
    if (children != null) {
      for (int i = 0; i < children.length; i++) {
        if (children[i] != null) {
          ((ASTNode) children[i]).flushTreeCache();
        }
      }
    }
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:276
   */
  public void flushCache() {
    flushAttrAndCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:280
   */
  public void flushAttrAndCollectionCache() {
    flushAttrCache();
    flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:285
   */
  public void flushAttrCache() {
  }
  /** @apilevel internal 
   * @declaredat ASTNode:288
   */
  public void flushCollectionCache() {
  }
  /** @apilevel internal 
   * @declaredat ASTNode:291
   */
  public ASTNode<T> clone() throws CloneNotSupportedException {
    ASTNode node = (ASTNode) super.clone();
    node.flushAttrAndCollectionCache();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:297
   */
  public ASTNode<T> copy() {
    try {
      ASTNode node = (ASTNode) clone();
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
   * @declaredat ASTNode:316
   */
  @Deprecated
  public ASTNode<T> fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:326
   */
  public ASTNode<T> treeCopyNoTransform() {
    ASTNode tree = (ASTNode) copy();
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
   * @declaredat ASTNode:346
   */
  public ASTNode<T> treeCopy() {
    ASTNode tree = (ASTNode) copy();
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
  /**
   * Performs a full traversal of the tree using getChild to trigger rewrites
   * @apilevel low-level
   * @declaredat ASTNode:363
   */
  public void doFullTraversal() {
    for (int i = 0; i < getNumChild(); i++) {
      getChild(i).doFullTraversal();
    }
  }
  /** @apilevel internal 
   * @declaredat ASTNode:369
   */
  protected boolean is$Equal(ASTNode n1, ASTNode n2) {
    if (n1 == null && n2 == null) return true;
    if (n1 == null || n2 == null) return false;
    return n1.is$Equal(n2);
  }
  /** @apilevel internal 
   * @declaredat ASTNode:375
   */
  protected boolean is$Equal(ASTNode node) {
    if (getClass() != node.getClass()) {
      return false;
    }
    if (numChildren != node.numChildren) {
      return false;
    }
    for (int i = 0; i < numChildren; i++) {
      if (children[i] == null && node.children[i] != null) {
        return false;
      }
      if (!((ASTNode)children[i]).is$Equal(((ASTNode)node.children[i]))) {
        return false;
      }
    }
    return true;
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Errors.jrag:26
   */
    protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    for (int i = 0; i < getNumChild(); i++) {
      getChild(i).collect_contributors_Program_errors(_root, _map);
    }
  }
  protected void contributeTo_Program_errors(Set<ErrorMessage> collection) {
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/FuncCall.jrag:11
   */
    protected void collect_contributors_Func_functionCalls(Func _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    for (int i = 0; i < getNumChild(); i++) {
      getChild(i).collect_contributors_Func_functionCalls(_root, _map);
    }
  }
  protected void contributeTo_Func_functionCalls(Set<Func> collection) {
  }

/** @apilevel internal */
protected boolean numLocals_visited = false;
  /**
   * Local variable counting.
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:309
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:309")
  public int numLocals() {
    if (numLocals_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.numLocals().");
    }
    numLocals_visited = true;
    int numLocals_value = lastNode().localIndex() - localIndex();
    numLocals_visited = false;
    return numLocals_value;
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
    int localIndex_value = prevNode().localIndex();
    localIndex_visited = false;
    return localIndex_value;
  }
/** @apilevel internal */
protected boolean lastNode_visited = false;
  /**
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:327
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:327")
  public ASTNode lastNode() {
    if (lastNode_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.lastNode().");
    }
    lastNode_visited = true;
    ASTNode lastNode_value = prevNode(getNumChild());
    lastNode_visited = false;
    return lastNode_value;
  }
/** @apilevel internal */
protected java.util.Set prevNode_int_visited;
  /**
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:328
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:328")
  public ASTNode prevNode(int i) {
    Object _parameters = i;
    if (prevNode_int_visited == null) prevNode_int_visited = new java.util.HashSet(4);
    if (prevNode_int_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute ASTNode.prevNode(int).");
    }
    prevNode_int_visited.add(_parameters);
    ASTNode prevNode_int_value = i>0 ? getChild(i-1).lastNode() : this;
    prevNode_int_visited.remove(_parameters);
    return prevNode_int_value;
  }
  /**
   * @attribute inh
   * @aspect CodeGen
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:325
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:325")
  public ASTNode prevNode() {
    if (prevNode_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.prevNode().");
    }
    prevNode_visited = true;
    ASTNode prevNode_value = getParent().Define_prevNode(this, null);
    prevNode_visited = false;
    return prevNode_value;
  }
/** @apilevel internal */
protected boolean prevNode_visited = false;
  /**
   * @attribute inh
   * @aspect Errors
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Errors.jrag:28
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="Errors", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Errors.jrag:28")
  public Program program() {
    if (program_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.program().");
    }
    program_visited = true;
    Program program_value = getParent().Define_program(this, null);
    program_visited = false;
    return program_value;
  }
/** @apilevel internal */
protected boolean program_visited = false;
  /**
   * @attribute inh
   * @aspect PredefinedFunctions
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/PredefinedFunctions.jrag:15
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="PredefinedFunctions", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/PredefinedFunctions.jrag:15")
  public List<Func> predefinedFunctions() {
    if (predefinedFunctions_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.predefinedFunctions().");
    }
    predefinedFunctions_visited = true;
    List<Func> predefinedFunctions_value = getParent().Define_predefinedFunctions(this, null);
    predefinedFunctions_visited = false;
    return predefinedFunctions_value;
  }
/** @apilevel internal */
protected boolean predefinedFunctions_visited = false;
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:8
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:8")
  public BoolType boolType() {
    if (boolType_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.boolType().");
    }
    boolType_visited = true;
    BoolType boolType_value = getParent().Define_boolType(this, null);
    boolType_visited = false;
    return boolType_value;
  }
/** @apilevel internal */
protected boolean boolType_visited = false;
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:9
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:9")
  public IntType intType() {
    if (intType_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.intType().");
    }
    intType_visited = true;
    IntType intType_value = getParent().Define_intType(this, null);
    intType_visited = false;
    return intType_value;
  }
/** @apilevel internal */
protected boolean intType_visited = false;
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:10
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:10")
  public UnknownType unknownType() {
    if (unknownType_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.unknownType().");
    }
    unknownType_visited = true;
    UnknownType unknownType_value = getParent().Define_unknownType(this, null);
    unknownType_visited = false;
    return unknownType_value;
  }
/** @apilevel internal */
protected boolean unknownType_visited = false;
  /**
   * @attribute inh
   * @aspect UnknownDecl
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/UnknownDecl.jrag:4
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/UnknownDecl.jrag:4")
  public UnknownDecl unknownDecl() {
    if (unknownDecl_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.unknownDecl().");
    }
    unknownDecl_visited = true;
    UnknownDecl unknownDecl_value = getParent().Define_unknownDecl(this, null);
    unknownDecl_visited = false;
    return unknownDecl_value;
  }
/** @apilevel internal */
protected boolean unknownDecl_visited = false;
  /**
   * @attribute inh
   * @aspect UnknownFunc
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/UnknownFunc.jrag:4
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="UnknownFunc", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/UnknownFunc.jrag:4")
  public UnknownFunc unknownFunc() {
    if (unknownFunc_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.unknownFunc().");
    }
    unknownFunc_visited = true;
    UnknownFunc unknownFunc_value = getParent().Define_unknownFunc(this, null);
    unknownFunc_visited = false;
    return unknownFunc_value;
  }
/** @apilevel internal */
protected boolean unknownFunc_visited = false;
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:325
   * @apilevel internal
   */
  public ASTNode Define_prevNode(ASTNode _callerNode, ASTNode _childNode) {
    int i = this.getIndexOfChild(_callerNode);
    return prevNode(i);
  }
  protected boolean canDefine_prevNode(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /** @apilevel internal */
  public boolean Define_isParam(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_isParam(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_isParam(self, _callerNode);
  }

  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:287
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isParam
   */
  protected boolean canDefine_isParam(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public Program Define_program(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_program(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_program(self, _callerNode);
  }

  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Errors.jrag:29
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute program
   */
  protected boolean canDefine_program(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public Func Define_enclosingFunc(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_enclosingFunc(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_enclosingFunc(self, _callerNode);
  }

  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/FuncCall.jrag:7
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute enclosingFunc
   */
  protected boolean canDefine_enclosingFunc(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public String Define_indexString(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_indexString(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_indexString(self, _callerNode);
  }

  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:152
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute indexString
   */
  protected boolean canDefine_indexString(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public IdDecl Define_funcLookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_funcLookup(self, _callerNode, name)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_funcLookup(self, _callerNode, name);
  }

  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:38
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute funcLookup
   */
  protected boolean canDefine_funcLookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return false;
  }
  /** @apilevel internal */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_lookup(self, _callerNode, name)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_lookup(self, _callerNode, name);
  }

  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:31
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute lookup
   */
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return false;
  }
  /** @apilevel internal */
  public IdDecl Define_localLookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_localLookup(self, _callerNode, name)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_localLookup(self, _callerNode, name);
  }

  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:64
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute localLookup
   */
  protected boolean canDefine_localLookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return false;
  }
  /** @apilevel internal */
  public boolean Define_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_inExprOf(self, _callerNode, decl)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_inExprOf(self, _callerNode, decl);
  }

  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:86
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute inExprOf
   */
  protected boolean canDefine_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    return false;
  }
  /** @apilevel internal */
  public List<Func> Define_predefinedFunctions(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_predefinedFunctions(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_predefinedFunctions(self, _callerNode);
  }

  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/PredefinedFunctions.jrag:16
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute predefinedFunctions
   */
  protected boolean canDefine_predefinedFunctions(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public BoolType Define_boolType(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_boolType(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_boolType(self, _callerNode);
  }

  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:12
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute boolType
   */
  protected boolean canDefine_boolType(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public IntType Define_intType(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_intType(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_intType(self, _callerNode);
  }

  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:13
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute intType
   */
  protected boolean canDefine_intType(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public UnknownType Define_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_unknownType(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_unknownType(self, _callerNode);
  }

  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:14
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownType
   */
  protected boolean canDefine_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_expectedType(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_expectedType(self, _callerNode);
  }

  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:42
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute expectedType
   */
  protected boolean canDefine_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public Func Define_function(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_function(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_function(self, _callerNode);
  }

  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:48
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute function
   */
  protected boolean canDefine_function(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public UnknownDecl Define_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_unknownDecl(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_unknownDecl(self, _callerNode);
  }

  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/UnknownDecl.jrag:5
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownDecl
   */
  protected boolean canDefine_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public UnknownFunc Define_unknownFunc(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_unknownFunc(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_unknownFunc(self, _callerNode);
  }

  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/UnknownFunc.jrag:5
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownFunc
   */
  protected boolean canDefine_unknownFunc(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
public ASTNode rewrittenNode() { throw new Error("rewrittenNode is undefined for ASTNode"); }
}
