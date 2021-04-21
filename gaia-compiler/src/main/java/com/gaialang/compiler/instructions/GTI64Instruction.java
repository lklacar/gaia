package com.gaialang.compiler.instructions;

import java.util.List;

public class GTI64Instruction extends Instruction {

    @Override
    public Long getOpCode() {
        return 10L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode());
    }

    @Override
    public String toAsm() {
        return "GT_i64,";
    }
}
