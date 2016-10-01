package org.codice.data.management.impl;

import org.codice.data.management.DataManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySqlManagment implements DataManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(MySqlManagment.class);

    public MySqlManagment() {

    }

    public void init() {
        LOGGER.trace("Initializing {}", MySqlManagment.class.getName());
    }

    @Override
    public void insert(String key, String value) {
        LOGGER.trace("Inserting Information");
    }


    @Override
    public void update(String key, String value) {
        LOGGER.trace("Updating Information");
    }


    @Override
    public void delete(String key) {
        LOGGER.trace("Deleting Information");
    }
}
