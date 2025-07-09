package com.v1;

import java.util.Scanner;
import java.util.Set;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            //결과값 저장 변수 설정
            double answer = 0;

            //첫 숫자 입력
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double num1 = sc.nextInt();

            //연산자 입력
            System.out.println("연산자(+,-,/,*)를 입력하세요: ");
            String operator = sc.next();


            //연산자 예외처리(set 활용)
            Set<String> operators = Set.of("+", "-", "*", "/");
            while (!operators.contains(operator)) {
                System.out.println("유효하지 않은 연산자입니다.");
                System.out.println("연산자(+,-,/,*)중에 한가지를 입력하세요.");
                operator = sc.next();

            }

            //두번째 숫자 입력
            System.out.print("두 번째 숫자를 입력하세요: ");
            double num2 = sc.nextInt();

            //두번째 숫자 예외처리
            if (operator.equals("/") && num2 == 0) {
                while (true) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    num2 = sc.nextInt();
                    if (num2 != 0) {
                        break;
                    }
                }
            }

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
                    answer = num1 / num2;
                    break;
            }

            System.out.println();
            System.out.println("계산 결과 : " + answer);
            System.out.println();

            System.out.println("계산을 계속하려면 아무버튼이나 입력하세요.");
            System.out.println("계산을 그만두려면 exit를 입력하세요.");
            String str = sc.next();
            if ("exit".equals(str)) {
                break;
            }

        }

    }

}
