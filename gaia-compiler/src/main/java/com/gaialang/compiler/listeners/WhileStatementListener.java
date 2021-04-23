package com.gaialang.compiler.listeners;

import com.gaialang.compiler.generated.GaiaBaseListener;
import com.gaialang.compiler.generated.GaiaParser;
import com.gaialang.compiler.instructions.JFInstruction;
import com.gaialang.compiler.instructions.JMPInstruction;
import com.gaialang.compiler.util.AddressUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WhileStatementListener extends GaiaBaseListener {
    private final FunctionDefinitionListener functionDefinitionListener;

    @Override
    public void enterWhileBody(GaiaParser.WhileBodyContext ctx) {
    }

    @Override
    public void exitWhileStatement(GaiaParser.WhileStatementContext ctx) {
    }
}
