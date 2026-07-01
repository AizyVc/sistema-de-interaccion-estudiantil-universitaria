/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.ComentarioDAO;
import Modelo.DTO.Comentario;
import Modelo.DTO.Usuario;
import Sesion.SesionUsuario;

/**
 *
 * @author User
 */
public class ComentarioController {

    private ComentarioDAO comentarioDAO;
    public ComentarioController() {
        comentarioDAO = new ComentarioDAO();
    }

    public boolean crearComentario(String contenido, int idPublicacion) {
        Usuario usuarioActual = SesionUsuario.obtenerUsuario();
        if (usuarioActual == null) {
            return false;
        }
        Comentario comentario = new Comentario();

        comentario.setContenido(contenido);
        comentario.setIdUsuario(usuarioActual.getIdUsuario());
        comentario.setIdPublicacion(idPublicacion);

        return comentarioDAO.crearComentario(comentario);
    }
}
