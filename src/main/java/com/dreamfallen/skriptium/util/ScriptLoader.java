package com.dreamfallen.skriptium.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScriptLoader {
    public static String loadScript(File file) throws IOException {
        return Files.readString(file.toPath());
    }
}
