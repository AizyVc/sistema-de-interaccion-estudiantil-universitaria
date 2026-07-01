/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Conexion.Conexion;
import Modelo.DTO.Publicacion;
import Modelo.DTO.Usuario;
import Modelo.DTO.Categoria;
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

    public PublicacionDAO() {
        conexion = Conexion.obtenerConexion();
    }

    public boolean crearPublicacion(Publicacion publicacion) {
        String sql = "INSERT INTO publicaciones(titulo, contenido, id_usuario, id_categoria) "
                + "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, publicacion.getTitulo());
            ps.setString(2, publicacion.getContenido());
            ps.setInt(3, publicacion.getIdUsuario());
            ps.setInt(4, publicacion.getIdCategoria());
            int filas = ps.executeUpdate();
            if (filas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
