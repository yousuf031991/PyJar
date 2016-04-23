// Generated from Hello.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
@SuppressWarnings("deprecation")
public interface NewListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#boolAssignment}.
	 * @param ctx the parse tree
	 */
	void enterBoolAssignment(@NotNull HelloParser.BoolAssignmentContext ctx);
	{
		if (ctx.BOOL() != null) {
			System.out.println("PUSH " + ctx.BOOL());
		}
	}
	/**
	 * Exit a parse tree produced by {@link HelloParser#boolAssignment}.
	 * @param ctx the parse tree
	 */
	void exitBoolAssignment(@NotNull HelloParser.BoolAssignmentContext ctx);
	{
		System.out.println("STORE " + ctx.IDENT());
	}
	/**
	 * Enter a parse tree produced by {@link HelloParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(@NotNull HelloParser.WhileLoopContext ctx);
	{
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
	 * Exit a parse tree produced by {@link HelloParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(@NotNull HelloParser.WhileLoopContext ctx);
	{
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
	 * Enter a parse tree produced by {@link HelloParser#compare}.
	 * @param ctx the parse tree
	 */
	void enterCompare(@NotNull HelloParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#compare}.
	 * @param ctx the parse tree
	 */
	void exitCompare(@NotNull HelloParser.CompareContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull HelloParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull HelloParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#stringCompare}.
	 * @param ctx the parse tree
	 */
	void enterStringCompare(@NotNull HelloParser.StringCompareContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#stringCompare}.
	 * @param ctx the parse tree
	 */
	void exitStringCompare(@NotNull HelloParser.StringCompareContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull HelloParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull HelloParser.StartContext ctx);
	{
		System.out.println("END");
	}
	/**
	 * Enter a parse tree produced by {@link HelloParser#voidcall}.
	 * @param ctx the parse tree
	 */
	void enterVoidcall(@NotNull HelloParser.VoidcallContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#voidcall}.
	 * @param ctx the parse tree
	 */
	void exitVoidcall(@NotNull HelloParser.VoidcallContext ctx);
	{
		System.out.println("PUSH " + ctx.IDENT());
		System.out.println("PRINT");
	}
	/**
	 * Enter a parse tree produced by {@link HelloParser#intCall}.
	 * @param ctx the parse tree
	 */
	void enterIntCall(@NotNull HelloParser.IntCallContext ctx);
	{
		System.out.println("READ STRING");
	}
	/**
	 * Exit a parse tree produced by {@link HelloParser#intCall}.
	 * @param ctx the parse tree
	 */
	void exitIntCall(@NotNull HelloParser.IntCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#strCall}.
	 * @param ctx the parse tree
	 */
	void enterStrCall(@NotNull HelloParser.StrCallContext ctx);
	{
		System.out.println("READ STRING");
	}
	/**
	 * Exit a parse tree produced by {@link HelloParser#strCall}.
	 * @param ctx the parse tree
	 */
	void exitStrCall(@NotNull HelloParser.StrCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#boolCall}.
	 * @param ctx the parse tree
	 */
	void enterBoolCall(@NotNull HelloParser.BoolCallContext ctx);
	{
		System.out.println("READ BOOLEAN");
	}
	/**
	 * Exit a parse tree produced by {@link HelloParser#boolCall}.
	 * @param ctx the parse tree
	 */
	void exitBoolCall(@NotNull HelloParser.BoolCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#intAssignment}.
	 * @param ctx the parse tree
	 */
	void enterIntAssignment(@NotNull HelloParser.IntAssignmentContext ctx);
	{
		if (ctx.INT() != null) {
			System.out.println("PUSH " + ctx.INT());
		}
	}
	/**
	 * Exit a parse tree produced by {@link HelloParser#intAssignment}.
	 * @param ctx the parse tree
	 */
	void exitIntAssignment(@NotNull HelloParser.IntAssignmentContext ctx);
	{
		System.out.println("STORE " + ctx.IDENT());
	}
	/**
	 * Enter a parse tree produced by {@link HelloParser#intOperation}.
	 * @param ctx the parse tree
	 */
	void enterIntOperation(@NotNull HelloParser.IntOperationContext ctx);
	{
		System.out.println("PUSH " + ctx.IDEN(0));
		System.out.println("PUSH " + ctx.IDEN(1));
	}
	/**
	 * Exit a parse tree produced by {@link HelloParser#intOperation}.
	 * @param ctx the parse tree
	 */
	void exitIntOperation(@NotNull HelloParser.IntOperationContext ctx);
	{
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
	 * Enter a parse tree produced by {@link HelloParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(@NotNull HelloParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(@NotNull HelloParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#strAssignment}.
	 * @param ctx the parse tree
	 */
	void enterStrAssignment(@NotNull HelloParser.StrAssignmentContext ctx);
	{
		if (ctx.STR() != null) {
			System.out.println("PUSH " + ctx.STR());
		}
	}
	/**
	 * Exit a parse tree produced by {@link HelloParser#strAssignment}.
	 * @param ctx the parse tree
	 */
	void exitStrAssignment(@NotNull HelloParser.StrAssignmentContext ctx);
	{
		System.out.println("STORE " + ctx.IDENT());
	}
	/**
	 * Enter a parse tree produced by {@link HelloParser#stringOperation}.
	 * @param ctx the parse tree
	 */
	void enterStringOperation(@NotNull HelloParser.StringOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#stringOperation}.
	 * @param ctx the parse tree
	 */
	void exitStringOperation(@NotNull HelloParser.StringOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#integerCompare}.
	 * @param ctx the parse tree
	 */
	void enterIntegerCompare(@NotNull HelloParser.IntegerCompareContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#integerCompare}.
	 * @param ctx the parse tree
	 */
	void exitIntegerCompare(@NotNull HelloParser.IntegerCompareContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#context}.
	 * @param ctx the parse tree
	 */
	void enterContext(@NotNull HelloParser.ContextContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#context}.
	 * @param ctx the parse tree
	 */
	void exitContext(@NotNull HelloParser.ContextContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#booleanOperation}.
	 * @param ctx the parse tree
	 */
	void enterBooleanOperation(@NotNull HelloParser.BooleanOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#booleanOperation}.
	 * @param ctx the parse tree
	 */
	void exitBooleanOperation(@NotNull HelloParser.BooleanOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(@NotNull HelloParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(@NotNull HelloParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#jump}.
	 * @param ctx the parse tree
	 */
	void enterJump(@NotNull HelloParser.JumpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#jump}.
	 * @param ctx the parse tree
	 */
	void exitJump(@NotNull HelloParser.JumpContext ctx);
}