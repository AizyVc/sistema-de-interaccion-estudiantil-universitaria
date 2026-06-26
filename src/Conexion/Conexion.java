package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author User
 */
public class Conexion {

    private static final String HOST = "dpg-d8u4r7kvikkc73d72uog-a.oregon-postgres.render.com";
    private static final String PORT = "5432";
    private static final String DB_NAME = "servidor_interaccion_ug";
    private static final String USER = "servidor_interaccion_ug_user";
    private static final String PASSWORD = "aHRfNgtZIBeHM4k5PEFaz3ZmsWdrNjEY";
    private static final String URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DB_NAME + "?sslmode=require";

    private Conexion (){
        
    }
    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado exitosamente");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR! No se encontró el driver JDBC de PostgreSQL en Libraries.");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("ERROR! No se pudo conectar a Render. Revisa tu internet");
            System.out.println(e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        System.out.println("Prueba de Conexion");
        obtenerConexion();
    }
}
