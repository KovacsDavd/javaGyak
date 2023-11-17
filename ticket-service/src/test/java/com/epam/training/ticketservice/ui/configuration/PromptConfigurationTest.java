package com.epam.training.ticketservice.ui.configuration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromptConfigurationTest {
    @InjectMocks
    private PromptConfiguration promptConfiguration;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPrompt() {
        var prompt = promptConfiguration.getPrompt();
        assertEquals("Ticket service>", prompt.toString());
    }
}
