/********************************/
/*  Formación Empresa           */
/*  Clase principal             */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import formacion_empresa.view.*;

/**
 *
 * @author Markel Canales Ramos
 */
public class Main extends javax.swing.JFrame {

    // constructor formulario
    public Main() {
        initComponents();
    }

    // crea la ventana donde aparece el menú principal al ejecutar
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alquilaria");
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        // define el estilo del formulario
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // aqui se ejecuta el programa
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                // se crea una instancia de cada menú
                Main ventana = new Main();
                MenuPrincipal menuP = new MenuPrincipal();
                MenuPropietarios menu1 = new MenuPropietarios();
                MenuInquilinos menu2 = new MenuInquilinos();
                MenuViviendas menu3 = new MenuViviendas();
                MenuContratos menu4 = new MenuContratos();
                Estadisticas est = new Estadisticas();
                
                // recibe eventos cada vez que se oculta o se muestra el menú principal
                menuP.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentShown(ComponentEvent e) {
                        ventana.setContentPane(menuP);
                    }

                    @Override
                    public void componentHidden(ComponentEvent e) {
                        if (menuP.isPropietariosVisible()) {
                            menu1.setVisible(true);
                            ventana.setContentPane(menu1);
                        }
                        else if (menuP.isInquilinosVisible()) {
                            menu2.setVisible(true);
                            ventana.setContentPane(menu2);
                        }
                        else if (menuP.isViviendasVisible()) {
                            menu3.setVisible(true);
                            ventana.setContentPane(menu3);
                        }
                        else if (menuP.isContratosVisible()) {
                            menu4.setVisible(true);
                            ventana.setContentPane(menu4);
                        }
                        else if (menuP.isEstadisticasVisible()) {
                            est.setVisible(true);
                            ventana.setContentPane(est);
                        }
                    }
                    
                });
                
                // cada vez que se cierra uno de los siguientes menús con el botón "Atras"
                // se ejecuta la función componentHidden() correspondiente
                // se hace visible el menú principal y se indica a este que el resto de submenús están cerrados
                menu1.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentHidden(ComponentEvent e) {
                        menuP.setVisible(true);
                        menuP.setPropietariosVisible(false);
                    }
                });
                
                menu2.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentHidden(ComponentEvent e) {
                        menuP.setVisible(true);
                        menuP.setInquilinosVisible(false);
                    }
                });
                
                menu3.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentHidden(ComponentEvent e) {
                        menuP.setVisible(true);
                        menuP.setViviendasVisible(false);
                    }
                });
                
                menu4.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentHidden(ComponentEvent e) {
                        menuP.setVisible(true);
                        menuP.setContratosVisible(false);
                    }
                });
                
                est.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentHidden(ComponentEvent e) {
                        menuP.setVisible(true);
                        menuP.setEstadisticasVisible(false);
                    }
                });
                
                // hacemos visible el formulario
                ventana.setContentPane(menuP);
                ventana.setVisible(true);
                
            }
        });
    }
}
