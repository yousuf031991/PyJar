import java.io.FileInputStream;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.ParserRuleContext;

public class HelloRunner {
	public static void main(String[] args) throws Exception {
		InputStream is;
		FileInputStream fis = new FileInputStream("example");//("C:\\Users\\DELL\\git\\BabyJava2\\BabyJava\\src\\example");		
		ANTLRInputStream input = new ANTLRInputStream(fis);//(System.in);

		HelloLexer lexer = new HelloLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		HelloParser parser = new HelloParser(tokens);
		//ParseTree tree = parser.start(); // begin parsing at rule 'r'
		ParserRuleContext tree = parser.start();
		// System.out.println(tree.toStringTree(parser)); // print LISP-style
		// tree
		System.out.println(tree);
		//5*5*5 on the console will give 125.0
		System.out.println(tree.toStringTree(parser));
		
		ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
		NewListener extractor = new NewListener();
		walker.walk(extractor, tree); // initiate walk of tree with listener
		System.out.println();
		//System.out.println(extractor.rewriter.getText());
		
	
	}
}