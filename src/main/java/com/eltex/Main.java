package com.eltex;


import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {

    private static final double DISCOUNT = 0.02;
    private static final int DISCOUNT_START = 3000;

    public static void main(String[] args) throws UnsupportedEncodingException {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Введите валюту: 1 - RUB, 2 - BYN, 3 - KZT");
        final String currencySymbol = ValueType.getSymbol(scanner.nextInt());

        System.out.println("Введите сумму покупок за прошлый год");

        final int clientYearlyPurchases = scanner.nextInt();

        final double totalDiscount;
        if (clientYearlyPurchases >= DISCOUNT_START) {
            totalDiscount = clientYearlyPurchases * DISCOUNT;
        } else {
            totalDiscount = 0;
        }

        if (totalDiscount == 0) {
            System.out.println("Попробуйте нашу новую подписку и сэкономьте 2%");
        } else {
            System.out.printf("За прошлый год вы бы сэкономили с подпиской %s %s ", totalDiscount, currencySymbol);
        }
    }
}