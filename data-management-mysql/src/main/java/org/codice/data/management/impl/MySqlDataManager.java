package org.codice.data.management.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.codice.data.management.DataManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySqlDataManager implements DataManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(MySqlDataManager.class);

    private static final String TABLE_NAME = "data";

    private DataSource dataSource;

    public MySqlDataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void init() {
        LOGGER.trace("Initializing {}", MySqlDataManager.class.getName());
        try (Connection con = dataSource.getConnection(); Statement stmt = con.createStatement()) {
            stmt.execute("create table " + TABLE_NAME + " (name varchar(100), email varchar(100))");
        } catch (SQLException e) {
            LOGGER.error("Unable to create table {}", TABLE_NAME);
        }
    }

    private void printTable(Statement statement) throws SQLException {
        LOGGER.trace("Printing entries for table {}", TABLE_NAME);
        ResultSet rs = statement.executeQuery("select * from " + TABLE_NAME);
        ResultSetMetaData meta = rs.getMetaData();
        while (rs.next()) {
            StringBuilder builder = new StringBuilder();
            for (int c = 1; c <= meta.getColumnCount(); c++) {
                builder.append(rs.getString(c) + " ");
            }
            LOGGER.trace("{}",
                    builder.toString()
                            .trim());
        }
    }

    @Override
    public void insert(String key, String value) {
        LOGGER.trace("Inserting Information");
        try (Connection con = dataSource.getConnection(); Statement stmt = con.createStatement()) {
            stmt.execute(
                    "insert into " + TABLE_NAME + " (name, email) values ('" + key + "', '" + value
                            + "')");
            printTable(stmt);
        } catch (SQLException e) {
            LOGGER.error("Could not insert into DB", e);
        }
    }

    @Override
    public void update(String key, String value) {
        LOGGER.trace("Updating Information");
        try (Connection con = dataSource.getConnection(); Statement stmt = con.createStatement()) {
            stmt.execute("update " + TABLE_NAME + " set email = '" + value + "' where name = '" + key
                    + "'");
            printTable(stmt);
        } catch (SQLException e) {
            LOGGER.error("Could not update into DB", e);
        }
    }

    @Override
    public void delete(String key) {
        LOGGER.trace("Deleting Information");
        try (Connection con = dataSource.getConnection(); Statement stmt = con.createStatement()) {
            stmt.execute("delete from " + TABLE_NAME + " where name = '" + key + "'");
            printTable(stmt);
        } catch (SQLException e) {
            LOGGER.error("Could not update into DB", e);
        }
    }
}
