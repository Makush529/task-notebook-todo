package repository;

import util.DatabaseConfig;
import util.SQLCommands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapRepository {
    private static MapRepository instance;
    private static Connection connection;

    public MapRepository() {
        connection = DatabaseConfig.getConnection();
    }

    public static MapRepository getInstance() {
        if (instance == null) {
            instance = new MapRepository();
        }
        return instance;
    }

    public static void addUserToBase(String username, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommands.CREATE_USER);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error in adding user to database");
        }
    }

    public boolean isUsernameContains(String username) {//наличие юзера в бд, для авторизации
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommands.GET_USER_BY_USERNAME);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("isUsernameContains ERROR");
            throw new RuntimeException(e);
        }
    }

    public boolean isValidCredentials(String username, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommands.GET_USER_BY_USERNAME_AND_PASSWORD);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("isValidCredentials ERROR"
            );
        }
        System.out.println("разобраться в репозитории");
        return false;
    }
}