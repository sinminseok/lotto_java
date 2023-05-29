package service;

import model.Lotto;
import model.WinLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RankServiceTest {

    RankService rankService;
    LottoService lottoService;

    @BeforeEach
    void setUp() {
        rankService = new RankService();
        lottoService = new LottoService();
    }
    @Test
    @DisplayName("Rank 리스트 생성 테스트")
    void rank_리스트_생성(){
        List<Lotto> lottos = lottoService.getLottos(3);
        WinLotto winLotto = new WinLotto("1,2,3,4,5,6", "7");

        lottos.stream()
                        .forEach( i -> System.out.println(i.getNumbers()));
        rankService.createRanks(lottos,winLotto);
    }
}
