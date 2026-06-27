/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//Esto es solo una prueba
package Main;

import Modelo.DAO.UsuarioDAO;
import Modelo.DTO.Usuario;

/**
 *
 * @author User
 */
public class ProyectoConstruccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario usuario = new Usuario();

        usuario.setNombre("Aizy");
        usuario.setCorreo("aizvc@gmail.com");
        usuario.setContrasena("123456");
        usuario.setCarrera("Ingeniería en Software");

        UsuarioDAO dao = new UsuarioDAO();

        boolean registrado = dao.registrarUsuario(usuario);

        if (registrado) {
            System.out.println("Usuario registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el usuario.");
        }
    }

}
