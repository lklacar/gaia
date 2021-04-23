package com.gaialang.compiler.util;

import com.gaialang.compiler.exceptions.GaiaException;
import com.gaialang.compiler.instructions.Instruction;

import java.util.List;

public class AddressUtil {
    private AddressUtil() {
        throw new GaiaException();
    }

    public static long toBytecodeAddress(List<Instruction> instructions, int instructionAddress) {
        return instructions.subList(0, instructionAddress + 1)
                .stream().map(instruction -> instruction.toBytecode().size())
                .reduce(0, Integer::sum);
    }
}
