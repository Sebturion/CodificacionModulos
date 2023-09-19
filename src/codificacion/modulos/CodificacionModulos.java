/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package codificacion.modulos;

/**
 *
 * @author usuario
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CodificacionModulos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/qusdb";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CodificacionModulos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM USERS");
            rs.next();
            do{
                    System.out.println(rs.getInt("User_ID")+" : "+rs.getString("FirstName"));
            }while(rs.next());
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CodificacionModulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
