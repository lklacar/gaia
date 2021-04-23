package com.gaialang.compiler.instructions;

import java.util.List;

public class CallInstruction extends Instruction {

    private final long parameter;

    public CallInstruction(long parameter) {
        this.parameter = parameter;
    }

    @Override
    public Long getOpCode() {
        return 19L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode(), parameter);
    }

    @Override
    public String toAsm() {
        return String.format("CALL, %d,", parameter);
    }
}
