package com.dreamfallen.skriptium;

import java.util.HashMap;
import java.util.Map;

public class ModuleManager {

    private final Skriptium plugin;
    // Single consolidated registry mapping module names/aliases to their configuration objects
    private final Map<String, Module> registeredModules = new HashMap<>();

    public ModuleManager(Skriptium plugin) {
        this.plugin = plugin;
    }

    public void registerIsolatedModule(String moduleName, String alias) {
        Module module = new Module(moduleName, alias);
        registeredModules.put(alias, module); // Keyed by alias to preserve local scoping rules
        plugin.getLogger().info("Registered isolated module: " + moduleName + " as [" + alias + "]");
    }

    public void registerPrioritizedModule(String moduleName, int priority) {
        Module module = new Module(moduleName, priority);
        registeredModules.put(moduleName, module); // Keyed by core name for global syntax lookups
        plugin.getLogger().info("Registered global module: " + moduleName + " (Priority: " + priority + ")");
    }

    public Map<String, Module> getRegisteredModules() {
        return registeredModules;
    }

    public void clearModules() {
        registeredModules.clear();
    }
}
