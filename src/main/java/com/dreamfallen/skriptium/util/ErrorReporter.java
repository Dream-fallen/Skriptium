package com.dreamfallen.skriptium.util;

public class ErrorReporter {
    public void report(String message) {
        System.err.println("[Skriptium] ERROR! " + message);
    }
}
