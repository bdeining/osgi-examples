package org.codice.data.management.command;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.codice.data.management.DataManager;

@Command(scope = "data", name = "update", description = "Updates key/value pair.")
@Service
public class UpdateCommand implements Action {

    @Reference
    private DataManager dataManager;

    @Argument(index = 0, name = "key", description = "Key to update.", required = true, multiValued = false)
    String key;

    @Argument(index = 1, name = "value", description = "New value.", required = true, multiValued = false)
    String value;

    @Override
    public Object execute() throws Exception {
        dataManager.update(key, value);
        System.out.println(String.format("Updated (Key: %s, Value: %s)", key, value));
        return null;
    }
}
