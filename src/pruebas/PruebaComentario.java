package Pruebas;

import Controlador.ComentarioController;
import Modelo.DTO.Usuario;
import Sesion.SesionUsuario;

public class PruebaComentario {

    public static void main(String[] args) {

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(17);
        usuario.setNombre("Aizy Vera");

        SesionUsuario.iniciarSesion(usuario);

        ComentarioController comentarioController = new ComentarioController();

        boolean creado = comentarioController.crearComentario(
                "Este es un comentario de prueba.",
                2 
        );

        if (creado) {
            System.out.println("Comentario creado correctamente.");
        } else {
            System.out.println("No se pudo crear el comentario.");
        }
    }
}