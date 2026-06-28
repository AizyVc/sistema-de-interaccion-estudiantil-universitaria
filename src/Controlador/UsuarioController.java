/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.UsuarioDAO;
import Modelo.DTO.Usuario;

/**
 *
 * @author User
 */
public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        usuarioDAO = new UsuarioDAO();
    }

    public boolean registrarUsuario(String nombre, String correo, String contrasena, String carrera) {

        Usuario usuario = new Usuario();

        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setContrasena(contrasena);
        usuario.setCarrera(carrera);

        return usuarioDAO.registrarUsuario(usuario);
    }

    public Usuario iniciarSesion(String correo, String contrasena) {
        return usuarioDAO.iniciarSesion(correo, contrasena);
    }

    public boolean validarCorreo(String correo) {
        if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            return false;
        }
        return true;
    }

    public boolean validarNombre(String nombre) {
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            return false;
        }
        return true;
    }

    public boolean validarContrasena(String contrasena) {
        if (contrasena.length() < 8) {
            return false;
        }
        return true;
    }

    public boolean existeCorreo(String correo) {
        return usuarioDAO.existeCorreo(correo);
    }
}
