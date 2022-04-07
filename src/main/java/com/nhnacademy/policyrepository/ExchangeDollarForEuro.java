package com.nhnacademy.policyrepository;

import com.nhnacademy.bankservice.Money;
import com.nhnacademy.bankservice.Policy;

public class ExchangeDollarForEuro implements Policy {
    double money;
    double rate = 0.1; // 달러에서 유럽으로 변경하려면 유럽돈으로 변경한 후 유럽돈 10% 수수료로 제외하고 준다.

    public ExchangeDollarForEuro(double money){
        this.money = money;
    }

    @Override
    public Money getExchangeMoney() {
        return Money.euro(round(this.money * 1.3 * (1 - rate)));
    }
}
