package com.gaialang.compiler.listeners;


import com.gaialang.compiler.Constant;
import com.gaialang.compiler.code.Scope;
import com.gaialang.compiler.exceptions.GaiaException;
import com.gaialang.compiler.generated.GaiaBaseListener;
import com.gaialang.compiler.generated.GaiaParser;
import com.gaialang.compiler.instructions.Instruction;
import com.gaialang.compiler.instructions.JFInstruction;
import com.gaialang.compiler.instructions.JFPlaceholderInstruction;
import com.gaialang.compiler.util.AddressUtil;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProgramListener extends GaiaBaseListener {

    private final List<FunctionDefinitionListener> functionDefinitionListeners = new ArrayList<>();
    private final List<GaiaParser.FunctionDefinitionContext> functionDefinitionContexts = new ArrayList<>();

    @Override
    public void enterFunctionDefinition(GaiaParser.FunctionDefinitionContext ctx) {
        functionDefinitionContexts.add(ctx);
    }

    @Override
    public void exitProgram(GaiaParser.ProgramContext ctx) {
        var mainFunctionContext = functionDefinitionContexts.stream()
                .filter(functionDefinitionContext -> functionDefinitionContext.ID().toString().equals(Constant.MAIN_FUNCTION_IDENTIFIER))
                .findFirst()
                .orElseThrow(GaiaException::new);

        functionDefinitionContexts.remove(mainFunctionContext);
        functionDefinitionContexts.add(0, mainFunctionContext);

        functionDefinitionContexts.forEach(context -> {
            var functionDefinitionListener = new FunctionDefinitionListener();
            functionDefinitionListeners.add(functionDefinitionListener);
            ParseTreeWalker.DEFAULT.walk(functionDefinitionListener, context);
        });

    }

    public List<Instruction> getInstructions() {
        var instructions = getScopes()
                .stream()
                .flatMap(scope -> scope.getInstructions().stream())
                .collect(Collectors.toList());

        adjustJumpAddresses(instructions);

        return instructions;
    }

    private void adjustJumpAddresses(List<Instruction> instructions) {

        IntStream.range(0, instructions.size()).forEach(i -> {
            var instruction = instructions.get(i);
            if (instruction instanceof JFPlaceholderInstruction) {
                var jumpTo = ((JFPlaceholderInstruction) instruction).getJumpTo();
                var jumpToInstructionAddress = instructions.indexOf(jumpTo);
                var jumpToBytecodeAddress = AddressUtil.toBytecodeAddress(instructions, jumpToInstructionAddress);
                var jfInstruction = new JFInstruction(jumpToBytecodeAddress);
                instructions.set(i, jfInstruction);
            }
        });
    }


    public List<Scope> getScopes() {
        return functionDefinitionListeners.stream().map(FunctionDefinitionListener::getCurrentScope)
                .collect(Collectors.toList());
    }
}
