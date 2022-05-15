package presentacion;

import datos.ConexionBD;
import dominio.Usuario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import negocios.FNegocios;

/**
 * Form principal para los usuarios con permisos de administrador.
 */
public class FPrincipalProductora extends javax.swing.JFrame {

    ConexionBD conexionBD;
    FNegocios fNegocios;
    FRegistrarResiduo fRegistroResiduo;
    FSolicitarTraslado fSolicitarTraslado;
    Usuario usuario;

    public FPrincipalProductora(Usuario usuario) {
        //Modo pantalla completa
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        initComponents();
        this.conexionBD = new ConexionBD();
        this.fNegocios = new FNegocios(conexionBD);
        this.usuario = usuario;

        btnRegistrarResiduo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarPantallaRegistroResiduos(evt);
            }
        });

        btnSolicitarTraslado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarPantallaSolicitarTraslado(evt);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        btnRegistrarResiduo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnSolicitarTraslado = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();

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

        btnRegistrarResiduo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/img/mas.png"))); // NOI18N
        btnRegistrarResiduo.setText("Registrar Residuo");
        btnRegistrarResiduo.setBorderPainted(false);
        btnRegistrarResiduo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrarResiduo.setFocusPainted(false);
        btnRegistrarResiduo.setFocusable(false);
        btnRegistrarResiduo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarResiduo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarResiduo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarResiduoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRegistrarResiduo);

        jSeparator1.setPreferredSize(new java.awt.Dimension(10, 0));
        jToolBar1.add(jSeparator1);

        btnSolicitarTraslado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/img/delivery-truck.png"))); // NOI18N
        btnSolicitarTraslado.setText("Solicitar Traslado");
        btnSolicitarTraslado.setBorderPainted(false);
        btnSolicitarTraslado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSolicitarTraslado.setFocusPainted(false);
        btnSolicitarTraslado.setFocusable(false);
        btnSolicitarTraslado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSolicitarTraslado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnSolicitarTraslado);

        jSeparator2.setPreferredSize(new java.awt.Dimension(10, 0));
        jToolBar1.add(jSeparator2);

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

    private void btnRegistrarResiduoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarResiduoActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarResiduoActionPerformed

    /**
     * Muestra la pantalla de registro de residuo.
     *
     * @param evt
     */
    private void mostrarPantallaRegistroResiduos(java.awt.event.ActionEvent evt) {
        if (fRegistroResiduo == null || !fRegistroResiduo.isVisible()) {
            fRegistroResiduo = new FRegistrarResiduo(fNegocios, usuario);
            desktop.add(fRegistroResiduo);
            fRegistroResiduo.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No se puede abrir la misma ventana dos veces",
                    "Información UI", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Muestra pantalla de solicitar traslado.
     * @param evt 
     */
    private void mostrarPantallaSolicitarTraslado(java.awt.event.ActionEvent evt) {
        if (fSolicitarTraslado == null || !fSolicitarTraslado.isVisible()) {
            fSolicitarTraslado = new FSolicitarTraslado(fNegocios, usuario);
            desktop.add(fSolicitarTraslado);
            fSolicitarTraslado.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No se puede abrir la misma ventana dos veces",
                    "Información UI", JOptionPane.WARNING_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarResiduo;
    private javax.swing.JButton btnSolicitarTraslado;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
