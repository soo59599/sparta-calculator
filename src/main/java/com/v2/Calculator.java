package com.v2;


import java.util.*;

public class Calculator {

    //연산 결과를 저장하는 필드
    private List<Double> results = new ArrayList<>();

    //Getter : 연산 결과 List
    public List<Double> getResults() {
        return this.results;
    }

    //Setter : 오래된 내역 삭제
    public boolean removeOldestResult() {
        if (results.isEmpty()) {
            return false;
        }
        results.remove(0);
        return true;
    }

    //계산기
    public double calculate(int num1, int num2, char operator) {

        double answer = 0;
        //계산 처리
        switch (operator) {
            case '+':
                answer = num1 + num2;
                break;
            case '-':
                answer = num1 - num2;
                break;
            case '*':
                answer = num1 * num2;
                break;
            case '/':
                answer = (double) num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
        }
        //결과값 저장
        results.add(answer);

        return answer;
    }

    //입력한 숫자 예외처리
    public int getNumber(Scanner sc) {
        while (true) {
            try {
                int num = sc.nextInt();
                sc.nextLine();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                sc.nextLine();
            }
        }
    }

    //입력한 연산자 예외 처리
    public char getOperator(Scanner sc) {
        while (true) {
            Set<Character> operators = Set.of('+', '-', '*', '/');
            char operator = sc.next().charAt(0);

            if (operators.contains(operator)) {
                return operator;
            } else {
                System.out.println("유효하지 않은 연산자입니다.");
                System.out.println("연산자(+,-,/,*)중에 한가지를 입력하세요.");
            }
        }
    }

    //입력한 계산 (숫자/0)예외 확인
    public void isValidDivision(int num2, char operator) {
        if (operator == '/' && num2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다. 처음부터 다시 시작합니다.");
        }
    }


}

