package ru.practicum;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class LaterApplication {
    private static final int PORT = 8080;

    public static void main(String[] args) throws LifecycleException {

        Tomcat tomcat = new Tomcat();
        tomcat.getConnector().setPort(PORT);

        tomcat.start();
    }
}