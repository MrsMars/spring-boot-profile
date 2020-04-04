package com.aoher;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.system.OutputCaptureRule;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    private static final String SPRING_PROFILE_PROPERTY = "spring.profiles.active";
    private static final String RESPONSE_MESSAGE_SUNNY = "Today is sunny day!";
    private static final String RESPONSE_MESSAGE_RAINING = "Today is raining day!";

    @Rule
    public OutputCaptureRule outputCaptureRule = new OutputCaptureRule();

    @Test
    public void testDefaultProfiles() {
        App.main(new String[0]);
        String output = outputCaptureRule.toString();
        assertTrue(output.contains(RESPONSE_MESSAGE_SUNNY));
    }

    @Test
    public void testRainingProfile() {
        System.setProperty(SPRING_PROFILE_PROPERTY, "raining");
        App.main(new String[0]);
        String output = outputCaptureRule.toString();
        assertTrue(output.contains(RESPONSE_MESSAGE_RAINING));
    }

    @Test
    public void testRainingProfileWithArgs() {
        App.main(new String[] { "--" + SPRING_PROFILE_PROPERTY + "=raining" });
        String output = outputCaptureRule.toString();
        assertTrue(output.contains(RESPONSE_MESSAGE_RAINING));
    }

    @After
    public void tearDown() {
        System.clearProperty(SPRING_PROFILE_PROPERTY);
    }
}