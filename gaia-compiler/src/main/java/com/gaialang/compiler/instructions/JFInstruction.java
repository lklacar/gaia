package com.gaialang.compiler.instructions;

import java.util.List;

public class JFInstruction extends Instruction {

    private final long parameter;

    public JFInstruction(long parameter) {
        this.parameter = parameter;
    }

    @Override
    public Long getOpCode() {
        return 13L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode(), parameter);
    }

    @Override
    public String toAsm() {
        return String.format("JF, %d,", parameter);
    }
}
