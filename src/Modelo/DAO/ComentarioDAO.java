/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Conexion.Conexion;
import Modelo.DTO.Comentario;
import Modelo.DTO.ComentarioVista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

        String sql = """
            INSERT INTO comentarios
            (contenido, fecha, id_usuario, id_publicacion)
            VALUES (?, CURRENT_TIMESTAMP, ?, ?)
            """;

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, comentario.getContenido());
            ps.setInt(2, comentario.getIdUsuario());
            ps.setInt(3, comentario.getIdPublicacion());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(
                    "Error al crear comentario: " + e.getMessage()
            );
            return false;
        }
    }

    public List<ComentarioVista> listarPorPublicacion(
            int idPublicacion
    ) {

        List<ComentarioVista> comentarios = new ArrayList<>();

        String sql = """
            SELECT co.id_comentario,
                   co.contenido,
                   co.fecha,
                   co.id_usuario,
                   co.id_publicacion,
                   u.nombre AS nombre_usuario
            FROM comentarios co
            INNER JOIN usuarios u
                ON co.id_usuario = u.id_usuario
            WHERE co.id_publicacion = ?
            ORDER BY co.fecha ASC
            """;

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idPublicacion);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Timestamp fechaSql
                            = rs.getTimestamp("fecha");

                    ComentarioVista comentario
                            = new ComentarioVista(
                                    rs.getInt("id_comentario"),
                                    rs.getString("contenido"),
                                    fechaSql != null
                                            ? fechaSql.toLocalDateTime()
                                            : null,
                                    rs.getInt("id_usuario"),
                                    rs.getInt("id_publicacion"),
                                    rs.getString("nombre_usuario")
                            );

                    comentarios.add(comentario);
                }
            }

        } catch (SQLException e) {
            System.err.println(
                    "Error al listar comentarios: "
                    + e.getMessage()
            );
        }

        return comentarios;
    }

}
