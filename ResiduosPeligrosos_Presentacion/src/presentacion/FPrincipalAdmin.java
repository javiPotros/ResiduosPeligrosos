package presentacion;

import datos.ConexionBD;
import dominio.Usuario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import negocios.FNegocios;

/**
 * Form principal para los usuarios con permisos de administrador.
 */
public class FPrincipalAdmin extends javax.swing.JFrame {

    ConexionBD conexionBD;
    FNegocios fNegocios;
    FSolicitudesTraslados fSolicitarTraslado;
    Usuario usuario;

    /**
     * Constructor que recibe el usuario que ocupa la sesión.
     *
     * @param usuario usuario que accedio al sistema
     * @param fNegocios
     */
    public FPrincipalAdmin(Usuario usuario, FNegocios fNegocios) {
        //Modo pantalla completa
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        this.fNegocios = fNegocios;
        this.usuario = usuario;

        btnVerSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (!fNegocios.consultarTraslados().isEmpty()) {
                    mostrarPantallaSolicitudesTraslado(evt);
                } else {
                    mostrarErrorConsulta("No hay solicitudes registradas en la base de datos");
                }
            }
        });
    }

    /**
     * Muestra la pantalla de solicitudes de traslados que se encuentran
     * pendientes.
     *
     * @param evt
     */
    private void mostrarPantallaSolicitudesTraslado(java.awt.event.ActionEvent evt) {
        if (fSolicitarTraslado == null || !fSolicitarTraslado.isVisible()) {
            fSolicitarTraslado = new FSolicitudesTraslados(fNegocios, usuario, desktop);
            desktop.add(fSolicitarTraslado);
            fSolicitarTraslado.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No se puede abrir la misma ventana dos veces",
                    "Información UI", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void mostrarErrorConsulta(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje,
                "Error Consulta", JOptionPane.WARNING_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnVerSolicitudes = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jSeparator1.setPreferredSize(new java.awt.Dimension(10, 0));
        jToolBar1.add(jSeparator1);

        btnVerSolicitudes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/img/delivery-truck.png"))); // NOI18N
        btnVerSolicitudes.setText("Ver solicitudes");
        btnVerSolicitudes.setBorderPainted(false);
        btnVerSolicitudes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVerSolicitudes.setFocusPainted(false);
        btnVerSolicitudes.setFocusable(false);
        btnVerSolicitudes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVerSolicitudes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnVerSolicitudes);
        jToolBar1.add(jSeparator2);

        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/img/cerrar-sesion.png"))); // NOI18N
        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.setFocusable(false);
        btnCerrarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrarSesion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCerrarSesion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(desktop))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        new FIniciarSesion(this.fNegocios).setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnVerSolicitudes;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
