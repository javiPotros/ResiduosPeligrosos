package presentacion;

import dominio.Residuo;
import dominio.Traslado;
import dominio.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.FNegocios;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 1
 */
public class FSolicitarTraslado extends javax.swing.JInternalFrame {

    private FNegocios fNegocios;
    private List<Residuo> listaResiduos;
    private List<Traslado> listaResiduosSeleccionados;
    private Usuario usuario;

    public FSolicitarTraslado(FNegocios fNegocios, Usuario usuario) {
        initComponents();
        setClosable(true);

        this.fNegocios = fNegocios;
        this.usuario = usuario;
        this.txtProductor.setText(usuario.getNombre());
        try {
            this.listaResiduos = fNegocios.consultarResiduosPorProductor(usuario.getId());
        } catch (Exception e) {
            mostrarErrorConsulta();
            return;
        }
        this.listaResiduosSeleccionados = new ArrayList<>();
        this.llenarTablaResiduos();

    }

    private void llenarTablaResiduos() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblResiduos.getModel();
        modeloTabla.setRowCount(0);
        listaResiduos.forEach(residuo -> {
            Object[] fila = new Object[2];
            fila[0] = residuo.getId();
            fila[1] = residuo.getNombre();
            modeloTabla.addRow(fila);
        });
    }

    private void llenarTablaResiduosSeleccionados() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblResiduosSeleccionados.getModel();
        modeloTabla.setRowCount(0);
        listaResiduosSeleccionados.forEach(traslado -> {
            Object[] fila = new Object[3];
            fila[0] = traslado.getResiduo().getId();
            fila[1] = traslado.getResiduo().getNombre();
            fila[2] = traslado.getCantidad();
            modeloTabla.addRow(fila);
        });
    }

    private ObjectId getResiduoSeleccionadoBuscados() {
        int indiceFilaSeleccionada = this.tblResiduos.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblResiduos.getModel();
            int indiceColumnaId = 0;
            ObjectId idClienteSeleccionado = (ObjectId) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
            return idClienteSeleccionado;
        } else {
            return null;
        }
    }

    private ObjectId getResiduoSeleccionadoAgregados() {
        int indiceFilaSeleccionada = this.tblResiduosSeleccionados.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblResiduosSeleccionados.getModel();
            int indiceColumnaId = 0;
            ObjectId idClienteSeleccionado = (ObjectId) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
            return idClienteSeleccionado;
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInformacionResiduo = new javax.swing.JLabel();
        pnlResiduos = new javax.swing.JScrollPane();
        tblResiduos = new javax.swing.JTable();
        lblBuscadorQuimicos = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JToggleButton();
        lblProductor = new javax.swing.JLabel();
        lblQuimicosSeleccionados = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        pnlResiduosSeleccionados = new javax.swing.JScrollPane();
        tblResiduosSeleccionados = new javax.swing.JTable();
        txtProductor = new javax.swing.JTextField();
        btnSolicitar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        pckFecha = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblInformacionResiduo.setText("Información de traslado");
        lblInformacionResiduo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tblResiduos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Residuo", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlResiduos.setViewportView(tblResiduos);

        lblBuscadorQuimicos.setText("Residuos registrados");
        lblBuscadorQuimicos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnCancelar.setText("Cancelar");
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblProductor.setText("Productor");
        lblProductor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblQuimicosSeleccionados.setText("Residuos seleccionados");
        lblQuimicosSeleccionados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblCodigo.setText("Fecha");
        lblCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tblResiduosSeleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Residuo", "Nombre", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlResiduosSeleccionados.setViewportView(tblResiduosSeleccionados);

        txtProductor.setEditable(false);

        btnSolicitar.setText("Solicitar");
        btnSolicitar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar -->");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setText("<-- Eliminar");
        btnEliminar.setMaximumSize(new java.awt.Dimension(72, 22));
        btnEliminar.setMinimumSize(new java.awt.Dimension(72, 22));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

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
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCodigo)
                                    .addComponent(lblProductor, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtProductor, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pckFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnSolicitar)
                        .addGap(34, 34, 34)
                        .addComponent(btnCancelar)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlResiduos, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblBuscadorQuimicos))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlResiduosSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuimicosSeleccionados))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBuscadorQuimicos)
                            .addComponent(lblQuimicosSeleccionados))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlResiduosSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(pnlResiduos, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInformacionResiduo)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProductor)
                            .addComponent(txtProductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo)
                            .addComponent(pckFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnSolicitar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limpiarFormulario();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarActionPerformed
        if (validarCampos()) {
            for (Traslado traslado : listaResiduosSeleccionados) {
                traslado.setFechaSolicitada(pckFecha.getDate());
                this.fNegocios.agregarTraslado(traslado);
            }
            JOptionPane.showMessageDialog(this, "Se ha solcitado el traslado con éxito", "Solicitar traslado", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarFormulario();
        }
    }//GEN-LAST:event_btnSolicitarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregarResiduo();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarResiduo();
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSolicitar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBuscadorQuimicos;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblInformacionResiduo;
    private javax.swing.JLabel lblProductor;
    private javax.swing.JLabel lblQuimicosSeleccionados;
    private com.github.lgooddatepicker.components.DatePicker pckFecha;
    private javax.swing.JScrollPane pnlResiduos;
    private javax.swing.JScrollPane pnlResiduosSeleccionados;
    private javax.swing.JTable tblResiduos;
    private javax.swing.JTable tblResiduosSeleccionados;
    private javax.swing.JTextField txtProductor;
    // End of variables declaration//GEN-END:variables

    private void mostrarErrorConsulta() {
        JOptionPane.showMessageDialog(this, "No se ha podido acceder a la lista de residuos registrados", "Error Consultar Residuos", JOptionPane.ERROR_MESSAGE);
    }

    private void agregarResiduo() {
        String[] s = {"Kg", "L"};
        JComboBox medida = new JComboBox(s);
        Object[] items = {medida};

        ObjectId id = getResiduoSeleccionadoBuscados();
        if (id != null) {
            String cantidad = JOptionPane.showInputDialog(this, items, "Introduzca una cantidad", JOptionPane.OK_CANCEL_OPTION);
            try {
                if (cantidad != null) {
                    if (Float.parseFloat(cantidad) > 0) {
                        Traslado traslado = new Traslado();
                        traslado.setCantidad(Float.parseFloat(cantidad));
                        Residuo residuo = fNegocios.consultarResiduo(id);
                        traslado.setResiduo(residuo);
                        traslado.setFechaSolicitada(pckFecha.getDate());
                        traslado.setEstado("pendiente");

                        if (residuo != null) {
                            listaResiduosSeleccionados.add(traslado);
                            listaResiduos.remove(fNegocios.consultarResiduo(id));
                        }
                        this.llenarTablaResiduos();
                        this.llenarTablaResiduosSeleccionados();
                    } else {
                        throw new NumberFormatException();
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Se debe introducir una cantidad valida",
                        "Error Solicitar Traslado", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    private void eliminarResiduo() {
        ObjectId id = getResiduoSeleccionadoAgregados();

        if (id != null) {
            Residuo residuo = fNegocios.consultarResiduo(id);
            if (residuo != null) {
                listaResiduosSeleccionados.remove(residuo);
                listaResiduos.add(residuo);
                this.llenarTablaResiduos();
                this.llenarTablaResiduosSeleccionados();
            }
        }

    }

    private boolean validarCampos() {
        if (this.pckFecha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Se debe seleccionar una fecha para la solicitud",
                    "Error Solicitar Traslado", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (listaResiduosSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay residuos seleccionados", "Error Solicitar traslado", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        LocalDate fecha = pckFecha.getDate();
        if (fecha.isBefore(LocalDate.now())) {
            JOptionPane.showMessageDialog(this, "La fecha no puede ser anterior", "Error Solicitar traslado", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void limpiarFormulario() {
        pckFecha.setDate(null);
        listaResiduosSeleccionados.clear();
        llenarTablaResiduosSeleccionados();
        this.listaResiduos = fNegocios.consultarResiduos();
        llenarTablaResiduos();
    }
}
