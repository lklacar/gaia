package com.gaialang.compiler.instructions;

import java.util.List;

public class LoadI64Instruction extends Instruction {

    private final long parameter;

    public LoadI64Instruction(long parameter) {
        this.parameter = parameter;
    }

    @Override
    public Long getOpCode() {
        return 7L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode(), parameter);
    }

    @Override
    public String toAsm() {
        return String.format("LOAD_i64, %d,", parameter);
    }
}
