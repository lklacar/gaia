package com.gaialang.compiler.instructions;

import java.util.List;

public class AllocVarsInstruction extends Instruction {

    private final long parameter;

    public AllocVarsInstruction(long parameter) {
        this.parameter = parameter;
    }

    @Override
    public Long getOpCode() {
        return 17L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode(), parameter);
    }

    @Override
    public String toAsm() {
        return String.format("ALLOC_VARS, %d,", parameter);
    }
}
