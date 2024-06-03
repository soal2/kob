package com.kob.matcingsystem.service;

public interface MatchingService {
    String addPlayer(Integer userid, Integer rating, Integer botId);
    String removePlayer(Integer userid);
}
