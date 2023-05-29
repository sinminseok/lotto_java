package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testPattern() {
        String regex = "\\d+"; // 1개 이상의 숫자를 나타내는 정규식
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.pattern());
        String input = "Hello, 123 World!";
        Matcher matcher = pattern.matcher(input);
        boolean isMatch = matcher.matches(); // 전체 문자열과 패턴이 일치하는지 확인
        boolean isFound = matcher.find(); // 패턴과 일치하는 부분을 찾는지 확인

        if (isMatch) {
            System.out.println("Input matches the pattern.");
        }

        if (isFound) {
            String matchedPart = matcher.group(); // 일치하는 부분을 추출
            System.out.println("Matched part: " + matchedPart);
        }
    }


    // 아래에 추가 테스트 작성 가능
}
