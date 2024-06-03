package com.kob.matcingsystem.service.impl;

import com.kob.matcingsystem.service.MatchingService;
import com.kob.matcingsystem.service.impl.utils.MatchingPool;
import org.springframework.stereotype.Service;

@Service
public class MatchingServiceImpl implements MatchingService {

    public final static MatchingPool matchingPool = new MatchingPool();  //匹配池实例
    @Override
    public String addPlayer(Integer userId, Integer rating, Integer botId) {
        System.out.println("add player:" + userId + " " + rating);
        matchingPool.addPlayer(userId, rating, botId);
        return "add player success!";
    }

    @Override
    public String removePlayer(Integer userId) {
        System.out.println("remove player:" + userId);
        matchingPool.removePlayer(userId);
        return "remove player success!";
    }
}
