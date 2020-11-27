/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.pkgfinal;
import java.util.Scanner;
/**
 *
 * @author Alfredo
 */
public class EvidenciaFinal {

    public static void main(String[] args) {
        // TODO code application logic here
        
         Scanner scanner = new Scanner(System.in);
        String opcion;
        String res = "";
        String user, password;
        User admin = new User();
        admin.DatosAdmin();

        do {

            System.out.println("Login.");
            System.out.println("---------------------");
            System.out.println("User: ");
            user = scanner.next();
            System.out.println("Password: ");
            password = scanner.next();

            if (user.equals(admin.getUser()) && password.equals(admin.getPassword())) {
                System.out.println("Hospital Tecmilenio");
                System.out.println("Menú");
                System.out.println("------------------------");
                System.out.println("Elige una opción: ");
                System.out.println("Alta de doctores.");
                System.out.println("Alta pacientes.");
                System.out.println("Crear una cita");
                System.out.println("Realizar conexion");
                System.out.println("Lista de doctores.");
                System.out.println("Lista de pacientes.");
                System.out.println("Lista de citas.");
                System.out.println("Mostrar conexion");
                
                opcion = scanner.next();

                switch (opcion) {
                    case "1":
                        Doctor doctor = new Doctor();
                        doctor.Datos();
                        doctor.darAltaDoctor();
                        break;

                    case "2":
                        Paciente paciente = new Paciente();
                        paciente.pedirDatos();
                        paciente.darAltaPaciente();
                        break;

                    case "3":
                        Cita cita = new Cita();
                        cita.DatosCita();
                        cita.crearCita();
                        break;

                    case "4":
                        Conexion conexion = new Conexion();
                        conexion.pedirDatos();
                        conexion.relacionarInformacion();
                        break;

                    case "5":
                        doctor = new Doctor();
                        doctor.mostrarDoctores();
                        break;

                    case "6":
                        paciente = new Paciente();
                        paciente.mostrarPacientes();
                        break;

                    case "7":
                        cita = new Cita();
                        cita.mostrarCitas();
                        break;

                    case "8":
                        conexion = new Conexion();
                        conexion.mostrarRelacionesInformacion();
                        break;
                        
                    default:
                        System.out.println("Elige una opcion correcta");

                }
            } else {
                System.out.println("Usuario o Contraseña incorrectos");
            }

            do {
                System.out.println("¿Deseas repetir la aplicacion?");
                System.out.println("si o no: ");
                scanner.nextLine();
                res = scanner.next();
                res = res.toLowerCase();

                if (!res.equals("si") && !res.equals("no")) {
                    System.out.println("Ingresa una opcion valida.");
                }

            } while (!res.equals("si") && !res.equals("no"));

            System.out.println();

        } while (res.equals("si"));

    }

    
    
}
