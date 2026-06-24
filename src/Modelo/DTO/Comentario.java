/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;

import java.time.LocalDateTime; // Cambiado para manejar fecha y hora de la DB

/**
 *
 * @author User
 */
public class Comentario {

    private int idComentario;
    private String contenido;
    private LocalDateTime fecha; 
    private int idUsuario;      
    private int idPublicacion;   

    public Comentario(String contenido, int idUsuario, int idPublicacion) {
        this.contenido = contenido;
        this.idUsuario = idUsuario;
        this.idPublicacion = idPublicacion;
    }

    public Comentario(int idComentario, String contenido, LocalDateTime fecha, int idUsuario, int idPublicacion) {
        this.idComentario = idComentario;
        this.contenido = contenido;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.idPublicacion = idPublicacion;
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
}