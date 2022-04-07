package com.nhnacademy.bankservice;

public class Bank {
    Money exchangeWonForDollar(double money) {
        return Money.dollar(money / 1000);
    }

    Money exchangeDollarForWon(double money) {
        return  Money.won(roundOrNot((int)money*1000));
    }

    public double roundOrNot(int i) {
        int result = i%10; // 1222 2
        i/=10; // 122
        i*=10; // 1220
        if(result>=5)
            return i + 10;
        return i+result;
    }
}
