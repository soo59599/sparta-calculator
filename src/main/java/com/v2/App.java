package com.v2;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        //반복문 시작
        while (true) {

            //첫 숫자 입력
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = calc.isNumber(sc);

            //두번째 숫자 입력
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = calc.isNumber(sc);

            //연산자 입력
            System.out.println("사칙연산 기호(+,-,/,*)를 입력하세요: ");
            char operator = calc.getOperator(sc);

            try {
                calc.isValidDivision(num2, operator);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            //계산하기
            double calculatedNum = calc.calculate(num1, num2, operator);


            System.out.println("계산 결과 : " + calculatedNum);
            System.out.println();


            System.out.println("더 계산하시겠습니까? (list 입력시 계산내역 확인)(exit 입력 시 종료)");
            String answer = sc.next();
            if ("exit".equalsIgnoreCase(answer)) {
                break;
            }else if("list".equalsIgnoreCase(answer)) {
                List<Double> results = calc.getResults();
                for (int i = 0; i < results.size(); i++) {
                    System.out.println(results.get(i));
                }
            }

        }

    }

}
