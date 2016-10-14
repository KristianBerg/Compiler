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
 * @declaredat /h/d5/m/ine13kbe/edan65/A6/simplicAST/src/jastadd/Interpreter.jrag:5
 */
public class ActivationRecord extends java.lang.Object {
  
		private HashMap<String, Integer> table;

  
	
		public ActivationRecord (){
			table = new HashMap<String, Integer>();
		}

  
		public void put(String s, Integer i){
			table.put(s, i);
		}

  

		public Integer get(String s){
			return table.get(s);
		}


}
