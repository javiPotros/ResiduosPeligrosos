package presentacion;

import dominio.Usuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.FNegocios;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 1
 */
public class FSolicitudesTraslados extends javax.swing.JInternalFrame {

    private FNegocios fNegocios;
    private Usuario usuario;

    public FSolicitudesTraslados(FNegocios fNegocios, Usuario usuario) {
        initComponents();

        this.fNegocios = fNegocios;
        this.usuario = usuario;


    }

//    private void llenarTablaResiduos() {
//        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblResiduos.getModel();
//        modeloTabla.setRowCount(0);
//        listaResiduos.forEach(residuo -> {
//            Object[] fila = new Object[2];
//            fila[0] = residuo.getId();
//            fila[1] = residuo.getNombre();
//            modeloTabla.addRow(fila);
//        });
//    }

//    private void llenarTablaResiduosSeleccionados() {
//        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblSolicitudes.getModel();
//        modeloTabla.setRowCount(0);
//        listaResiduosSeleccionados.forEach(traslado -> {
//            Object[] fila = new Object[3];
//            fila[0] = traslado.getResiduo().getId();
//            fila[1] = traslado.getResiduo().getNombre();
//            fila[2] = traslado.getCantidad();
//            modeloTabla.addRow(fila);
//        });
//    }

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

        pnlSolicitudes = new javax.swing.JScrollPane();
        tblResiduos = new javax.swing.JTable();
        lblBuscadorQuimicos = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblResiduos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Productor", "Fecha solicitada", "Residuo", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlSolicitudes.setViewportView(tblResiduos);

        lblBuscadorQuimicos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBuscadorQuimicos.setText("Solicitudes");

        btnAgregar.setText("Asignar empresas");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBuscadorQuimicos)
                    .addComponent(pnlSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblBuscadorQuimicos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
 
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBuscadorQuimicos;
    private javax.swing.JScrollPane pnlSolicitudes;
    private javax.swing.JTable tblResiduos;
    // End of variables declaration//GEN-END:variables

    private void mostrarErrorConsulta() {
        JOptionPane.showMessageDialog(this, "No se ha podido acceder a la lista de residuos registrados", "Error Consultar Residuos", JOptionPane.ERROR_MESSAGE);
    }

    private boolean validarCampos() {
        return false;
    }

    private void limpiarFormulario() {
    }
}
