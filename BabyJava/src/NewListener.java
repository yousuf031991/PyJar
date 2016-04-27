// Generated from Hello.g4 by ANTLR 4.5.3

import java.util.ArrayList;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link HelloListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class NewListener implements HelloListener {
	ArrayList<String> op = new ArrayList<String>();
	Stack<Integer> whileStart = new Stack<Integer>();
	Stack<Integer> whileCond = new Stack<Integer>();
	Stack<Integer> ifElseCount = new Stack<Integer>();
	Stack<Integer> ifElseEnd = new Stack<Integer>();
	Stack<Integer> ifElseCond = new Stack<Integer>();
	
	
	int line_no = 1;
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStart(HelloParser.StartContext ctx) {		
		op.add("");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStart(HelloParser.StartContext ctx) {
		op.add("END");
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
	@Override public void enterVoidcall(HelloParser.VoidcallContext ctx) {
		line_no++;
		op.add("PUSH " + ctx.IDENT());
		line_no++;
		op.add("PRINT");
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
	@Override public void enterReadCall(HelloParser.ReadCallContext ctx) {
		line_no++;		
		op.add("READ");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitReadCall(HelloParser.ReadCallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFunctionDeclaration(HelloParser.FunctionDeclarationContext ctx) {
		line_no++; 
		op.add("FUNC " + ctx.IDENT());
		if(ctx.argumentsDefinition().IDENT()!=null){
			for(Object m:ctx.argumentsDefinition().IDENT()){
				line_no++;
				op.add("STORE " + m);
			}
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFunctionDeclaration(HelloParser.FunctionDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArgumentsDefinition(HelloParser.ArgumentsDefinitionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArgumentsDefinition(HelloParser.ArgumentsDefinitionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFunctionBody(HelloParser.FunctionBodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFunctionBody(HelloParser.FunctionBodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFunctionCall(HelloParser.FunctionCallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFunctionCall(HelloParser.FunctionCallContext ctx) {
		line_no++;
		op.add("CALL " + ctx.IDENT() );
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterParametersDefinition(HelloParser.ParametersDefinitionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitParametersDefinition(HelloParser.ParametersDefinitionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */	
	@Override public void enterDataType(HelloParser.DataTypeContext ctx) { 
		if(ctx.INT()!=null){
			line_no++;
			op.add("PUSH " + ctx.INT());
		}else if(ctx.BOOL()!=null){
			line_no++;
			op.add("PUSH " + ctx.BOOL());
		}else{
			line_no++;
			op.add("PUSH " + ctx.IDENT());
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDataType(HelloParser.DataTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */	
	@Override public void enterFunctionReturn(HelloParser.FunctionReturnContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFunctionReturn(HelloParser.FunctionReturnContext ctx) {
		if(ctx.IDENT() != null){
			line_no++;
			op.add("RET " + ctx.IDENT());
		}else if(ctx.INT() != null){
			line_no++;
			op.add("RET " + ctx.INT());
		}else if(ctx.BOOL() != null){
			line_no++;
			op.add("RET " + ctx.BOOL());
		} else{
			line_no++;
			op.add("STORE tempVar");
			line_no++;
			op.add("RET tempVar");
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */	
	@Override public void enterStackDeclaration(HelloParser.StackDeclarationContext ctx) {
		line_no++;
		op.add("STACK " +ctx.IDENT());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStackDeclaration(HelloParser.StackDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStackOps(HelloParser.StackOpsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStackOps(HelloParser.StackOpsContext ctx) {
		if(ctx.stackFuncs().stackPop() != null ){
			line_no++;
			op.add("STACKPOP " + ctx.IDENT());
		} else if(ctx.stackFuncs().stackPush() != null ){
			line_no++;
			op.add("STACKPUSH " + ctx.IDENT());
		} else{
			line_no++;
			op.add("STACKISEMPTY " + ctx.IDENT());
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStackFuncs(HelloParser.StackFuncsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStackFuncs(HelloParser.StackFuncsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStackPush(HelloParser.StackPushContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStackPush(HelloParser.StackPushContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStackPop(HelloParser.StackPopContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStackPop(HelloParser.StackPopContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStackIsEmpty(HelloParser.StackIsEmptyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStackIsEmpty(HelloParser.StackIsEmptyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIfelse(HelloParser.IfelseContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIfelse(HelloParser.IfelseContext ctx) {
		Integer count = ifElseCount.pop();
		for(int i=0;i<count;i++){
			Integer pos = ifElseEnd.pop();
			String prev = op.get(pos);
			prev += " " + (line_no);
			op.set(pos, prev);			
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override public void enterIfStatement(HelloParser.IfStatementContext ctx) {
    	ifElseCount.push(1);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitIfStatement(HelloParser.IfStatementContext ctx) {
    	line_no++;
		op.add("PUSH True");		
		op.add("TESTTGOTO");
		ifElseEnd.add(line_no);		
		Integer pos = ifElseCond.pop();
		String prev = op.get(pos);
		prev += " " + (line_no + 1);
		op.set(pos, prev);
		line_no++;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */	
	@Override public void enterPrefixIf(HelloParser.PrefixIfContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPrefixIf(HelloParser.PrefixIfContext ctx) {		
		op.add("TESTFGOTO");
		ifElseCond.push(line_no);		
		line_no++;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override public void enterElseIfStatement(HelloParser.ElseIfStatementContext ctx) {
    	Integer cur = ifElseCount.pop();
    	ifElseCount.push(1 + cur);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitElseIfStatement(HelloParser.ElseIfStatementContext ctx) {
    	line_no++;
		op.add("PUSH True");		
		ifElseEnd.add(line_no);
		op.add("TESTTGOTO");
		Integer pos = ifElseCond.pop();
		String prev = op.get(pos);
		prev += " " + (line_no + 1);
		op.set(pos, prev);
		line_no++;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */	
	@Override public void enterPrefixElseIf(HelloParser.PrefixElseIfContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPrefixElseIf(HelloParser.PrefixElseIfContext ctx) {		
		op.add("TESTFGOTO");
		ifElseCond.push(line_no);
		line_no++;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override public void enterElseStatement(HelloParser.ElseStatementContext ctx) {
    	
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitElseStatement(HelloParser.ElseStatementContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */	
	@Override public void enterPrefixElse(HelloParser.PrefixElseContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPrefixElse(HelloParser.PrefixElseContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */	
	@Override public void enterPrefixContext(HelloParser.PrefixContextContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPrefixContext(HelloParser.PrefixContextContext ctx) {	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */	
	@Override public void enterWhileLoop(HelloParser.WhileLoopContext ctx) {
		whileStart.push(line_no);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWhileLoop(HelloParser.WhileLoopContext ctx) {
		line_no++;
		op.add("PUSH True");		
		op.add("TESTTGOTO " + whileStart.pop());
		Integer pos = whileCond.pop();
		String prev = op.get(pos);
		prev += " " + (line_no + 1);
		op.set(pos, prev);
		line_no++;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterWhilePrefix(HelloParser.WhilePrefixContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWhilePrefix(HelloParser.WhilePrefixContext ctx) {		
		whileCond.push(line_no);
		op.add("TESTFGOTO");
		line_no++;
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
	@Override public void exitAssignment(HelloParser.AssignmentContext ctx) {
		line_no++;
		op.add("STORE " + ctx.IDENT());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpression(HelloParser.ExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpression(HelloParser.ExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override public void enterSubExpression(HelloParser.SubExpressionContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public String checkAddOp(HelloParser.SubExpressionContext ctx){
		String a="";
		switch(ctx.ADDOP().toString()){
			case "+":
				a = "ADD";
				break;
			case "-":
				a = "SUBTRACT";
				break;						
		}
		return a;
	}
    @Override public void exitSubExpression(HelloParser.SubExpressionContext ctx) {
    	line_no++;
    	op.add(checkAddOp(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */	
	@Override public void enterTerm(HelloParser.TermContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTerm(HelloParser.TermContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSubTerm(HelloParser.SubTermContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	public String checkMulOp(HelloParser.SubTermContext ctx){
		String a="";
		switch(ctx.MULOP().toString()){
			case "*":
				a = "MULTIPLY";
				break;
			case "/":
				a = "DIVIDE";
				break;
			case "%":
				a = "MODULUS";
				break;
			
		}
		return a;
	}
	
	@Override public void exitSubTerm(HelloParser.SubTermContext ctx) {
		line_no++;
		op.add(checkMulOp(ctx));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFactor(HelloParser.FactorContext ctx) {
		if(ctx.IDENT()!=null){
			line_no++;
			op.add("PUSH "+ctx.IDENT());
		} else if(ctx.INT()!=null){
			line_no++;
			op.add("PUSH "+ctx.INT());
		}		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFactor(HelloParser.FactorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override public void enterBoolExpression(HelloParser.BoolExpressionContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitBoolExpression(HelloParser.BoolExpressionContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterBoolSubExpression(HelloParser.BoolSubExpressionContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitBoolSubExpression(HelloParser.BoolSubExpressionContext ctx) {
    	if(ctx.BOOLOR() != null){
    		line_no++;
    		op.add("OR");
    	}
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterBoolTerm(HelloParser.BoolTermContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitBoolTerm(HelloParser.BoolTermContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterSubBoolTerm(HelloParser.SubBoolTermContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitSubBoolTerm(HelloParser.SubBoolTermContext ctx) {
    	if(ctx.BOOLAND() != null){
    		line_no++;
    		op.add("AND");
    	}
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterBoolFactor(HelloParser.BoolFactorContext ctx) {
    	if(ctx.IDENT() != null){
			line_no++;
			op.add("PUSH " + ctx.IDENT());
		} else if(ctx.BOOL() != null){
			line_no++;
			op.add("PUSH " + ctx.BOOL());
		}	
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitBoolFactor(HelloParser.BoolFactorContext ctx) { }
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
	@Override public void exitIntegerCompare(HelloParser.IntegerCompareContext ctx) {
		switch(ctx.INTCOMP().toString()){
			case ">":
				line_no++;
				op.add("GREATER");
				break;
			case "<":
				line_no++;
				op.add("LESSER");
				break;
			case ">=":
				line_no++;
				op.add("GREATEREQUAL");
				break;
			case "<=":
				line_no++;
				op.add("LESSEREQUAL");
				break;
			case "==":
				line_no++;
				op.add("EQUALS");
				break;	
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override public void enterBoolCompare(HelloParser.BoolCompareContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitBoolCompare(HelloParser.BoolCompareContext ctx) {
    	line_no++;
    	op.add("EQUALS");
    }
 
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