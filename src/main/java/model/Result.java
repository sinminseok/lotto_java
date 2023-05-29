package model;

import java.util.Map;

public class Result {
    private final Map<Rank, Integer> result;

    public Result(Map<Rank, Integer> result) {
        this.result = result;
    }

    public void printResult() {
        for (Rank rank : Rank.values()) {
            int count = result.getOrDefault(rank, 0);
            System.out.println(rank + ": " + count);
        }
    }
}
