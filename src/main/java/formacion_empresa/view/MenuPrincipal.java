/********************************/
/*  Formación Empresa           */
/*  Clase menú principal        */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.view;

/**
 * @author Markel Canales Ramos
 */
public class MenuPrincipal extends javax.swing.JPanel {
    
    // atributos que le dicen al menú principal que submenú está activo
    private boolean propietariosVisible = false;
    private boolean inquilinosVisible = false;
    private boolean viviendasVisible = false;
    private boolean contratosVisible = false;
    private boolean estadisticasVisible = false;

    // getters y setters para los atributos de arriba
    public boolean isPropietariosVisible() {
        return propietariosVisible;
    }

    public boolean isInquilinosVisible() {
        return inquilinosVisible;
    }

    public boolean isViviendasVisible() {
        return viviendasVisible;
    }

    public boolean isContratosVisible() {
        return contratosVisible;
    }

    public boolean isEstadisticasVisible() {
        return estadisticasVisible;
    }

    public void setPropietariosVisible(boolean propietariosVisible) {
        this.propietariosVisible = propietariosVisible;
    }

    public void setInquilinosVisible(boolean inquilinosVisible) {
        this.inquilinosVisible = inquilinosVisible;
    }

    public void setViviendasVisible(boolean viviendasVisible) {
        this.viviendasVisible = viviendasVisible;
    }

    public void setContratosVisible(boolean contratosVisible) {
        this.contratosVisible = contratosVisible;
    }

    public void setEstadisticasVisible(boolean estadisticasVisible) {
        this.estadisticasVisible = estadisticasVisible;
    }
    
    // crea el panel
    public MenuPrincipal() {
        initComponents();
    }
    
    // crea el panel que contiene el menú principal
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnPropietarios = new javax.swing.JButton();
        btnInquilinos = new javax.swing.JButton();
        btnViviendas = new javax.swing.JButton();
        btnContratos = new javax.swing.JButton();
        btnEstadisticas = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setText("MANTENIMIENTO ALQUILARIA");

        btnPropietarios.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        btnPropietarios.setText("Propietarios");
        btnPropietarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPropietariosActionPerformed(evt);
            }
        });

        btnInquilinos.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        btnInquilinos.setText("Inquilinos");
        btnInquilinos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInquilinosActionPerformed(evt);
            }
        });

        btnViviendas.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        btnViviendas.setText("Viviendas");
        btnViviendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViviendasActionPerformed(evt);
            }
        });

        btnContratos.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        btnContratos.setText("Contratos");
        btnContratos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContratosActionPerformed(evt);
            }
        });

        btnEstadisticas.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        btnEstadisticas.setText("Estadisticas");
        btnEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadisticasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(btnPropietarios, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(btnInquilinos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(btnViviendas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(btnContratos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(btnEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1)))
                .addContainerGap(230, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPropietarios, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInquilinos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViviendas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnContratos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addComponent(btnEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }

    // eventos para que cada botón del menú principal abra su correspondiente submenú
    // todos ocultan el menú principal
    private void btnPropietariosActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        propietariosVisible = true;
    }

    private void btnInquilinosActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        inquilinosVisible = true;
    }

    private void btnViviendasActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        viviendasVisible = true;
    }

    private void btnContratosActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        contratosVisible = true;
    }

    private void btnEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        estadisticasVisible = true;
    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnContratos;
    private javax.swing.JButton btnEstadisticas;
    private javax.swing.JButton btnInquilinos;
    private javax.swing.JButton btnPropietarios;
    private javax.swing.JButton btnViviendas;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration
}
