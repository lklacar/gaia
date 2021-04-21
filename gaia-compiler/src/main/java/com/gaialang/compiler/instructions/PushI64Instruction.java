package com.gaialang.compiler.instructions;

import java.util.List;

public class PushI64Instruction extends Instruction {

    private final long parameter;

    public PushI64Instruction(long parameter) {
        this.parameter = parameter;
    }

    @Override
    public Long getOpCode() {
        return 1L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode(), parameter);
    }

    @Override
    public String toAsm() {
        return String.format("PUSH_i64, %d,", parameter);
    }
}
