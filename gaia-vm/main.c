#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

#define STACK_SIZE 4096
#define VARS_COUNT 4096

#define END 0
#define PUSH_i64 1
#define ADD_i64 2
#define SUB_i64 3
#define MUL_i64 4
#define DIV_i64 5
#define STORE_i64 6
#define LOAD_i64 7
#define PRINT_i64 8
#define NEGATE_i64 9
#define GT_i64 10
#define LT_i64 11
#define JT 12
#define JF 13
#define JMP 14
#define MOD_i64 15
#define EQ_i64 16

#define OP(type) (type) (*(++program))

#define PUSH(arg) *(++stack) = arg
#define POP() *(stack--)

#define BINARY_OP(type, operation)      uint64_t b = POP();                  \
                                        uint64_t  a = POP();                 \
                                        type op1;                            \
                                        type op2;                            \
                                        memcpy(&op1, &a, sizeof(type));      \
                                        memcpy(&op2, &b, sizeof(type));      \
                                        type res = operation;                \
                                        type r;                              \
                                        memcpy(&r, &res, sizeof(type));      \
                                        PUSH(r)                              \


uint64_t run(uint64_t *program) {
    uint64_t *stack = malloc(STACK_SIZE * sizeof(uint64_t));
    uint64_t *vars = malloc(VARS_COUNT * sizeof(uint64_t));
    uint8_t eq = 0;
    uint8_t gt = 0;
    uint8_t lt = 0;
    uint64_t *start = program;

    while (*program != END) {
        switch (*program) {
            case PUSH_i64: {
                int64_t op = OP(int64_t);
                PUSH(op);
                break;
            }
            case ADD_i64: {
                BINARY_OP(int64_t, op1 + op2);
                break;
            }
            case SUB_i64: {
                BINARY_OP(int64_t, op1 - op2);
                break;
            }
            case MUL_i64: {
                BINARY_OP(int64_t, op1 * op2);
                break;
            }
            case DIV_i64: {
                BINARY_OP(int64_t, op1 / op2);
                break;
            }
            case EQ_i64: {
                BINARY_OP(int64_t, op1 == op2);
                break;
            }
            case STORE_i64: {
                int64_t op = OP(int64_t);
                int64_t val = POP();
                vars[op] = val;
                break;;
            }
            case LOAD_i64: {
                int64_t op = OP(int64_t);
                uint64_t val = vars[op];
                PUSH(val);
                break;
            }
            case PRINT_i64: {
                uint64_t val = POP();
                int64_t v;
                memcpy(&v, &val, sizeof(int64_t));
                printf("%lld\n", v);
                //fflush(stdout);
                break;
            }
            case NEGATE_i64: {
                int64_t val = POP();
                val = -val;
                PUSH(val);
                break;
            }
            case MOD_i64: {
                BINARY_OP(int64_t, op1 % op2);
                break;
            }
            case GT_i64: {
                BINARY_OP(int64_t, op1 > op2);
                break;
            }
            case LT_i64: {
                BINARY_OP(int64_t, op1 < op2);
                break;
            }
            case JF: {
                int64_t op = OP(int64_t);
                int64_t val = POP();
                if (!val) {
                    program = start + op;
                }

                break;
            }
            case JT: {
                int64_t op = OP(int64_t);
                int64_t val = POP();
                if (val) {
                    program = start + op;
                }

                break;
            }
            case JMP: {
                int64_t op = OP(int64_t);
                program = start + op;

                break;
            }
            default:
                break;
        }
        program++;
    }

    return *stack;
}


uint64_t *load(char *filename) {
    FILE *fileptr;
    char *buffer;
    long filelen;

    fileptr = fopen(filename, "rb");
    if (fileptr == NULL) {
        printf("File not found\n");
        exit(1);
    }

    fseek(fileptr, 0, SEEK_END);
    filelen = ftell(fileptr);
    rewind(fileptr);

    buffer = (char *) malloc(filelen * sizeof(char));
    fread(buffer, filelen, 1, fileptr);
    fclose(fileptr);

    uint64_t *program = malloc(filelen / 4 * sizeof(uint64_t) + 1);

    int k = 0;
    for (int i = 0; i < filelen; i += 8) {
        uint64_t value = (uint64_t) (buffer[i + 7]) |
                         (uint64_t) (buffer[i + 6]) << 8 |
                         (uint64_t) (buffer[i + 5]) << 16 |
                         (uint64_t) (buffer[i + 4]) << 24 |
                         (uint64_t) (buffer[i + 3]) << 32 |
                         (uint64_t) (buffer[i + 2]) << 40 |
                         (uint64_t) (buffer[i + 1]) << 48 |
                         (uint64_t) (buffer[i]) << 56;

        program[k++] = value;
    }

    program[k] = END;
    free(buffer);
    return program;
}

int main(int argc, char *argv[]) {
    if (argc < 2) {
        printf("Usage: gaia [input].gaiac\n");
        return -1;
    }

    uint64_t *p = load(argv[1]);
    run(p);

    return 0;
}
