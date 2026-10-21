package com.dreamfallen.skriptium;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ScriptManager {

    private final Skriptium plugin;
    private final File scriptsFolder;

    public ScriptManager(Skriptium plugin) {
        this.plugin = plugin;
        this.scriptsFolder = new File(plugin.getDataFolder(), "scripts");
    }

    public void loadScripts() {
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

    public void loadAllScripts(File dataFolder) {
        File folder = new File(dataFolder, "scripts");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File[] files = folder.listFiles((dir, name) -> name.endsWith(".skm"));
        if (files == null || files.length == 0) {
            plugin.getLogger().info("No .skm scripts found under " + folder.getAbsolutePath());
            return;
        }

        for (File file : files) {
            parseScript(file);
        }
    }

    public List<File> getScriptFiles() {
        List<File> result = new ArrayList<>();

        if (!scriptsFolder.exists()) {
            return result;
        }

        File[] files = scriptsFolder.listFiles((dir, name) -> name.endsWith(".skm"));
        if (files != null) {
            for (File file : files) {
                result.add(file);
            }
        }

        return result;
    }

    private void parseScript(File file) {
        plugin.getLogger().info("Parsing script: " + file.getName());
        // TODO: implement lexer/parser/interpreter pipeline here
    }
}
