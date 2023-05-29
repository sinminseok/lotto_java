package service;

import model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import java.util.List;

public class LottoServiceTest {

    LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("입력한 금액만큼 로또 개수를 반환합니다.")
    void getLottoCount() {
        int lottoCount = lottoService.getLottoCount(String.valueOf(2000));
        Assertions.assertThat(lottoCount).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 발행 개수만큼 로또 객체를 생성해 List형식으로 반환합니다.")
    void getLottos() {
        List<Lotto> lottos = lottoService.getLottos(3);
        Assertions.assertThat(lottos.size()).isEqualTo(3);
    }


}
