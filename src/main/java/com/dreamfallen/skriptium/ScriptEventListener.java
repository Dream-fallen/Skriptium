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
        plugin.getLogger().info("Player joined: " + event.getPlayer().getName());
        // TODO: trigger any "on join" script handlers here
    }
}
