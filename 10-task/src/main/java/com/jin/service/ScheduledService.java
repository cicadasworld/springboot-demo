package com.jin.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    @Scheduled(cron = "0 48 22 * * ?")
    public void schedule() {
        System.out.println("===========run==========");
    }
}
