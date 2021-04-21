package com.gaialang.compiler.instructions;

import java.util.List;

public class DivI64Instruction extends Instruction {

    @Override
    public Long getOpCode() {
        return 5L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode());
    }

    @Override
    public String toAsm() {
        return "DIV_i64,";
    }
}
