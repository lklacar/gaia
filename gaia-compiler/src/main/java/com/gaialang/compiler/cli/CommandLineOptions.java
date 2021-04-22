package com.gaialang.compiler.cli;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandLineOptions {
    private final String inputFileName;
    private final String outputFileName;
}
