# Gaia Programming Language

## Overview

Gaia is a simple programming language that compiles to `gaiac` bytecode. 


Example program:
```
let i : i64 = 0
let sum : i64 = 0
while(i < 10) {
    sum = sum + i
    i = i + 1
}
print sum
```


Features:
- [x] 64-bit integer support
- [x] Basic arithmetic operations
- [x] If-statements
- [x] While-statements
- [x] Variable definitions
- [x] Variable reassignment
- [ ] Function support
- [ ] Else-statement
- [ ] For-statement
- [ ] 64-bit float support
- [ ] Array support
- [ ] Char support
- [ ] String support
- [ ] Structures support

## VM

Gaia VM is a stack based VM written in C.
Instructions:

| Instruction | Description                                                                                         | Arguments         | OpCode |
|-------------|-----------------------------------------------------------------------------------------------------|-------------------|--------|
| END         | Stops the execution                                                                                 | /                 | 0      |
| PUSH_i64    | Pushes 64-bit integer to the stack                                                                  | Integer value     | 1      |
| ADD_i64     | Pops 2 64-bit integers from the stack, sums them and pushes the result back to the stack            | /                 | 2      |
| SUB_i64     | Pops 2 64-bit integers from the stack, subtracts them and pushes the result back to the stack       | /                 | 3      |
| MUL_i64     | Pops 2 64-bit integers from the stack, multiplies them and pushes the result back to the stack      | /                 | 4      |
| DIV_i64     | Pops 2 64-bit integers from the stack, divides them and pushes the result back to the stack         | /                 | 5      |
| STORE_i64   | Pops 1 64-bit integer from the stack, and stores it as a variable                                   | Variable location | 6      |
| LOAD_i64    | Loads the variable from the argument position and pushes it to the stack                            | Variable location | 7      |
| PRINT_i64   | Pops 1 64-bit integer from the stack and prints it to stdout                                        | /                 | 8      |
| NEGATE_i64  | Pops 1 64-bit integer from the stack, negates it and pushes it back to the stack                    | /                 | 9      |
| GT_i64      | Pops 2 64-bit integers from the stack, compares them and pushes the result back to the stack        | /                 | 10     |
| LT_i64      | Pops 2 64-bit integers from the stack, compares them and pushes the result back to the stack        | /                 | 11     |
| JT          | Pops 1 value from the stack, and jumps the the address if that value is != 0                        | Jump address      | 12     |
| JF          | Pops 1 value from the stack, and jumps the the address if that value is == 0                        | Jump address      | 13     |
| JMP         | Jumps to the given address                                                                          | Jump address      | 14     |
| MOD_i64     | Pops 2 64-bit integers from the stack, calculates their mod and pushes the result back to the stack | /                 | 15     |
| EQ_i64      | Pops 2 64-bit integers from the stack, checks if they are equal and pushes the result to the stack  | /                 | 16     |


## Compiler
Compiler reads .gaia source file and produces .gaiac bytecode that can later be executed in the VM.
Compiler is written in Java and parsed with antlr4.
