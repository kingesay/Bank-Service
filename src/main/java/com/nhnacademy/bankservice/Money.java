package com.nhnacademy.bankservice;

import java.util.Objects;

public class Money {
    private final long money;
    private Currency currency;

    public Money(long money, Currency currency) {
        if (money < 0) {
            throw new IllegalArgumentException("money is not negative. negative money : " + money);
        }
        this.money = money;
        this.currency = currency;
    }

    static Money dollar(long money) {
        return new Money(money, Currency.DOLLAR);
    }

    static Money won(long money) {
        return new Money(money, Currency.WON);
    }

    Money addMoney(Money money) {
        return new Money(this.money + money.getMoney(), this.currency);
    }

    long getMoney() {
        return this.money;
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

    public void isNotEqualCurrency(Money money) {
        if (!this.currency.equals(money.getCurrency())) {
            throw new IllegalArgumentException("Not Equal Currency. "
                + this.currency
                + " "
                + money.getCurrency());
        }
    }

    private Currency getCurrency() {
        return this.currency;
    }
}
