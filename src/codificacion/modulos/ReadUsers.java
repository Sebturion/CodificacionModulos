/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codificacion.modulos;

/**
 *
 * @author usuario
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadUsers {
    public static void main(String[] args) {
        String selectQuery = "SELECT * FROM users";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {
            while (resultSet.next()) {
                int userId = resultSet.getInt("User_ID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String email = resultSet.getString("Email");

                System.out.println("User ID: " + userId);
                System.out.println("Name: " + firstName + " " + lastName);
                System.out.println("Email: " + email);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}