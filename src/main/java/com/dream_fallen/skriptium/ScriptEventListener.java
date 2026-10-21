package com.dreamfallen.skriptium;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ScriptEventListener implements Listener {

    private final Skriptium plugin;

    public ScriptEventListener(Skriptium plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // This acts as the bridge to pass 'event.player' data to the parsed '.skm' files
        // logic will hook into plugin.getScriptManager() here later
    }
}
