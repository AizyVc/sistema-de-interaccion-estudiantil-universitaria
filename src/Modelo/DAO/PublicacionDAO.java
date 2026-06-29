/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Conexion.Conexion;
import Modelo.DTO.Publicacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class PublicacionDAO {
    private Connection conexion; 
    
    public PublicacionDAO(){
        conexion = Conexion.obtenerConexion();
    }
    /*
    public boolean CrearPublicación (Publicacion publicacion){
    String sql = "INSERT INTO publicaciones(titulo, contenido, id_usuario, id_categoria)";
    
    }
     */
}
