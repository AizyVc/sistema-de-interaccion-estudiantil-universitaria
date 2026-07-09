/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.PublicacionController;
import Modelo.DTO.PublicacionVista;
import Modelo.DTO.Usuario;
import Sesion.SesionUsuario;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import Controlador.CategoriaController;
import Modelo.DTO.Categoria;

/**
 *
 * @author User
 */
public class HomePanel extends javax.swing.JPanel {

    /**
     * Creates new form HomePanel
     */
    private DashBoard padre;
    private PublicacionController publicacionController;
    private CategoriaController categoriaController;
    private List<Categoria> listaCategorias;

    public HomePanel() {
        initComponents();
        categoriaController = new CategoriaController();
        publicacionController = new PublicacionController();
        cargarCategoriasFiltro();
        Usuario usuarioActual
                = SesionUsuario.obtenerUsuario();

        if (usuarioActual != null) {
            lblBienvenida.setText(
                    "Bienvenido/a, "
                    + usuarioActual.getNombre()
            );
        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Debe iniciar sesión para acceder.");
        }

        cargarPublicaciones();
    }

    public HomePanel(DashBoard padre) {
        this();
        this.padre = padre;
    }

    private void cargarPublicaciones() {

        panelPublicaciones.removeAll();
        panelPublicaciones.setLayout(
                new BoxLayout(
                        panelPublicaciones,
                        BoxLayout.Y_AXIS
                )
        );
        List<PublicacionVista> publicaciones
                = publicacionController.listarPublicaciones();
        if (publicaciones.isEmpty()) {

            panelPublicaciones.add(
                    new javax.swing.JLabel(
                            "No hay publicaciones disponibles."
                    )
            );

        } else {
            for (PublicacionVista publicacion : publicaciones) {
                PublicacionPanel tarjeta = new PublicacionPanel(publicacion);
                tarjeta.setAlignmentX(
                        java.awt.Component.LEFT_ALIGNMENT
                );
                tarjeta.setMaximumSize(
                        new java.awt.Dimension(
                                Integer.MAX_VALUE,
                                tarjeta.getPreferredSize().height
                        )
                );

                panelPublicaciones.add(tarjeta);

                panelPublicaciones.add(
                        javax.swing.Box.createVerticalStrut(10)
                );
            }
        }

        panelPublicaciones.revalidate();
        panelPublicaciones.repaint();
    }

    public void actualizarPublicaciones() {
        cargarPublicaciones();
    }

    private void cargarCategoriasFiltro() {

        cmbCategoria.removeAllItems();

        cmbCategoria.addItem("Todas las categorías");

        listaCategorias
                = categoriaController.listarCategorias();

        for (Categoria categoria : listaCategorias) {

            cmbCategoria.addItem(
                    categoria.getNombreCategoria()
            );
        }
    }

    private void mostrarPublicaciones(
            List<PublicacionVista> publicaciones
    ) {

        panelPublicaciones.removeAll();

        panelPublicaciones.setLayout(
                new BoxLayout(
                        panelPublicaciones,
                        BoxLayout.Y_AXIS
                )
        );

        if (publicaciones == null || publicaciones.isEmpty()) {

            panelPublicaciones.add(
                    new javax.swing.JLabel(
                            "No se encontraron publicaciones."
                    )
            );

        } else {

            for (PublicacionVista publicacion : publicaciones) {

                PublicacionPanel tarjeta
                        = new PublicacionPanel(publicacion);

                tarjeta.setAlignmentX(
                        java.awt.Component.LEFT_ALIGNMENT
                );

                tarjeta.setMaximumSize(
                        new java.awt.Dimension(
                                Integer.MAX_VALUE,
                                tarjeta.getPreferredSize().height
                        )
                );

                panelPublicaciones.add(tarjeta);

                panelPublicaciones.add(
                        javax.swing.Box.createVerticalStrut(10)
                );
            }
        }

        panelPublicaciones.revalidate();
        panelPublicaciones.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNuevaPublicacion = new javax.swing.JButton();
        scrollPublicaciones = new javax.swing.JScrollPane();
        panelPublicaciones = new javax.swing.JPanel();
        cmbCategoria = new javax.swing.JComboBox<>();
        lblBuscarPublicacion = new javax.swing.JLabel();
        btnBuscarPublicacion = new javax.swing.JButton();
        lblBienvenida = new javax.swing.JLabel();
        btnLimpiarBusqueda = new javax.swing.JButton();

        btnNuevaPublicacion.setText("Nueva publicación");
        btnNuevaPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaPublicacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPublicacionesLayout = new javax.swing.GroupLayout(panelPublicaciones);
        panelPublicaciones.setLayout(panelPublicacionesLayout);
        panelPublicacionesLayout.setHorizontalGroup(
            panelPublicacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
        );
        panelPublicacionesLayout.setVerticalGroup(
            panelPublicacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        scrollPublicaciones.setViewportView(panelPublicaciones);

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Confesiones", "Proyectos", "Tareas", "Eventos", "Preguntas académicas" }));
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        lblBuscarPublicacion.setText("Filtrar publicaciones por categoria");

        btnBuscarPublicacion.setText("Buscar");
        btnBuscarPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPublicacionActionPerformed(evt);
            }
        });

        lblBienvenida.setText("Bienvenida");

        btnLimpiarBusqueda.setText("Limpiar busqueda");
        btnLimpiarBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(scrollPublicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lblBienvenida)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiarBusqueda)
                    .addComponent(btnBuscarPublicacion))
                .addGap(160, 160, 160))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblBuscarPublicacion)
                        .addComponent(btnNuevaPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(47, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblBienvenida)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarPublicacion)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiarBusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(scrollPublicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addComponent(lblBuscarPublicacion)
                    .addGap(45, 45, 45)
                    .addComponent(btnNuevaPublicacion)
                    .addContainerGap(551, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaPublicacionActionPerformed
        // TODO add your handling code here:
        CrearPublicacionForm crearForm = new CrearPublicacionForm(this);
        crearForm.setLocationRelativeTo(javax.swing.SwingUtilities.getWindowAncestor(this));
        crearForm.setVisible(true);
    }//GEN-LAST:event_btnNuevaPublicacionActionPerformed

    private void btnBuscarPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPublicacionActionPerformed
        // TODO add your handling code here:
        int indiceSeleccionado
                = cmbCategoria.getSelectedIndex();

        if (indiceSeleccionado <= 0) {

            cargarPublicaciones();
            return;
        }

        Categoria categoriaSeleccionada
                = listaCategorias.get(
                        indiceSeleccionado - 1
                );

        List<PublicacionVista> publicaciones
                = publicacionController.listarPorCategoria(
                        categoriaSeleccionada.getIdCategoria()
                );

        mostrarPublicaciones(publicaciones);

    }//GEN-LAST:event_btnBuscarPublicacionActionPerformed

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void btnLimpiarBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarBusquedaActionPerformed
        // TODO add your handling code here:
          cmbCategoria.setSelectedIndex(0);
          cargarPublicaciones();
    }//GEN-LAST:event_btnLimpiarBusquedaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPublicacion;
    private javax.swing.JButton btnLimpiarBusqueda;
    private javax.swing.JButton btnNuevaPublicacion;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblBuscarPublicacion;
    private javax.swing.JPanel panelPublicaciones;
    private javax.swing.JScrollPane scrollPublicaciones;
    // End of variables declaration//GEN-END:variables
}
