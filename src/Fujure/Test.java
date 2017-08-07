package Fujure;
import Fujure.*;
import Fujure.Absyn.*;
import java.io.*;
import java_cup.runtime.*;

public class Test
{
  Yylex l;
  parser p;
  
  public Test(String[] args)
  {
    try
    {
      Reader input;
      if (args.length == 0)input = new InputStreamReader(System.in);
      else input = new FileReader(args[0]);
      l = new Yylex(input);
    }
    catch(IOException e)
    {
      System.err.println("Error: File not found: " + args[0]);
      System.exit(1);
    }
    p = new parser(l);
  }
  
  public Fujure.Absyn.ValueDef parse() throws Exception
  {
    /* The default parser is the first-defined entry point. */
    /* Other options are: */
    /* not available. */
    Fujure.Absyn.ValueDef ast = p.pValueDef();
    System.out.println();
    System.out.println("Parse Succesful!");
    System.out.println();
    System.out.println("[Abstract Syntax]");
    System.out.println();
    System.out.println(PrettyPrinter.show(ast));
    System.out.println();
    System.out.println("[Linearized Tree]");
    System.out.println();
    System.out.println(PrettyPrinter.print(ast));
    return ast;
  }
  
  public static void main(String args[]) throws Exception
  {
    Test t = new Test(args);
    try
    {
      t.parse();
    }
    catch(Throwable e)
    {
      System.err.println("At line " + String.valueOf(t.l.line_num()) + ", near \"" + t.l.buff() + "\" :");
      System.err.println("     " + e.getMessage());
      System.exit(1);
    }
  }
}