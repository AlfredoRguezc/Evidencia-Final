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
public class Doctor {
    private String nombre;
    private String especialidad;
    //private int id=0;
    private Connection conexion;
    private Scanner scanner = new Scanner(System.in);
    
  
    public void Datos() {
        System.out.println("Ingresa el nombre del doctor: ");
        this.nombre = scanner.nextLine();
        System.out.println("Ingresa su especialidad: ");
        this.especialidad = scanner.nextLine();
        //this.id=1;
    }
    
  
    public void darAltaDoctor() {
        try {
           
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Alfredo\\Desktop\\Quinto Semestre\\Computacion en java\\EvidenciaJava.db");
         
            Statement INSERT;
            INSERT = conexion.createStatement();
            
            INSERT.execute("INSERT INTO Doctores (nombre, especialidad) VALUES('"+this.nombre+"','"+this.especialidad+"');'");
   
            System.out.println("El doctor se ha registrado correctamente.");
            
            INSERT.close();
            conexion.close();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
 
    public void mostrarDoctores() {
        ResultSet dato = null;
        
        try {
           
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sC:\\Users\\Alfredo\\Desktop\\Quinto Semestre\\Computacion en java\\EvidenciaJava.db");
   
            PreparedStatement busqueda = conexion.prepareStatement("SELECT * FROM Doctores");
            
            dato = busqueda.executeQuery();
            
            while(dato.next()) {
                System.out.print("ID: ");
                System.out.println(dato.getInt("id"));
                
                System.out.print("Nombre: ");
                System.out.println(dato.getString("nombre"));
                
                System.out.print("Especialidad: ");
                System.out.println(dato.getString("especialidad"));
                
                
            }
            
            busqueda.close();
            conexion.close();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
