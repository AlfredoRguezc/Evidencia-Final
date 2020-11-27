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
import java.sql.Statement;
import java.util.Scanner;
/**
 *
 * @author Alfredo
 */
public class Paciente {
    
    private String nombre;
    private Connection conexion;
    //private int id = 0;
    private Scanner scanner = new Scanner(System.in);
    
    
    
    public void pedirDatos() {
        System.out.println("Ingresa el nombre del paciente: ");
        this.nombre = scanner.nextLine();
    }
    

    public void darAltaPaciente() {
        try {
            
            Class.forName("org.sqlite.JDBC");
           Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Alfredo\\Desktop\\Quinto Semestre\\Computacion en java\\EvidenciaJava.db");

         
            Statement INSERT;
            INSERT = conexion.createStatement();

            INSERT.execute("INSERT INTO Pacientes (nombre) VALUES('" + this.nombre + "');'");
            
            System.out.println("El paciente se ha registrado correctamente.");
            
            INSERT.close();
            conexion.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void mostrarPacientes() {
        ResultSet dato = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Alfredo\\Desktop\\Quinto Semestre\\Computacion en java\\EvidenciaJava.db");

            PreparedStatement busqueda = conexion.prepareStatement("SELECT * FROM Pacientes");
            
            dato = busqueda.executeQuery();
            
            while(dato.next()) {
                System.out.print("ID: ");
                System.out.println(dato.getInt("id"));
                
                System.out.print("Nombre: ");
                System.out.println(dato.getString("nombre"));
           
            }
            
            busqueda.close();
            conexion.close();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
