package com.nhnacademy.bankservice;

public interface Policy {
    public Money getExchangeMoney();

    default double round(double money){
        return ((int)(Math.round(money*100)))/100.0;
    }
}
