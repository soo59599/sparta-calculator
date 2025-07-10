package com.v2;


import java.util.List;
import java.util.Set;

public class Calculator {

    private List<Double> result;

    public double calculate(int num1, int num2, String operator) {

        //결과값 저장 변수 설정
        double answer = 0;
        //계산 처리
        switch (operator) {
            case "+":
                answer = num1 + num2;
                break;
            case "-":
                answer = num1 - num2;
                break;
            case "*":
                answer = num1 * num2;
                break;
            case "/":
                answer = (double) num1 / num2;
                break;
        }
        return answer;
    }

    public boolean isOperator(String operator) {
        //연산자 예외처리(set 활용)
        Set<String> operators = Set.of("+", "-", "*", "/");

        return operators.contains(operator);
    }

//    public String getValidOperator() {
//
//
//    }


}

