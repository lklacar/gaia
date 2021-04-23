package com.gaialang.compiler.instructions;

import java.util.List;

public class ReturnInstruction extends Instruction {

    @Override
    public Long getOpCode() {
        return 18L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode());
    }

    @Override
    public String toAsm() {
        return "RET,";
    }
}
