package com.yet.spring.bean;

import com.yet.spring.loggers.Event;
import com.yet.spring.loggers.EventLogger;

public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
