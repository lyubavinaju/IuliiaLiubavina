package com.epam.tc.hw5.cucumber.context;

import java.util.HashMap;
import java.util.Map;

public final class TestContext {
    private static TestContext instance;

    private TestContext() {
    }

    private final Map<String, Object> context = new HashMap<>();

    public <T> T getValue(String key, Class<T> valueClass) {
        return valueClass.cast(context.get(key));
    }

    public void addValue(String key, Object value) {
        context.put(key, value);
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
}
