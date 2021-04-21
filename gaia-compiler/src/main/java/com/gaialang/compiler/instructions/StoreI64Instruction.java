package com.gaialang.compiler.instructions;

import java.util.List;

public class StoreI64Instruction extends Instruction {

    private final long parameter;

    public StoreI64Instruction(long parameter) {
        this.parameter = parameter;
    }

    @Override
    public Long getOpCode() {
        return 6L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode(), parameter);
    }

    @Override
    public String toAsm() {
        return String.format("STORE_i64, %d,", parameter);
    }
}
