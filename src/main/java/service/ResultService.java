package service;

import model.Rank;
import model.Result;

import java.util.*;

public class ResultService {

    public void getResult(List<Rank> ranks) {
        Map<Rank, Integer> rankCounts = new HashMap<>();
        for (Rank rank : ranks) {
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
        Result result = new Result(rankCounts);
        result.printResult();
    }


}
