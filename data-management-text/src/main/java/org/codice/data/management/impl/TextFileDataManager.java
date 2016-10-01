package org.codice.data.management.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.codice.data.management.DataManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextFileDataManager implements DataManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextFileDataManager.class);

    private File file;

    public TextFileDataManager(String filePath) {
        file = new File(filePath);
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                LOGGER.error("Unable to create file : {}", filePath);
            }
        }
    }

    public void init() {
        LOGGER.trace("Initializing {}", TextFileDataManager.class.getName());
    }

    @Override
    public void insert(String key, String value) {
        LOGGER.trace("Inserting Information");
        try {
            if (!doesKeyExistInFile(key)) {
                Files.write(file.toPath(),
                        (key + "-" + value + "\n").getBytes(),
                        StandardOpenOption.APPEND);
            }

            // printTextFileContents();
        } catch (IOException e) {
            LOGGER.error("Unable to insert information.", e);
        }
    }

    @Override
    public void update(String key, String value) {
        LOGGER.trace("Updating Information");
        try {
            Files.write(file.toPath(), changeValueOf(key, value), Charset.defaultCharset());
        } catch (IOException e) {
            LOGGER.error("Unable to update information.", e);
        }
    }

    @Override
    public void delete(String key) {
        LOGGER.trace("Deleting Information {}", key);
        try {
            Files.write(file.toPath(), removeValueOf(key), Charset.defaultCharset());
        } catch (IOException e) {
            LOGGER.error("Unable to delete information", e);
        }
    }

    private boolean doesKeyExistInFile(String key) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath(), Charset.defaultCharset());
        for (String line : lines) {
            if (line.contains(key)) {
                return true;
            }
        }
        return false;
    }

    private List<String> changeValueOf(String key, String value) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath(), Charset.defaultCharset());
        List<String> newLines = new ArrayList<>();
        for (String line : lines) {
            if (line.contains(key)) {
                newLines.add(key + "-" + value);
            } else {
                newLines.add(line);
            }

        }
        return newLines;
    }

    private List<String> removeValueOf(String key) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath(), Charset.defaultCharset());
        return lines.stream().filter(line -> !line.contains(key)).collect(
                Collectors.toList());
    }

    private void printTextFileContents() throws IOException {
        List<String> lines = Files.readAllLines(file.toPath(), Charset.defaultCharset());
        lines.stream().peek(line -> LOGGER.info("{}", line));
    }
}
