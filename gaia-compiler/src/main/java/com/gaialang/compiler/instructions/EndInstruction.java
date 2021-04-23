package com.gaialang.compiler.instructions;

import java.util.List;

public class EndInstruction extends Instruction {

    @Override
    public Long getOpCode() {
        return 0L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode());
    }

    @Override
    public String toAsm() {
        return "END,";
    }
}
