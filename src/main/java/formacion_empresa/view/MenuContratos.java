/********************************/
/*  Formación Empresa           */
/*  Clase menú contratos        */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.view;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.nio.channels.ClosedByInterruptException;
import java.time.LocalDate;
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import formacion_empresa.controller.Conexion;
import formacion_empresa.controller.Consultas;
import formacion_empresa.controller.CRUDcontrato;
import formacion_empresa.model.Contrato;

/**
 * @author Markel Canales Ramos
 */
public class MenuContratos extends javax.swing.JPanel {

    DefaultTableModel modelo;
    int aceptar;
    
    // deshabilita los botones
    public void deshabilitarBtns() {
        btnConsultar.setEnabled(false);
        btnInsertar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnExportar.setEnabled(false);
    }
    
    // habilita los botones
    public void habilitarBtns() {
        btnConsultar.setEnabled(true);
        btnInsertar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnExportar.setEnabled(true);
    }

    /**
     * Creates new form MenuContratos
     */
    public MenuContratos() {
        initComponents();
        modelo = (DefaultTableModel) TableContratos.getModel();
        setVisible(false);

        // cuando se cierre el formulario de inserción/actualización se deben habilitar los botones para evitar que se queden desactivados
        jFrame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                habilitarBtns();
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jFrame = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        txtIDinquilino = new javax.swing.JTextField();
        txtCodigoVivienda = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableContratos = new javax.swing.JTable();
        btnConsultar = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        btnCambiarEstado = new javax.swing.JButton();

        jFrame.setTitle("Contrato");
        jFrame.setAlwaysOnTop(true);
        jFrame.setPreferredSize(new java.awt.Dimension(400, 400));
        jFrame.setSize(new java.awt.Dimension(400, 400));

        jLabel2.setText("ID inquilino:");

        jLabel3.setText("Código vivienda:");

        jLabel4.setText("Fecha inicio (YYYY-MM-DD):");

        jLabel5.setText("Fecha fin (YYYY-MM-DD):");

        jLabel6.setText("Precio:");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel8.setText("ID:");

        javax.swing.GroupLayout jFrameLayout = new javax.swing.GroupLayout(jFrame.getContentPane());
        jFrame.getContentPane().setLayout(jFrameLayout);
        jFrameLayout.setHorizontalGroup(
            jFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameLayout.createSequentialGroup()
                .addGroup(jFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrameLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addComponent(txtCodigoVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jFrameLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addGap(21, 21, 21)
                        .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jFrameLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jFrameLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jFrameLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(36, 36, 36)
                                .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jFrameLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addGap(56, 56, 56)
                        .addComponent(txtIDinquilino, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jFrameLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jFrameLayout.setVerticalGroup(
            jFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIDinquilino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigoVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(btnAceptar)
                .addContainerGap())
        );

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                MenuContratos.this.componentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("CONTRATOS ENCONTRADOS");

        btnAtras.setText("Volver");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        TableContratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID inquilino", "Codigo vivienda", "Fecha inicio", "Fecha fin", "Precio", "Estado"
            }
            
        ) {
            @SuppressWarnings("rawtypes")
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            @SuppressWarnings("rawtypes")
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableContratos);

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        btnCambiarEstado.setText("Cambiar estado");
        btnCambiarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnAtras)
                        .addGap(578, 578, 578)
                        .addComponent(btnExportar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnConsultar)
                        .addGap(111, 111, 111)
                        .addComponent(btnInsertar)
                        .addGap(119, 119, 119)
                        .addComponent(btnModificar)
                        .addGap(112, 112, 112)
                        .addComponent(btnEliminar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCambiarEstado)
                        .addGap(202, 202, 202)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtras)
                    .addComponent(btnExportar))
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultar)
                    .addComponent(btnInsertar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(42, 42, 42)
                .addComponent(btnCambiarEstado)
                .addContainerGap())
        );
    }

    // método que se ejecuta cada vez que se muestra este panel
    // se rellena la tabla utilizando la función consultarTodo() de la clase Consultas
    public void componentShown(java.awt.event.ComponentEvent evt) {
        try {
            Connection con = Conexion.getConexion(Conexion.getUrl(), Conexion.getUser(), Conexion.getPassword());
            ResultSet rs = Consultas.consultarTodo(con, "contrata");
            ResultSet rsEstado = Consultas.consultarCustom(con, "SELECT t.estado, c.id FROM tipo_estado t INNER JOIN contrata c ON t.id = c.estado ORDER BY c.id");

            if (rs == null || rsEstado == null) {
                throw new SQLException();
            }
            else {
                while (rs.next() && rsEstado.next()) {
                    modelo.addRow(new Object[]{rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rsEstado.getString(1)});
                }

                TableContratos.setModel(modelo);
            }

            con.close();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al obtener los datos de la tabla Contrata", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // oculta este panel y vuelve al menú principal
    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        modelo.setRowCount(0);
    }

    // ordena ejecutar la consulta y la muestra en la tabla
    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {
        deshabilitarBtns();
        
        try {
            Connection con = Conexion.getConexion(Conexion.getUrl(), Conexion.getUser(), Conexion.getPassword());
            String id = JOptionPane.showInputDialog(null, "Introduzca el ID del contrato:", "Consultar", JOptionPane.PLAIN_MESSAGE);

            if (id == null) {
                throw new ClosedByInterruptException();
            }

            Contrato c = CRUDcontrato.consultar(con, Integer.parseInt(id));

            if (c == null) {
                throw new SQLException();
            }
            else if (c.getId() == -2) {
                throw new NullPointerException();
            }
            else {
                modelo.setRowCount(0);
                modelo.addRow(new Object[]{c.getId(), c.getId_inquilino(), c.getCodigo_vivienda(), c.getFecha_inicio(), c.getFecha_fin(), c.getPrecio(), c.getEstado()});
            }

            con.close();
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor introducido debe ser un número entero", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al consultar la tabla Contrato", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "El ID indicado no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (ClosedByInterruptException e) {}

        habilitarBtns();
    }

    // muestra el formulario de inserción/actualización
    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {
        deshabilitarBtns();
        
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        txtId.setEnabled(false);

        aceptar = 1;
    }

    // muestra el formulario de inserción/actualización
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {
        deshabilitarBtns();
        
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        txtId.setEnabled(true);

        aceptar = 2;
    }

    // ejecuta el método de borrado de contrato
    // antes de borrar pregunta al usuario si está seguro que quiere realizar esa acción
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        deshabilitarBtns();
        
        try {
            Connection con = Conexion.getConexion(Conexion.getUrl(), Conexion.getUser(), Conexion.getPassword());
            String idStr = JOptionPane.showInputDialog(null, "Introduzca el ID del contrato:", "Eliminar", JOptionPane.PLAIN_MESSAGE);
            if (idStr == null) {
                throw new ClosedByInterruptException();
            }

            int id = Integer.parseInt(idStr);
            int err;

            if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere eliminar el registro con ID " + id + "?", "Confirmación", JOptionPane.YES_NO_OPTION) == 0) {
                err = CRUDcontrato.eliminar(con, id);
                if (err == -1) {
                    throw new SQLException();
                }
                else if (err == -2) {
                    throw new NullPointerException();
                }
            }

            con.close();
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor introducido debe ser un número entero", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al eliminar de la tabla Contrato. No se ha realizado ningún cambio", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "El ID indicado no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (ClosedByInterruptException e) {}
        
        habilitarBtns();
        txtId.setEnabled(true);
        modelo.setRowCount(0);
        componentShown(null);
    }

    // recibe los datos del formulario y ordena ejecutar la inserción/actualización
    // dependiendo del valor de la variable "aceptar" (1 = inserción, 2 = actualización)
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        if (aceptar == 1) {
            try {
                int id_inquilino = Integer.parseInt(txtIDinquilino.getText());
                String codigo_vivienda = txtCodigoVivienda.getText();
                String fecha_inicio = txtFechaInicio.getText();
                String fecha_fin = txtFechaFin.getText();
                double precio = Double.parseDouble(txtPrecio.getText());

                Connection con = Conexion.getConexion(Conexion.getUrl(), Conexion.getUser(), Conexion.getPassword());
                int id_ins = CRUDcontrato.insertar(con, new Contrato(0, id_inquilino, codigo_vivienda, fecha_inicio, fecha_fin, precio, "Pendiente"));

                if (id_ins == -1) {
                    throw new SQLException();
                }
                else if (id_ins == -3) {
                    throw new IndexOutOfBoundsException();
                }
                else if (id_ins == -4) {
                    throw new IllegalArgumentException();
                }

                JOptionPane.showMessageDialog(null, "Contrato insertado con ID: " + id_ins, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El ID introducido debe ser un número entero", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "El ID del inquilino o el código de la vivienda no existen", "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al insertar en la tabla Contrato", "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar actualizar en la tabla Contrata\nSugerencia: comprueba solapamiento de fechas y compatibilidad de mascotas", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else {
            try {
                int id = Integer.parseInt(txtId.getText());
                String id_inquilino = txtIDinquilino.getText();
                String codigo_vivienda = txtCodigoVivienda.getText();
                String fecha_inicio = txtFechaInicio.getText();
                String fecha_fin = txtFechaFin.getText();
                String precio = txtPrecio.getText();

                Connection con = Conexion.getConexion(Conexion.getUrl(), Conexion.getUser(), Conexion.getPassword());
                Contrato oldC = CRUDcontrato.consultar(con, id);
                Contrato newC = new Contrato(id, 0, codigo_vivienda, fecha_inicio, fecha_fin, 0, oldC.getEstado());

                // si el usuario deja campos en blanco no se actualizarán
                if (txtIDinquilino.getText().isBlank()) {
                    newC.setId_inquilino(oldC.getId_inquilino());
                }
                else {
                    newC.setId_inquilino(Integer.parseInt(id_inquilino));
                }
                if (codigo_vivienda.isBlank()) {
                    newC.setCodigo_vivienda(oldC.getCodigo_vivienda());
                }
                if (fecha_inicio.isBlank()) {
                    newC.setFecha_inicio(oldC.getFecha_inicio());
                }
                if (fecha_fin.isBlank()) {
                    newC.setFecha_fin(oldC.getFecha_fin());
                }
                if (txtPrecio.getText().isBlank()) {
                    newC.setPrecio(oldC.getPrecio());
                }
                else {
                    newC.setPrecio(Double.parseDouble(precio));
                }

                int err = CRUDcontrato.actualizar(con, newC);

                if (err == -1) throw new SQLException();
                else if (err == -2) throw new NullPointerException();
                else if (err == -3) throw new IndexOutOfBoundsException();
                else if (err == -4) throw new IllegalArgumentException();
                else JOptionPane.showMessageDialog(null, "Los datos han sido modificados correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                con.close();
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El ID introducido debe ser un número entero", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "El ID especificado no existe", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al insertar en la tabla Contrato", "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "El ID del propietario o el código de la vivienda no existen", "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar actualizar en la tabla Contrata\nSugerencia: comprueba solapamiento de fechas y compatibilidad de mascotas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        jFrame.setVisible(false);
        habilitarBtns();
        modelo.setRowCount(0);
        componentShown(null);
    }

    // ordena ejecutar la exportación de la tabla
    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Connection con = Conexion.getConexion(Conexion.getUrl(), Conexion.getUser(), Conexion.getPassword());
            int err = Consultas.exportar(con, "contrata");

            if (err == 0) {
                JOptionPane.showMessageDialog(null, "Tabla exportada a CSV correctamente");
            }
            else {
                throw new Exception();
            }

            con.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar exportar la tabla Contrata", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ordena cambiar el estado del contrato indicado utilizando CRUDcontrato.actualizar()
    // puede ser pendiente -> activo o activo -> vencido
    private void btnCambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Connection con = Conexion.getConexion(Conexion.getUrl(), Conexion.getUser(), Conexion.getPassword());
            String idStr = JOptionPane.showInputDialog(null, "Introduzca el ID del contrato", "Cambiar estado", JOptionPane.PLAIN_MESSAGE);
            if (idStr == null) {
                throw new ClosedByInterruptException();
            }

            int id = Integer.parseInt(idStr);
            LocalDate fechaActual = LocalDate.now();
            int err; 

            Contrato c = CRUDcontrato.consultar(con, id);
            if (c.getEstado().equals("Pendiente")) {
                err = CRUDcontrato.actualizar(con, new Contrato(c.getId(), c.getId_inquilino(), c.getCodigo_vivienda(), c.getFecha_inicio(), c.getFecha_fin(), c.getPrecio(), "Activo"));
            }
            else if (c.getEstado().equals("Activo")) {
                err = CRUDcontrato.actualizar(con, new Contrato(c.getId(), c.getId_inquilino(), c.getCodigo_vivienda(), c.getFecha_inicio(), fechaActual.toString(), c.getPrecio(), "Vencido"));
            }
            else {
                throw new IllegalArgumentException();
            }

            if (err == -1) throw new SQLException();
            JOptionPane.showMessageDialog(null, "Estado cambiado correctamente para el contrato con ID = " + id, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            con.close();
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor introducido debe ser un número entero", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar actualizar el estado en la tabla Contrata", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "El contrato ya está vencido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (ClosedByInterruptException e) {}

        modelo.setRowCount(0);
        componentShown(null);
    }


    // Variables declaration - do not modify
    private javax.swing.JTable TableContratos;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnCambiarEstado;
    private javax.swing.JFrame jFrame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCodigoVivienda;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtIDinquilino;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration
}
