package service;

import model.Lotto;
import model.Rank;
import model.WinLotto;

import java.util.*;
import java.util.stream.IntStream;

public class RankService {

    public List<Rank> createRanks(List<Lotto> lottos, WinLotto winLotto) {
        List<Rank> ranks = getRankList(lottos, winLotto);
        return ranks;
    }

    private List<Rank> getRankList(List<Lotto> lottos, WinLotto winLotto) {
        List<Rank> ranks = new ArrayList<>();
        IntStream.range(0, lottos.size())
                .forEach(i -> {
                    int count = calculateMatchCount(lottos.get(i).getNumbers(), winLotto.getNumbers());
                    int check_count = i;
                    ranks.add(Arrays.stream(Rank.values())
                            .filter(rank -> rank.win(count, hasBonus(lottos.get(check_count), winLotto.getBonusNumber())))
                            .findFirst()
                            .orElse(Rank.NONE));
                });
        return ranks;
    }


    private static <T> int calculateMatchCount(List<T> lottoNumbers, List<T> winLottoNumbers) {
        Set<T> set1 = new HashSet<>(lottoNumbers);
        Set<T> set2 = new HashSet<>(winLottoNumbers);
        set1.retainAll(set2);
        return set1.size();
    }

    private boolean hasBonus(Lotto lotto, int bonus) {
        return lotto.getNumbers().contains(bonus);
    }
}
