package ru.job4j.dream.utils;

import java.io.File;

public class FileUtils {
    public static File getFileById(String id) {
        File targetFile = null;
        for (File file : new File("c:\\images\\").listFiles()) {
            if ((id + ".jpg").equalsIgnoreCase(file.getName()) ||
                    (id + ".png").equalsIgnoreCase(file.getName())) {
                targetFile = file;
                break;
            }
        }
        return targetFile;
    }
}
