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
 * @ast class
 * @aspect Interpreter
 * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:20
 */
public class ReturnException extends RuntimeException {
  
		private int i;

  
		public ReturnException(int i){
			this.i = i;
		}

  
		public int getValue(){
			return i;
		}


}
