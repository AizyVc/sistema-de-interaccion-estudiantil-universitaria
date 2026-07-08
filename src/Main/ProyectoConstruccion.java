/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//Esto es solo una prueba
package Main;

import Modelo.DAO.UsuarioDAO;
import Modelo.DTO.Usuario;
import Vista.LoginForm;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;

/**
 *
 * @author User
 */
public class ProyectoConstruccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatLightLaf.setup();
        SwingUtilities.invokeLater(() -> {
            LoginForm login = new LoginForm();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        });
    }

}
