/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;

import java.time.LocalDateTime;

public class ComentarioVista {

    private int idComentario;
    private String contenido;
    private LocalDateTime fecha;
    private int idUsuario;
    private int idPublicacion;
    private String nombreUsuario;

    public ComentarioVista() {
    }

    public ComentarioVista(
            int idComentario,
            String contenido,
            LocalDateTime fecha,
            int idUsuario,
            int idPublicacion,
            String nombreUsuario
    ) {
        this.idComentario = idComentario;
        this.contenido = contenido;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.idPublicacion = idPublicacion;
        this.nombreUsuario = nombreUsuario;
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}