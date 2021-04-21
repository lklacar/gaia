package com.gaialang.compiler.instructions;

import java.util.List;

public class NegateI64Instruction extends Instruction {

    @Override
    public Long getOpCode() {
        return 9L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode());
    }

    @Override
    public String toAsm() {
        return "NEGATE_i64,";
    }
}
