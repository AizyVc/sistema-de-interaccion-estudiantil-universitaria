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
import Modelo.DTO.PublicacionVista;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    public List<PublicacionVista> listarPublicaciones() {

        List<PublicacionVista> publicaciones = new ArrayList<>();

        String sql = """
        SELECT p.id_publicacion,
               p.titulo,
               p.contenido,
               p.fecha,
               u.nombre AS nombre_usuario,
               c.nombre_categoria
        FROM publicaciones p
        INNER JOIN usuarios u
            ON p.id_usuario = u.id_usuario
        INNER JOIN categorias c
            ON p.id_categoria = c.id_categoria
        ORDER BY p.fecha DESC
        """;

        try (
                PreparedStatement ps = conexion.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Timestamp fechaSql = rs.getTimestamp("fecha");

                PublicacionVista publicacion = new PublicacionVista(
                        rs.getInt("id_publicacion"),
                        rs.getString("titulo"),
                        rs.getString("contenido"),
                        fechaSql != null
                                ? fechaSql.toLocalDateTime()
                                : null,
                        rs.getString("nombre_usuario"),
                        rs.getString("nombre_categoria")
                );

                publicaciones.add(publicacion);
            }

        } catch (SQLException e) {
            System.err.println(
                    "Error al listar publicaciones: "
                    + e.getMessage()
            );
        }

        return publicaciones;
    }

    public List<PublicacionVista> listarPublicacionesPorUsuario(int idUsuario) {

        List<PublicacionVista> publicaciones = new ArrayList<>();

        String sql = """
        SELECT p.id_publicacion,
               p.titulo,
               p.contenido,
               p.fecha,
               u.nombre AS nombre_usuario,
               c.nombre_categoria
        FROM publicaciones p
        INNER JOIN usuarios u
            ON p.id_usuario = u.id_usuario
        INNER JOIN categorias c
            ON p.id_categoria = c.id_categoria
        WHERE p.id_usuario = ?
        ORDER BY p.fecha DESC
        """;

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Timestamp fechaSql = rs.getTimestamp("fecha");

                    PublicacionVista publicacion = new PublicacionVista(
                            rs.getInt("id_publicacion"),
                            rs.getString("titulo"),
                            rs.getString("contenido"),
                            fechaSql != null
                                    ? fechaSql.toLocalDateTime()
                                    : null,
                            rs.getString("nombre_usuario"),
                            rs.getString("nombre_categoria")
                    );

                    publicaciones.add(publicacion);
                }
            }

        } catch (SQLException e) {
            System.err.println(
                    "Error al listar publicaciones del usuario: "
                    + e.getMessage()
            );
        }

        return publicaciones;
    }

    public boolean eliminarPublicacion(
            int idPublicacion,
            int idUsuario
    ) {

        String verificarSql = """
        SELECT id_publicacion
        FROM publicaciones
        WHERE id_publicacion = ?
        AND id_usuario = ?
        """;

        String eliminarComentariosSql = """
        DELETE FROM comentarios
        WHERE id_publicacion = ?
        """;

        String eliminarPublicacionSql = """
        DELETE FROM publicaciones
        WHERE id_publicacion = ?
        AND id_usuario = ?
        """;

        try {
            conexion.setAutoCommit(false);

            try (PreparedStatement verificar
                    = conexion.prepareStatement(verificarSql)) {

                verificar.setInt(1, idPublicacion);
                verificar.setInt(2, idUsuario);

                try (ResultSet rs = verificar.executeQuery()) {
                    if (!rs.next()) {
                        conexion.rollback();
                        return false;
                    }
                }
            }

            try (PreparedStatement eliminarComentarios
                    = conexion.prepareStatement(eliminarComentariosSql)) {

                eliminarComentarios.setInt(1, idPublicacion);
                eliminarComentarios.executeUpdate();
            }

            int filas;

            try (PreparedStatement eliminarPublicacion
                    = conexion.prepareStatement(eliminarPublicacionSql)) {

                eliminarPublicacion.setInt(1, idPublicacion);
                eliminarPublicacion.setInt(2, idUsuario);

                filas = eliminarPublicacion.executeUpdate();
            }

            conexion.commit();

            return filas > 0;

        } catch (SQLException e) {

            try {
                conexion.rollback();
            } catch (SQLException rollbackError) {
                System.err.println(
                        "Error al revertir la eliminación: "
                        + rollbackError.getMessage()
                );
            }

            System.err.println(
                    "Error al eliminar publicación: "
                    + e.getMessage()
            );

            return false;

        } finally {

            try {
                conexion.setAutoCommit(true);
            } catch (SQLException e) {
                System.err.println(
                        "Error al restaurar la conexión: "
                        + e.getMessage()
                );
            }
        }
    }

    public List<PublicacionVista> listarPorCategoria(int idCategoria) {

        List<PublicacionVista> publicaciones = new ArrayList<>();

        String sql = """
        SELECT p.id_publicacion,
               p.titulo,
               p.contenido,
               p.fecha,
               u.nombre AS nombre_usuario,
               c.nombre_categoria
        FROM publicaciones p
        INNER JOIN usuarios u
            ON p.id_usuario = u.id_usuario
        INNER JOIN categorias c
            ON p.id_categoria = c.id_categoria
        WHERE p.id_categoria = ?
        ORDER BY p.fecha DESC
        """;

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idCategoria);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Timestamp fechaSql = rs.getTimestamp("fecha");

                    PublicacionVista publicacion
                            = new PublicacionVista(
                                    rs.getInt("id_publicacion"),
                                    rs.getString("titulo"),
                                    rs.getString("contenido"),
                                    fechaSql != null
                                            ? fechaSql.toLocalDateTime()
                                            : null,
                                    rs.getString("nombre_usuario"),
                                    rs.getString("nombre_categoria")
                            );

                    publicaciones.add(publicacion);
                }
            }

        } catch (SQLException e) {
            System.err.println(
                    "Error al filtrar publicaciones por categoría: "
                    + e.getMessage()
            );
        }

        return publicaciones;
    }

}
