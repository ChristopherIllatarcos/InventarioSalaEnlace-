
package vista;

/**
 *
 * @author caill
 */
public class DetalleAlumno extends javax.swing.JFrame {

   
    public DetalleAlumno() {
        initComponents();
        this.setSize(500, 440);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("DETALLE DE PRESTAMO Y DEVOLUCIÓN");
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel_accesorio_numero_detalle_alumno = new javax.swing.JLabel();
        jLabel_curso_detalle_alumno = new javax.swing.JLabel();
        jLabel_hora_entrega_detalle_alumno = new javax.swing.JLabel();
        jLabel_hora_devolucion_detalle_alumno = new javax.swing.JLabel();
        jLabel_estado_detalle_alumno = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel_nombre_detalle_alumno = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel_accesorio_detalle_alumno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 120, 25));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setText("Curso:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 130, 25));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setText("Hora entrega:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 120, 25));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setText("Hora devolución:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 120, 25));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setText("N° Accesorio:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 120, 25));

        jLabel_accesorio_numero_detalle_alumno.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_accesorio_numero_detalle_alumno.setForeground(new java.awt.Color(0, 153, 0));
        jLabel_accesorio_numero_detalle_alumno.setText("Numero");
        jPanel1.add(jLabel_accesorio_numero_detalle_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 200, 25));

        jLabel_curso_detalle_alumno.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_curso_detalle_alumno.setForeground(new java.awt.Color(0, 153, 0));
        jLabel_curso_detalle_alumno.setText("Curso");
        jPanel1.add(jLabel_curso_detalle_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 200, 25));

        jLabel_hora_entrega_detalle_alumno.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_hora_entrega_detalle_alumno.setForeground(new java.awt.Color(0, 153, 0));
        jLabel_hora_entrega_detalle_alumno.setText("00:00:00");
        jPanel1.add(jLabel_hora_entrega_detalle_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 200, 25));

        jLabel_hora_devolucion_detalle_alumno.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_hora_devolucion_detalle_alumno.setForeground(new java.awt.Color(0, 153, 0));
        jLabel_hora_devolucion_detalle_alumno.setText("00:00:00");
        jPanel1.add(jLabel_hora_devolucion_detalle_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 200, 25));

        jLabel_estado_detalle_alumno.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_estado_detalle_alumno.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_estado_detalle_alumno.setText("ESTADO");
        jPanel1.add(jLabel_estado_detalle_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 200, 25));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("DETALLE DE PRESTAMO Y DEVOLUCIÓN");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 350, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 360, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel9.setText("Estado:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 120, 25));

        jLabel_nombre_detalle_alumno.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_nombre_detalle_alumno.setForeground(new java.awt.Color(0, 153, 0));
        jLabel_nombre_detalle_alumno.setText("Nombre");
        jPanel1.add(jLabel_nombre_detalle_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 200, 25));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel10.setText("Accesorio:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 120, 25));

        jLabel_accesorio_detalle_alumno.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_accesorio_detalle_alumno.setForeground(new java.awt.Color(0, 153, 0));
        jLabel_accesorio_detalle_alumno.setText("Accesorio");
        jPanel1.add(jLabel_accesorio_detalle_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 200, 25));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(DetalleAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel jLabel_accesorio_detalle_alumno;
    public static javax.swing.JLabel jLabel_accesorio_numero_detalle_alumno;
    public static javax.swing.JLabel jLabel_curso_detalle_alumno;
    public static javax.swing.JLabel jLabel_estado_detalle_alumno;
    public static javax.swing.JLabel jLabel_hora_devolucion_detalle_alumno;
    public static javax.swing.JLabel jLabel_hora_entrega_detalle_alumno;
    public static javax.swing.JLabel jLabel_nombre_detalle_alumno;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
