package com.v2;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        //반복문 시작
        outer: while (true) {

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


            while(true) {
                System.out.println("더 계산하시겠습니까?");
                System.out.println("1. list 입력시 계산내역 확인");
                System.out.println("2. remove 입력시 오래된 내역부터 삭제");
                System.out.println("3. exit 입력 시 종료");
                System.out.println("그 외 다른 키는 계산 계속하기 입니다.");
                String answer = sc.next();
                if ("exit".equalsIgnoreCase(answer)) {
                    break outer;
                } else if ("list".equalsIgnoreCase(answer)) {
                    List<Double> results = calc.getResults();
                    for (Double result : results) {
                        System.out.println(result);
                    }
                }else if("remove".equalsIgnoreCase(answer)) {
                    calc.removeResult();
                }else{
                    break;
                }
            }

        }
        sc.close();

    }

}
