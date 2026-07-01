/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.PublicacionDAO;
import Modelo.DTO.Publicacion;
import Modelo.DTO.Usuario;
import Sesion.SesionUsuario;

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
}
