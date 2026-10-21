package com.dreamfallen.skriptium;

import org.bukkit.plugin.java.JavaPlugin;

public class Skriptium extends JavaPlugin {

    private static Skriptium instance;
    private ScriptManager scriptManager;

    @Override
    public void onEnable() {
        instance = this;

        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        this.scriptManager = new ScriptManager(this);

        getServer().getPluginManager().registerEvents(new ScriptEventListener(this), this);

        this.scriptManager.loadScripts();

        getLogger().info("Skriptium Engine successfully initialized.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Skriptium Engine shut down safely.");
    }

    public static Skriptium getInstance() {
        return instance;
    }

    public ScriptManager getScriptManager() {
        return scriptManager;
    }
}
