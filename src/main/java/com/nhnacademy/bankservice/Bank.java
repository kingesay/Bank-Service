package com.nhnacademy.bankservice;

public class Bank {
    Money exchangeWonForDollar(double money) {
        return Money.dollar(money / 1000);
    }

    Money exchangeDollarForWon(double money) {
        return Money.won(roundOrNotWon((int) (money * 1000)));
    }

    // 해당 코드를 테스트 성공후에 아래에 예쁘게 리팩토링 했습니다 ^^
    //    public double roundOrNot(int i) {
    //        int result = i%10; // 1222 2
    //        i/=10; // 122
    //        i*=10; // 1220
    //        if(result>=5)
    //            return i + 10;
    //        return i+result;
    //    }

    public double roundOrNotWon(int money) {
        if (money % 10 >= 5) {
            return (money / 10 * 10) + 10;
        }

        return money;
    }

    double roundOrNotDollar(double money) {
        return roundOrNotWon((int) (money * 1000)) / 1000;
    }

    public Money exchange(Money myMoney, Currency currency) {
        return ExchangeCenter.pleaseExchange(myMoney, currency);
    }
}
