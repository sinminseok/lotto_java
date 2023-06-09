package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public enum Rank {

    FIRST(6, false, 2_000_000_000, (count, bonus) -> count == 6),
    SECOND(5, true, 30_000_000, (count, bonus) -> count == 5 && bonus),
    THIRD(5, false, 1_500_000, (count, bonus) -> count == 5 && !bonus),
    FOURTH(4, false, 50_000, (count, bonus) -> count == 4),
    FIFTH(3, false, 5_000, (count, bonus) -> count == 3),
    NONE(0, false, 0, (count, bonus) -> count <= 2);

    private final int count;
    private final int price;
    private final BiFunction<Integer,Boolean,Boolean> expression;

    Rank(int count, boolean bonus, int price, BiFunction<Integer, Boolean, Boolean> expression) {
        this.count = count;
        this.price = price;
        this.expression = expression;
    }

    public boolean win(int count, boolean bonus) {
        return expression.apply(count, bonus);
    }

    public int getCount() {
        return count;
    }


}