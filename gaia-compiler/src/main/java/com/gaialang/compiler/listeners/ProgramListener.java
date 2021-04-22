package com.gaialang.compiler.listeners;


import com.gaialang.compiler.code.CodeBlock;
import com.gaialang.compiler.generated.GaiaBaseListener;
import com.gaialang.compiler.generated.GaiaParser;
import com.gaialang.compiler.instructions.*;
import lombok.Getter;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.*;
import java.util.stream.Collectors;

public class ProgramListener extends GaiaBaseListener {

    @Getter
    private final CodeBlock currentCodeBlock = new CodeBlock();

    @Getter
    private final Map<String, Long> variableMap = new HashMap<>();

    @Getter
    private final Deque<Integer> pointcutAddresses = new ArrayDeque<>();

    public List<CodeBlock> getCodeBlocks() {
        return List.of(currentCodeBlock);
    }

    @Override
    public void exitProgram(GaiaParser.ProgramContext ctx) {
        var asm = currentCodeBlock.stream()
                .map(Instruction::toAsm)
                .collect(Collectors.joining("\n"));

        System.out.println(asm);
        System.out.println(currentCodeBlock.stream().flatMap(instruction -> instruction.toBytecode().stream()).collect(Collectors.toList()));
    }

    @Override
    public void exitAtomInt(GaiaParser.AtomIntContext ctx) {
        var value = Long.parseLong(ctx.getChild(0).toString());
        currentCodeBlock.add(new PushI64Instruction(value));
    }

    @Override
    public void exitExpressionAdd(GaiaParser.ExpressionAddContext ctx) {
        currentCodeBlock.add(new AddI64Instruction());
    }

    @Override
    public void exitExpressionSub(GaiaParser.ExpressionSubContext ctx) {
        currentCodeBlock.add(new SubI64Instruction());
    }

    @Override
    public void exitExpressionMul(GaiaParser.ExpressionMulContext ctx) {
        currentCodeBlock.add(new MulI64Instruction());
    }

    @Override
    public void exitExpressionDiv(GaiaParser.ExpressionDivContext ctx) {
        currentCodeBlock.add(new DivI64Instruction());
    }

    @Override
    public void exitAssignmentStatement(GaiaParser.AssignmentStatementContext ctx) {
        var id = ctx.ID().toString();
        if (!variableMap.containsKey(id)) {
            throw new RuntimeException("Variable not defined: " + id);
        }

        var index = variableMap.get(id);
        currentCodeBlock.add(new StoreI64Instruction(index));
    }

    @Override
    public void exitVariableDefinitionStatement(GaiaParser.VariableDefinitionStatementContext ctx) {
        var variableIndex = (long) variableMap.size();
        var id = ctx.ID().toString();
        if (variableMap.containsKey(id)) {
            throw new RuntimeException("Variable already defined: " + id);
        }

        variableMap.put(id, variableIndex);
        currentCodeBlock.add(new StoreI64Instruction(variableIndex));
    }

    @Override
    public void exitAtomId(GaiaParser.AtomIdContext ctx) {
        var variableIndex = variableMap.get(ctx.ID().toString());
        currentCodeBlock.add(new LoadI64Instruction(variableIndex));
    }

    @Override
    public void exitPrintStatement(GaiaParser.PrintStatementContext ctx) {
        currentCodeBlock.add(new PrintI64Instruction());
    }

    @Override
    public void exitExpressionNegate(GaiaParser.ExpressionNegateContext ctx) {
        currentCodeBlock.add(new NegateI64Instruction());
    }

    @Override
    public void exitExpressionGreaterThan(GaiaParser.ExpressionGreaterThanContext ctx) {
        currentCodeBlock.add(new GTI64Instruction());
    }

    @Override
    public void exitExpressionLessThan(GaiaParser.ExpressionLessThanContext ctx) {
        currentCodeBlock.add(new LTI64Instruction());
    }

    @Override
    public void enterIfStatement(GaiaParser.IfStatementContext ctx) {
        var ifStatementListener = new IfStatementListener(this);
        ParseTreeWalker.DEFAULT.walk(ifStatementListener, ctx);
    }

    @Override
    public void enterWhileStatement(GaiaParser.WhileStatementContext ctx) {
        pointcutAddresses.push(currentAddress());
        var whileStatementListener = new WhileStatementListener(this);
        ParseTreeWalker.DEFAULT.walk(whileStatementListener, ctx);
    }

    public int currentAddress() {
        return currentCodeBlock.size();
    }

    @Override
    public void exitExpressionMod(GaiaParser.ExpressionModContext ctx) {
        currentCodeBlock.add(new ModI64Instruction());
    }

    @Override
    public void exitExpressionEquals(GaiaParser.ExpressionEqualsContext ctx) {
        currentCodeBlock.add(new EqualsI64Instruction());
    }


}
