package presentacion;

import dominio.Residuo;
import dominio.Transporte;
import dominio.Traslado;
import dominio.Tratamiento;
import dominio.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.FNegocios;
import org.bson.types.ObjectId;

/**
 * Formulario donde se muestran los transportes y se termina de registrar el
 * residuo.
 */
public class FTransporte extends javax.swing.JInternalFrame {

    private FNegocios fNegocios;
    private Usuario usuario;
    private Traslado traslado;
    private List<Transporte> listaTransportes;
    private List<Transporte> listaTransportesSeleccionados;

    /**
     * Constructor por defecto del formulario.
     *
     * @param fNegocios Referencia a la fachada de negocios.
     * @param usuario Usuario logueado al formulario.
     * @param idTraslado Id del traslado seleccionado anteriormente.
     */
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

        this.listaTransportesSeleccionados = new ArrayList<>();
        this.llenarTablaTransportes();
    }

    /**
     * Muestra un error en la consulta en caso de que exista.
     */
    private void mostrarErrorConsulta() {
        JOptionPane.showMessageDialog(this, "No se ha podido acceder a la lista de transportes", "Error Consultar Transportes", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Llena la tabla de los transportes.
     */
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

    /**
     * Llena la tabla de los transportes seleccionados.
     */
    private void llenarTablaTransportesSeleccionados() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblTransportesSeleccionados.getModel();
        modeloTabla.setRowCount(0);
        listaTransportesSeleccionados.forEach(transporte -> {
            Object[] fila = new Object[5];
            fila[0] = transporte.getId();
            fila[1] = transporte.getMatricula();
            fila[2] = transporte.getMarca();
            fila[3] = transporte.getModelo();
            fila[4] = transporte.getTipo();
            modeloTabla.addRow(fila);
        });
    }

    /**
     * Devuelve el id del transporte seleccionado.
     * @return Id del transporte seleccionado.
     */
    private ObjectId getTransporteSeleccionadoBuscado() {
        int indiceFilaSeleccionada = this.tblTransportes.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblTransportes.getModel();
            int indiceColumnaId = 0;
            ObjectId idTransporteSeleccionado = (ObjectId) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
            return idTransporteSeleccionado;
        } else {
            return null;
        }
    }

    /**
     * Devuelve el id del transporte agregado seleccionado.
     * @return Id del transporte agregado seleccionado.
     */
    private ObjectId getTransporteSeleccionadoAgregado() {
        int indiceFilaSeleccionada = this.tblTransportesSeleccionados.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblTransportesSeleccionados.getModel();
            int indiceColumnaId = 0;
            ObjectId idTransporteSeleccionado = (ObjectId) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
            return idTransporteSeleccionado;
        } else {
            return null;
        }
    }

    /**
     * Agrega un transporte a la parte de seleccionados de la lista.
     */
    public void agregarTransporte() {
        ObjectId id = getTransporteSeleccionadoBuscado();

        for (Iterator<Transporte> i = listaTransportes.iterator(); i.hasNext();) {
            Transporte transporte = i.next();
            if (transporte.getId() == id) {
                this.listaTransportesSeleccionados.add(transporte);
                i.remove();
            }
        }

        this.llenarTablaTransportes();
        this.llenarTablaTransportesSeleccionados();
    }

    /**
     * Remueve un transporte de la parte de seleccionados de la lista.
     */
    public void eliminarTransporte() {
        ObjectId id = getTransporteSeleccionadoAgregado();

        for (Iterator<Transporte> i = listaTransportesSeleccionados.iterator(); i.hasNext();) {
            Transporte transporte = i.next();
            if (transporte.getId() == id) {
                this.listaTransportes.add(transporte);
                i.remove();
            }
        }

        this.llenarTablaTransportesSeleccionados();
        this.llenarTablaTransportes();
    }

    /**
     * Valida todos los campos a llenar por el usuario.
     * @return Confirmación de la validación.
     */
    public boolean validarCampos() {
        if (txtKilometros.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo de los kilómetros recorridos se encuentra vacío", "Error Registrar Traslado", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (this.txtCosto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo del costo se encuentra vacío", "Error Registrar Traslado", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (this.dpFecha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo de la fecha de llegada se encuentra vacío", "Error Registrar Traslado", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (this.txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo del nombre se encuentra vacío", "Error Registrar Traslado", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (this.txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo de la descripción se encuentra vacío", "Error Registrar Traslado", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (this.txtNombre.getText().length() > 100) {
            JOptionPane.showMessageDialog(this, "El campo del nombre no es válido (mayor a 100)", "Error Registrar Traslado", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (this.txtDescripcion.getText().length() > 280) {
            JOptionPane.showMessageDialog(this, "El campo de la descripción no es válido (mayor a 280)", "Error Registrar Traslado", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (this.dpFecha.getDate().isBefore(this.traslado.getFechaSolicitada())) {
            JOptionPane.showMessageDialog(this, "La fecha de llegada no puede ser antes que la fecha solicitada", "Error Registrar Traslado", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (listaTransportesSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se han seleccionado transportes", "Error Registrar Traslado", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            if (Float.parseFloat(this.txtKilometros.getText()) < 0 || Float.parseFloat(this.txtKilometros.getText()) > 1000) {
                JOptionPane.showMessageDialog(this, "Los kilómetros recorridos no pueden ser negativos ni mayores a 1000", "Error Registrar Traslado", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Los kilómetros recorridos deben de estar definidos como un valor numérico", "Error Registrar Traslado", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            if (Float.parseFloat(this.txtCosto.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "El costo no puede ser negativo", "Error Registrar Traslado", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "El costo debe de estar definido como un valor numérico", "Error Registrar Traslado", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    /**
     * Limpia las entradas del formulario.
     */
    public void limpiarFormulario() {
        this.txtKilometros.setText("");
        this.txtCosto.setText("");
        this.dpFecha.setDate(null);
        this.txtNombre.setText("");
        this.txtDescripcion.setText("");
        this.listaTransportesSeleccionados.forEach(transporte -> {
            this.listaTransportes.add(transporte);
        });
        this.listaTransportesSeleccionados.clear();
        this.llenarTablaTransportes();
        this.llenarTablaTransportesSeleccionados();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtKilometros = new javax.swing.JTextField();
        lblInformacionTraslado = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
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
        lblQuimicosSeleccionados = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        pnlTransportesSeleccionados = new javax.swing.JScrollPane();
        tblTransportesSeleccionados = new javax.swing.JTable();
        lblBuscadorTransportes = new javax.swing.JLabel();
        pnlTransportes = new javax.swing.JScrollPane();
        tblTransportes = new javax.swing.JTable();

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

        lblCosto.setText("Costo");
        lblCosto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblInformacionTratamiento.setText("Información del tratamiento");
        lblInformacionTratamiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblDescripcion.setText("Descripción");
        lblDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        pnlDescripcion.setViewportView(txtDescripcion);

        lblNombre.setText("Nombre");
        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblQuimicosSeleccionados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblQuimicosSeleccionados.setText("Transportes seleccionados");

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

        tblTransportesSeleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Transporte", "Matrícula", "Marca", "Modelo", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlTransportesSeleccionados.setViewportView(tblTransportesSeleccionados);

        lblBuscadorTransportes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBuscadorTransportes.setText("Transportes registrados");

        tblTransportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Transporte", "Matrícula", "Marca", "Modelo", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlTransportes.setViewportView(tblTransportes);

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
                    .addComponent(lblBuscadorTransportes)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlTransportes, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTransportesSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuimicosSeleccionados))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
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
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBuscadorTransportes)
                            .addComponent(lblQuimicosSeleccionados))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pnlTransportes, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                                    .addComponent(pnlTransportesSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Botón final de registrar.
     * @param evt 
     */
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (validarCampos()) {
            this.traslado.setKmRecorridos(Float.parseFloat(this.txtKilometros.getText()));
            this.traslado.setCosto(Double.parseDouble(this.txtCosto.getText()));
            this.traslado.setFechaLlegada(this.dpFecha.getDate());
            this.traslado.setEstado("registrado");

            Residuo residuo = this.traslado.getResiduo();
            Tratamiento tratamiento = new Tratamiento();
            tratamiento.setNombre(this.txtNombre.getText());
            tratamiento.setDescripcion(this.txtDescripcion.getText());
            residuo.setTratamiento(tratamiento);

            List<ObjectId> listaIdsTraslados = new ArrayList<>();
            this.listaTransportesSeleccionados.forEach(transporte -> {
                listaIdsTraslados.add(transporte.getId());
            });
            this.traslado.setIdTransportes(listaIdsTraslados);

            this.fNegocios.actualizarTraslado(traslado);
            JOptionPane.showMessageDialog(this, "Se ha registrado el traslado con exito", "Registro Traslados", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarFormulario();
            this.dispose();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    /**
     * Botón de cancelar.
     * @param evt 
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limpiarFormulario();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Botón de agregar.
     * @param evt 
     */
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.agregarTransporte();
    }//GEN-LAST:event_btnAgregarActionPerformed

    /**
     * Botón de eliminar.
     * @param evt 
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        this.eliminarTransporte();
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private com.github.lgooddatepicker.components.DatePicker dpFecha;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBuscadorTransportes;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFechaLlegada;
    private javax.swing.JLabel lblInformacionTraslado;
    private javax.swing.JLabel lblInformacionTratamiento;
    private javax.swing.JLabel lblKilometros;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblQuimicosSeleccionados;
    private javax.swing.JScrollPane pnlDescripcion;
    private javax.swing.JScrollPane pnlTransportes;
    private javax.swing.JScrollPane pnlTransportesSeleccionados;
    private javax.swing.JTable tblTransportes;
    private javax.swing.JTable tblTransportesSeleccionados;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtKilometros;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
