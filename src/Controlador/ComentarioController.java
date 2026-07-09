/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.ComentarioDAO;
import Modelo.DTO.Comentario;
import Modelo.DTO.ComentarioVista;
import Modelo.DTO.Usuario;
import Sesion.SesionUsuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ComentarioController {

    private ComentarioDAO comentarioDAO;

    public ComentarioController() {
        comentarioDAO = new ComentarioDAO();
    }

    public boolean crearComentario(
            String contenido,
            int idPublicacion
    ) {

        if (contenido == null || contenido.isBlank()) {
            return false;
        }

        if (idPublicacion <= 0) {
            return false;
        }

        Usuario usuarioActual
                = SesionUsuario.obtenerUsuario();

        if (usuarioActual == null) {
            return false;
        }

        Comentario comentario = new Comentario();

        comentario.setContenido(contenido.trim());
        comentario.setIdUsuario(
                usuarioActual.getIdUsuario()
        );
        comentario.setIdPublicacion(idPublicacion);

        return comentarioDAO.crearComentario(comentario);
    }

    public List<ComentarioVista> listarComentarios(
            int idPublicacion
    ) {

        if (idPublicacion <= 0) {
            return new ArrayList<>();
        }

        return comentarioDAO.listarPorPublicacion(
                idPublicacion
        );
    }
}
