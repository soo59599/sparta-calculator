package com.v3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class ArithmeticCalculator<T extends Number> {

    //연산 결과를 저장하는 필드
    private final List<BigDecimal> results = new ArrayList<>();

    //Getter : 연산 결과 List
    public List<BigDecimal> getResults() {
        return Collections.unmodifiableList(results);
    }

    //Setter : 오래된 내역 삭제
    public boolean removeOldestResult() {
        if (results.isEmpty()) {
            return false;
        }
        results.remove(0);
        return true;
    }

    //BigDecimal 변환메서드
    private BigDecimal toBigDecimal(T number) {
        return new BigDecimal(number.toString());
    }

    //계산기
    public BigDecimal calculate(T num1, T num2, char operator) {

        BigDecimal answer = BigDecimal.ZERO;
        BigDecimal a = toBigDecimal(num1);
        BigDecimal b = toBigDecimal(num2);

        //계산 처리
        switch (operator) {
            case '+' -> answer = a.add(b);
            case '-' -> answer = a.subtract(b);
            case '*' -> answer = a.multiply(b);
            case '/' -> answer = a.divide(b, 10, RoundingMode.HALF_UP);

            default -> throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
        }
        //결과값 저장
        results.add(answer);

        return answer;
    }

    //입력한 숫자 예외처리
    public double getNumber(Scanner sc) {
        while (true) {
            try {
                double num = sc.nextDouble();
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
            String input = sc.nextLine().trim();

            if (input.length() != 1) {
                System.out.println("사칙연산 기호(+,-,/,*)를 한 글자만 입력해주세요.");
                continue;
            }

            char operator = input.charAt(0);

            if (Arrays.stream(OperatorType.values()).anyMatch(op -> op.matches(operator))) {
                return operator;
            }

            System.out.println("유효하지 않은 연산자입니다. 다시 입력하세요.");

        }
    }


    //입력한 계산 (숫자/0)예외 확인
    public void isValidDivision(double num2, char operator) {
        if (operator == '/' && num2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다. 처음부터 다시 시작합니다.");
        }
    }


}
