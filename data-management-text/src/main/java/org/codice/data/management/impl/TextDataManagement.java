package org.codice.data.management.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import org.codice.data.management.DataManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextDataManagement implements DataManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextDataManagement.class);

    private File file;

    public TextDataManagement(String filePath) {
        file = new File(filePath);
    }

    public void init() {
        LOGGER.trace("Initializing {}", TextDataManagement.class.getName());
    }

    @Override
    public void insert(String key, String value) {
        LOGGER.trace("Inserting Information");
        try {
            Files.write(file.toPath(),
                    (key + "-" + value + "\n").getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            LOGGER.error("Unable to insert information.", e);
        }
    }

    @Override
    public void update() {
        LOGGER.trace("Updating Information");
    }

    @Override
    public void delete() {
        LOGGER.trace("Deleting Information");
    }
}
