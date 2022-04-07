package com.nhnacademy.policyrepository;

import com.nhnacademy.bankservice.Money;
import com.nhnacademy.bankservice.Policy;

public class ExchangeWonForDollar implements Policy {
    double money;
    double rate = 0.05; // 우리나라에서 미국 돈으로 변경하려면 미국돈으로 변경한 후 미국 돈 5% 수수료로 제외하고 준다(동맹국이니까 조금 봐줍니다.)

    public ExchangeWonForDollar(double money){
        this.money = money;
    }
    @Override
    public Money getExchangeMoney() {
        return Money.dollar(round(money/1000 * (1 - rate)));
    }
}
