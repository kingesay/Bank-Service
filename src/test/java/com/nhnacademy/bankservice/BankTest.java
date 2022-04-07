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

    @DisplayName("달러 -> 원화: 5원 이상 -> 10원으로 반올림")
    @Test
    void roundOrNotDollarForWonTest() {
        assertThat(bank.roundOrNotDollarForWon(5)).isEqualTo(10);
        assertThat(bank.roundOrNotDollarForWon(1225)).isEqualTo(1230);
        assertThat(bank.roundOrNotDollarForWon(1222)).isEqualTo(1222);
    }

    @DisplayName("달러 -> 원화: 5원 이상 -> 10원으로 반올림")
    @Test
    void exchangeDollarForWon_Round() {
        assertThat(bank.exchangeDollarForWon(0.005).getMoney()).isEqualTo(10);
        assertThat(bank.exchangeDollarForWon(1.222).getMoney()).isEqualTo(1222);
        assertThat(bank.exchangeDollarForWon(1.225).getMoney()).isEqualTo(1230);
    }

    @DisplayName("원화 -> 달러: $0.005 이상 -> $0.01 반올림")
    @Test
    void roundOrNotWonForDollarTest() {
        assertThat(bank.roundOrNotWonForDollar(0.005)).isEqualTo(0.01);
        assertThat(bank.roundOrNotWonForDollar(1.222)).isEqualTo(1.222);
//        assertThat(bank.roundOrNotWonForDollar(1.225)).isEqualTo(1.230);
    }

}
