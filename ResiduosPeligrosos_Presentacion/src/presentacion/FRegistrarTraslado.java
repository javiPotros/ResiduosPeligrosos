package presentacion;

import dominio.Traslado;
import dominio.Usuario;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.FNegocios;
import org.bson.types.ObjectId;

/**
 * Formulario para comenzar a registrar un residuo.
 */
public class FRegistrarTraslado extends javax.swing.JInternalFrame {

    private FNegocios fNegocios;
    private Usuario usuario;
    private FTransporte fTransporte;
    private JDesktopPane desktop;
    private List<Traslado> listaTraslados;

    /**
     * Constructor por defecto del formulario.
     * @param fNegocios Referencia a la fachada de negocios.
     * @param usuario Usuario logueado al formulario.
     * @param desktop Panel de escritorio de la pantalla principal.
     * @param fTransporte Formulario en donde se procedera con el registro del traslado.
     */
    public FRegistrarTraslado(FNegocios fNegocios, Usuario usuario, JDesktopPane desktop, FTransporte fTransporte) {
        initComponents();

        this.fNegocios = fNegocios;
        this.usuario = usuario;
        this.desktop = desktop;
        this.fTransporte = fTransporte;

        try {
            this.listaTraslados = fNegocios.consultarTrasladosAsignados(this.usuario.getId());
        } catch (Exception e) {
            this.mostrarErrorConsulta();
            return;
        }

        this.llenarTablaTraslados();
    }

    /**
     * Muestra un error en la consulta en caso de que exista.
     */
    private void mostrarErrorConsulta() {
        JOptionPane.showMessageDialog(this, "No se ha podido acceder a la lista de traslados solicitados", "Error Consultar Traslados", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Llena la tabla de los traslados.
     */
    private void llenarTablaTraslados() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblTraslados.getModel();
        modeloTabla.setRowCount(0);
        listaTraslados.forEach(traslado -> {
            Object[] fila = new Object[5];
            fila[0] = traslado.getId();
            fila[1] = traslado.getFechaSolicitada();
            fila[2] = traslado.getResiduo().getNombre();
            fila[3] = traslado.getCantidad();
            fila[4] = this.fNegocios.consultarUsuario(traslado.getResiduo().getIdProductora()).getNombre();
            modeloTabla.addRow(fila);
        });
    }

    /**
     * Devuelve el id del traslado seleccionado.
     * @return Id del traslado seleccionado.
     */
    private ObjectId getTrasladoSeleccionadoBuscado() {
        int indiceFilaSeleccionada = this.tblTraslados.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblTraslados.getModel();
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

        pnlTraslados = new javax.swing.JScrollPane();
        tblTraslados = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        lblTraslados = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Registrar Traslado");

        tblTraslados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Traslado", "Fecha Solicitada", "Residuo", "Cantidad", "Productora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        pnlTraslados.setViewportView(tblTraslados);

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        lblTraslados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTraslados.setText("Traslados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addGap(372, 372, 372))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTraslados, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTraslados)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTraslados)
                .addGap(11, 11, 11)
                .addComponent(pnlTraslados, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Botón de registrar.
     */
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        ObjectId idTraslado = getTrasladoSeleccionadoBuscado();

        if (idTraslado != null) {
            if (fTransporte == null || !fTransporte.isVisible()) {

                FTransporte fTransporte = new FTransporte(fNegocios, usuario, idTraslado);
                desktop.add(fTransporte);
                fTransporte.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se puede abrir la misma ventana dos veces",
                        "Información UI", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Se debe de seleccionar un traslado",
                    "Información Registro Traslados", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel lblTraslados;
    private javax.swing.JScrollPane pnlTraslados;
    private javax.swing.JTable tblTraslados;
    // End of variables declaration//GEN-END:variables
}
