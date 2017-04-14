/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Clases.Conexion;
import Persistencia.Autenticacion;
import Persistencia.DatabaseConnection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public final class Login extends javax.swing.JFrame {

  private String user;
  private String pass;
  private final Conexion conexion = new Conexion();

  public Login() {
    initComponents();
    this.setTitle("Ventana de Login");
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    LimpiarText();
  }

  public void iniciarSesion() {
    user = txtUsuario.getText();
    pass = txtContrasena.getText();
    if (user.isEmpty() || pass.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Por favor llena los campos");
    } else {
      try {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Autenticacion autenticacion = new Autenticacion();
        if (autenticacion.autenticar(user, pass, databaseConnection)) {
          Main ventanaPrincipal = new Main();
          ventanaPrincipal.setVisible(true);
          dispose();
        } else {
          JOptionPane.showMessageDialog(this, "No existe tu usuario y contraseña");
          LimpiarText();
        }

      } catch (ClassNotFoundException ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
      }
//      conexion.conectar();
//      /*pregunto si esta conectado*/
//      Statement st = conexion.getStatement();
//      try {
//        ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE name_usuario='" + user + "' AND password='" + pass + "'");
//        rs.last();
//        int encontrado = rs.getRow();
//        /* verificamos que exista una coincidencia*/
//        String nivel = rs.getString("nivel");
//        if (encontrado == 1) {
//          if (nivel.equals("1")) {
//            Main ventanaPrincipal = new Main();
//            ventanaPrincipal.setVisible(true);
//            dispose();
//          } else {
//            JOptionPane.showMessageDialog(null, "Actualmente tu modulo no esta disponible");
//            LimpiarText();
//          }
//
//        } else {
//          // Men saje que no se encontro algun usuario
//          LimpiarText();
//        }
//        rs.close();
//        st.close();
//      } catch (SQLException e) {
//      }
//      conexion.conectar();
//      /*pregunto si esta conectado*/
//      Statement st = conexion.getStatement();
//      try {
//        ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE name_usuario='" + user + "' AND password='" + pass + "'");
//        rs.last();
//        int encontrado = rs.getRow();
//        /* verificamos que exista una coincidencia*/
//        String nivel = rs.getString("nivel");
//        if (encontrado == 1) {
//          if (nivel.equals("1")) {
//            Main ventanaPrincipal = new Main();
//            ventanaPrincipal.setVisible(true);
//            dispose();
//          } else {
//            JOptionPane.showMessageDialog(null, "Actualmente tu modulo no esta disponible");
//            LimpiarText();
//          }
//
//        } else {
//          // Men saje que no se encontro algun usuario
//          LimpiarText();
//        }
//        rs.close();
//        st.close();
//      } catch (SQLException e) {
//      }
    }
  }

  public void LimpiarText() {
    this.txtUsuario.setText("");
    this.txtUsuario.setFocusable(true);
    this.txtContrasena.setText("");
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        btnIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 60, 108));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(160, 100));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recuros/default_large.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setBackground(new java.awt.Color(0, 60, 108));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUsuario.setMargin(new java.awt.Insets(0, 5, 0, 2));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre de usuario:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");

        txtContrasena.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtContrasena.setMargin(new java.awt.Insets(0, 5, 0, 2));

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(txtUsuario)
                    .addComponent(txtContrasena)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIniciar)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
      iniciarSesion();
    }//GEN-LAST:event_btnIniciarActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Login().setVisible(true);
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
