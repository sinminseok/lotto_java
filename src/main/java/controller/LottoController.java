package controller;

import model.Lotto;
import model.Rank;
import model.WinLotto;
import service.LottoService;
import service.RankService;
import service.ResultService;
import service.WinLottoService;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private LottoService lottoService = new LottoService();
    private WinLottoService winLottoService = new WinLottoService();
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private RankService rankService = new RankService();
    private ResultService resultService = new ResultService();
    private List<Lotto> lottos = new ArrayList<>();
    private WinLotto winLotto;


    public void run() {
        int lottoCount = lottoService.getLottoCount(inputView.inputPrice());
        lottos = lottoService.getLottos(lottoCount);
        outputView.printLottos(lottos);
        winLotto = winLottoService.createWinLotto(inputView.inputWinNumbers(), inputView.inputBonusNumber());
        resultService.getResult(rankService.createRanks(lottos, winLotto));

    }
}
