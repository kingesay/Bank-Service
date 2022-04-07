package com.nhnacademy.bankservice;

public class Bank {
    Money exchangeWonForDollar(double money) {
        return Money.dollar(money / 1000);
    }

    Money exchangeDollarForWon(double money) {
        return  Money.won((long) (money * 1000));
    }
}
