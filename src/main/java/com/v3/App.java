package com.v3;


import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Number> calc = new ArithmeticCalculator<>();

        //반복문 시작
        outer:
        while (true) {

            //첫 숫자 입력
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double num1 = calc.getNumber(sc);

            //두번째 숫자 입력
            System.out.print("두 번째 숫자를 입력하세요: ");
            double num2 = calc.getNumber(sc);

            //연산자 입력
            System.out.println("사칙연산 기호(+,-,/,*)를 입력하세요: ");
            char operator = calc.getOperator(sc);

            // 0으로 나누기 예외 검사
            try {
                calc.isValidDivision(num2, operator);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;  // 다시 처음으로 이동
            }

            //계산하기
            BigDecimal result = calc.calculate(num1, num2, operator);

            System.out.println("계산 결과 : " + result);
            System.out.println();

            while (true) {
                System.out.println("더 계산하시겠습니까?");
                System.out.println("1. list 입력시 계산내역 확인");
                System.out.println("2. remove 입력시 오래된 내역부터 삭제");
                System.out.println("3. exit 입력 시 종료");
                System.out.println("그 외 다른 키는 계산 계속하기 입니다.");
                System.out.println("4. threshold 입력 시 저장된 연산 결과들 중 새로 입력한 값보다 큰 값을 가진 목록을 볼 수 있습니다.");
                String answer = sc.next();
                if ("exit".equalsIgnoreCase(answer)) {
                    break outer;
                } else if ("list".equalsIgnoreCase(answer)) {
                    List<BigDecimal> results = calc.getResults();
                    for (BigDecimal r : results) {
                        System.out.println(r);
                    }
                } else if ("remove".equalsIgnoreCase(answer)) {
                    if (calc.removeOldestResult()) {
                        System.out.println("오래된 계산 내역이 삭제되었습니다.\n");
                    } else {
                        System.out.println("삭제할 결과가 없습니다.\n");
                    }
                } else if("threshold".equalsIgnoreCase(answer)) {
                    System.out.println("기준값을 입력해 주세요");
                    for(double d : calc.printResultsOverThreshold(sc.nextDouble())){
                        System.out.println(d);
                    }
                }
                else {
                    break;
                }
            }

        }
        sc.close();
    }
}
