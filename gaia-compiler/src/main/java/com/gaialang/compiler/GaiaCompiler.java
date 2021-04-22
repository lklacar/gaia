package com.gaialang.compiler;

import com.gaialang.compiler.cli.CommandLineOptions;
import com.gaialang.compiler.generated.GaiaLexer;
import com.gaialang.compiler.generated.GaiaParser;
import com.gaialang.compiler.listeners.ProgramListener;
import lombok.SneakyThrows;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.stream.Collectors;

public class GaiaCompiler {
    private final CommandLineOptions commandLineOptions;
    private final ProgramListener programListener;

    public GaiaCompiler(CommandLineOptions commandLineOptions, ProgramListener programListener) {
        this.commandLineOptions = commandLineOptions;
        this.programListener = programListener;
    }

    @SneakyThrows
    public void compile() {
        var charStream = CharStreams.fromFileName(commandLineOptions.getInputFileName());
        var lexer = new GaiaLexer(charStream);
        var tokens = new CommonTokenStream(lexer);
        var parser = new GaiaParser(tokens);

        ParseTreeWalker.DEFAULT.walk(programListener, parser.program());
        writeOutput();
    }

    private void writeOutput() throws IOException {
        var output = programListener.getCodeBlocks().stream().flatMap(Collection::stream)
                .flatMap(instruction -> instruction.toBytecode().stream())
                .map(this::longToBytes)
                .collect(Collectors.toList());

        try (OutputStream outputStream = new FileOutputStream(commandLineOptions.getOutputFileName())) {
            output.forEach(byteArray -> writeByteArray(outputStream, byteArray));
        }
    }

    private byte[] longToBytes(long x) {
        var buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(x);
        return buffer.array();
    }

    @SneakyThrows
    private void writeByteArray(OutputStream outputStream, byte[] byteArray) {
        outputStream.write(byteArray);
    }

}
