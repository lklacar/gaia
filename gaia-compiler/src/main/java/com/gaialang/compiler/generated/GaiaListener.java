// Generated from /Users/lukaklacar/Projects/gaia/gaia-compiler/Gaia.g4 by ANTLR 4.9.1
package com.gaialang.compiler.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GaiaParser}.
 */
public interface GaiaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GaiaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GaiaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GaiaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GaiaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GaiaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GaiaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GaiaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GaiaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GaiaParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(GaiaParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GaiaParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(GaiaParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GaiaParser#functionParameters}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameters(GaiaParser.FunctionParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link GaiaParser#functionParameters}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameters(GaiaParser.FunctionParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link GaiaParser#variableDefinitionStatement}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinitionStatement(GaiaParser.VariableDefinitionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GaiaParser#variableDefinitionStatement}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinitionStatement(GaiaParser.VariableDefinitionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GaiaParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(GaiaParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GaiaParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(GaiaParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GaiaParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(GaiaParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GaiaParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(GaiaParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GaiaParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(GaiaParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GaiaParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(GaiaParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GaiaParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(GaiaParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GaiaParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(GaiaParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GaiaParser#ifBody}.
	 * @param ctx the parse tree
	 */
	void enterIfBody(GaiaParser.IfBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GaiaParser#ifBody}.
	 * @param ctx the parse tree
	 */
	void exitIfBody(GaiaParser.IfBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GaiaParser#whileBody}.
	 * @param ctx the parse tree
	 */
	void enterWhileBody(GaiaParser.WhileBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GaiaParser#whileBody}.
	 * @param ctx the parse tree
	 */
	void exitWhileBody(GaiaParser.WhileBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GaiaParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(GaiaParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GaiaParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(GaiaParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GaiaParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(GaiaParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GaiaParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(GaiaParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionDiv}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionDiv(GaiaParser.ExpressionDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionDiv}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionDiv(GaiaParser.ExpressionDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionAdd}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAdd(GaiaParser.ExpressionAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionAdd}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAdd(GaiaParser.ExpressionAddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionSub}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionSub(GaiaParser.ExpressionSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionSub}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionSub(GaiaParser.ExpressionSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionLessThan}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionLessThan(GaiaParser.ExpressionLessThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionLessThan}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionLessThan(GaiaParser.ExpressionLessThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionEquals}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionEquals(GaiaParser.ExpressionEqualsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionEquals}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionEquals(GaiaParser.ExpressionEqualsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionMod}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionMod(GaiaParser.ExpressionModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionMod}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionMod(GaiaParser.ExpressionModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionMul}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionMul(GaiaParser.ExpressionMulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionMul}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionMul(GaiaParser.ExpressionMulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionNumber}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionNumber(GaiaParser.ExpressionNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionNumber}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionNumber(GaiaParser.ExpressionNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionFunctionCall}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionFunctionCall(GaiaParser.ExpressionFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionFunctionCall}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionFunctionCall(GaiaParser.ExpressionFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionNested}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionNested(GaiaParser.ExpressionNestedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionNested}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionNested(GaiaParser.ExpressionNestedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionNegate}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionNegate(GaiaParser.ExpressionNegateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionNegate}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionNegate(GaiaParser.ExpressionNegateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionGreaterThan}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionGreaterThan(GaiaParser.ExpressionGreaterThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionGreaterThan}
	 * labeled alternative in {@link GaiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionGreaterThan(GaiaParser.ExpressionGreaterThanContext ctx);
	/**
	 * Enter a parse tree produced by {@link GaiaParser#functionCallExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(GaiaParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GaiaParser#functionCallExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(GaiaParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GaiaParser#functionArguments}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArguments(GaiaParser.FunctionArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GaiaParser#functionArguments}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArguments(GaiaParser.FunctionArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomInt}
	 * labeled alternative in {@link GaiaParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomInt(GaiaParser.AtomIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomInt}
	 * labeled alternative in {@link GaiaParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomInt(GaiaParser.AtomIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomId}
	 * labeled alternative in {@link GaiaParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomId(GaiaParser.AtomIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomId}
	 * labeled alternative in {@link GaiaParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomId(GaiaParser.AtomIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GaiaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GaiaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GaiaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GaiaParser.TypeContext ctx);
}