package com.gaialang.compiler.code;


import com.gaialang.compiler.Variable;
import com.gaialang.compiler.instructions.Instruction;
import com.gaialang.compiler.instructions.PlaceholderInstruction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Scope {
    @Builder.Default
    private List<Instruction> instructions = new ArrayList<>();

    private Scope parent;

    @Builder.Default
    private List<Variable> variables = new ArrayList<>();

    public Variable createVariable(String identifier) {
        return findVariableByIdentifier(identifier)
                .orElseGet(() -> {
                    var variable = Variable
                            .builder()
                            .identifier(identifier)
                            .scope(this)
                            .address((long) variables.size())
                            .build();
                    variables.add(variable);
                    return variable;
                });
    }

    public Optional<Variable> findVariableByIdentifier(String identifier) {
        return variables.stream().filter(variable -> variable.getIdentifier().equals(identifier))
                .findFirst();
    }

    public void addInstruction(Instruction instruction) {
        instructions.add(instruction);
    }

    public void replaceInstruction(PlaceholderInstruction placeholder, Instruction instruction) {
        var placeholderIndex = instructions.indexOf(placeholder);
        instructions.set(placeholderIndex, instruction);
    }

    public long varCount() {
        return variables.size();
    }
}
