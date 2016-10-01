package org.codice.data.management;

public interface DataManager {

    void insert(String key, String value);

    void update(String key, String value);

    void delete(String key);
}
