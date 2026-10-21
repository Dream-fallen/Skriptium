package com.dreamfallen.skriptium;

import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class Skriptium extends JavaPlugin {

    private static Skriptium instance;
    private ScriptManager scriptManager;

    @Override
    public void onEnable() {
        instance = this;
        
        // 1. Create the plugin folder automatically if it doesn't exist
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        // 2. Initialize the custom engine and file manager
        this.scriptManager = new ScriptManager();
        
        // 3. Register our core event listener to handle "on join", etc.
        getServer().getPluginManager().registerEvents(new ScriptEventListener(this), this);

        // 4. Load all .skm files from the plugin directory
        this.scriptManager.loadAllScripts(getDataFolder());

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
