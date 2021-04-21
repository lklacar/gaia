package com.gaialang.compiler.instructions;

import java.util.List;

public class SubI64Instruction extends Instruction {

    @Override
    public Long getOpCode() {
        return 3L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode());
    }

    @Override
    public String toAsm() {
        return "SUB_i64,";
    }
}
