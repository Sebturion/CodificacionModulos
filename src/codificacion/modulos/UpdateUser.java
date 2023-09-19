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

public class UpdateUser {
    public static void main(String[] args) {
        String updateQuery = "UPDATE users SET FirstName = ?, LastName = ? WHERE User_ID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, "NuevoNombre");
            preparedStatement.setString(2, "NuevoApellido");
            preparedStatement.setInt(3, 100); // ID del usuario a actualizar

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuario actualizado con éxito.");
            } else {
                System.out.println("No se pudo actualizar el usuario.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

