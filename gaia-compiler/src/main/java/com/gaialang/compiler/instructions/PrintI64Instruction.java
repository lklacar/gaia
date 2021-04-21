package com.gaialang.compiler.instructions;

import java.util.List;

public class PrintI64Instruction extends Instruction {

    @Override
    public Long getOpCode() {
        return 8L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode());
    }

    @Override
    public String toAsm() {
        return "PRINT_i64,";
    }
}
