package presentacion;

import dominio.Traslado;
import dominio.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.FNegocios;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 1
 */
public class FSolicitud extends javax.swing.JInternalFrame {
    
    private FNegocios fNegocios;
    private Usuario usuario;
    private Traslado traslado;
    private List<Usuario> listaTransportadoras;
    private List<Usuario> listaTransportadorasSeleccionados;
    
    public FSolicitud(FNegocios fNegocios, Usuario usuario, ObjectId idTraslado) {
        initComponents();
        
        this.fNegocios = fNegocios;
        this.usuario = usuario;
        this.traslado = this.fNegocios.consultarTraslado(idTraslado);
        this.txtProductor.setText(fNegocios.consultarUsuario(traslado.getResiduo().getIdProductora()).getNombre());
        this.txtFechaSolicitada.setText(traslado.getFechaSolicitada().toString());
        this.txtResiduo.setText(traslado.getResiduo().getNombre());
        this.txtCantidad.setText(traslado.getCantidad().toString());
        
        try {
            this.listaTransportadoras = fNegocios.consultarUsuariosTransportadoras();
        } catch (Exception e) {
            this.mostrarErrorConsulta();
            return;
        }
        
        this.llenarTablaTransportadoras();
    }
    
        private void llenarTablaTransportadoras() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblTransportadorasDisponibles.getModel();
        modeloTabla.setRowCount(0);
        listaTransportadoras.forEach(transportadora -> {
            Object[] fila = new Object[3];
            fila[0] = transportadora.getId();
            fila[1] = transportadora.getNombre();
            fila[2] = transportadora.getDireccion();
            modeloTabla.addRow(fila);
        });
    }
    
//        private ObjectId getTrasladoSeleccionadoBuscados() {
//        int indiceFilaSeleccionada = this.tblTraslados.getSelectedRow();
//        if (indiceFilaSeleccionada != -1) {
//            DefaultTableModel modelo = (DefaultTableModel) this.tblTraslados.getModel();
//            int indiceColumnaId = 0;
//            ObjectId idClienteSeleccionado = (ObjectId) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
//            return idClienteSeleccionado;
//        } else {
//            return null;
//        }
//    }
    
    
//    private ObjectId getResiduoSeleccionadoAgregados() {
//        int indiceFilaSeleccionada = this.tblSolicitudes.getSelectedRow();
//        if (indiceFilaSeleccionada != -1) {
//            DefaultTableModel modelo = (DefaultTableModel) this.tblSolicitudes.getModel();
//            int indiceColumnaId = 0;
//            ObjectId idClienteSeleccionado = (ObjectId) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
//            return idClienteSeleccionado;
//        } else {
//            return null;
//        }
//    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        txtFechaSolicitada = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        txtResiduo = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblInformacionResiduo = new javax.swing.JLabel();
        pnlEmpresasDisponibles = new javax.swing.JScrollPane();
        tblTransportadorasDisponibles = new javax.swing.JTable();
        lblEmpresasDisponibles = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JToggleButton();
        lblProductor = new javax.swing.JLabel();
        lblFechaSolicitud = new javax.swing.JLabel();
        lblResiduo = new javax.swing.JLabel();
        txtProductor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pnlEmpresasSeleccionadas = new javax.swing.JScrollPane();
        tblTransportodasSeleccionadas = new javax.swing.JTable();
        txtCantidad = new javax.swing.JTextField();
        lblEmpresasDisponibles1 = new javax.swing.JLabel();

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtFechaSolicitada.setEditable(false);
        txtFechaSolicitada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnAgregar.setText("Agregar -->");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtResiduo.setEditable(false);
        txtResiduo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnEliminar.setText("<-- Eliminar");
        btnEliminar.setMaximumSize(new java.awt.Dimension(72, 22));
        btnEliminar.setMinimumSize(new java.awt.Dimension(72, 22));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblInformacionResiduo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInformacionResiduo.setText("Información de solicitud");

        tblTransportadorasDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Empresa", "Nombre", "Dirección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlEmpresasDisponibles.setViewportView(tblTransportadorasDisponibles);

        lblEmpresasDisponibles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEmpresasDisponibles.setText("Transportadoras disponibles");

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblProductor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblProductor.setText("Productor");

        lblFechaSolicitud.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFechaSolicitud.setText("Fecha solicitada");

        lblResiduo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblResiduo.setText("Residuo");

        txtProductor.setEditable(false);

        jLabel1.setText("Cantidad");

        tblTransportodasSeleccionadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Empresa", "Nombre", "Dirección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlEmpresasSeleccionadas.setViewportView(tblTransportodasSeleccionadas);

        txtCantidad.setEditable(false);
        txtCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblEmpresasDisponibles1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEmpresasDisponibles1.setText("Transportadoras seleccionadas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInformacionResiduo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblResiduo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtResiduo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblFechaSolicitud)
                                        .addComponent(lblProductor, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(17, 17, 17)
                                            .addComponent(txtFechaSolicitada, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(txtProductor)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnGuardar)
                        .addGap(34, 34, 34)
                        .addComponent(btnCancelar)))
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlEmpresasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblEmpresasDisponibles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmpresasDisponibles1)
                        .addGap(0, 162, Short.MAX_VALUE))
                    .addComponent(pnlEmpresasSeleccionadas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEmpresasDisponibles)
                            .addComponent(lblEmpresasDisponibles1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pnlEmpresasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pnlEmpresasSeleccionadas, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInformacionResiduo)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProductor)
                            .addComponent(txtProductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFechaSolicitud)
                            .addComponent(txtFechaSolicitada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblResiduo)
                            .addComponent(txtResiduo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnGuardar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEmpresasDisponibles;
    private javax.swing.JLabel lblEmpresasDisponibles1;
    private javax.swing.JLabel lblFechaSolicitud;
    private javax.swing.JLabel lblInformacionResiduo;
    private javax.swing.JLabel lblProductor;
    private javax.swing.JLabel lblResiduo;
    private javax.swing.JScrollPane pnlEmpresasDisponibles;
    private javax.swing.JScrollPane pnlEmpresasSeleccionadas;
    private javax.swing.JTable tblTransportadorasDisponibles;
    private javax.swing.JTable tblTransportodasSeleccionadas;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFechaSolicitada;
    private javax.swing.JTextField txtProductor;
    private javax.swing.JTextField txtResiduo;
    // End of variables declaration//GEN-END:variables

    private void mostrarErrorConsulta() {
        JOptionPane.showMessageDialog(this, "No se ha podido acceder a la lista de transportadoras registradas", "Error Consultar Residuos", JOptionPane.ERROR_MESSAGE);
    }
}
