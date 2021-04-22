package com.gaialang.compiler.listeners;

import com.gaialang.compiler.generated.GaiaBaseListener;
import com.gaialang.compiler.generated.GaiaParser;
import com.gaialang.compiler.instructions.JFInstruction;
import com.gaialang.compiler.util.AddressUtil;

public class IfStatementListener extends GaiaBaseListener {

    private final ProgramListener programListener;

    public IfStatementListener(ProgramListener programListener) {
        this.programListener = programListener;
    }

    @Override
    public void enterIfBody(GaiaParser.IfBodyContext ctx) {
        programListener.getPointcutAddresses().push(programListener.currentAddress());
        programListener.getCurrentCodeBlock().add(new JFInstruction(-1));
    }

    @Override
    public void exitIfStatement(GaiaParser.IfStatementContext ctx) {
        var currentBlock = programListener.getCurrentCodeBlock();
        var blockStart = programListener.getPointcutAddresses().pop();
        var blockEnd = programListener.currentAddress();
        var jumpToAddress = AddressUtil.toBytecodeAddress(currentBlock, blockEnd) - 1;
        programListener.getCurrentCodeBlock().set(blockStart, new JFInstruction(jumpToAddress));
    }
}
