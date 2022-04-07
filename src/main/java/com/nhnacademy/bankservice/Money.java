package com.nhnacademy.bankservice;

import java.util.Objects;

public class Money {
    long money = 0;
    String currency = "";
    public Money(long money) {
        if(money<0){
            throw new IllegalArgumentException("money is not negative. negative money : " + money);
        }
        this.money = money;
    }

    public Money(long money, String currency) {
        if(money<0){
            throw new IllegalArgumentException("money is not negative. negative money : " + money);
        }
        this.money = money;
        this.currency = currency;
    }

    static Money dollar(long money){
        return null;
    }

    Money addMoney(Money money){

        return new Money(this.money + money.getMoney());
    }

    long getMoney(){
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

}
