package org.codice.rest.service;

import org.codice.data.management.DataManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestServiceImpl implements RestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestServiceImpl.class);

    public DataManager dataManager;

    public RestServiceImpl(DataManager dataManager) {
        this.dataManager = dataManager;
        LOGGER.trace("Setting datamanger {}", dataManager);
    }

    @Override
    public void insert(String entry) {
        LOGGER.trace("Inserting {}", entry);
        String[] entryArray = entry.split("-");
        if(entryArray.length == 2) {
            dataManager.insert(entryArray[0], entryArray[1]);
        }
    }

    @Override
    public void update(String entry) {
        LOGGER.trace("Updating {}", entry);
        String[] entryArray = entry.split("-");
        if(entryArray.length == 2) {
            dataManager.update(entryArray[0], entryArray[1]);
        }
    }

    @Override
    public void delete(String key) {
        LOGGER.trace("Deleting {}", key);
        dataManager.delete(key);
    }
}
