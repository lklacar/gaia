package com.gaialang.compiler.util;

import com.gaialang.compiler.code.CodeBlock;

public class AddressUtil {
    public static long toBytecodeAddress(CodeBlock currentCodeBlock, int instructionAddress) {
        return currentCodeBlock.subList(0, instructionAddress)
                .stream().map(instruction -> instruction.toBytecode().size())
                .reduce(0, Integer::sum);
    }
}
