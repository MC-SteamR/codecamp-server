package com.mastercard.devgn.extreme_startup.server;

import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class WebserverServer {

    private static final Logger log = LoggerFactory.getLogger(WebserverServer.class);

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(1337), 0);

        server.createContext("/", new ExtremeStartupResponder());
        server.setExecutor(Executors.newFixedThreadPool(10));
        server.start();
        log.info(" Server started on port 1337");
    }
}
