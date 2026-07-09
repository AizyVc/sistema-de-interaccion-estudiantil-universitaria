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

            panelPublicaciones.setLayout(new java.awt.GridBagLayout());

    javax.swing.JLabel lblVacio = new javax.swing.JLabel("No hay publicaciones disponibles.");
    lblVacio.setFont(new java.awt.Font("Century Gothic", java.awt.Font.PLAIN, 14));
    lblVacio.setForeground(new java.awt.Color(125, 129, 142));
    lblVacio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    panelPublicaciones.add(lblVacio);

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

            panelPublicaciones.setLayout(new java.awt.GridBagLayout());

            javax.swing.JLabel lblVacio = new javax.swing.JLabel("No se encontraron publicaciones.");
            lblVacio.setFont(new java.awt.Font("Century Gothic", java.awt.Font.PLAIN, 14));
            lblVacio.setForeground(new java.awt.Color(125, 129, 142));
            lblVacio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

            panelPublicaciones.add(lblVacio);

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

        scrollPublicaciones = new javax.swing.JScrollPane();
        panelPublicaciones = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblBienvenida = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnNuevaPublicacion = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblBuscarPublicacion = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        btnBuscarPublicacion = new javax.swing.JButton();
        btnLimpiarBusqueda = new javax.swing.JButton();

        setBackground(new java.awt.Color(245, 248, 252));

        panelPublicaciones.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelPublicacionesLayout = new javax.swing.GroupLayout(panelPublicaciones);
        panelPublicaciones.setLayout(panelPublicacionesLayout);
        panelPublicacionesLayout.setHorizontalGroup(
            panelPublicacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
        );
        panelPublicacionesLayout.setVerticalGroup(
            panelPublicacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        scrollPublicaciones.setViewportView(panelPublicaciones);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblBienvenida.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblBienvenida.setForeground(new java.awt.Color(0, 58, 154));
        lblBienvenida.setText("Bienvenida");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user2icon.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Comparte, aprende, resuelve dudas e interactua con la comunidad universitaria.");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("¿Que deseas publicar hoy?");

        btnNuevaPublicacion.setBackground(new java.awt.Color(0, 58, 154));
        btnNuevaPublicacion.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnNuevaPublicacion.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevaPublicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/plusicon.png"))); // NOI18N
        btnNuevaPublicacion.setText("Nueva publicación");
        btnNuevaPublicacion.setBorder(null);
        btnNuevaPublicacion.setBorderPainted(false);
        btnNuevaPublicacion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNuevaPublicacion.setIconTextGap(10);
        btnNuevaPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaPublicacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBienvenida)
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28)
                        .addComponent(btnNuevaPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblBienvenida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnNuevaPublicacion, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblBuscarPublicacion.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblBuscarPublicacion.setForeground(new java.awt.Color(0, 58, 154));
        lblBuscarPublicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/filtericon.png"))); // NOI18N
        lblBuscarPublicacion.setText("Filtrar publicaciones por categoria");

        cmbCategoria.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Confesiones", "Proyectos", "Tareas", "Eventos", "Preguntas académicas" }));
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        btnBuscarPublicacion.setBackground(new java.awt.Color(0, 58, 154));
        btnBuscarPublicacion.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnBuscarPublicacion.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarPublicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupaicon.png"))); // NOI18N
        btnBuscarPublicacion.setText("Buscar");
        btnBuscarPublicacion.setBorder(null);
        btnBuscarPublicacion.setBorderPainted(false);
        btnBuscarPublicacion.setIconTextGap(10);
        btnBuscarPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPublicacionActionPerformed(evt);
            }
        });

        btnLimpiarBusqueda.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnLimpiarBusqueda.setForeground(new java.awt.Color(0, 58, 154));
        btnLimpiarBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reloadicon.png"))); // NOI18N
        btnLimpiarBusqueda.setText("Limpiar busqueda");
        btnLimpiarBusqueda.setBorder(null);
        btnLimpiarBusqueda.setBorderPainted(false);
        btnLimpiarBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblBuscarPublicacion)
                .addGap(18, 18, 18)
                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiarBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarPublicacion)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPublicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPublicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblBuscarPublicacion;
    private javax.swing.JPanel panelPublicaciones;
    private javax.swing.JScrollPane scrollPublicaciones;
    // End of variables declaration//GEN-END:variables
}
