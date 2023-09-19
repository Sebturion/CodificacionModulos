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
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateUser {
    public static void main(String[] args) {
        String insertQuery = "INSERT INTO users (User_ID, FirstName, LastName, Email, Password, Address, Cellphone, Document, UserType_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, 12);
            preparedStatement.setString(2, "Nombre");
            preparedStatement.setString(3, "Apellido");
            preparedStatement.setString(4, "correo@example.com");
            preparedStatement.setString(5, "contraseña");
            preparedStatement.setString(6, "Dirección");
            preparedStatement.setString(7, "1234567890");
            preparedStatement.setString(8, "123456789");
            preparedStatement.setInt(9, 1); // UserType_ID

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuario creado con éxito.");
            } else {
                System.out.println("No se pudo crear el usuario.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

