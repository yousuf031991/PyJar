import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class HelloRunner {
	public static void main(String[] args) throws Exception {

		ANTLRInputStream input = new ANTLRInputStream(System.in);

		HelloLexer lexer = new HelloLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		HelloParser parser = new HelloParser(tokens);
		double tree = parser.eval().value; // begin parsing at rule 'r'
		// System.out.println(tree.toStringTree(parser)); // print LISP-style
		// tree
		System.out.println(tree);
		//5*5*5 on the console will give 125.0
	}
}