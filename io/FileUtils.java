package com.bridge.io;

import java.io.File;

public class FileUtils {
    public static boolean deleteFiles(File files) {
        System.out.println(files);
        File[] listFiles = files.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                deleteFiles(file);
            }
        } // deleting files
        return files.delete();
    }
}
