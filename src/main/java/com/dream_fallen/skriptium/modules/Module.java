package com.dreamfallen.skriptium;

public class Module {

    private final String name;
    private String alias;
    private int priority;
    private final boolean isIsolated;

    /**
     * Constructor for an isolated namespace module.
     * Example: require(skquery) with alias query
     */
    public Module(String name, String alias) {
        this.name = name;
        this.alias = alias;
        this.priority = 5; // Default lowest priority
        this.isIsolated = true;
    }

    /**
     * Constructor for a prioritized framework module.
     * Example: require(tuske) with priority 1
     */
    public Module(String name, int priority) {
        this.name = name;
        this.alias = null;
        this.isIsolated = false;
        
        // Enforce your priority threshold (1 to 5)
        if (priority < 1 || priority > 5) {
            this.priority = 5;
        } else {
            this.priority = priority;
        }
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isIsolated() {
        return isIsolated;
    }

    /**
     * Utility to check if this module's syntax should override another 
     * during a compiler conflict.
     */
    public boolean overrides(Module other) {
        if (this.isIsolated || other.isIsolated()) {
            return false; // Isolated syntax rules don't collide globally
        }
        // Lower number priority wins (Priority 1 overrides Priority 2)
        return this.priority < other.getPriority();
    }
}
