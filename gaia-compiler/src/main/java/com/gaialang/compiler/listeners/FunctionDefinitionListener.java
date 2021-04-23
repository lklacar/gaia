package com.gaialang.compiler.listeners;


import com.gaialang.compiler.Constant;
import com.gaialang.compiler.code.Scope;
import com.gaialang.compiler.exceptions.GaiaException;
import com.gaialang.compiler.generated.GaiaBaseListener;
import com.gaialang.compiler.generated.GaiaParser;
import com.gaialang.compiler.instructions.*;
import lombok.Getter;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayDeque;
import java.util.Deque;

public class FunctionDefinitionListener extends GaiaBaseListener {

    @Getter
    private final Scope currentScope;
    private final Deque<PlaceholderInstruction> placeholderInstructions = new ArrayDeque<>();

    public FunctionDefinitionListener() {
        currentScope = new Scope();
    }

    @Override
    public void enterFunctionDefinition(GaiaParser.FunctionDefinitionContext ctx) {
        var instruction = new PlaceholderInstruction();
        currentScope.addInstruction(instruction);
        placeholderInstructions.push(instruction);
    }

    @Override
    public void enterFunctionParameters(GaiaParser.FunctionParametersContext ctx) {
        currentScope.createVariable(ctx.ID().toString());
    }

    @Override
    public void exitAtomInt(GaiaParser.AtomIntContext ctx) {
        var value = Long.parseLong(ctx.getChild(0).toString());
        currentScope.addInstruction(new PushI64Instruction(value));
    }

    @Override
    public void exitExpressionAdd(GaiaParser.ExpressionAddContext ctx) {
        currentScope.addInstruction(new AddI64Instruction());
    }

    @Override
    public void exitExpressionSub(GaiaParser.ExpressionSubContext ctx) {
        currentScope.addInstruction(new SubI64Instruction());
    }

    @Override
    public void exitExpressionMul(GaiaParser.ExpressionMulContext ctx) {
        currentScope.addInstruction(new MulI64Instruction());
    }

    @Override
    public void exitExpressionDiv(GaiaParser.ExpressionDivContext ctx) {
        currentScope.addInstruction(new DivI64Instruction());
    }

    @Override
    public void exitAssignmentStatement(GaiaParser.AssignmentStatementContext ctx) {
        var id = ctx.ID().toString();
        var variable = currentScope.createVariable(id);
        currentScope.addInstruction(new StoreI64Instruction(variable.getAddress()));
    }

    @Override
    public void exitVariableDefinitionStatement(GaiaParser.VariableDefinitionStatementContext ctx) {
        var id = ctx.ID().toString();
        currentScope.findVariableByIdentifier(id)
                .ifPresentOrElse(variable -> {
                    throw new GaiaException("Cannot redefine variable.");
                }, () -> {
                    var variable = currentScope.createVariable(id);
                    currentScope.addInstruction(new StoreI64Instruction(variable.getAddress()));
                });
    }

    @Override
    public void exitAtomId(GaiaParser.AtomIdContext ctx) {
        var id = ctx.ID().toString();
        var variable = currentScope.findVariableByIdentifier(id)
                .orElseThrow(() -> new GaiaException("Variable not defined"));
        currentScope.addInstruction(new LoadI64Instruction(variable.getAddress()));
    }

    @Override
    public void exitPrintStatement(GaiaParser.PrintStatementContext ctx) {
        currentScope.addInstruction(new PrintI64Instruction());
    }

    @Override
    public void exitExpressionNegate(GaiaParser.ExpressionNegateContext ctx) {
        currentScope.addInstruction(new NegateI64Instruction());
    }

    @Override
    public void exitExpressionGreaterThan(GaiaParser.ExpressionGreaterThanContext ctx) {
        currentScope.addInstruction(new GTI64Instruction());
    }

    @Override
    public void exitExpressionLessThan(GaiaParser.ExpressionLessThanContext ctx) {
        currentScope.addInstruction(new LTI64Instruction());
    }

    @Override
    public void enterWhileStatement(GaiaParser.WhileStatementContext ctx) {
        var whileStatementListener = new WhileStatementListener(this);
        ParseTreeWalker.DEFAULT.walk(whileStatementListener, ctx);
    }

    @Override
    public void exitExpressionMod(GaiaParser.ExpressionModContext ctx) {
        currentScope.addInstruction(new ModI64Instruction());
    }

    @Override
    public void exitExpressionEquals(GaiaParser.ExpressionEqualsContext ctx) {
        currentScope.addInstruction(new EqualsI64Instruction());
    }

    @Override
    public void exitFunctionDefinition(GaiaParser.FunctionDefinitionContext ctx) {
        if (ctx.ID().toString().equals(Constant.MAIN_FUNCTION_IDENTIFIER)) {
            currentScope.addInstruction(new EndInstruction());
        }

        var placeholder = placeholderInstructions.pop();
        currentScope.replaceInstruction(placeholder, new AllocVarsInstruction(currentScope.varCount()));
    }

    @Override
    public void exitReturnStatement(GaiaParser.ReturnStatementContext ctx) {
        currentScope.addInstruction(new ReturnInstruction());
    }

    @Override
    public void exitFunctionCallExpression(GaiaParser.FunctionCallExpressionContext ctx) {
        currentScope.addInstruction(new CallInstruction(-1));
    }

    @Override
    public void enterIfBody(GaiaParser.IfBodyContext ctx) {
        var instruction = new PlaceholderInstruction();
        currentScope.addInstruction(instruction);
        placeholderInstructions.push(instruction);

    }

    @Override
    public void exitIfStatement(GaiaParser.IfStatementContext ctx) {
        var nop = new NopInstruction();
        currentScope.addInstruction(nop);
        var placeholder = placeholderInstructions.pop();
        var jfPlaceholder = new JFPlaceholderInstruction(nop);
        currentScope.replaceInstruction(placeholder, jfPlaceholder);
    }

}
