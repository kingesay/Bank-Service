package com.nhnacademy.bankservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("1000 + 1000 = 2000")
    @Test
    void addMoneyTest() {
//        Money money1 = new Money(1000L);
//        Money money2 = new Money(1000L);
        Money money1 = Money.won(1_000L);
        Money money2 = Money.won(1_000L);

        Money resultMoney = money1.addMoney(money2);

        assertThat(resultMoney.getMoney()).isEqualTo(2000L);
    }

    @DisplayName("2,000원과 2,000원은 같다.(equals)")
    @Test
    void equalMoneyTest() {
//        Money money1 = new Money(2000L);
//        Money money2 = new Money(2000L);
        Money money1 = Money.won(2_000L);
        Money money2 = Money.won(2_000L);

        assertThat(money1.equals(money2)).isTrue();
    }

    @DisplayName("돈은 음수일 수 없다.")
    @Test
    void notNegativeMoneyTest() {
        long negativeMoney = -1L;

        assertThatThrownBy(() -> Money.dollar(negativeMoney))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("negative");

    }

    @DisplayName("5$ + 5$ = 10$")
    @Test
    void addDollarTest() {
        //Money money = new Money(1_000L , DOLLAR);

        Money money1 = Money.dollar(5);
        Money money2 = Money.dollar(5);
        Money money3 = Money.dollar(10);

        assertThat(money1.addMoney(money2)).isEqualTo(money3);
    }

    @DisplayName("1000WON + 1000DOL = Exception")
    @Test
    void isNotEqualCurrency() {
        Money won = Money.won(1000L);
        Money dollar = Money.dollar(1000L);

        assertThatThrownBy(()->won.isNotEqualCurrency(dollar))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Not Equal Currency");

    }
}
