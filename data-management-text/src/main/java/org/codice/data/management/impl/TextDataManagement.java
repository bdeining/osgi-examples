package org.codice.data.management.impl;

import org.codice.data.management.DataManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextDataManagement implements DataManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextDataManagement.class);

    public TextDataManagement() {

    }

    public void init() {
        LOGGER.trace("Initializing {}", TextDataManagement.class.getName());
    }

    @Override
    public void insert() {
        LOGGER.trace("Inserting Information");
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
