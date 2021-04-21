package com.gaialang.compiler.instructions;

import java.util.List;

public class MulI64Instruction extends Instruction {

    @Override
    public Long getOpCode() {
        return 4L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode());
    }

    @Override
    public String toAsm() {
        return "MUL_i64,";
    }
}
