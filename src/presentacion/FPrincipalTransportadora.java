package presentacion;

import datos.ConexionBD;
import dominio.Usuario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import negocios.FNegocios;

public class FPrincipalTransportadora extends javax.swing.JFrame {

    ConexionBD conexionBD;
    FNegocios fNegocios;
    FRegistroResiduo fRegistroResiduo;
    FSolicitarTraslado fSolicitarTraslado;
    FRegistrarTraslado fRegistrarTraslado;
    Usuario usuario;

    public FPrincipalTransportadora(Usuario usuario) {
        //Modo pantalla completa
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        initComponents();
        this.conexionBD = new ConexionBD();
        this.fNegocios = new FNegocios(conexionBD);
        this.usuario = usuario;

        btnRegistrarTraslado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarPantallaRegistrarTraslado(evt);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnRegistrarTraslado = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
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

    private void mostrarPantallaRegistrarTraslado(java.awt.event.ActionEvent evt) {
        if (fRegistrarTraslado == null || !fRegistrarTraslado.isVisible()) {
            fRegistrarTraslado = new FRegistrarTraslado(fNegocios, usuario, desktop);
            desktop.add(fRegistrarTraslado);
            fRegistrarTraslado.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No se puede abrir la misma ventana dos veces",
                    "Información UI", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarTraslado;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
