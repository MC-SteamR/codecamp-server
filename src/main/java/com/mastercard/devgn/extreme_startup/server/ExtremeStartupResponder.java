package com.mastercard.devgn.extreme_startup.server;

public class ExtremeStartupResponder extends GetHttpHandler {
    @Override
    protected String answer(String query) {
        return "team name";
    }
}
