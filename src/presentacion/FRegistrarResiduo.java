package presentacion;

import dominio.Quimico;
import dominio.Residuo;
import dominio.Usuario;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.FNegocios;
import org.bson.types.ObjectId;

/**
 * Form de registro de residuo.
 *
 * @author Equipo 1 - Residuos Peligrsosos. Id's: 215058, 228359, 229333
 */
public class FRegistrarResiduo extends javax.swing.JInternalFrame {

    private FNegocios fNegocios;
    private List<Quimico> listaQuimicos;
    private List<Quimico> listaQuimicosSeleccionados;
    private Usuario usuario;

    public FRegistrarResiduo(FNegocios fNegocios, Usuario usuario) {
        initComponents();

        this.fNegocios = fNegocios;
        this.usuario = usuario;
        this.txtProductor.setText(usuario.getNombre());
        try {
            this.listaQuimicos = fNegocios.consultarQuimicos();
        } catch (Exception e) {
            mostrarErrorConsulta();
            return;
        }
        this.listaQuimicosSeleccionados = new ArrayList<>();
        this.llenarTablaQuimicos();
    }

    /**
     * Llena tabla de quimicos disponibles.
     */
    private void llenarTablaQuimicos() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblQuimicos.getModel();
        modeloTabla.setRowCount(0);
        listaQuimicos.forEach(quimico -> {
            Object[] fila = new Object[2];
            fila[0] = quimico.getId();
            fila[1] = quimico.getNombre();
            modeloTabla.addRow(fila);
        });
    }

    /**
     * Llena tabla de quimicos seleccionados.
     */
    private void llenarTablaQuimicosSeleccionados() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblQuimicosSeleccionados.getModel();
        modeloTabla.setRowCount(0);
        listaQuimicosSeleccionados.forEach(quimico -> {
            Object[] fila = new Object[2];
            fila[0] = quimico.getId();
            fila[1] = quimico.getNombre();
            modeloTabla.addRow(fila);
        });
    }

    /**
     * Obtiene el id del quimico seleccionado.
     *
     * @return id del quimico seleccionado
     */
    private ObjectId getQuimicoSeleccionadoBuscados() {
        int indiceFilaSeleccionada = this.tblQuimicos.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblQuimicos.getModel();
            int indiceColumnaId = 0;
            ObjectId idClienteSeleccionado = (ObjectId) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
            return idClienteSeleccionado;
        } else {
            return null;
        }
    }

    /**
     * Obtiene el id del quimico seleccionado.
     *
     * @return id del quimico seleccionado
     */
    private ObjectId getQuimicoSeleccionadoAgregados() {
        int indiceFilaSeleccionada = this.tblQuimicosSeleccionados.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblQuimicosSeleccionados.getModel();
            int indiceColumnaId = 0;
            ObjectId idClienteSeleccionado = (ObjectId) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
            return idClienteSeleccionado;
        } else {
            return null;
        }
    }

    /**
     * Valida los campos del formulario, que la lista no este vacia y que la
     * fecha sea mayor a la actual
     *
     * @return true si la información de los campos son válidos
     */
    public boolean validarCampos() {
        Pattern pattern = Pattern.compile("^[0-9]{6,6}$");
        boolean validacion = pattern.matcher(txtCodigo.getText()).matches();

        if (txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo del código se encuentra vacío", "Error Agregar Residuo", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo del nombre se encuentra vacío", "Error Agregar Residuo", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (txtNombre.getText().length() > 100) {
            JOptionPane.showMessageDialog(this, "El campo del nombre no es válido (mayor a 100)", "Error Agregar Residuo", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (listaQuimicosSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se han seleccionado químicos", "Error Agregar Residuo", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!validacion) {
            JOptionPane.showMessageDialog(this, "El campo del código no es válido (deben ser 6 dígitos)", "Error Agregar Residuo", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        List<Residuo> listaResiduos = fNegocios.consultarResiduos();
        for (Residuo residuo : listaResiduos) {
            if (this.txtNombre.getText().equalsIgnoreCase(residuo.getNombre())) {
                JOptionPane.showMessageDialog(this, "Existe el mismo nombre en la base de datos", "Error Agregar Residuo", JOptionPane.ERROR_MESSAGE);
                return false;
            } else if (this.txtCodigo.getText().equalsIgnoreCase(residuo.getCodigo())) {
                JOptionPane.showMessageDialog(this, "Existe el mismo código en la base de datos", "Error Agregar Residuo", JOptionPane.ERROR_MESSAGE);
                return false;
            } else if (listEqualsIgnoreOrder(this.listaQuimicosSeleccionados, residuo.getQuimicos())) {
                JOptionPane.showMessageDialog(this, "Existe la misma composición de elementos en la base de datos", "Error Agregar Residuo", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    /**
     * Agrega un quimico a la lista de selección
     */
    public void agregarQuimico() {
        ObjectId id = getQuimicoSeleccionadoBuscados();

        for (Iterator<Quimico> i = listaQuimicos.iterator(); i.hasNext();) {
            Quimico quim = i.next();
            if (quim.getId() == id) {
                this.listaQuimicosSeleccionados.add(quim);
                i.remove();
            }
        }

        this.llenarTablaQuimicos();
        this.llenarTablaQuimicosSeleccionados();
    }

    /**
     * Elimina un quimico de la lista de selección.
     */
    public void eliminarQuimico() {
        ObjectId id = getQuimicoSeleccionadoAgregados();

        for (Iterator<Quimico> i = listaQuimicosSeleccionados.iterator(); i.hasNext();) {
            Quimico quim = i.next();
            if (quim.getId() == id) {
                this.listaQuimicos.add(quim);
                i.remove();
            }
        }

        this.llenarTablaQuimicosSeleccionados();
        this.llenarTablaQuimicos();
    }

    /**
     * muestra error de consulta de la lista de quimicos
     */
    public final void mostrarErrorConsulta() {
        JOptionPane.showMessageDialog(this, "No se ha podido acceder a la lista de quimicos disponibles", "Error Consultar Quimicos", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Borra los datos introducidos en los campos del formulario.
     */
    public void limpiarFormulario() {
        this.txtCodigo.setText("");
        this.txtNombre.setText("");
        this.listaQuimicosSeleccionados.forEach(quimico -> {
            this.listaQuimicos.add(quimico);
        });
        this.listaQuimicosSeleccionados.clear();
        this.llenarTablaQuimicos();
        this.llenarTablaQuimicosSeleccionados();
    }

    public static <T> boolean listEqualsIgnoreOrder(List<T> list1, List<T> list2) {
        return new HashSet<>(list1).equals(new HashSet<>(list2));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBuscadorQuimicos = new javax.swing.JLabel();
        lblProductor = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtProductor = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblInformacionResiduo = new javax.swing.JLabel();
        pnlQuimicos = new javax.swing.JScrollPane();
        tblQuimicos = new javax.swing.JTable();
        btnCancelar = new javax.swing.JToggleButton();
        lblQuimicosSeleccionados = new javax.swing.JLabel();
        pnlQuimicosSeleccionados = new javax.swing.JScrollPane();
        tblQuimicosSeleccionados = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);

        lblBuscadorQuimicos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBuscadorQuimicos.setText("Buscador de quimicos");

        lblProductor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblProductor.setText("Productor");

        lblCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCodigo.setText("Código");

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre.setText("Nombre");

        txtProductor.setEditable(false);

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblInformacionResiduo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInformacionResiduo.setText("Información de residuo");

        tblQuimicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Quimico", "Nombre"
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
        pnlQuimicos.setViewportView(tblQuimicos);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblQuimicosSeleccionados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblQuimicosSeleccionados.setText("Quimicos seleccionados");

        tblQuimicosSeleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Quimico", "Nombre"
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
        pnlQuimicosSeleccionados.setViewportView(tblQuimicosSeleccionados);

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrar.setText("Guardar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCodigo)
                                    .addComponent(lblProductor, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProductor))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addGap(51, 51, 51)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblInformacionResiduo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnRegistrar)
                        .addGap(34, 34, 34)
                        .addComponent(btnCancelar)))
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlQuimicos, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblBuscadorQuimicos))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlQuimicosSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuimicosSeleccionados))
                .addContainerGap(25, Short.MAX_VALUE))
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
                            .addComponent(pnlQuimicosSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(pnlQuimicos, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 4, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInformacionResiduo)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProductor)
                            .addComponent(txtProductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnRegistrar))))
                .addGap(25, 25, 25))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limpiarFormulario();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (validarCampos()) {
            Residuo residuo = new Residuo();
            residuo.setNombre(txtNombre.getText());
            residuo.setCodigo(txtCodigo.getText());
            residuo.setQuimicos(listaQuimicosSeleccionados);
            residuo.setIdProductora(usuario.getId());
            this.fNegocios.agregarResiduo(residuo);
            JOptionPane.showMessageDialog(this, "El residuo se ha agregado con éxito", "Agregar Residuo", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarFormulario();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregarQuimico();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarQuimico();
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBuscadorQuimicos;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblInformacionResiduo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblProductor;
    private javax.swing.JLabel lblQuimicosSeleccionados;
    private javax.swing.JScrollPane pnlQuimicos;
    private javax.swing.JScrollPane pnlQuimicosSeleccionados;
    private javax.swing.JTable tblQuimicos;
    private javax.swing.JTable tblQuimicosSeleccionados;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtProductor;
    // End of variables declaration//GEN-END:variables
}
