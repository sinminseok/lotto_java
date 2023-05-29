package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @DisplayName("맞은 개수가 6이고 보너스 번호가 틀린 경우 1등이다.")
    @Test
    void first(){
        Rank rank = Rank.SECOND;
        System.out.println(rank.getCount());
        boolean win = rank.win(6, false);
        Assertions.assertThat(win).isTrue();
    }

}
