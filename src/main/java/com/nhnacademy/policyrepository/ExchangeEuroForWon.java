package com.nhnacademy.policyrepository;

import com.nhnacademy.bankservice.Money;
import com.nhnacademy.bankservice.Policy;

public class ExchangeEuroForWon implements Policy {
    double money;
    double rate = 0.001; // 유로에서 우리나라 돈으로 변경하려면 한국돈으로 변경한 후 한국돈 0.1% 수수료로 제외하고 준다(우리나라로 많이 오세요).

    public ExchangeEuroForWon(double money){
        this.money = money;
    }
    @Override
    public Money getExchangeMoney()
    {
        return Money.won(round(this.money * 1300 * (1 - rate)));
    }
}
