package com.gaialang.compiler.instructions;

import java.util.List;

public class EqualsI64Instruction extends Instruction {

    @Override
    public Long getOpCode() {
        return 16L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode());
    }

    @Override
    public String toAsm() {
        return "EQ_i64,";
    }
}
