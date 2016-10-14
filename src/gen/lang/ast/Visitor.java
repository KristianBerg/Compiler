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
 * @ast interface
 * @aspect Visitor
 * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Visitor.jrag:6
 */
public interface Visitor {

		 
		public Object visit(List node, Object data);

		 
		public Object visit(Opt node, Object data);

		 
		public Object visit(Program node, Object data);

		 
		public Object visit(Func node, Object data);

		 
		public Object visit(Block node, Object data);

		 
		public Object visit(IdDecl node, Object data);

		 
		public Object visit(IdDeclStmt node, Object data);

		 
		public Object visit(IdDeclAss node, Object data);

		 
		public Object visit(Assign node, Object data);

		 
		public Object visit(ReturnStmt node, Object data);

		 
		public Object visit(WhileStmt node, Object data);

		 
		public Object visit(FuncStmt node, Object data);

		 
		public Object visit(IfStmt node, Object data);

		 
		public Object visit(ElseStmt node, Object data);

		 
		public Object visit(Equals node, Object data);

		 
		public Object visit(NotEquals node, Object data);

		 
		public Object visit(LessThan node, Object data);

		 
		public Object visit(LessEqual node, Object data);

		 
		public Object visit(GreaterThan node, Object data);

		 
		public Object visit(GreaterEqual node, Object data);

		 
		public Object visit(Add node, Object data);

		 
		public Object visit(Sub node, Object data);

		 
		public Object visit(Mul node, Object data);

		 
		public Object visit(Div node, Object data);

		 
		public Object visit(Mod node, Object data);

		 
		public Object visit(Numeral node, Object data);

		 
		public Object visit(IdUse node, Object data);

		 
		public Object visit(FuncUse node, Object data);
}
