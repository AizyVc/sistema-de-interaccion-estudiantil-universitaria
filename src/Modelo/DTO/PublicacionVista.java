/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;

import java.time.LocalDateTime;

public class PublicacionVista {

    private int idPublicacion;
    private String titulo;
    private String contenido;
    private LocalDateTime fecha;
    private String nombreUsuario;
    private String nombreCategoria;

    public PublicacionVista() {
    }

    public PublicacionVista(
            int idPublicacion,
            String titulo,
            String contenido,
            LocalDateTime fecha,
            String nombreUsuario,
            String nombreCategoria
    ) {
        this.idPublicacion = idPublicacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
        this.nombreUsuario = nombreUsuario;
        this.nombreCategoria = nombreCategoria;
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}