package com.sunzequn.bp.xor;

import java.util.Scanner;

/**
 * Created by sloriac on 15-10-24.
 */
public class Main {

    private static Calculator mCalculator = new Calculator();

    public static void main(String[] args) {

        if (mCalculator.train())
            while (true) {
                System.out.println();
                System.out.println("请输入两个运算值(结束程序请输入-1)");
                Scanner scanner = new Scanner(System.in);
                int a = scanner.nextInt();
                if (a == -1)
                    return;
                int b = scanner.nextInt();
                mCalculator.test(a, b);
            }
    }
}
