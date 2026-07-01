/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.CategoriaDAO;
import Modelo.DTO.Categoria;
import java.util.List;

/**
 *
 * @author User
 */
public class CategoriaController {

    private CategoriaDAO categoriaDAO;

    public CategoriaController() {
        categoriaDAO = new CategoriaDAO();
    }

    public List<Categoria> listarCategorias() {
        return categoriaDAO.listarCategorias();
    }
    
}
