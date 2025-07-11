package com.v3;


import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator calc = new ArithmeticCalculator();

        //반복문 시작
        outer:
        while (true) {
            int num1;
            int num2;
            char operator;
            double calculatedNum;

            //첫 숫자 입력
            System.out.print("첫 번째 숫자를 입력하세요: ");
            num1 = calc.isNumber(sc);

            //두번째 숫자 입력
            System.out.print("두 번째 숫자를 입력하세요: ");
            num2 = calc.isNumber(sc);

            try {
                //연산자 입력
                System.out.println("사칙연산 기호(+,-,/,*)를 입력하세요: ");
                operator = calc.getOperator(sc);

                //계산하기
                calculatedNum = calc.calculate(num1, num2, operator);

            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("계산 결과 : " + calculatedNum);
            System.out.println();


            while (true) {
                System.out.println("더 계산하시겠습니까?");
                System.out.println("1. list 입력시 계산내역 확인");
                System.out.println("2. remove 입력시 오래된 내역부터 삭제");
                System.out.println("3. exit 입력 시 종료");
                System.out.println("그 외 다른 키는 계산 계속하기 입니다.");
                String answer = sc.next();
                if ("exit".equalsIgnoreCase(answer) || "3".equals(answer)) {
                    break outer;
                } else if ("list".equalsIgnoreCase(answer) || "1".equals(answer)) {
                    List<Double> results = calc.getResults();
                    for (Double result : results) {
                        System.out.println(result);
                    }
                } else if ("remove".equalsIgnoreCase(answer) || "2".equals(answer)) {
                    calc.removeResult();
                } else {
                    break;
                }
            }

        }
        sc.close();

    }
}
