package com.gaialang.compiler.instructions;

import java.util.List;

public class NopInstruction extends Instruction {

    @Override
    public Long getOpCode() {
        return 20L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode());
    }

    @Override
    public String toAsm() {
        return "NOP,";
    }
}
