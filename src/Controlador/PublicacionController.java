/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.PublicacionDAO;
import Modelo.DTO.Publicacion;
import Modelo.DTO.Usuario;
import Sesion.SesionUsuario;
import Modelo.DTO.PublicacionVista;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class PublicacionController {

    private PublicacionDAO publicacionDAO;

    public PublicacionController() {
        publicacionDAO = new PublicacionDAO();
    }

    public boolean crearPublicacion(String titulo, String contenido, int idCategoria) {
        if (titulo == null || titulo.isBlank()) {
            return false;
        }

        if (contenido == null || contenido.isBlank()) {
            return false;
        }

        if (idCategoria <= 0) {
            return false;
        }

        Usuario usuarioActual = SesionUsuario.obtenerUsuario();
        if (usuarioActual == null) {
            return false;
        }
        Publicacion publicacion = new Publicacion();
        publicacion.setTitulo(titulo);
        publicacion.setContenido(contenido);
        publicacion.setIdUsuario(usuarioActual.getIdUsuario());
        publicacion.setIdCategoria(idCategoria);
        return publicacionDAO.crearPublicacion(publicacion);
    }

    public List<PublicacionVista> listarPublicaciones() {
        return publicacionDAO.listarPublicaciones();
    }

    public List<PublicacionVista> listarPublicacionesDelUsuario() {

        Usuario usuarioActual = SesionUsuario.obtenerUsuario();

        if (usuarioActual == null) {
            return new ArrayList<>();
        }

        return publicacionDAO.listarPublicacionesPorUsuario(
                usuarioActual.getIdUsuario()
        );
    }

    public boolean eliminarPublicacion(int idPublicacion) {

        if (idPublicacion <= 0) {
            return false;
        }

        Usuario usuarioActual = SesionUsuario.obtenerUsuario();

        if (usuarioActual == null) {
            return false;
        }

        return publicacionDAO.eliminarPublicacion(
                idPublicacion,
                usuarioActual.getIdUsuario()
        );
    }

    public List<PublicacionVista> listarPorCategoria(
            int idCategoria
    ) {

        if (idCategoria <= 0) {
            return publicacionDAO.listarPublicaciones();
        }

        return publicacionDAO.listarPorCategoria(idCategoria);
    }
}
