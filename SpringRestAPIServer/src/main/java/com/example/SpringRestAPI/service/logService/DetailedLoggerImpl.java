package com.example.SpringRestAPI.service.logService;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "project.logger", havingValue = "detail", matchIfMissing = false)
public class DetailedLoggerImpl implements Logger {
    @Override
    public void log(String request, String data) {
        System.out.println("A request was made: "+request+", with parameter: "+data);
    }
}
