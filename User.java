/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.pkgfinal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
/**
 *
 * @author Alfredo
 */
public class User {

    String user;
    String password;
    private Connection conexion;
    private Scanner scanner = new Scanner(System.in);

   
    public void DatosAdmin() {
        ResultSet dato = null;

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Alfredo\\Desktop\\Quinto Semestre\\Computacion en java\\EvidenciaJava.db");

          
            PreparedStatement busqueda = conexion.prepareStatement("SELECT user, password FROM Usuarios WHERE id = 1 ");

            dato = busqueda.executeQuery();
            this.user = dato.getString("user");
            this.password = dato.getString("password");
            
            busqueda.close();
            conexion.close();
                
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    // Métodos getters.
    public String getUser() {
        return this.user;
    }
    
    public String getPassword() {
        return this.password;
    }

}
