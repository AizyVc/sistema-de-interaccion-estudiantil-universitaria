package Modelo.DAO;

import Conexion.Conexion;
import Modelo.DTO.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private Connection conexion;

    public CategoriaDAO() {
        conexion = Conexion.obtenerConexion();
    }

   public List<Categoria> listarCategorias() {

    List<Categoria> categorias = new ArrayList<>();

    String sql = "SELECT id_categoria, nombre_categoria FROM categorias ORDER BY id_categoria";

    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Categoria categoria = new Categoria();
            categoria.setIdCategoria(rs.getInt("id_categoria"));
            categoria.setNombreCategoria(rs.getString("nombre_categoria"));
            categorias.add(categoria);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return categorias;
}
}