package com.dreamfallen.skriptium.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public final class FileUtils {

    private FileUtils() {
    }

    public static String readText(File file) throws IOException {
        return Files.readString(file.toPath(), StandardCharsets.UTF_8);
    }

    public static void ensureDirectory(File dir) {
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
}
