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

public class DeleteUser {
    public static void main(String[] args) {
        String deleteQuery = "DELETE FROM users WHERE User_ID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, 12); // ID del usuario a eliminar

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuario eliminado con éxito.");
            } else {
                System.out.println("No se pudo eliminar el usuario.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}