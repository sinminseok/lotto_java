package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static service.LottoService.NUMBER_RANGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (validateRange(numbers)) {
            throw new IllegalArgumentException("로또 개수가 6개가 아닙니다.");
        }
        if (validateDuplication(numbers)) {
            throw new IllegalArgumentException("중복되는 숫자가 있습니다.");
        }
    }

    private boolean validateRange(List<Integer> numbers) {
        if (numbers.size() != NUMBER_RANGE) {
            return true;
        }
        return false;
    }

    private boolean validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueSet = new HashSet<>(numbers);
        if ((uniqueSet.size() < numbers.size())) {
            return true;
        }
        return false;
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

}