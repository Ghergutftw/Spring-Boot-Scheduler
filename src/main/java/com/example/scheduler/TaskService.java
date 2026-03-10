package com.example.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.Instant;

@Service
public class TaskService {

    private String lastEvent = "System initialized";

    @Scheduled(fixedDelay = 5000)
    public void runScheduledTask() {
        lastEvent = "Scheduled task ran at " + Instant.now();
        System.out.println(lastEvent);
    }

    public void triggerManualTask() {
        lastEvent = "Manual trigger activated at " + Instant.now();
        System.out.println(lastEvent);
    }

    public TaskStatus getStatus() {
        return new TaskStatus(lastEvent, System.currentTimeMillis());
    }
}