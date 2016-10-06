package org.codice.data.management.command;

import org.codice.data.management.DataManager;

/*
@Command(scope = "data", name = "insert", description = "Inserts key/value pair.")
@Service
*/
public class InsertCommand /*implements Action*/ {

    private DataManager dataManager;
/*    @Reference


    @Argument(index = 0, name = "key", description = "Key to insert.", required = true, multiValued = false)
    String key;

    @Argument(index = 1, name = "value", description = "Value to insert.", required = true, multiValued = false)
    String value;

    @Override*/

    public InsertCommand(DataManager dataManager) {
        this.dataManager = dataManager;
        System.out.println("!" + dataManager);
    }

    public Object execute() throws Exception {
        //dataManager.insert(key, value);
        System.out.println(String.format("Inserted (Key: %s, Value: %s)", "", ""));
        return null;
    }
}
