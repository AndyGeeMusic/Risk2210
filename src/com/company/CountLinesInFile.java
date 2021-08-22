package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountLinesInFile {

    public CountLinesInFile() {
    }

    public static long getLinesInFile(String fileName) {
        Path path = Paths.get(fileName);

        long lines = 0;
        try {

            lines = Files.lines(path).count();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;

    }
}
