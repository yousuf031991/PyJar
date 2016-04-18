import java.io.FileInputStream;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class HelloRunner {
	public static void main(String[] args) throws Exception {
		InputStream is;
		FileInputStream fis = new FileInputStream("..\\example");		
		ANTLRInputStream input = new ANTLRInputStream(fis);

		HelloLexer lexer = new HelloLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		HelloParser parser = new HelloParser(tokens);
		ParseTree tree = parser.start(); // begin parsing at rule 'r'
		// System.out.println(tree.toStringTree(parser)); // print LISP-style
		// tree
		System.out.println(tree);
		//5*5*5 on the console will give 125.0
	}
}