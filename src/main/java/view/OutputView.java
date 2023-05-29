package view;

import model.Lotto;

import java.util.List;

public class OutputView {

    private final static String BUY_LOTTO_MESSAGE = "개를 구매했습니다.";

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + BUY_LOTTO_MESSAGE);
        printLottosString(lottos);
    }

    private void printLottosString(List<Lotto> lottos) {
        lottos.stream().forEach(e -> {
            String result = e.getNumbers().stream()
                    .map(Object::toString)
                    .reduce((s1, s2) -> s1 + ", " + s2)
                    .orElse("");
            System.out.println("[" + result + "]");
        });
    }
}
