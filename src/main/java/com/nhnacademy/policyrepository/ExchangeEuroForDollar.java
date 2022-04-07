package com.nhnacademy.policyrepository;


import com.nhnacademy.bankservice.Money;
import com.nhnacademy.bankservice.Policy;

public class ExchangeEuroForDollar implements Policy {
    double money;
    double rate = 0.20; // 유럽에서 미국 돈으로 변경하려면 미국돈으로 변경한 후 미국 돈 20% 수수료로 제외하고 준다(미국 가지마세요.)

    public ExchangeEuroForDollar(double money){
        this.money = money;
    }

    @Override
    public Money getExchangeMoney() {
        return Money.dollar(round(this.money / 1.3 * (1 - rate)));
    }
}
