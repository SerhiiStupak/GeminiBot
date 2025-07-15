package com.mycompany.userregistr.dao;

import com.mycompany.userregistr.config.PropertiesManager;
import com.mycompany.userregistr.exceptions.ApplicationException;
import com.mycompany.userregistr.exceptions.AlreadyRegisteredException;
import com.mycompany.userregistr.model.AppUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AppUserDaoImpl implements AppUserDao {
    private PropertiesManager propertiesManager = new PropertiesManager();
    private static final String USER_BY_EMAIL_QUERY = "select * from users where email = '%s'";
    @Override
    public AppUser getByEmail(String email) {
        AppUser user = null;
        try (Connection connection = retrieveConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(String.format(USER_BY_EMAIL_QUERY, email));
            while (resultSet.next()) {
                user = new AppUser();
                user.setId(resultSet.getLong("userid"));
                user.setSurname(resultSet.getString("surname"));
                user.setName(resultSet.getString("name"));
                user.setGender(resultSet.getString("gender"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));

            }
        } catch (Exception e) {
            throw new ApplicationException("Failed to load user from DB", e);
        }
        if (user == null) {
//            throw new ApplicationException("User not found by email: " + email);
            user = new AppUser((long) 0,"","","","","");
        }
        return user;

    }

    private static final String INSER_USER_QUERY = "insert into users (surname, name, gender, email, password) values (?, ?, ?, ?, ?)";
    @Override
    public AppUser create(AppUser user) {
        checkUserInDB(user);
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(INSER_USER_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getSurname());
            statement.setString(2, user.getName());
            statement.setString(3, user.getGender());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getLong(1));
            }
        } catch (Exception e) {
            throw new ApplicationException("Failed to insert user into DB", e);
        }
        return user;
    }
    private Connection retrieveConnection() {
        return DBManager.getConnection(propertiesManager.getApplicationProperties());
    }
    private void checkUserInDB(AppUser user){
        AppUser userInDB = getByEmail(user.getEmail());
        if(userInDB.getEmail().trim().equals(user.getEmail().trim())){
            throw new AlreadyRegisteredException("The user cannot register two times", user.getGender());
        }
    }
}
