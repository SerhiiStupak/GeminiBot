package com.mycompany.userregistr.dao;

import com.mycompany.userregistr.config.PropertiesManager;
import com.mycompany.userregistr.exceptions.ApplicationException;
import com.mycompany.userregistr.model.AppWare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppWareDaoImpl implements AppWareDao{
    private static final String INSER_WARE_QUERY = "insert into wares (product_name, manufacturer, price_per_unit, quantity, warehouse_number, minimum_batch) values (?, ?, ?, ?, ?, ?)";
    @Override
    public AppWare create(AppWare ware) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(INSER_WARE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, ware.getProductName());
            statement.setString(2, ware.getManufacturer());
            statement.setBigDecimal(3, ware.getPricePerUnit());
            statement.setInt(4, ware.getQuantity());
            statement.setString(5, ware.getWarehouseNumber());
            statement.setInt(6, ware.getMinimumBatch());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                ware.setId(generatedKeys.getLong(1));
            }
        } catch (Exception e) {
            throw new ApplicationException("Failed to insert ware into DB", e);
        }
        return ware;
    }
    private PropertiesManager propertiesManager = new PropertiesManager();
    private Connection retrieveConnection() {
        return DBManager.getConnection(propertiesManager.getApplicationProperties());
    }
    private static final String SELECT_ALL_WARES = "SELECT * FROM wares";

    public List<AppWare> getAllWares() {
        List<AppWare> wares = new ArrayList<>();
        try (Connection connection = retrieveConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_WARES)) {
            while (resultSet.next()) {
                AppWare ware = new AppWare();
                ware.setId(resultSet.getLong("wareid"));
                ware.setProductName(resultSet.getString("product_name"));
                ware.setManufacturer(resultSet.getString("manufacturer"));
                ware.setPricePerUnit(resultSet.getBigDecimal("price_per_unit"));
                ware.setQuantity(resultSet.getInt("quantity"));
                ware.setWarehouseNumber(resultSet.getString("warehouse_number"));
                ware.setMinimumBatch(resultSet.getInt("minimum_batch"));
                wares.add(ware);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch wares from database", e);
        }
        return wares;
    }
}
