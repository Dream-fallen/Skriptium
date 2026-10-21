package com.dreamfallen.skriptium;

import org.bukkit.plugin.java.JavaPlugin;

public class Skriptium extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Skriptium has been successfully enabled!");
        // This is where you will initialize your custom parser/lexer 
        // for handling your .skm files later on.
    }

    @Override
    public void onDisable() {
        getLogger().info("Skriptium has been safely disabled.");
    }
}
