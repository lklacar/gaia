package com.gaialang.compiler.instructions;

import java.util.List;

public abstract class Instruction {
    public abstract Long getOpCode();

    public abstract List<Long> toBytecode();

    public abstract String toAsm();
}
