package com.gaialang.compiler.instructions;

import java.util.List;

public class AddI64Instruction extends Instruction {

    @Override
    public Long getOpCode() {
        return 2L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode());
    }

    @Override
    public String toAsm() {
        return "ADD_i64,";
    }
}
