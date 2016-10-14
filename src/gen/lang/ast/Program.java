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
 * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/lang.ast:1
 * @production Program : {@link ASTNode} ::= <span class="component">{@link Func}*</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:2
   */
  private static int labelIndex = 0;
  /**
   * @aspect CodeGen
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:3
   */
  public static int nextLabelIndex(){
		return Program.labelIndex++;
	}
  /**
   * @aspect CodeGen
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:7
   */
  public void genCode(PrintStream out) {
		out.println(".global _start");
		out.println(".data");
		out.println("ask_message: .ascii \"Please enter a number: \"");
		out.println("ask_msg_len: .quad 23");
		out.println("buf: .skip 1024");
		out.println();
		out.println(".text");
		// etc.
		out.println("_start:");	
		// call main function
		out.println("        call main");
		// call sys_exit
		out.println("        movq $0, %rdi");
		out.println("        movq $60, %rax");
		out.println("        syscall");
		// program functions
		for (Func decl: getFuncList()) {
			decl.genCode(out);
		}
		// helper procedures (print/read)
		out.println("# Procedure to read number from stdin");
		out.println("# C signature: long int read(void)");
		out.println("read:");
		out.println("        pushq %rbp");
		out.println("        movq %rsp, %rbp");
		out.println("        movq $0, %rdi");
		out.println("        movq $buf, %rsi");
		out.println("        movq $1024, %rdx");
		out.println("        movq $0, %rax");
		out.println("        syscall                 # %rax = sys_read(0, buf, 1024)");
		out.println("        ### convert string to integer:");
		out.println("        ### %rax contains nchar");
		out.println("        ### %rsi contains ptr");
		out.println("        movq $0, %rdx           # sum = 0");
		out.println("atoi_loop:");
		out.println("        cmpq $0, %rax           # while (nchar > 0)");
		out.println("        jle atoi_done           # leave loop if nchar <= 0");
		out.println("        movzbq (%rsi), %rbx     # move byte, and sign extend to qword");
		out.println("        cmpq $0x30, %rbx        # test if < '0'");
		out.println("        jl atoi_done            # character is not numeric");
		out.println("        cmpq $0x39, %rbx        # test if > '9'");
		out.println("        jg atoi_done            # character is not numeric");
		out.println("        imulq $10, %rdx         # multiply sum by 10");
		out.println("        subq $0x30, %rbx        # value of character");
		out.println("        addq %rbx, %rdx         # add to sum");
		out.println("        incq %rsi               # step to next char");
		out.println("        decq %rax               # nchar--");
		out.println("        jmp atoi_loop           # loop back");
		out.println("atoi_done:");
		out.println("        movq %rdx, %rax         # return value in RAX");
		out.println("        popq %rbp");
		out.println("        ret");
		out.println();
		out.println("# Procedure to print number to stdout");
		out.println("# C signature: void print(long int)");
		out.println("print:");
		out.println("        pushq %rbp");
		out.println("        movq %rsp, %rbp");
		out.println("        ### convert integer to string");
		out.println("        movq 16(%rbp), %rax     # parameter");
		out.println("        movq $(buf+1023), %rsi  # write ptr (start from end of buf)");
		out.println("        movb $0x0a, (%rsi)      # insert newline");
		out.println("        movq $1, %rcx           # string length");
		out.println("itoa_loop:                      # do.. while (at least one iteration)");
		out.println("        movq $10, %rbx");
		out.println("        movq $0, %rdx");
		out.println("        idivq %rbx              # divide rdx:rax by 10");
		out.println("        addb $0x30, %dl         # remainder + '0'");
		out.println("        decq %rsi               # move string pointer");
		out.println("        movb %dl, (%rsi)");
		out.println("        incq %rcx               # increment string length");
		out.println("        cmpq $0, %rax");
		out.println("        jg itoa_loop            # produce more digits");
		out.println("itoa_done:");
		out.println("        movq $1, %rdi");
		out.println("        movq %rcx, %rdx");
		out.println("        movq $1, %rax");
		out.println("        syscall");
		out.println("        popq %rbp");
		out.println("        ret");
		out.println();
		out.println("print_string:");
		out.println("        pushq %rbp");
		out.println("        movq %rsp, %rbp");
		out.println("        movq $1, %rdi");
		out.println("        movq 16(%rbp), %rsi");
		out.println("        movq 24(%rbp), %rdx");
		out.println("        movq $1, %rax");
		out.println("        syscall");
		out.println("        popq %rbp");
		out.println("        ret");
	}
  /**
   * @aspect Interpreter
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:30
   */
  public void eval(){
		Func main = null;
		for(int i = 0; i < getNumFunc(); i++){
			Func f = getFunc(i);
			if (f.getFuncName().getID().equals("main")){
				main = f;
			}
		}
		if(main == null){
			throw new RuntimeException("main function undefined");
		}
		ActivationRecord ar = new ActivationRecord();
		main.eval(ar);
	}
  /**
   * @aspect Visitor
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Visitor.jrag:46
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public Program() {
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
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  public Program(List<Func> p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:18
   */
  protected int numChildren() {
    return 1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:22
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    predefinedFunctions_reset();
    boolType_reset();
    intType_reset();
    unknownType_reset();
    unknownDecl_reset();
    unknownFunc_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:32
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    Program_errors_visited = false;
    Program_errors_computed = false;
    
    Program_errors_value = null;
    contributorMap_Program_errors = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:46
   */
  public Program copy() {
    try {
      Program node = (Program) clone();
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
   * @declaredat ASTNode:65
   */
  @Deprecated
  public Program fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:75
   */
  public Program treeCopyNoTransform() {
    Program tree = (Program) copy();
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
   * @declaredat ASTNode:95
   */
  public Program treeCopy() {
    Program tree = (Program) copy();
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
   * @declaredat ASTNode:109
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Func list.
   * @param list The new list node to be used as the Func list.
   * @apilevel high-level
   */
  public void setFuncList(List<Func> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the Func list.
   * @return Number of children in the Func list.
   * @apilevel high-level
   */
  public int getNumFunc() {
    return getFuncList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Func list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Func list.
   * @apilevel low-level
   */
  public int getNumFuncNoTransform() {
    return getFuncListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Func list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Func list.
   * @apilevel high-level
   */
  public Func getFunc(int i) {
    return (Func) getFuncList().getChild(i);
  }
  /**
   * Check whether the Func list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasFunc() {
    return getFuncList().getNumChild() != 0;
  }
  /**
   * Append an element to the Func list.
   * @param node The element to append to the Func list.
   * @apilevel high-level
   */
  public void addFunc(Func node) {
    List<Func> list = (parent == null) ? getFuncListNoTransform() : getFuncList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addFuncNoTransform(Func node) {
    List<Func> list = getFuncListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Func list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setFunc(Func node, int i) {
    List<Func> list = getFuncList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Func list.
   * @return The node representing the Func list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Func")
  public List<Func> getFuncList() {
    List<Func> list = (List<Func>) getChild(0);
    return list;
  }
  /**
   * Retrieves the Func list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Func list.
   * @apilevel low-level
   */
  public List<Func> getFuncListNoTransform() {
    return (List<Func>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the Func list without
   * triggering rewrites.
   */
  public Func getFuncNoTransform(int i) {
    return (Func) getFuncListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Func list.
   * @return The node representing the Func list.
   * @apilevel high-level
   */
  public List<Func> getFuncs() {
    return getFuncList();
  }
  /**
   * Retrieves the Func list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Func list.
   * @apilevel low-level
   */
  public List<Func> getFuncsNoTransform() {
    return getFuncListNoTransform();
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Errors.jrag:26
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_Program_errors = null;

  protected void survey_Program_errors() {
    if (contributorMap_Program_errors == null) {
      contributorMap_Program_errors = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_Program_errors(this, contributorMap_Program_errors);
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
protected boolean predefinedFunctions_visited = false;
  /** @apilevel internal */
  private void predefinedFunctions_reset() {
    predefinedFunctions_computed = false;
    
    predefinedFunctions_value = null;
    predefinedFunctions_visited = false;
  }
  /** @apilevel internal */
  protected boolean predefinedFunctions_computed = false;

  /** @apilevel internal */
  protected List<Func> predefinedFunctions_value;

  /**
   * @attribute syn
   * @aspect PredefinedFunctions
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/PredefinedFunctions.jrag:3
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="PredefinedFunctions", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/PredefinedFunctions.jrag:3")
  public List<Func> predefinedFunctions() {
    ASTNode$State state = state();
    if (predefinedFunctions_computed) {
      return predefinedFunctions_value;
    }
    if (predefinedFunctions_visited) {
      throw new RuntimeException("Circular definition of attribute Program.predefinedFunctions().");
    }
    predefinedFunctions_visited = true;
    state().enterLazyAttribute();
    predefinedFunctions_value = predefinedFunctions_compute();
    predefinedFunctions_value.setParent(this);
    predefinedFunctions_computed = true;
    state().leaveLazyAttribute();
    predefinedFunctions_visited = false;
    return predefinedFunctions_value;
  }
  /** @apilevel internal */
  private List<Func> predefinedFunctions_compute() {
  		List<Func> list = new List<Func>();
  
  		// Create objects of type FunctionDecl and add them to the list
  		Func read = new Func(new IdDecl("read"), new List(), new Block());
  		list.add(read);
  		Func print = new Func(new IdDecl("print"), new List().add(new IdDecl("int text")), new Block());
  		list.add(print);
  		return list;
  	}
/** @apilevel internal */
protected boolean boolType_visited = false;
  /** @apilevel internal */
  private void boolType_reset() {
    boolType_computed = false;
    
    boolType_value = null;
    boolType_visited = false;
  }
  /** @apilevel internal */
  protected boolean boolType_computed = false;

  /** @apilevel internal */
  protected BoolType boolType_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:3
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:3")
  public BoolType boolType() {
    ASTNode$State state = state();
    if (boolType_computed) {
      return boolType_value;
    }
    if (boolType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.boolType().");
    }
    boolType_visited = true;
    state().enterLazyAttribute();
    boolType_value = new BoolType();
    boolType_value.setParent(this);
    boolType_computed = true;
    state().leaveLazyAttribute();
    boolType_visited = false;
    return boolType_value;
  }
/** @apilevel internal */
protected boolean intType_visited = false;
  /** @apilevel internal */
  private void intType_reset() {
    intType_computed = false;
    
    intType_value = null;
    intType_visited = false;
  }
  /** @apilevel internal */
  protected boolean intType_computed = false;

  /** @apilevel internal */
  protected IntType intType_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:4
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:4")
  public IntType intType() {
    ASTNode$State state = state();
    if (intType_computed) {
      return intType_value;
    }
    if (intType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.intType().");
    }
    intType_visited = true;
    state().enterLazyAttribute();
    intType_value = new IntType();
    intType_value.setParent(this);
    intType_computed = true;
    state().leaveLazyAttribute();
    intType_visited = false;
    return intType_value;
  }
/** @apilevel internal */
protected boolean unknownType_visited = false;
  /** @apilevel internal */
  private void unknownType_reset() {
    unknownType_computed = false;
    
    unknownType_value = null;
    unknownType_visited = false;
  }
  /** @apilevel internal */
  protected boolean unknownType_computed = false;

  /** @apilevel internal */
  protected UnknownType unknownType_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:5
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:5")
  public UnknownType unknownType() {
    ASTNode$State state = state();
    if (unknownType_computed) {
      return unknownType_value;
    }
    if (unknownType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unknownType().");
    }
    unknownType_visited = true;
    state().enterLazyAttribute();
    unknownType_value = new UnknownType();
    unknownType_value.setParent(this);
    unknownType_computed = true;
    state().leaveLazyAttribute();
    unknownType_visited = false;
    return unknownType_value;
  }
/** @apilevel internal */
protected boolean unknownDecl_visited = false;
  /** @apilevel internal */
  private void unknownDecl_reset() {
    unknownDecl_computed = false;
    
    unknownDecl_value = null;
    unknownDecl_visited = false;
  }
  /** @apilevel internal */
  protected boolean unknownDecl_computed = false;

  /** @apilevel internal */
  protected UnknownDecl unknownDecl_value;

  /**
   * @attribute syn
   * @aspect UnknownDecl
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/UnknownDecl.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/UnknownDecl.jrag:2")
  public UnknownDecl unknownDecl() {
    ASTNode$State state = state();
    if (unknownDecl_computed) {
      return unknownDecl_value;
    }
    if (unknownDecl_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unknownDecl().");
    }
    unknownDecl_visited = true;
    state().enterLazyAttribute();
    unknownDecl_value = unknownDecl_compute();
    unknownDecl_value.setParent(this);
    unknownDecl_computed = true;
    state().leaveLazyAttribute();
    unknownDecl_visited = false;
    return unknownDecl_value;
  }
  /** @apilevel internal */
  private UnknownDecl unknownDecl_compute() { return new UnknownDecl();}
/** @apilevel internal */
protected boolean unknownFunc_visited = false;
  /** @apilevel internal */
  private void unknownFunc_reset() {
    unknownFunc_computed = false;
    
    unknownFunc_value = null;
    unknownFunc_visited = false;
  }
  /** @apilevel internal */
  protected boolean unknownFunc_computed = false;

  /** @apilevel internal */
  protected UnknownFunc unknownFunc_value;

  /**
   * @attribute syn
   * @aspect UnknownFunc
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/UnknownFunc.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="UnknownFunc", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/UnknownFunc.jrag:2")
  public UnknownFunc unknownFunc() {
    ASTNode$State state = state();
    if (unknownFunc_computed) {
      return unknownFunc_value;
    }
    if (unknownFunc_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unknownFunc().");
    }
    unknownFunc_visited = true;
    state().enterLazyAttribute();
    unknownFunc_value = unknownFunc_compute();
    unknownFunc_value.setParent(this);
    unknownFunc_computed = true;
    state().leaveLazyAttribute();
    unknownFunc_visited = false;
    return unknownFunc_value;
  }
  /** @apilevel internal */
  private UnknownFunc unknownFunc_compute() { return new UnknownFunc();}
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/CodeGen.jrag:286
   * @apilevel internal
   */
  public boolean Define_isParam(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  protected boolean canDefine_isParam(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Errors.jrag:28
   * @apilevel internal
   */
  public Program Define_program(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return this;
  }
  protected boolean canDefine_program(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/FuncCall.jrag:4
   * @apilevel internal
   */
  public Func Define_enclosingFunc(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownFunc();
  }
  protected boolean canDefine_enclosingFunc(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:147
   * @apilevel internal
   */
  public String Define_indexString(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    {
    		return "";
    	}
  }
  protected boolean canDefine_indexString(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:8
   * @apilevel internal
   */
  public IdDecl Define_funcLookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    int childIndex = this.getIndexOfChild(_callerNode);
    {
    		unknownDecl();
    		for(Func i: predefinedFunctions()){
    			if(i.getFuncName().getID().equals(name)){
    				return i.getFuncName();
    			}
    		}
    		for(int i = 0; i < getNumFunc(); i++){
    			if(getFunc(i).getFuncName().getID().equals(name)){
    				return getFunc(i).getFuncName();
    			}
    		}
    		return unknownDecl();
    	}
  }
  protected boolean canDefine_funcLookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:3
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownDecl();
  }
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:6
   * @apilevel internal
   */
  public IdDecl Define_localLookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownDecl();
  }
  protected boolean canDefine_localLookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/NameAnalysis.jrag:85
   * @apilevel internal
   */
  public boolean Define_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  protected boolean canDefine_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    return true;
  }
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/PredefinedFunctions.jrag:15
   * @apilevel internal
   */
  public List<Func> Define_predefinedFunctions(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return predefinedFunctions();
  }
  protected boolean canDefine_predefinedFunctions(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:8
   * @apilevel internal
   */
  public BoolType Define_boolType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return boolType();
  }
  protected boolean canDefine_boolType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:9
   * @apilevel internal
   */
  public IntType Define_intType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return intType();
  }
  protected boolean canDefine_intType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:10
   * @apilevel internal
   */
  public UnknownType Define_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownType();
  }
  protected boolean canDefine_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
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
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/TypeAnalysis.jrag:47
   * @apilevel internal
   */
  public Func Define_function(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return null;
  }
  protected boolean canDefine_function(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/UnknownDecl.jrag:4
   * @apilevel internal
   */
  public UnknownDecl Define_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownDecl();
  }
  protected boolean canDefine_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/UnknownFunc.jrag:4
   * @apilevel internal
   */
  public UnknownFunc Define_unknownFunc(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownFunc();
  }
  protected boolean canDefine_unknownFunc(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
/** @apilevel internal */
protected boolean Program_errors_visited = false;
  /**
   * @attribute coll
   * @aspect Errors
   * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Errors.jrag:26
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="Errors", declaredAt="/h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Errors.jrag:26")
  public Set<ErrorMessage> errors() {
    ASTNode$State state = state();
    if (Program_errors_computed) {
      return Program_errors_value;
    }
    if (Program_errors_visited) {
      throw new RuntimeException("Circular definition of attribute Program.errors().");
    }
    Program_errors_visited = true;
    state().enterLazyAttribute();
    Program_errors_value = errors_compute();
    Program_errors_computed = true;
    state().leaveLazyAttribute();
    Program_errors_visited = false;
    return Program_errors_value;
  }
  /** @apilevel internal */
  private Set<ErrorMessage> errors_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof Program)) {
      node = node.getParent();
    }
    Program root = (Program) node;
    root.survey_Program_errors();
    Set<ErrorMessage> _computedValue = new TreeSet<ErrorMessage>();
    if (root.contributorMap_Program_errors.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_Program_errors.get(this)) {
        contributor.contributeTo_Program_errors(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected boolean Program_errors_computed = false;

  /** @apilevel internal */
  protected Set<ErrorMessage> Program_errors_value;

}
