package model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static service.LottoService.NUMBER_TYPE;

public class WinLotto {

    private final List<Integer> numbers;

    private final int bonusNumber;

    public WinLotto(String numbers, String bonusNumber) {
        validateNumbers(numbers);
        validateBonusNumbers(bonusNumber);
        this.numbers = convertStringToList(numbers);
        this.bonusNumber = convertStringToInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }


    private void validateNumbers(String numbers) {
        if (isStringMatch(numbers)) {
            throw new IllegalArgumentException("입력 형식이 잘못 됐습니다.");
        }
        if (isStringRange(numbers)) {
            throw new IllegalArgumentException(",를 이용해 6자리 숫자를 입력해주세요");
        }
    }

    private void validateBonusNumbers(String numbers) {
        if (isInt(numbers)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
        if (isStringBonusRange(numbers)) {
            throw new IllegalArgumentException(",를 이용해 6자리 숫자를 입력해주세요");
        }
    }

    public boolean isInt(String content) {
        return !Pattern.matches(NUMBER_TYPE, content);
    }

    private static boolean isStringBonusRange(String input) {
        if (input.length() < 1 || input.length() > 2) {
            return true;
        }
        return false;
    }

    private static boolean isStringRange(String input) {
//        if (input.length() != 11) {
//            return true;
//        }
        return false;
    }

    private static boolean isStringMatch(String input) {
        return !Pattern.compile("^\\d+(,\\d+)*$").matcher(input).matches();
    }

    private List<Integer> convertStringToList(String input) {
        List<Integer> integerList = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String number = matcher.group();
            integerList.add(Integer.parseInt(number));
        }
        return integerList;
    }


    private int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
