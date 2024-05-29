package com.kob.matcingsystem;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import com.kob.matcingsystem.service.impl.MatchingServiceImpl;
import com.kob.matcingsystem.service.impl.utils.MatchingPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MatchingSystemApplication {
    public static void main(String[] args) {
        //在服务器启动之前启动匹配池子
        MatchingServiceImpl.matchingPool.start();  //启动匹配线程
        SpringApplication.run(MatchingSystemApplication.class, args);
    }
}