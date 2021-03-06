package lang.ast; // The generated scanner will belong to the package lang.ast

import lang.ast.LangParser.Terminals; // The terminals are implicitly defined in the parser
import lang.ast.LangParser.SyntaxError;

%%

// define the signature for the generated scanner
%public
%final
%class LangScanner
%extends beaver.Scanner

// the interface between the scanner and the parser is the nextToken() method
%type beaver.Symbol 
%function nextToken 

// store line and column information in the tokens
%line
%column

// this code will be inlined in the body of the generated scanner class
%{
  private beaver.Symbol sym(short id) {
    return new beaver.Symbol(id, yyline + 1, yycolumn + 1, yylength(), yytext());
  }
%}

// macros
Comment = "//"[^\n\r]*(\n(\r)?)?
WhiteSpace = [ ] | \t | \f | \n | \r
ID = [a-zA-Z][a-zA-Z0-9]*
NUM = [0-9]+

%%

// discard whitespace information and comments
{Comment}     { }
{WhiteSpace}  { }

// token definitions
"int"		{ return sym(Terminals.INT); }
"return"	{ return sym(Terminals.RETURN); }
"while"		{ return sym(Terminals.WHILE); }
"if"		{ return sym(Terminals.IF); }
"else"		{ return sym(Terminals.ELSE); }

"("		{ return sym(Terminals.LPAR); }
")"		{ return sym(Terminals.RPAR); }
"{"		{ return sym(Terminals.LBRA); }
"}"		{ return sym(Terminals.RBRA); }
"="		{ return sym(Terminals.ASSIGN); }
";"		{ return sym(Terminals.SC); }
","		{ return sym(Terminals.COMMA); }
"+"		{ return sym(Terminals.PLUS); }
"-"		{ return sym(Terminals.MINUS); }
"*"		{ return sym(Terminals.MUL); }
"/"		{ return sym(Terminals.DIV); }
"%"		{ return sym(Terminals.MOD); }

"=="		{ return sym(Terminals.EQ); }
"!="		{ return sym(Terminals.NE); }
"<"		{ return sym(Terminals.LT); }
"<="		{ return sym(Terminals.LE); }
">"		{ return sym(Terminals.GT); }
">="		{ return sym(Terminals.GE); }

{NUM}		{ return sym(Terminals.NUM); }
{ID}          { return sym(Terminals.ID); }
<<EOF>>       { return sym(Terminals.EOF); }

/* error fallback */
[^]           { throw new SyntaxError("Illegal character <"+yytext()+">"); }
