/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Conexion.Conexion;
import Modelo.DTO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class UsuarioDAO {

    public Connection conexion;

    public UsuarioDAO() {
        conexion = Conexion.obtenerConexion();
    }

    public boolean registrarUsuario(Usuario usuario) {
        String sql
                = "INSERT INTO usuarios(nombre, correo, contraseña, carrera)"
                + "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());
            ps.setString(4, usuario.getCarrera());
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
