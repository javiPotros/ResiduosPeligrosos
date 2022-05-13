package presentacion;

import dominio.Residuo;
import dominio.Transporte;
import dominio.Traslado;
import dominio.Tratamiento;
import dominio.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.FNegocios;
import org.bson.types.ObjectId;

public class FTransporte extends javax.swing.JInternalFrame {

    private FNegocios fNegocios;
    private Usuario usuario;
    private Traslado traslado;
    private List<Transporte> listaTransportes;

    public FTransporte(FNegocios fNegocios, Usuario usuario, ObjectId idTraslado) {
        initComponents();

        this.fNegocios = fNegocios;
        this.usuario = usuario;
        this.traslado = this.fNegocios.consultarTraslado(idTraslado);
        
        try {
            this.listaTransportes = fNegocios.consultarTransportes();
        } catch (Exception e) {
            this.mostrarErrorConsulta();
            return;
        }
        
        this.llenarTablaTransportes();
    }

    private void mostrarErrorConsulta() {
        JOptionPane.showMessageDialog(this, "No se ha podido acceder a la lista de transportes", "Error Consultar Transportes", JOptionPane.ERROR_MESSAGE);
    }
    
    private void llenarTablaTransportes() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblTransportes.getModel();
        modeloTabla.setRowCount(0);
        listaTransportes.forEach(transporte -> {
            Object[] fila = new Object[5];
            fila[0] = transporte.getId();
            fila[1] = transporte.getMatricula();
            fila[2] = transporte.getMarca();
            fila[3] = transporte.getModelo();
            fila[4] = transporte.getTipo();
            modeloTabla.addRow(fila);
        });
    }

    public boolean validarCampos() {
        return false;
    }

    public void limpiarFormulario() {
        this.txtKilometros.setText("");
        this.txtCosto.setText("");
        this.dpFecha.setDate(null);
        this.txtNombre.setText("");
        this.txtDescripcion.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtKilometros = new javax.swing.JTextField();
        lblInformacionTraslado = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        pnlTransportes = new javax.swing.JScrollPane();
        tblTransportes = new javax.swing.JTable();
        lblTransportes = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnCancelar = new javax.swing.JToggleButton();
        dpFecha = new com.github.lgooddatepicker.components.DatePicker();
        lblKilometros = new javax.swing.JLabel();
        lblFechaLlegada = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        lblInformacionTratamiento = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        pnlDescripcion = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblNombre = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Registrar Traslado");

        lblInformacionTraslado.setText("Información de traslado");
        lblInformacionTraslado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnRegistrar.setText("Registrar");
        btnRegistrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        tblTransportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Transporte", "Matricula", "Marca", "Modelo", "Tipo", "Selección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlTransportes.setViewportView(tblTransportes);

        lblTransportes.setText("Transportes");
        lblTransportes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnCancelar.setText("Cancelar");
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblKilometros.setText("Kilómetros");
        lblKilometros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFechaLlegada.setText("Fecha llegada");
        lblFechaLlegada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblCosto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCosto.setText("Costo");

        lblInformacionTratamiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInformacionTratamiento.setText("Información del tratamiento");

        lblDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDescripcion.setText("Descripción");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        pnlDescripcion.setViewportView(txtDescripcion);

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre.setText("Nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInformacionTraslado, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion)
                            .addComponent(lblNombre)
                            .addComponent(lblKilometros)
                            .addComponent(lblCosto)
                            .addComponent(lblFechaLlegada))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtKilometros)
                                .addComponent(txtCosto)
                                .addComponent(dpFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombre)
                                .addComponent(pnlDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btnRegistrar)
                                .addGap(34, 34, 34)
                                .addComponent(btnCancelar))))
                    .addComponent(lblInformacionTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlTransportes, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTransportes)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTransportes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlTransportes, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblInformacionTraslado)
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblKilometros, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblFechaLlegada))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtKilometros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dpFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addComponent(lblInformacionTratamiento)
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pnlDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCancelar)
                                    .addComponent(btnRegistrar))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (validarCampos()) {
            this.traslado.setKmRecorridos(Float.parseFloat(this.txtKilometros.getText()));
            this.traslado.setCosto(Double.parseDouble(this.txtCosto.getText()));
            this.traslado.setFechaLlegada(this.dpFecha.getDate());
            Residuo residuo = this.traslado.getResiduo();
            Tratamiento tratamiento = new Tratamiento();
            tratamiento.setNombre(this.txtNombre.getText());
            tratamiento.setDescripcion(this.txtDescripcion.getText());
            residuo.setTratamiento(tratamiento);
            //this.fNegocios.actualizarTrasladoPendiente(this.traslado, residuo);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limpiarFormulario();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private com.github.lgooddatepicker.components.DatePicker dpFecha;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFechaLlegada;
    private javax.swing.JLabel lblInformacionTraslado;
    private javax.swing.JLabel lblInformacionTratamiento;
    private javax.swing.JLabel lblKilometros;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTransportes;
    private javax.swing.JScrollPane pnlDescripcion;
    private javax.swing.JScrollPane pnlTransportes;
    private javax.swing.JTable tblTransportes;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtKilometros;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
