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

    //이넘에 있는 연산자랑 입력받은 연산자 비교 메서드
    public boolean matches(char operator) {
        return this.operator == operator;
    }
}
