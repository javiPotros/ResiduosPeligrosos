package presentacion;

import dominio.Usuario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import negocios.FNegocios;

/**
 * Form principal que se muestra a la transportadora.
 */
public class FPrincipalTransportadora extends javax.swing.JFrame {
    
    FNegocios fNegocios;
    FRegistrarResiduo fRegistroResiduo;
    FSolicitarTraslado fSolicitarTraslado;
    FRegistrarTraslado fRegistrarTraslado;
    FTransporte fTransporte;
    Usuario usuario;

    /**
     * Constructor por defecto del form.
     *
     * @param usuario Usuario logueado
     */
    public FPrincipalTransportadora(Usuario usuario, FNegocios fNegocios) {
        //Modo pantalla completa
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        this.fNegocios = fNegocios;
        this.usuario = usuario;

        btnRegistrarTraslado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (!fNegocios.consultarTrasladosAsignados(usuario.getId()).isEmpty()) {
                    if (!fNegocios.consultarTransportes().isEmpty()) {
                        mostrarPantallaRegistrarTraslado(evt);
                    } else {
                        mostrarErrorConsulta("No hay transportes registrados en la base de datos");
                    }
                } else {
                    mostrarErrorConsulta("No hay traslados registrados en la base de datos");
                }
            }
        });
    }

    /**
     * Botón para iniciar el caso de uso de Registrar Traslado.
     *
     * @param evt
     */
    private void mostrarPantallaRegistrarTraslado(java.awt.event.ActionEvent evt) {
        if (fRegistrarTraslado == null || !fRegistrarTraslado.isVisible()) {
            fRegistrarTraslado = new FRegistrarTraslado(fNegocios, usuario, desktop, fTransporte);
            desktop.add(fRegistrarTraslado);
            fRegistrarTraslado.setVisible(true);
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

        jToolBar1 = new javax.swing.JToolBar();
        btnRegistrarTraslado = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnCerrarSesion = new javax.swing.JButton();
        desktop = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnRegistrarTraslado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/img/delivery-truck.png"))); // NOI18N
        btnRegistrarTraslado.setText("Registrar Traslado");
        btnRegistrarTraslado.setFocusable(false);
        btnRegistrarTraslado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarTraslado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnRegistrarTraslado);

        jSeparator2.setPreferredSize(new java.awt.Dimension(10, 0));
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

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 411, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktop)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        new FIniciarSesion(this.fNegocios).setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnRegistrarTraslado;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
