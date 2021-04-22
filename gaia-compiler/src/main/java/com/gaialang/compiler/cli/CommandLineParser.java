package com.gaialang.compiler.cli;

import java.io.File;

public class CommandLineParser {

    public CommandLineOptions parseCommandLine(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: gaia [input].gaia");
            System.exit(1);
        }

        var inputFileName = args[0];
        var outputFileName = getOutputFileName(inputFileName);

        return CommandLineOptions
                .builder()
                .inputFileName(inputFileName)
                .outputFileName(outputFileName)
                .build();
    }

    private String getOutputFileName(String arg) {
        var outputFileName = new File(arg).getName();
        outputFileName = (outputFileName.contains(".") ? outputFileName.substring(0, outputFileName.lastIndexOf('.')) : outputFileName) + ".gaiac";
        return outputFileName;
    }

}
