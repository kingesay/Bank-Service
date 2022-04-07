package com.nhnacademy.policyrepository;

import com.nhnacademy.bankservice.Money;
import com.nhnacademy.bankservice.Policy;

public class ExchangeDollarForWon implements Policy {
    double money;
    double rate = 0.001; // 달러에서 우리나라 돈으로 변경하려면 한국돈으로 변경한 후 한국돈 0.1% 수수료로 제외하고 준다(우리나라로 많이 오세요).

    public ExchangeDollarForWon(double money) {
        this.money = money;
    }

    @Override
    public Money getExchangeMoney() {
        return Money.won(round(money * 1000  * (1 - rate)));
    }


}
