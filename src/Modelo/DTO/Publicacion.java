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
public class Publicacion {

    private int idPublicacion;
    private String titulo;
    private String contenido;
    private LocalDateTime fecha; 
    private int idUsuario;      
    private int idCategoria;   

  
    public Publicacion(String titulo, String contenido, int idUsuario, int idCategoria) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
    }

    public Publicacion(int idPublicacion, String titulo, String contenido, LocalDateTime fecha, int idUsuario, int idCategoria) {
        this.idPublicacion = idPublicacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}