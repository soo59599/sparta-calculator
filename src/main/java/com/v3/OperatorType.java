package com.v3;

public enum OperatorType {
    ADD('+') {
        @Override
        public double operate(int num1, int num2) {
            return num1 + num2;
        }
    },
    SUB('-') {
        @Override
        public double operate(int num1, int num2) {
            return num1 - num2;
        }
    },
    MUL('*') {
        @Override
        public double operate(int num1, int num2) {
            return num1 * num2;
        }
    },
    DIV('/') {
        @Override
        public double operate(int num1, int num2) {
            if (num2 == 0) {
                throw new ArithmeticException("0으로는 나눌 수 없습니다.");
            }
            return (double) num1 / num2;
        }
    };

    //필드
    char operator;

    //생성자
    OperatorType(char operator) {
        this.operator = operator;
    }

    //추상 메서드
    public abstract double operate(int num1, int num2);



}
