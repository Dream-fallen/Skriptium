package com.dreamfallen.skriptium;

import java.io.File;

public class ScriptManager {

    private final Skriptium plugin;
    private final File scriptsFolder;

    public ScriptManager(Skriptium plugin) {
        this.plugin = plugin;
        // Automatically targets the 'plugins/Skriptium/scripts' directory
        this.scriptsFolder = new File(plugin.getDataFolder(), "scripts");
    }

    public void loadScripts() {
        // Automatically create the directories if they don't exist yet
        if (!scriptsFolder.exists()) {
            scriptsFolder.mkdirs();
            plugin.getLogger().info("Created default scripts folder at: " + scriptsFolder.getPath());
        }

        File[] files = scriptsFolder.listFiles((dir, name) -> name.endsWith(".skm"));
        if (files == null || files.length == 0) {
            plugin.getLogger().info("No .skm scripts found to load.");
            return;
        }

        plugin.getLogger().info("Found " + files.length + " script(s) to parse...");
        for (File file : files) {
            parseScript(file);
        }
    }

    private void parseScript(File file) {
        // TODO: Implement the custom parser for 'using py' and 'using js' syntax
        plugin.getLogger().info("Parsing script: " + file.getName());
    }
}
