package com.kob.botrunningsystem.service.impl.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BotPool extends Thread{
    private final static ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();  //条件变量
    private final Queue<Bot> bots = new LinkedList<>();

    public void addBot(Integer userId, String botCode, String input) {
        lock.lock();
        try {
            bots.add(new Bot(userId, botCode, input));
            condition.signal();  //唤醒另外一个线程
        } finally {
            lock.unlock();
        }
    }

    private void consume(Bot bot) {
        Consumer consumer = new Consumer();
        consumer.startTimeout(2000, bot);
    }

    @Override
    public void run() {
        while(true) {
            lock.lock();
            if(bots.isEmpty()) {
                try {
                    condition.await();  //阻塞当前线程直至被唤醒(自动放锁)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            } else {
                Bot bot = bots.remove();
                lock.unlock();
                consume(bot);  // 操作比较耗时，因此执行前需要解锁
            }
        }
    }
}
