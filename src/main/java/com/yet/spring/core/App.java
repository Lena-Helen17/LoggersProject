package com.yet.spring.core;

import com.yet.spring.bean.Client;
import com.yet.spring.loggers.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private Client client;
    private Map<EventType,EventLogger> loggerMap;
    private EventLogger defouldLogger;

    public App(Client client, EventLogger defouldLogger, Map<EventType, EventLogger> loggerMap) {
        this.client = client;
        this.defouldLogger = defouldLogger;
        this.loggerMap = loggerMap;
    }

    private void logEvent(Event event, String msg, EventType eventType) {
        EventLogger eventLogger = loggerMap.get(eventType);
        if (eventLogger == null) {
            eventLogger = defouldLogger;
        }
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {

        ApplicationContext ctx =  new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");

        Event event = ctx.getBean(Event.class);
        app.logEvent(event, "Ceйчас в сети 1 позьватель", null);

        event = ctx.getBean(Event.class);
        app.logEvent(event, "Ceйчас в сети 2 позьватель", EventType.ERROR);

        event = ctx.getBean(Event.class);
        app.logEvent(event, "Ceйчас в сети INFO позьватель", EventType.INFO);
        //app.logEvent("Ceйчас в сети 1 позьватель");
        //app.logEvent("Ceйчас в сети 2 позьватель");
        //App app = new App();

       // app.client = new com.yet.spring.bean.Client("1", "Katrin");

        //app.eventLogger = new com.yet.spring.bean.ConsoleEventLogger();

        //app.logEvent("Сейчас в сети пользователь 1");
    }
}
