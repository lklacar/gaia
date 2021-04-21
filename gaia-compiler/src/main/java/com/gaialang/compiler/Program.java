package com.gaialang.compiler;

import com.gaialang.compiler.generated.GaiaLexer;
import com.gaialang.compiler.generated.GaiaParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.stream.Collectors;

public class Program {
    public static byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(x);
        return buffer.array();
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Usage: gaiac [input].gaia [output].gaiac");
            return;
        }

        var inputFileName = args[0];
        var outputFileName = args[1];

        var charStream = CharStreams.fromFileName(inputFileName);
        var lexer = new GaiaLexer(charStream);
        var tokens = new CommonTokenStream(lexer);
        var parser = new GaiaParser(tokens);

        var listener = new CustomListener();
        ParseTreeWalker.DEFAULT.walk(listener, parser.program());

        var output = listener.getCodeBlocks().stream().flatMap(Collection::stream)
                .flatMap(instruction -> instruction.toBytecode().stream())
                .map(Program::longToBytes)
                .collect(Collectors.toList());

        OutputStream outputStream = new FileOutputStream(outputFileName);
        output.forEach(byteArray -> {
            try {
                outputStream.write(byteArray);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
