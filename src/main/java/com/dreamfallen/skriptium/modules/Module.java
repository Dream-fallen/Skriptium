package com.dreamfallen.skriptium.modules;

public interface Module {
    String getName();

    default String getAlias() {
        return getName();
    }

    default int getPriority() {
        return 5;
    }

    default boolean isBuiltIn() {
        return true;
    }
}
