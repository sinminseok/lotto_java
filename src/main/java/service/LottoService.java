package service;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    public final static String NUMBER_TYPE = "^[0-9]*$"; //숫자만
    public final static int NUMBER_RANGE = 6;

    private final static String NOT_INT = "숫자를 입력해주세요.";
    private final static String NOT_PRICE_RANGE = "1000원 단위로 입력해주세요";
    private final static int MIN_PRICE = 1000;
    private final static int REMAIN = 0;
    private final static int ONE_THOUSAND_WON = 1000;

    public int getLottoCount(String price) {
        validatePrice(price);
        return calculateCount(Integer.parseInt(price));
    }

    public List<Lotto> getLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> createLotto())
                .collect(Collectors.toList());
    }

    private int calculateCount(int price) {
        return price / ONE_THOUSAND_WON;
    }

    private Lotto createLotto() {
        return new Lotto(createNumbers());
    }

    private List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void validatePrice(String price) {
        if (validateInt(price)) {
            throw new IllegalArgumentException(NOT_INT);
        }
        if (validatePriceRange(price)) {
            throw new IllegalArgumentException(NOT_PRICE_RANGE);
        }
    }

    public boolean validateInt(String content) {
        return !Pattern.matches(NUMBER_TYPE, content);
    }

    public boolean validatePriceRange(String price) {
        if (Integer.parseInt(price) < MIN_PRICE || Integer.parseInt(price) % MIN_PRICE != REMAIN) {
            return true;
        }
        return false;
    }
}
