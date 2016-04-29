import java.io.FileInputStream;
import java.io.PrintWriter;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class HelloRunner {
	public static void main(String[] args) throws Exception {	
		//Please specify the input filename as an argument when running this file
		FileInputStream fis = new FileInputStream(args[0]);		
		ANTLRInputStream input = new ANTLRInputStream(fis);

		HelloLexer lexer = new HelloLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		HelloParser parser = new HelloParser(tokens);		
		ParserRuleContext tree = parser.start();
		// print LISP-style tree in file parseTree.pt
		try {
			PrintWriter writer = new PrintWriter("parseTree.pt", "UTF-8");
			writer.println(tree);	
			writer.println(tree.toStringTree(parser));			
			writer.close();
		} catch (Exception e) {
			System.out.println("Cannot write to the file \n\n\n\n"
					+ e.toString());
		}			
		ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
		NewListener extractor = new NewListener();
		walker.walk(extractor, tree); // initiate walk of tree with listener
		// print the output in the file output.bjav
		try {
			PrintWriter writer = new PrintWriter("intermediate.pyj", "UTF-8");
			for (int i = 1; i < extractor.op.size(); i++) {
				writer.println(extractor.op.get(i));
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("Cannot write to the file \n\n\n\n"
					+ e.toString());
		}		
	}
}