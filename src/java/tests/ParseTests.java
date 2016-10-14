package tests;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class ParseTests extends AbstractTestSuite {
	public ParseTests() {
		super("testfiles/parser");// where test input files are
	}

	@Test
	public void funcs() {
		testValidSyntax("funcs.simplic");
	}

	@Test
	public void error() {
		testSyntaxError("error.simplic");
	}

	@Test
	public void vars() {
		testValidSyntax("vars.simplic");
	}

	@Test 
	public void Add() {
		testValidSyntax("add.simplic");
	}
	
	@Test
	public void Arithmetic() {
		testValidSyntax("arithmetic.simplic");
	}

	@Test
	public void Conditionals() {
		testValidSyntax("conditionals.simplic");
		testSyntaxError("condError.simplic");
	}

	@Test
	public void returnStmt() {
		testValidSyntax("return.simplic");
	}

	@Test
	public void readFunc() {
		testValidSyntax("read.simplic");
	}

	@Test
	public void stmtTypes() {
		testValidSyntax("stmtTypes.simplic");
	}

	@Test
	public void comments() {
		testValidSyntax("comments.simplic");
	}
	
	@Test
	public void example() {
		testValidSyntax("example.simplic");
	}
}
