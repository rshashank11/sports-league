package com.team2.sportsleague.service;

import com.team2.sportsleague.model.Ranking;
import com.team2.sportsleague.repository.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    public List<Ranking> getAllRankings() {
        return rankingRepository.getAllRankings();
    }
}


