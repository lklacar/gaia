package com.gaialang.compiler.listeners;

import com.gaialang.compiler.generated.GaiaBaseListener;
import com.gaialang.compiler.generated.GaiaParser;
import com.gaialang.compiler.instructions.JFInstruction;
import com.gaialang.compiler.instructions.JMPInstruction;
import com.gaialang.compiler.util.AddressUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WhileStatementListener extends GaiaBaseListener {
    private final ProgramListener programListener;

    @Override
    public void enterWhileBody(GaiaParser.WhileBodyContext ctx) {
        programListener.getPointcutAddresses().push(programListener.currentAddress());
        programListener.getCurrentCodeBlock().add(new JFInstruction(-1));
    }

    @Override
    public void exitWhileStatement(GaiaParser.WhileStatementContext ctx) {
        var currentBlock = programListener.getCurrentCodeBlock();
        var blockStart = programListener.getPointcutAddresses().pop();
        var blockEnd = programListener.currentAddress();
        var jumpForwardAddress = AddressUtil.toBytecodeAddress(currentBlock, blockEnd) + 1;
        var jumpBack = programListener.getPointcutAddresses().pop();
        var jumpBackAddress = AddressUtil.toBytecodeAddress(currentBlock, jumpBack) - 1;
        programListener.getCurrentCodeBlock().set(blockStart, new JFInstruction(jumpForwardAddress));
        programListener.getCurrentCodeBlock().add(new JMPInstruction(jumpBackAddress));
    }
}
