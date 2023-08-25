package com.mastercard.devgn.extreme_startup.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import static java.net.URLDecoder.decode;

public abstract class GetHttpHandler implements HttpHandler {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public final void handle(HttpExchange httpExchange) {
        try {
            log.info("Request: {} {}", httpExchange.getRequestMethod(), httpExchange.getRequestURI());

            String response = "";
            if ("GET".equals(httpExchange.getRequestMethod())) {
                String q = getQuery(httpExchange.getRequestURI().toString());
                log.info("   Query: {}", q);
                response = answer(q);
            }
            log.info("Response: {}", response);
            respond(httpExchange, response);
        } catch(Exception ex) {
            log.error("Failed to process request", ex);
        }
    }

    private String getQuery(String uri) throws UnsupportedEncodingException {
        if(uri.contains("?q=")) {
            return decode(uri.substring(uri.indexOf("?q=")+3), "UTF-8");
        } else {
            return "";
        }
    }


    protected abstract String answer(String query);

    private void respond(HttpExchange exchange, String responseText) throws IOException {
        OutputStream outputStream = exchange.getResponseBody();

        exchange.sendResponseHeaders(200, responseText.length());
        outputStream.write(responseText.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
