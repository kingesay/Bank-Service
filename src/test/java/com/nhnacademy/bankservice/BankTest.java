package com.nhnacademy.bankservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankTest {
    static public Bank bank = null;

    @BeforeAll
    static void setUp() {
        bank = new Bank();
    }

    @DisplayName("통화는 달러화와 원화만이 존재하고, 환율은 1달러 <-> 1,000원")
    @Test
    void exchangeWonForDollar() {
        Money money = Money.won(1000);
        Money resultMoney = bank.exchangeWonForDollar(money.getMoney());

        assertThat(resultMoney.getMoney()).isEqualTo(1);
        assertThat(resultMoney.getCurrency()).isEqualTo(Currency.DOLLAR);

        money = Money.won(1230);
        resultMoney = bank.exchangeWonForDollar(money.getMoney());

        assertThat(resultMoney.getMoney()).isEqualTo(1.23);
        assertThat(resultMoney.getCurrency()).isEqualTo(Currency.DOLLAR);
    }

    @DisplayName("통화는 달러화와 원화만이 존재하고, 1000원 <-> 1달러러")
    @Test
    void exchangeDollarForWon() {
        Money money = Money.dollar(1);
        Money resultMoney = bank.exchangeDollarForWon(money.getMoney());

        assertThat(resultMoney.getMoney()).isEqualTo(1000);
        assertThat(resultMoney.getCurrency()).isEqualTo(Currency.WON);
    }

    @DisplayName("5.25$ -> 5,250원")
    @Test
    void exchangeDollarForWonDetail() {
        Money money = Money.dollar(5.25);
        Money resultMoney = bank.exchangeDollarForWon(money.getMoney());

        assertThat(resultMoney.getMoney()).isEqualTo(5250);
        assertThat(resultMoney.getCurrency()).isEqualTo(Currency.WON);
    }


}
