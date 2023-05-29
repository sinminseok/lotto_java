package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

public class WinLottoTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,", "1,2,3,4,5,6,7","a,s,d,f,g,h"})
    void 로또_당첨번호_잘못된_입력형식(String lottoPurchaseAmount) {
        Assertions.assertThatThrownBy(() ->new WinLotto(lottoPurchaseAmount,"1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 형식이 잘못 됐습니다.");
    }


}
