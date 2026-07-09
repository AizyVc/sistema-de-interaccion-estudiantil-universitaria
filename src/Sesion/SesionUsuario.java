/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sesion;

/**
 *
 * @author User
 */
import Modelo.DTO.Usuario;

public class SesionUsuario {

    private static Usuario usuarioActual;

    private SesionUsuario() {
    }

    public static void iniciarSesion(Usuario usuario) {
        usuarioActual = usuario;
    }

    public static Usuario obtenerUsuario() {
        return usuarioActual;
    }

    public static void cerrarSesion() {
        usuarioActual = null;
    }

    public static boolean haySesionActiva() {
        return usuarioActual != null;
    }
   
}
