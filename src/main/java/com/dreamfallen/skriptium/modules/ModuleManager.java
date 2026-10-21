package com.dreamfallen.skriptium.modules;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ModuleManager {

    private final Map<String, Module> modules = new HashMap<>();

    public void register(Module module) {
        if (module == null) {
            throw new IllegalArgumentException("Module cannot be null.");
        }
        modules.put(module.getName(), module);
    }

    public Optional<Module> getModule(String name) {
        return Optional.ofNullable(modules.get(name));
    }

    public boolean hasModule(String name) {
        return modules.containsKey(name);
    }
}
