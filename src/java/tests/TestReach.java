package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lang.ast.ErrorMessage;
import lang.ast.Program;
import lang.ast.Func;
import java.io.*;

/**
 * Tests name analysis
 */
@RunWith(Parameterized.class)
public class TestReach extends AbstractParameterizedTest{
	/**
	 * Directory where test files live
	 */
	private static final String TEST_DIR = "testfiles/reach";

	/**
	 * Construct a new JastAdd test
	 * @param testFile filename of test input file
	 */
	public TestReach(String testFile) {
		super(TEST_DIR, testFile);
	}

	/**
	 * Run the JastAdd test
	 */
	@Test
	public void runTest() throws Exception {
		PrintStream out = System.out;
		try{
			Program program = (Program) parse(inFile);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			System.setOut(new PrintStream(baos));
			for(int i = 0; i < program.getNumFunc(); i++){
				Func func = program.getFunc(i);
				System.out.println(func.getFuncName().getID() + " reaches:");
				for(Func f: func.reachable()){
					System.out.println(f.getFuncName().getID());
				}
			}
			compareOutput(baos.toString(), outFile, expectedFile);
		} finally {
			System.setOut(out);
		}
	}

	@SuppressWarnings("javadoc")
	@Parameters(name = "{0}")
	public static Iterable<Object[]> getTests() {
		return getTestParameters(TEST_DIR);
	}
}
