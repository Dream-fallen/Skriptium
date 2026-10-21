package com.dreamfallen.skriptium.minecraft.api;

import org.bukkit.entity.Player;

public class ScriptContext {
    private final Player player;

    public ScriptContext(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
