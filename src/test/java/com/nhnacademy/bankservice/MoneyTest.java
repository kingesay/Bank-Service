package com.nhnacademy.bankservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
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
    void isNotEqualCurrencyTest() {
        Money won = Money.won(1000L);
        Money dollar = Money.dollar(1000L);

        assertThatThrownBy(() -> won.isNotEqualCurrency(dollar))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Not Equal Currency");

    }

    @DisplayName("5$ - 6$ = Exception")
    @Test
    void subDollarFailTest() {
        Money dollar1 = Money.dollar(5L);
        Money dollar2 = Money.dollar(6L);

        assertThatThrownBy(() -> dollar1.subMoney(dollar2))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("sub result is not negative money.");

    }

    @DisplayName("10$ - 6$ = 4$")
    @Test
    void subDollarSuccessTest() {
        Money dollar1 = Money.dollar(10L);
        Money dollar2 = Money.dollar(6L);

        assertThat(dollar1.subMoney(dollar2).getMoney()).isEqualTo(4);
    }

    @Test
    void inputDecimalPointTest() {
        assertThatCode(() -> Money.dollar(5.25)).doesNotThrowAnyException();
    }

    @DisplayName("5.25$ + 5.25$ = 10.50$ (소숫점 이하 2자리)")
    @Test
    void addMoneyAboutDecimalPointTest() {
        Money dollar2 = Money.dollar(5.25);
        Money dollar1 = Money.dollar(5.25);

        assertThat(dollar1.addMoney(dollar2).getMoney()).isEqualTo(10.50);
    }

    @DisplayName("decimalPointRound 소수점 확인")
    @Test
    void decimalPointRoundTest() {
        assertThat(Money.decimalPointRound(5.2511111)).isEqualTo(5.25);
        assertThat(Money.decimalPointRound(5.24555)).isEqualTo(5.25);
        assertThat(Money.decimalPointRound(5.2566)).isEqualTo(5.26);

    }
    @DisplayName("5.2455$ + 5.2455$ = 10.49$ (소숫점 이하 2자리)")
    @Test
    void decimalPointRoundAddAndSubTest() {
        Money dollar2 = Money.dollar(5.2455);
        Money dollar1 = Money.dollar(5.2455);

        assertThat(dollar1.addMoney(dollar2).getMoney()).isEqualTo(10.49);

        Money dollar3 = Money.dollar(10.12);
        Money dollar4 = Money.dollar(9.119);

        assertThat(dollar3.subMoney(dollar4).getMoney()).isEqualTo(1);
    }


}
