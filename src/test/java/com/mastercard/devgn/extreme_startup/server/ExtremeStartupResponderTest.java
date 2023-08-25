package com.mastercard.devgn.extreme_startup.server;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExtremeStartupResponderTest {

    private final ExtremeStartupResponder server = new ExtremeStartupResponder();

    @Test
    void should_accept_missing_input() {
        assertEquals("team name", server.answer(null));
    }

    @Test
    void should_add_numbers() {
        assertEquals("18", server.answer("what is the sum of 14 and 4"));
    }
}
