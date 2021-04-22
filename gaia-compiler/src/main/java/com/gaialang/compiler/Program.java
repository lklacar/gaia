package com.gaialang.compiler;

import com.gaialang.compiler.cli.CommandLineParser;
import com.gaialang.compiler.listeners.ProgramListener;

public class Program {

    public static void main(String[] args) {
        var commandLineParser = new CommandLineParser();
        var commandLineOptions = commandLineParser.parseCommandLine(args);
        var programListener = new ProgramListener();
        var compiler = new GaiaCompiler(commandLineOptions, programListener);
        compiler.compile();
    }
}
