package service;

import model.WinLotto;


public class WinLottoService {

    public WinLotto createWinLotto(String winLottoNumbers,String bonusNumber) {
        return new WinLotto(winLottoNumbers,bonusNumber);
    }

}
