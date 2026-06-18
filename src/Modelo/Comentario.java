/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Comentario {

    private int idComentario;
    private String contenido;
    private LocalDate fecha;
    private Usuario usuario;
    private Publicacion publicacion;

    public Comentario(String contenido, LocalDate fecha, Usuario usuario, Publicacion publicacion) {
        this.contenido = contenido;
        this.fecha = fecha;
        this.usuario = usuario;
        this.publicacion = publicacion;
    }

    public Comentario(int idComentario, String contenido, LocalDate fecha, Usuario usuario, Publicacion publicacion) {
        this.idComentario = idComentario;
        this.contenido = contenido;
        this.fecha = fecha;
        this.usuario = usuario;
        this.publicacion = publicacion;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

}
