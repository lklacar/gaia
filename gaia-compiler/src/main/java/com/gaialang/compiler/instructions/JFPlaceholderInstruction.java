package com.gaialang.compiler.instructions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class JFPlaceholderInstruction extends Instruction {

    @Getter
    private final Instruction jumpTo;

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
        return String.format("JF_PLACEHOLDER, %s,", jumpTo);
    }
}
