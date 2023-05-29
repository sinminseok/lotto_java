package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.LottoService;
import service.RankService;
import service.ResultService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResultServieTest {

    private List<Lotto> lottos = new ArrayList<>();
    private WinLotto winLotto;
    private LottoService lottoService = new LottoService();
    private RankService rankService = new RankService();
    private ResultService resultService = new ResultService();


    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Result생성 테스트")
    void result테스트() {


        lottos = lottoService.getLottos(3);
        winLotto = new WinLotto("1,2,3,4,5,6", "7");
        List<Rank> ranke = rankService.createRanks(lottos, winLotto);
        resultService.getResult(ranke);
    }


}
