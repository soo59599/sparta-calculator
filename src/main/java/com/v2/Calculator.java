package com.v2;


import java.util.*;

public class Calculator {

    //연산 결과를 저장하는 필드
    private List<Double> result = new ArrayList<>();

    //연산 결과 Getter
    public List<Double> getResults() {
        return this.result;
    }

    //연산 결과 Setter
    public void setResults(List<Double> result) {
        this.result = result;
    }

    public void removeResult(){
        if(result.isEmpty()) {
            System.out.println("삭제할 결과가 없습니다.\n");
            return;
        }
        System.out.println("오래된 계산 내역이 삭제되었습니다.\n");
        result.remove(0);
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
        }
        //결과값 저장
        result.add(answer);

        return answer;
    }

    //입력한 숫자 예외처리
    public int isNumber(Scanner sc) {
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

    //입력한 연산자 확인(set 활용)
    public boolean isOperator(char operator) {

        Set<Character> operators = Set.of('+', '-', '*', '/');

        return operators.contains(operator);
    }

    //입력한 연산자 예외 처리
    public char getOperator(Scanner sc) {
        while (true) {
            char operator = sc.next().charAt(0);
            if(isOperator(operator)) {
                return operator;
            }else{
                System.out.println("유효하지 않은 연산자입니다.");
                System.out.println("연산자(+,-,/,*)중에 한가지를 입력하세요.");
            }
        }
    }

    //입력한 계산 (숫자/0)예외 확인
    public void isValidDivision (int num, char operator){
        if(operator == '/'&& num==0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다. 처음부터 다시 시작합니다.");
        }
    }


}

