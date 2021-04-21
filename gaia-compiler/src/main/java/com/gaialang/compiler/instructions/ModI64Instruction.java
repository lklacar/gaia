package com.gaialang.compiler.instructions;

import java.util.List;

public class ModI64Instruction extends Instruction {

    @Override
    public Long getOpCode() {
        return 15L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode());
    }

    @Override
    public String toAsm() {
        return "MOD_i64,";
    }
}
