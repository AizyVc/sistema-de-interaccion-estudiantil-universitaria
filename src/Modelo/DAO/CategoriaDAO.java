/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;
import Conexion.Conexion;
import Modelo.DTO.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
public class CategoriaDAO {
    
    private Connection conexion;

    public CategoriaDAO() {
        conexion = Conexion.obtenerConexion();
    }
    
    public List<Categoria> listarCategorias() {

    List<Categoria> categorias = new ArrayList<>();

    String sql = "SELECT id_categoria, nombre, descripcion "
            + "FROM categorias ORDER BY id_categoria";


}
}