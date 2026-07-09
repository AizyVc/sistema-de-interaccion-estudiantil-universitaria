/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.UsuarioDAO;
import Modelo.DTO.Usuario;
import Utilidades.PasswordUtils;

/**
 *
 * @author User
 */
public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        usuarioDAO = new UsuarioDAO();
    }

    public boolean registrarUsuario(
            String nombre,
            String correo,
            String contrasena,
            String carrera
    ) {

        if (nombre == null || nombre.isBlank()
                || correo == null || correo.isBlank()
                || contrasena == null || contrasena.isBlank()
                || carrera == null || carrera.isBlank()) {

            return false;
        }

        String contrasenaHash
                = PasswordUtils.generarHash(contrasena);

        Usuario usuario = new Usuario();

        usuario.setNombre(nombre.trim());
        usuario.setCorreo(correo.trim());
        usuario.setContrasena(contrasenaHash);
        usuario.setCarrera(carrera.trim());

        return usuarioDAO.registrarUsuario(usuario);
    }

    public Usuario iniciarSesion(
            String correo,
            String contrasena
    ) {

        if (correo == null || correo.isBlank()
                || contrasena == null
                || contrasena.isBlank()) {

            return null;
        }

        Usuario usuario
                = usuarioDAO.buscarPorCorreo(
                        correo.trim()
                );

        if (usuario == null) {
            return null;
        }

        boolean coincide
                = PasswordUtils.verificarContrasena(
                        contrasena,
                        usuario.getContrasena()
                );

        if (!coincide) {
            return null;
        }

        // No necesitamos conservar el hash en la sesión.
        usuario.setContrasena(null);

        return usuario;
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
