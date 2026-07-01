/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Conexion.Conexion;
import Modelo.DTO.Comentario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ComentarioDAO {

    private Connection conexion;

    public ComentarioDAO() {
        conexion = Conexion.obtenerConexion();
    }

    public boolean crearComentario(Comentario comentario) {

        String sql = "INSERT INTO comentarios(contenido, id_usuario, id_publicacion) "
                + "VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, comentario.getContenido());
            ps.setInt(2, comentario.getIdUsuario());
            ps.setInt(3, comentario.getIdPublicacion());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
