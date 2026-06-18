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
public class Publicacion {

    private int idPublicacion;
    private String titulo;
    private String contenido;
    private LocalDate fecha;
    private String estado;
    private Usuario usuario;
    private Categoria categoria;

    public Publicacion(String titulo, String contenido, LocalDate fecha, String estado, Usuario usuario, Categoria categoria) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
        this.estado = estado;
        this.usuario = usuario;
        this.categoria = categoria;
    }

    public Publicacion(int idPublicacion, String titulo, String contenido, LocalDate fecha, String estado, Usuario usuario, Categoria categoria) {
        this.idPublicacion = idPublicacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
        this.estado = estado;
        this.usuario = usuario;
        this.categoria = categoria;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
