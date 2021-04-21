package com.gaialang.compiler.instructions;

import java.util.List;

public class LTI64Instruction extends Instruction {

    @Override
    public Long getOpCode() {
        return 11L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode());
    }

    @Override
    public String toAsm() {
        return "LT_i64,";
    }
}
