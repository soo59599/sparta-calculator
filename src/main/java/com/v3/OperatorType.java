package com.v3;

public enum OperatorType {
    ADD('+'),
    SUB('-'),
    MUL('*'),
    DIV('/');

    //필드
    char operator;

    //생성자
    OperatorType(char operator) {
        this.operator = operator;
    }
}
