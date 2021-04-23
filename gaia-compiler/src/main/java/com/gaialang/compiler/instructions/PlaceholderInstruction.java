package com.gaialang.compiler.instructions;

import java.util.List;

public class PlaceholderInstruction extends Instruction {

    @Override
    public Long getOpCode() {
        return -1L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode());
    }

    @Override
    public String toAsm() {
        return "PLACEHOLDER,";
    }
}
