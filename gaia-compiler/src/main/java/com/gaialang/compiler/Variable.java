package com.gaialang.compiler;

import com.gaialang.compiler.code.Scope;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Variable {
    private String identifier;
    private Long address;
    private Scope scope;
}
