package com.nhnacademy.bankservice;

import java.util.Objects;

public class Money {
    private final double money;
    private Currency currency;

    public Money(double money, Currency currency) {
        if (money < 0) {
            throw new IllegalArgumentException("money is not negative. negative money : " + money);
        }
        this.money = money;
        this.currency = currency;
    }

    static Money dollar(double money) {
        return new Money(money, Currency.DOLLAR);
    }

    static Money won(long money) {
        return new Money(money, Currency.WON);
    }

    Money addMoney(Money money) {
        isNotEqualCurrency(money);
        return new Money(decimalPointRound(this.money + money.getMoney()), this.currency);
    }

    Money subMoney(Money money) {
        isNotEqualCurrency(money);
        if (this.money < money.getMoney()) {
            throw new IllegalArgumentException(
                "sub result is not negative money. money : " + this.money + " < " +
                    money.getMoney());
        }
        return new Money(decimalPointRound(this.money - money.getMoney()), this.currency);
    }


    double getMoney() {
        return this.money;
    }

    public void isNotEqualCurrency(Money money) {
        if (!this.currency.equals(money.getCurrency())) {
            throw new IllegalArgumentException("Not Equal Currency. "
                + this.currency
                + " "
                + money.getCurrency());
        }
    }

    public Currency getCurrency() {
        return this.currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    public static double decimalPointRound(double money) {
        return Math.round(money*100)/100.0;
    }
}
