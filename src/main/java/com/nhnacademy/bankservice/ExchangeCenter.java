package com.nhnacademy.bankservice;

import com.nhnacademy.policyrepository.ExchangeDollarForEuro;
import com.nhnacademy.policyrepository.ExchangeDollarForWon;
import com.nhnacademy.policyrepository.ExchangeEuroForDollar;
import com.nhnacademy.policyrepository.ExchangeEuroForWon;
import com.nhnacademy.policyrepository.ExchangeWonForDollar;
import com.nhnacademy.policyrepository.ExchangeWonForEuro;

public class ExchangeCenter {
    public static Money pleaseExchange(Money myMoney, Currency currency) {
        if (myMoney.getCurrency().equals(Currency.DOLLAR)) {
            if (currency.equals(Currency.WON)) {
                Policy policy = new ExchangeDollarForWon(myMoney.getMoney());
                return policy.getExchangeMoney() ;
            }

            // 목표 통화가 현재 currency.equals(Currency.EURO)인 경우
            Policy policy = new ExchangeDollarForEuro(myMoney.getMoney());
            return policy.getExchangeMoney();

        }

        if (myMoney.getCurrency().equals(Currency.WON)) {
            if (currency.equals(Currency.DOLLAR)) {
                Policy policy = new ExchangeWonForDollar(myMoney.getMoney());
                return policy.getExchangeMoney();
            }

            // 목표 통화가 현재 currency.equals(Currency.EURO)인 경우
            Policy policy = new ExchangeWonForEuro(myMoney.getMoney());
            return policy.getExchangeMoney();
        }

        if (myMoney.getCurrency().equals(Currency.EURO)) {
            if (currency.equals(Currency.DOLLAR)) {
                Policy policy = new ExchangeEuroForDollar(myMoney.getMoney());
                return policy.getExchangeMoney();
            }

            // 목표 통화가 현재 currency.equals(Currency.WON)인 경우
            Policy policy = new ExchangeEuroForWon(myMoney.getMoney());
            return policy.getExchangeMoney();
        }

        return null;
    }
}
