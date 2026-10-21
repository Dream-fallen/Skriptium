package com.dreamfallen.skriptium.minecraft.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinBridge implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        // TODO: call script handlers for "on join"
    }
}
