package com.bridge.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class NIOFileAPI {
    public static void main(String[] args) throws IOException {
        String url = System.getProperty("user.dir");
        Path path = Paths.get(url + "/src/main/java/com/bridge/io/Demo");

        // Check File Exists
        System.out.println("Demo directory exists:" + Files.exists(path));

        // creating directory
        Path directories = Files.createDirectories(path);
        System.out.println(directories);

        // check file not exist
        Path path1 = Path.of(url + "/src/main/java/com/bridge/io/Demo");
        System.out.println("Demo directory exists:" + Files.exists(path1));
        if (Files.exists(path1)) {
            // to delete directory
            path1.toFile().delete();
        }
        System.out.println("After delete operation demo exists:" + Files.exists(path1));

        //delete directory and file
        Path path3 = Paths.get(url + "/src/main/java/com/bridge/io/Demo");
        if (Files.exists(path3)) {
            FileUtils.deleteFiles(path3.toFile());
        }

        // creating  10 files in a temp directory
        Path path6 = Paths.get(url + "/src/main/java/com/bridge/io/TempDirectory");
        String folderPath = url + "/src/main/java/com/bridge/io/TempDirectory";
        Files.createDirectories(path6);
        IntStream.range(1, 10).forEach(value -> {
            Path tempFile = Paths.get(folderPath + "/temp" + value + ".java");
            try {
                Files.createFile(tempFile);
            } catch (IOException e) {
                System.out.println(e);
            }
        });

        // listing the files
        Files.list(path6).filter(value -> Files.isRegularFile(value))
                .forEach(System.out::println);

    }
}
