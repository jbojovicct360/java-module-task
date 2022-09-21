package org.example;

import org.example.io.ThreadReader;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {

    public static ArrayList<String> getInputFiles() throws IOException {
        ArrayList<String> fileSet = new ArrayList<>();
        String dir = System.getProperty("user.dir") + "/input";
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileSet.add(path.getFileName()
                            .toString());
                }
            }
        }
        return fileSet;
    }
    public static void main(String[] args) throws Exception {
        ArrayList<String> files = getInputFiles();
        int numberOfTasks = files.size();
        // moze i ovako
        // ExecutorService fixed = Executors.newFixedThreadPool(numberOfTasks);
        ExecutorService cached = Executors.newCachedThreadPool();
        for(int i = 0; i < numberOfTasks; i++) {
            cached.execute(new ThreadReader(files.get(i)));
        }
        cached.shutdown();
    }
}