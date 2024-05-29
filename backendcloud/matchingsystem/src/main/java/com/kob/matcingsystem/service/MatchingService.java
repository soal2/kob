package com.kob.matcingsystem.service;

public interface MatchingService {
    String addPlayer(Integer userid, Integer rating);
    String removePlayer(Integer userid);
}
