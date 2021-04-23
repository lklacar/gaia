package com.gaialang.compiler;

import com.gaialang.compiler.exceptions.GaiaException;

public class Constant {

    private Constant() {
        throw new GaiaException();
    }

    public static final String MAIN_FUNCTION_IDENTIFIER = "main";
}
