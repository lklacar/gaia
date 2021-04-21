package com.gaialang.compiler;


import com.gaialang.compiler.generated.GaiaBaseListener;
import com.gaialang.compiler.generated.GaiaParser;
import com.gaialang.compiler.instructions.*;

import java.util.*;
import java.util.stream.Collectors;

public class CustomListener extends GaiaBaseListener {

    private final CodeBlock currentCodeBlock = new CodeBlock();
    private final Map<String, Long> variableMap = new HashMap<>();
    private final Deque<Integer> ifAddresses = new ArrayDeque<>();


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
    public void enterIfBody(GaiaParser.IfBodyContext ctx) {
        ifAddresses.push(currentAddress());

        // Placeholder
        currentCodeBlock.add(new JFInstruction(-1));
    }

    @Override
    public void exitIfStatement(GaiaParser.IfStatementContext ctx) {
        var blockStart = ifAddresses.pop();
        var blockEnd = currentAddress();
        var jumpToAddress = toBytecodeAddress(blockEnd) - 1;

        currentCodeBlock.set(blockStart, new JFInstruction(jumpToAddress));
    }

    @Override
    public void enterWhileStatement(GaiaParser.WhileStatementContext ctx) {
        ifAddresses.push(currentAddress());
    }

    @Override
    public void enterWhileBody(GaiaParser.WhileBodyContext ctx) {
        ifAddresses.push(currentAddress());

        // Placeholder
        currentCodeBlock.add(new JFInstruction(-1));
    }

    @Override
    public void exitWhileStatement(GaiaParser.WhileStatementContext ctx) {
        var blockStart = ifAddresses.pop();
        var blockEnd = currentAddress();
        var jumpForwardAddress = toBytecodeAddress(blockEnd) + 1; // Offset it by JMP length
        var jumpBack = ifAddresses.pop();
        var jumpBackAddress = toBytecodeAddress(jumpBack) - 1;

        currentCodeBlock.set(blockStart, new JFInstruction(jumpForwardAddress));
        currentCodeBlock.add(new JMPInstruction(jumpBackAddress));
    }

    public int currentAddress() {
        return currentCodeBlock.size();
    }

    public long toBytecodeAddress(int instructionAddress) {
        return currentCodeBlock.subList(0, instructionAddress)
                .stream().map(instruction -> instruction.toBytecode().size())
                .reduce(0, Integer::sum);
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
