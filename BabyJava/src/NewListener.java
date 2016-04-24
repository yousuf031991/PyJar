

// Generated from Hello.g4 by ANTLR 4.5.3

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link HelloListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class NewListener extends HelloBaseListener {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStart(HelloParser.StartContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStart(HelloParser.StartContext ctx) { 

		System.out.println("END");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterContext(HelloParser.ContextContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitContext(HelloParser.ContextContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCall(HelloParser.CallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCall(HelloParser.CallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVoidcall(HelloParser.VoidcallContext ctx) { 

		System.out.println("PUSH " + ctx.IDENT());
		System.out.println("PRINT");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVoidcall(HelloParser.VoidcallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIntCall(HelloParser.IntCallContext ctx) {

		System.out.println("READ INT");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIntCall(HelloParser.IntCallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStrCall(HelloParser.StrCallContext ctx) {

		System.out.println("READ STRING");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStrCall(HelloParser.StrCallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBoolCall(HelloParser.BoolCallContext ctx) {

		System.out.println("READ BOOLEAN");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBoolCall(HelloParser.BoolCallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterJump(HelloParser.JumpContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitJump(HelloParser.JumpContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterWhileLoop(HelloParser.WhileLoopContext ctx) {
		if (ctx.integerCompare() != null) 
		{
			System.out.println("PUSH " + ctx.integerCompare().IDENT(0));
			System.out.println("PUSH " + ctx.integerCompare().IDENT(1));
			switch (ctx.integerCompare().INTCOMP().toString()) 
			{
				case ">":
					System.out.println("GREATER");
					break;
			}
		}
		System.out.println("testfgoto 22");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWhileLoop(HelloParser.WhileLoopContext ctx) {
		if (ctx.integerCompare() != null) 
		{
			System.out.println("push " + ctx.integerCompare().IDENT(0));
			System.out.println("push " + ctx.integerCompare().IDENT(1));
			switch (ctx.integerCompare().INTCOMP().toString()) 
			{
				case ">":
					System.out.println("greater");
					break;
			}
		}
		System.out.println("testtgoto 10");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAssignment(HelloParser.AssignmentContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAssignment(HelloParser.AssignmentContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIntAssignment(HelloParser.IntAssignmentContext ctx) {

		if (ctx.INT() != null) {
			System.out.println("PUSH " + ctx.INT());
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIntAssignment(HelloParser.IntAssignmentContext ctx) {

		System.out.println("STORE " + ctx.IDENT());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStrAssignment(HelloParser.StrAssignmentContext ctx) { 

		if (ctx.STR() != null) {
			System.out.println("PUSH " + ctx.STR());
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStrAssignment(HelloParser.StrAssignmentContext ctx) {

		System.out.println("STORE " + ctx.IDENT());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBoolAssignment(HelloParser.BoolAssignmentContext ctx) { 
		if (ctx.BOOL() != null) {
			System.out.println("PUSH " + ctx.BOOL());
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBoolAssignment(HelloParser.BoolAssignmentContext ctx) { 

		System.out.println("STORE " + ctx.IDENT());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterOperation(HelloParser.OperationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitOperation(HelloParser.OperationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIntOperation(HelloParser.IntOperationContext ctx) { 

		System.out.println("PUSH " + ctx.IDENT(0));
		System.out.println("PUSH " + ctx.IDENT(1));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIntOperation(HelloParser.IntOperationContext ctx) {
		switch (ctx.INTOP().toString()) {
		case "*":
			System.out.println("MULTIPLY");
			break;
		case "-":
			System.out.println("MINUS");
			break;
		case "+":
			System.out.println("ADD");
			break;
		default:
			System.out.println("NO SUCH OPERATOR " + ctx.INTOP());
	}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStringOperation(HelloParser.StringOperationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStringOperation(HelloParser.StringOperationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBooleanOperation(HelloParser.BooleanOperationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBooleanOperation(HelloParser.BooleanOperationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCompare(HelloParser.CompareContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCompare(HelloParser.CompareContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIntegerCompare(HelloParser.IntegerCompareContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIntegerCompare(HelloParser.IntegerCompareContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStringCompare(HelloParser.StringCompareContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStringCompare(HelloParser.StringCompareContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }
}

