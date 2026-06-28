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

}
