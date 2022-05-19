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
 * Form de asignación de solicitudes pendientes.
 */
public class FSolicitudesTraslados extends javax.swing.JInternalFrame {

    private FNegocios fNegocios;
    private Usuario usuario;
    private FSolicitud fSolicitud;
    private List<Traslado> listaTraslados;
    private JDesktopPane desktop;

    /**
     * Constructor que recibe la fachada de negocios, usuario y el dektop donde
     * se muestran las pantallas.
     *
     * @param fNegocios fachada de control
     * @param usuario usuario con credenciales
     * @param desktop desktop principal
     */
    public FSolicitudesTraslados(FNegocios fNegocios, Usuario usuario, JDesktopPane desktop) {
        initComponents();

        this.fNegocios = fNegocios;
        this.usuario = usuario;
        this.desktop = desktop;

        try {
            this.listaTraslados = fNegocios.consultarTrasladosPendientes();
        } catch (Exception e) {
            mostrarErrorConsulta();
            return;
        }
        this.llenarTablaTraslados();
    }

    /**
     * Llena la tabla con todas las solicitudes de traslados que se ecuentren
     * pendientes.
     */
    public void llenarTablaTraslados() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblSolicitudes.getModel();
        modeloTabla.setRowCount(0);
        listaTraslados.forEach(traslado -> {
            Object[] fila = new Object[5];
            fila[0] = traslado.getId();
            fila[1] = fNegocios.consultarUsuario(traslado.getResiduo().getIdProductora()).getNombre();
            fila[2] = traslado.getFechaSolicitada();
            fila[3] = traslado.getResiduo().getNombre();
            fila[4] = traslado.getCantidad();
            modeloTabla.addRow(fila);
        });
    }

    /**
     * Obtiene el id del traslado seleccionado de la tabla.
     *
     * @return id del traslado seleccionado
     */
    private ObjectId getTrasladoSeleccionadoBuscados() {
        int indiceFilaSeleccionada = this.tblSolicitudes.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblSolicitudes.getModel();
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

        pnlSolicitudes = new javax.swing.JScrollPane();
        tblSolicitudes = new javax.swing.JTable();
        lblSolicitudes = new javax.swing.JLabel();
        btnAsignarEmpresas = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Solicitudes de traslados");

        tblSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id traslado", "Productora", "Fecha solicitada", "Residuo", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Long.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
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
        pnlSolicitudes.setViewportView(tblSolicitudes);

        lblSolicitudes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSolicitudes.setText("Solicitudes");

        btnAsignarEmpresas.setText("Asignar empresas");
        btnAsignarEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarEmpresasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblSolicitudes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAsignarEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(399, 399, 399))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblSolicitudes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnAsignarEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Abre una nueva ventana donde se asignaran las empresas transportadoras.
     *
     * @param evt
     */
    private void btnAsignarEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarEmpresasActionPerformed
        ObjectId idTraslado = getTrasladoSeleccionadoBuscados();

        if (idTraslado != null) {
            if (fSolicitud == null || !fSolicitud.isVisible()) {
                this.fSolicitud = new FSolicitud(fNegocios, usuario, idTraslado, this);
                desktop.add(fSolicitud);
                fSolicitud.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se puede abrir la misma ventana dos veces",
                        "Información UI", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Se debe de seleccionar una solicitud",
                    "Información Registro Traslados", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAsignarEmpresasActionPerformed

    /**
     * Muestra un mensaje de error avisando que hubo un error en la consulta.
     */
    private void mostrarErrorConsulta() {
        JOptionPane.showMessageDialog(this, "No se ha podido acceder a la lista de solicitudes registradoa", "Error Consultar Residuos", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarEmpresas;
    private javax.swing.JLabel lblSolicitudes;
    private javax.swing.JScrollPane pnlSolicitudes;
    private javax.swing.JTable tblSolicitudes;
    // End of variables declaration//GEN-END:variables

}
