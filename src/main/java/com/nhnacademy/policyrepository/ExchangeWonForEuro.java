package com.nhnacademy.policyrepository;

import com.nhnacademy.bankservice.Money;
import com.nhnacademy.bankservice.Policy;

public class ExchangeWonForEuro implements Policy {
    double money;
    double rate = 0.5; // 한국돈에서 유럽으로 변경하려면 유럽돈으로 변경한 후 유럽돈 50% 수수료로 제외하고 준다.(유럽 전쟁중이니까 가지마세요.)

    public ExchangeWonForEuro(double money){
        this.money = money;
    }
    @Override
    public Money getExchangeMoney() {
        return Money.euro(round(this.money / 1300 * (1 - rate)));
    }
}
