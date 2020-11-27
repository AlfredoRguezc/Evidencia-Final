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
public class Cita {

    private String fecha;
    private String hora;
    private String motivo;
    private Connection conexion;
    private Scanner scanner = new Scanner(System.in);


    public void DatosCita() {
        System.out.println("Ingresa la fecha de la cita (dd/mm/yyyy): ");
        this.fecha = scanner.nextLine();
        System.out.println("Ingresa la hora de la cita: ");
        this.hora = scanner.nextLine();
        System.out.println("Ingresa el motivo de la cita: ");
        this.motivo = scanner.nextLine();
    }
  
    public void crearCita() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Alfredo\\Desktop\\Quinto Semestre\\Computacion en java\\EvidenciaJava.db");
            Statement INSERT;
            INSERT = conexion.createStatement();

          
            INSERT.execute("INSERT INTO Citas (fecha, hora, Motivo) VALUES('" + this.fecha + "','" + this.hora + "','" + this.motivo+ "');'");

            System.out.println("La cita se ha registrado correctamente.");
            
            conexion.close();
            INSERT.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    

    public void mostrarCitas() {
        ResultSet resultado = null;
        
        try {
         
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Alfredo\\Desktop\\Quinto Semestre\\Computacion en java\\EvidenciaJava.db");
         
            
            PreparedStatement busqueda = conexion.prepareStatement("SELECT * FROM Citas");
            
            resultado = busqueda.executeQuery();
            
            while(resultado.next()) {
                System.out.print("ID: ");
                System.out.println(resultado.getInt("id"));
                
                System.out.print("Fecha: ");
                System.out.println(resultado.getString("fecha"));
                
                System.out.print("Hora: ");
                System.out.println(resultado.getString("hora"));
                
                System.out.print("Motivo de la cita: ");
                System.out.println(resultado.getString("Motivo"));
            }
            
            conexion.close();
            busqueda.close();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
