package com.yet.spring.loggers;

import java.util.List;

public class CombinerEventLogger implements EventLogger{
    List<EventLogger> loggerList;

    public CombinerEventLogger(List<EventLogger> loggerList) {
        this.loggerList = loggerList;
    }

    @Override
    public void logEvent(Event event) {
      //  loggerList.forEach(loggerList -> loggerList.toString());
    }
}
