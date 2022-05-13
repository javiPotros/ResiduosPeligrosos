package presentacion;

import dominio.Residuo;
import dominio.Traslado;
import dominio.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import negocios.FNegocios;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 1
 */
public class FSolicitudesTraslado extends  javax.swing.JInternalFrame {

    private FNegocios fNegocios;
    private List<Residuo> listaResiduos;
    private List<Traslado> listaResiduosSeleccionados;
    private Usuario usuario;
    
    public FSolicitudesTraslado(FNegocios fNegocios, Usuario usuario) {
        initComponents();
        setClosable(true);
        
        this.fNegocios = fNegocios;
        this.usuario = usuario;
      
        try {
            this.listaResiduos = fNegocios.consultarResiduosPorProductor(usuario.getNombre());
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
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblSolicitudes.getModel();
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
        tblResiduos = new javax.swing.JTable();
        lblBuscadorQuimicos = new javax.swing.JLabel();
        lblQuimicosSeleccionados = new javax.swing.JLabel();
        pnlResiduosSeleccionados = new javax.swing.JScrollPane();
        tblSolicitudes = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblResiduos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id ", "Productora", "Residuos", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
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

        lblQuimicosSeleccionados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblQuimicosSeleccionados.setText("Detalles del residuo");

        tblSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
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
        pnlResiduosSeleccionados.setViewportView(tblSolicitudes);

        btnAgregar.setText("Asignar transporte");
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
                    .addComponent(pnlSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlResiduosSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblQuimicosSeleccionados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblQuimicosSeleccionados))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBuscadorQuimicos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlResiduosSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregarResiduo();
    }//GEN-LAST:event_btnAgregarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBuscadorQuimicos;
    private javax.swing.JLabel lblQuimicosSeleccionados;
    private javax.swing.JScrollPane pnlResiduosSeleccionados;
    private javax.swing.JScrollPane pnlSolicitudes;
    private javax.swing.JTable tblResiduos;
    private javax.swing.JTable tblSolicitudes;
    // End of variables declaration//GEN-END:variables

    private void mostrarErrorConsulta() {
        JOptionPane.showMessageDialog(this, "No se ha podido acceder a la lista de residuos registrados", "Error Consultar Residuos", JOptionPane.ERROR_MESSAGE);
    }

    private void agregarResiduo() {

   
        String[] s = {"Kg","L"}; 
        JComboBox medida = new JComboBox(s);
        Object[] items = {medida};

        ObjectId id = getResiduoSeleccionadoBuscados();
        
        if (id != null) {
            String cantidad = JOptionPane.showInputDialog(this, items, "Introduzca una cantidad", JOptionPane.OK_CANCEL_OPTION);
            if (cantidad != null) {
                Traslado traslado = new Traslado();
                traslado.setCantidad(Float.parseFloat(cantidad));
                Residuo residuo = fNegocios.consultarResiduo(id);
                traslado.setResiduo(residuo);

                if (residuo != null) {
                    listaResiduosSeleccionados.add(traslado);
                    listaResiduos.remove(residuo);
                }
                this.llenarTablaResiduos();
                this.llenarTablaResiduosSeleccionados();
            }

        }

        
        
    }

    private void eliminarResiduo() {
        ObjectId id = getResiduoSeleccionadoAgregados();
        
        if(id!=null){
            
            Traslado traslado = fNegocios.consultarTraslado(id);
           
            if(traslado!=null){
                listaResiduosSeleccionados.remove(traslado);
                listaResiduos.add(traslado.getResiduo());
            }
            this.llenarTablaResiduos();
            this.llenarTablaResiduosSeleccionados();
        }

    }

    private boolean validarCampos() {
        return false;
    }

    private void limpiarFormulario() {
    }
}
