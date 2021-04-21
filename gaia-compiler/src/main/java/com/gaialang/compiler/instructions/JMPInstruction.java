package com.gaialang.compiler.instructions;

import java.util.List;

public class JMPInstruction extends Instruction {

    private final long parameter;

    public JMPInstruction(long parameter) {
        this.parameter = parameter;
    }

    @Override
    public Long getOpCode() {
        return 14L;
    }

    @Override
    public List<Long> toBytecode() {
        return List.of(getOpCode(), parameter);
    }

    @Override
    public String toAsm() {
        return String.format("JMP, %d,", parameter);
    }
}
