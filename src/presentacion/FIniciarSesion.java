package presentacion;

import datos.ConexionBD;
import dominio.Usuario;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import negocios.FNegocios;

/**
 * Form de inicio de sesión para usuarios registrados en la base de datos.
 */
public class FIniciarSesion extends javax.swing.JFrame {

    ConexionBD conexionBD;
    FNegocios fNegocios;

    public FIniciarSesion() {
        initComponents();
        this.conexionBD = new ConexionBD();
        this.fNegocios = new FNegocios(conexionBD);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblContrasena = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        txtContrasena = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de sesión");

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario.setText("Usuario");

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        lblContrasena.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblContrasena.setText("Contraseña");

        btnIngresar.setBackground(new java.awt.Color(255, 255, 255));
        btnIngresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnIngresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblContrasena))
                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lblUsuario))
                    .addComponent(txtContrasena))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIngresar)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento para el tecleo en el campo de usuario, muestra un mensaje avisando
     * que solamente se pueden utilizar letras.
     *
     * @param evt
     */
    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        if (!Character.isLetter(evt.getKeyChar())
                && !(evt.getKeyChar() == KeyEvent.VK_SPACE)
                && !(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "El usuario solamente contiene letras");
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    /**
     * Evento para 
     * @param evt 
     */
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        Usuario usuario = fNegocios.consultarUsuario(txtUsuario.getText(), txtContrasena.getText());

        if (usuario != null) {

            switch (usuario.getTipo().toLowerCase()) {
                case "productora":
                    FPrincipalProductora fPrincipalProductora = new FPrincipalProductora(usuario);
                    fPrincipalProductora.setVisible(true);
                    this.dispose();
                    break;
                case "administrador":
                    FPrincipalAdmin fPrincipalAdmin = new FPrincipalAdmin(usuario);
                    fPrincipalAdmin.setVisible(true);
                    this.dispose();
                    break;
                case "transportadora":
                    FPrincipalTransportadora fPrincipalTransportadora = new FPrincipalTransportadora(usuario);
                    fPrincipalTransportadora.setVisible(true);
                    this.dispose();
                    break;
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Usario y/o Clave incorrecta");
        }


    }//GEN-LAST:event_btnIngresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
