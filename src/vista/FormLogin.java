package vista;

import controlador.UsuarioController;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author caill
 */
public class FormLogin extends javax.swing.JFrame {

    public FormLogin() {
        initComponents();
        this.setTitle("SISTEMA DE REGISTRO SALA DE ENLACE");
        this.setSize(900, 550);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @Override
    public Image getIconImage() {

        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/computadora.png"));
        return retValue;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_usuario = new javax.swing.JTextField();
        jPasswordField_contrasena = new javax.swing.JPasswordField();
        jButton_acceder = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("INICIAR SESIÓN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("USUARIO:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("CONTRASEÑA:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jTextField_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_usuarioKeyPressed(evt);
            }
        });
        jPanel1.add(jTextField_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 240, 30));

        jPasswordField_contrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField_contrasenaKeyPressed(evt);
            }
        });
        jPanel1.add(jPasswordField_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 240, 30));

        jButton_acceder.setBackground(new java.awt.Color(0, 0, 0));
        jButton_acceder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_acceder.setForeground(new java.awt.Color(255, 255, 255));
        jButton_acceder.setText("ACCEDER");
        jButton_acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_accederActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 240, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 550));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("BIENVENIDO AL SISTEMA DE REGISTRO");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ubicacion.png"))); // NOI18N
        jLabel6.setText("Avenida Argentina 455, Valparaíso ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Escuela Alemanía");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ing_alemania-png.png"))); // NOI18N
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 150, 160));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registro3.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 140, 150));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 550, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_accederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_accederActionPerformed
        this.IniciarSesion();
    }//GEN-LAST:event_jButton_accederActionPerformed

    private void jTextField_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_usuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jPasswordField_contrasena.requestFocus();
        }
    }//GEN-LAST:event_jTextField_usuarioKeyPressed

    private void jPasswordField_contrasenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField_contrasenaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.IniciarSesion();
        }
    }//GEN-LAST:event_jPasswordField_contrasenaKeyPressed

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
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_acceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField_contrasena;
    private javax.swing.JTextField jTextField_usuario;
    // End of variables declaration//GEN-END:variables

    private void IniciarSesion() {
        String usuario = jTextField_usuario.getText().trim();
        char[] contrasenaChar = jPasswordField_contrasena.getPassword(); // Usar getPassword()
        String contrasena = new String(contrasenaChar); // Convertir a String si es necesario

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            // Mensaje específico para campos vacíos
            JOptionPane.showMessageDialog(null, "Debe ingresar usuario y contraseña", "Error", JOptionPane.ERROR_MESSAGE);
            if (usuario.isEmpty()) {
                jTextField_usuario.requestFocus();
            } else {
                jPasswordField_contrasena.requestFocus();
            }
            return;
        }

        UsuarioController controlUsuario = new UsuarioController();
        Usuario user = new Usuario();
        user.setUsuario(usuario);
        user.setContrasena(contrasena);

        if (controlUsuario.login(user)) {
            FormMenu menu = new FormMenu();
            menu.setVisible(true);
            this.dispose(); // Cierra la ventana actual
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            // Limpiar el campo de contraseña para seguridad
            jPasswordField_contrasena.setText("");
            jPasswordField_contrasena.requestFocus();
        }
    }

//    private void IniciarSesion() {
//        if (jTextField_usuario.getText().isEmpty() && jPasswordField_contrasena.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Ingrese su usuario y contraseña");
//        } else {
//            UsuarioController controlUsuario = new UsuarioController();
//            Usuario usuario = new Usuario();
//            usuario.setUsuario(jTextField_usuario.getText().trim());
//            usuario.setContrasena(jPasswordField_contrasena.getText().trim());
//            if (controlUsuario.login(usuario)) {
//                FormMenu menu = new FormMenu();
//                menu.setVisible(true);
//                this.dispose();
//            } else {
//                JOptionPane.showMessageDialog(null, "Usuario  o contraseña incorrecto");
//            }
//        }
//    }
}