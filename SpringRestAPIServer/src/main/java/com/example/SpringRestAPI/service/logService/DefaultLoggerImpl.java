package com.example.SpringRestAPI.service.logService;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "project.logger", havingValue = "default", matchIfMissing = true)
public class DefaultLoggerImpl implements Logger {
    @Override
    public void log(String request, String data) {
        System.out.println("A request was made.");
    }
}
