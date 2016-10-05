package org.codice.data.management.command;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.codice.data.management.DataManager;

@Command(scope = "data", name = "delete", description = "Deletes key/value pair.")
@Service
public class DeleteCommand implements Action {

    @Reference
    private DataManager dataManager;

    @Argument(index = 0, name = "key", description = "Key to delete.", required = true, multiValued = false)
    String key;

    @Override
    public Object execute() throws Exception {
        dataManager.delete(key);
        System.out.println(String.format("Deleted (Key: %s)", key));
        return null;
    }
}
