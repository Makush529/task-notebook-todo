package util;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        //1.создание соединения с БД
        Connection connection = DatabaseConfig.getConnection();
        //2.создаем statement (CallableStatement,Statement,PreparedStatement)
        //можно донасатроить!!!
        PreparedStatement preparedStatement = connection.prepareStatement(SQLCommands.GET_ALL_USERS);
        //3.отправляем statement
        //preparedStatement.execute()=>boolean
        //preparedStatement.executeUpdate()=>изменение данных в бд(добавление ,обновление, удаление)
        //preparedStatement.executeQuery()=>получаем данные, возвращает ResultSet
        ResultSet resultSet = preparedStatement.executeQuery();
        //4.парсинг ResultSet
        //реляционная модель
        /*while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
        }*/

        //из реляционнй модели перевели в объектную(user)
        List<String> users = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setUser_id(resultSet.getInt("user_id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            users.add(user.toString());
        }
        System.out.println(users);
    }
}
