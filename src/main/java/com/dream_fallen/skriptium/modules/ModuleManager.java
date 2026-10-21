package com.dreamfallen.skriptium;

import java.util.HashMap;
import java.util.Map;

public class ModuleManager {

    private final Skriptium plugin;
    
    // Tracks loaded addons and their designated alias namespaces
    private final Map<String, Object> loadedModules = new HashMap<>();
    
    // Tracks syntax priorities (Priority 1 = Highest, 5 = Lowest)
    private final Map<String, Integer> modulePriorities = new HashMap<>();

    public ModuleManager(Skriptium plugin) {
        this.plugin = plugin;
    }

    /**
     * Registers a module/addon with an isolated namespace (Alias).
     * Example syntax: require(skquery) with alias query
     */
    public void registerModuleWithAlias(String moduleName, String alias) {
        // TODO: Hook into external plugin APIs (like SkQuery, SkBee, etc.)
        loadedModules.put(alias, moduleName);
        plugin.getLogger().info("Loaded addon '" + moduleName + "' isolated under alias '" + alias + "'");
    }

    /**
     * Registers a module/addon with a priority level to handle syntax collisions.
     * Example syntax: require(tuske) with priority 1
     */
    public void registerModuleWithPriority(String moduleName, int priority) {
        if (priority < 1 || priority > 5) {
            plugin.getLogger().warning("Priority for " + moduleName + " must be between 1 and 5. Defaulting to 5.");
            priority = 5;
        }
        
        modulePriorities.put(moduleName, priority);
        plugin.getLogger().info("Loaded addon '" + moduleName + "' with priority level: " + priority);
    }

    /**
     * Checks if a specific syntax rule conflict should be overridden by a priority module.
     */
    public boolean hasPriorityOver(String moduleA, String moduleB) {
        int priorityA = modulePriorities.getOrDefault(moduleA, 5);
        int priorityB = modulePriorities.getOrDefault(moduleB, 5);
        
        // Lower number equals higher precedence (1 overrides 2)
        return priorityA < priorityB;
    }

    public void clearModules() {
        loadedModules.clear();
        modulePriorities.clear();
    }
}
