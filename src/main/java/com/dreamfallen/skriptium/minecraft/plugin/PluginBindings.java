package com.dreamfallen.skriptium.minecraft.plugin;

import com.dreamfallen.skriptium.Skriptium;

public class PluginBindings {
    private final Skriptium plugin;

    public PluginBindings(Skriptium plugin) {
        this.plugin = plugin;
    }

    public Skriptium getPlugin() {
        return plugin;
    }
}
