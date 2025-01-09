package vista;

import com.itextpdf.text.DocumentException;
import conexion.Conexion;
import controlador.AlumnoController;
import controlador.FuncionarioController;
import controlador.ReporteAlumno;
import controlador.ReportesController;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;

/**
 *
 * @author caill
 */
public class FormMenu extends javax.swing.JFrame {

    private int idFuncionario = 0;
    private int idAlumno = 0;

    public FormMenu() {
        initComponents();
        this.setSize(1100, 580);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Sitema de Registro Sala de Computación");

        this.getRootPane().setDefaultButton(jButton_registrar);
        this.CargarTablaFuncionarios();

        jLabel_info_alumno.setVisible(false);

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
        jLabel_logo = new javax.swing.JLabel();
        jButton_cerrar_sesion = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel_footer = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel_registrar_funcionario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_nombre = new javax.swing.JTextField();
        jComboBox_cargo_funcionario = new javax.swing.JComboBox<>();
        jTextField_especialidad = new javax.swing.JTextField();
        jComboBox_curso = new javax.swing.JComboBox<>();
        jButton_registrar = new javax.swing.JButton();
        jPanel_salida_funcionario = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel_info_alumno = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField_nombre_retiro_alumno = new javax.swing.JTextField();
        jButton_buscar_nombre_funcionario = new javax.swing.JButton();
        jButton_retirar = new javax.swing.JButton();
        jLabel_nro_accesorio = new javax.swing.JLabel();
        jLabel_especialidad = new javax.swing.JLabel();
        jLabel_hora_entrega = new javax.swing.JLabel();
        jLabel_hora_devolucion = new javax.swing.JLabel();
        jLabel_info = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextField_nombre_retiro = new javax.swing.JTextField();
        jButton_buscar_nombre_alumno = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton_retirar_alumno = new javax.swing.JButton();
        jLabel_cargo = new javax.swing.JLabel();
        jLabel_curso = new javax.swing.JLabel();
        jLabel_accesorio_alumno = new javax.swing.JLabel();
        jLabel_hora_entrada = new javax.swing.JLabel();
        jLabel_hora_salida = new javax.swing.JLabel();
        jPanel_administrar_ingreso = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField_busqueda_criterio = new javax.swing.JTextField();
        jDateChooser_fecha_busqueda = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_funcionarios = new javax.swing.JTable();
        jButton_buscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel_reporte_funcionario = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jComboBox_cargo_funcionario1 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField_nombre_alumno = new javax.swing.JTextField();
        jComboBox_curso_alumno = new javax.swing.JComboBox<>();
        jComboBox_accesorio = new javax.swing.JComboBox<>();
        jComboBox_nro_accesorio = new javax.swing.JComboBox<>();
        jButton_registrar1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jTextField_busqueda_criterio_alumno = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_alumno = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel_reporte_alumno = new javax.swing.JLabel();
        jLabel_elimonar_alumno = new javax.swing.JLabel();
        jButton_buscar_alumno = new javax.swing.JButton();
        jDateChooser_fecha_busqueda_alumno = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("SISTEMA DE INGRESO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registro.png"))); // NOI18N
        jPanel1.add(jLabel_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 130, 110));

        jButton_cerrar_sesion.setBackground(new java.awt.Color(0, 0, 0));
        jButton_cerrar_sesion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_cerrar_sesion.setForeground(new java.awt.Color(255, 255, 255));
        jButton_cerrar_sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        jButton_cerrar_sesion.setText("CERRAR SESIÓN");
        jButton_cerrar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cerrar_sesionActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_cerrar_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 210, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 550));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_footer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_footer.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_footer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_footer.setText("©Desarrollado por NexusPro");
        jPanel2.add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, 600, 20));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(790, 500));

        jPanel_registrar_funcionario.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_registrar_funcionario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registro de Ingreso de Funcionarios ");
        jPanel_registrar_funcionario.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nombre:");
        jPanel_registrar_funcionario.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Cargo:");
        jPanel_registrar_funcionario.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Especialidad:");
        jPanel_registrar_funcionario.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Curso:");
        jPanel_registrar_funcionario.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, 30));

        jTextField_nombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_nombreKeyPressed(evt);
            }
        });
        jPanel_registrar_funcionario.add(jTextField_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 230, 30));

        jComboBox_cargo_funcionario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox_cargo_funcionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cargo:", "Docente", "Paradocente", "administrador", "Técnico de Soporte", "Auxiliar de limpieza", "Coordinador Académico" }));
        jComboBox_cargo_funcionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox_cargo_funcionarioKeyPressed(evt);
            }
        });
        jPanel_registrar_funcionario.add(jComboBox_cargo_funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 230, 30));

        jTextField_especialidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_especialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_especialidadKeyPressed(evt);
            }
        });
        jPanel_registrar_funcionario.add(jTextField_especialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 230, 30));

        jComboBox_curso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox_curso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione curso:", "Sin curso", "Pre-Kinder", "Kinder", "1°a", "1°b", "2°a", "2°b", "3°a", "3°b", "4°a", "4°b", "5°a", "5°b", "6°a", "6°b", "7°a", "7°b", "8°a", "8°b" }));
        jComboBox_curso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox_cursoKeyPressed(evt);
            }
        });
        jPanel_registrar_funcionario.add(jComboBox_curso, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 230, 30));

        jButton_registrar.setBackground(new java.awt.Color(0, 0, 0));
        jButton_registrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_registrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registrarse.png"))); // NOI18N
        jButton_registrar.setText("REGISTRAR");
        jButton_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarActionPerformed(evt);
            }
        });
        jPanel_registrar_funcionario.add(jButton_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 230, 40));

        jTabbedPane1.addTab("Registrar Funcionario", jPanel_registrar_funcionario);

        jPanel_salida_funcionario.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_salida_funcionario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Devolución de Accesorio por Alumno y Salida de Funcionario");
        jPanel_salida_funcionario.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 530, 30));

        jLabel_info_alumno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_info_alumno.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_info_alumno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_info_alumno.setText("Accesorio Entregado");
        jPanel_salida_funcionario.add(jLabel_info_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 250, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel11.setText("Nombre:");
        jPanel_salida_funcionario.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 100, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel13.setText("Hora devolución:");
        jPanel_salida_funcionario.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 120, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel14.setText("Hora salida:");
        jPanel_salida_funcionario.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 100, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel15.setText("Especialidad:");
        jPanel_salida_funcionario.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 100, 30));

        jTextField_nombre_retiro_alumno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel_salida_funcionario.add(jTextField_nombre_retiro_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 210, 30));

        jButton_buscar_nombre_funcionario.setBackground(new java.awt.Color(0, 0, 0));
        jButton_buscar_nombre_funcionario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_buscar_nombre_funcionario.setForeground(new java.awt.Color(255, 255, 255));
        jButton_buscar_nombre_funcionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        jButton_buscar_nombre_funcionario.setText("BUSCAR");
        jButton_buscar_nombre_funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscar_nombre_funcionarioActionPerformed(evt);
            }
        });
        jPanel_salida_funcionario.add(jButton_buscar_nombre_funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 130, 30));

        jButton_retirar.setBackground(new java.awt.Color(0, 0, 0));
        jButton_retirar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_retirar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_retirar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        jButton_retirar.setText("RETIRAR");
        jButton_retirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_retirarActionPerformed(evt);
            }
        });
        jPanel_salida_funcionario.add(jButton_retirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 250, 40));

        jLabel_nro_accesorio.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_nro_accesorio.setForeground(new java.awt.Color(0, 153, 51));
        jLabel_nro_accesorio.setText("NUMERO");
        jPanel_salida_funcionario.add(jLabel_nro_accesorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 200, 30));

        jLabel_especialidad.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_especialidad.setForeground(new java.awt.Color(0, 153, 51));
        jLabel_especialidad.setText("ESPECIALIDAD");
        jPanel_salida_funcionario.add(jLabel_especialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 200, 30));

        jLabel_hora_entrega.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_hora_entrega.setForeground(new java.awt.Color(0, 153, 51));
        jLabel_hora_entrega.setText("00:00:00");
        jPanel_salida_funcionario.add(jLabel_hora_entrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 200, 30));

        jLabel_hora_devolucion.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_hora_devolucion.setForeground(new java.awt.Color(0, 153, 51));
        jLabel_hora_devolucion.setText("00:00:00");
        jPanel_salida_funcionario.add(jLabel_hora_devolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 200, 30));

        jLabel_info.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_info.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_info.setText("Funcionario Retirado");
        jPanel_salida_funcionario.add(jLabel_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 250, 30));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel25.setText("Nombre:");
        jPanel_salida_funcionario.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 100, 30));

        jTextField_nombre_retiro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel_salida_funcionario.add(jTextField_nombre_retiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, 30));

        jButton_buscar_nombre_alumno.setBackground(new java.awt.Color(0, 0, 0));
        jButton_buscar_nombre_alumno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_buscar_nombre_alumno.setForeground(new java.awt.Color(255, 255, 255));
        jButton_buscar_nombre_alumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        jButton_buscar_nombre_alumno.setText("BUSCAR");
        jButton_buscar_nombre_alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscar_nombre_alumnoActionPerformed(evt);
            }
        });
        jPanel_salida_funcionario.add(jButton_buscar_nombre_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 125, 30));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel26.setText("Cargo:");
        jPanel_salida_funcionario.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 100, 30));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel27.setText("Número:");
        jPanel_salida_funcionario.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 100, 30));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel28.setText("Hora entrada:");
        jPanel_salida_funcionario.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 100, 30));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel29.setText("Hora entrega:");
        jPanel_salida_funcionario.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 100, 30));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel30.setText("Curso:");
        jPanel_salida_funcionario.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 100, 30));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel31.setText("Accesorio:");
        jPanel_salida_funcionario.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 100, 30));

        jButton_retirar_alumno.setBackground(new java.awt.Color(0, 0, 0));
        jButton_retirar_alumno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_retirar_alumno.setForeground(new java.awt.Color(255, 255, 255));
        jButton_retirar_alumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        jButton_retirar_alumno.setText("RETIRAR");
        jButton_retirar_alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_retirar_alumnoActionPerformed(evt);
            }
        });
        jPanel_salida_funcionario.add(jButton_retirar_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 250, 40));

        jLabel_cargo.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_cargo.setForeground(new java.awt.Color(0, 153, 51));
        jLabel_cargo.setText("CARGO");
        jPanel_salida_funcionario.add(jLabel_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 200, 30));

        jLabel_curso.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_curso.setForeground(new java.awt.Color(0, 153, 51));
        jLabel_curso.setText("CURSO");
        jPanel_salida_funcionario.add(jLabel_curso, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 200, 30));

        jLabel_accesorio_alumno.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_accesorio_alumno.setForeground(new java.awt.Color(0, 153, 51));
        jLabel_accesorio_alumno.setText("ACCESORIO");
        jPanel_salida_funcionario.add(jLabel_accesorio_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 200, 30));

        jLabel_hora_entrada.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_hora_entrada.setForeground(new java.awt.Color(0, 153, 51));
        jLabel_hora_entrada.setText("00:00:00");
        jPanel_salida_funcionario.add(jLabel_hora_entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 200, 30));

        jLabel_hora_salida.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_hora_salida.setForeground(new java.awt.Color(0, 153, 51));
        jLabel_hora_salida.setText("00:00:00");
        jPanel_salida_funcionario.add(jLabel_hora_salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 200, 30));

        jTabbedPane1.addTab("Devolución y Retiro", jPanel_salida_funcionario);

        jPanel_administrar_ingreso.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_administrar_ingreso.setPreferredSize(new java.awt.Dimension(790, 400));
        jPanel_administrar_ingreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Administrar Ingreso de Funcionarios");
        jPanel_administrar_ingreso.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 580, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel8.setText("Nombre/Especialidad:");
        jPanel_administrar_ingreso.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel9.setText("Fecha:");
        jPanel_administrar_ingreso.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, 30));

        jTextField_busqueda_criterio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel_administrar_ingreso.add(jTextField_busqueda_criterio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 200, 30));

        jDateChooser_fecha_busqueda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel_administrar_ingreso.add(jDateChooser_fecha_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 150, 30));

        jTable_funcionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_funcionarios);

        jPanel_administrar_ingreso.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 85, 660, 230));

        jButton_buscar.setBackground(new java.awt.Color(0, 0, 0));
        jButton_buscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_buscar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        jButton_buscar.setText("BUSCAR");
        jButton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarActionPerformed(evt);
            }
        });
        jPanel_administrar_ingreso.add(jButton_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 130, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_reporte_funcionario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_reporte_funcionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        jLabel_reporte_funcionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_reporte_funcionarioMouseClicked(evt);
            }
        });
        jPanel3.add(jLabel_reporte_funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 30, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 30, 30));

        jPanel_administrar_ingreso.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 30, 170));

        jComboBox_cargo_funcionario1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox_cargo_funcionario1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cargo:", "Docente", "Paradocente", "administrador", "Técnico de Soporte", "Auxiliar de limpieza", "Coordinador Académico" }));
        jComboBox_cargo_funcionario1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox_cargo_funcionario1KeyPressed(evt);
            }
        });
        jPanel_administrar_ingreso.add(jComboBox_cargo_funcionario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 230, 30));

        jTabbedPane1.addTab("Administrar Ingreso", jPanel_administrar_ingreso);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Registro de Prestamo de Accesorios");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Nombre:");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Curso:");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Accesorio:");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, -1, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Nro :");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 50, 30));

        jTextField_nombre_alumno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_nombre_alumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_nombre_alumnoKeyPressed(evt);
            }
        });
        jPanel4.add(jTextField_nombre_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 230, 30));

        jComboBox_curso_alumno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox_curso_alumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione curso:", "Sin curso", "Pre-Kinder", "Kinder", "1°a", "1°b", "2°a", "2°b", "3°a", "3°b", "4°a", "4°b", "5°a", "5°b", "6°a", "6°b", "7°a", "7°b", "8°a", "8°b" }));
        jComboBox_curso_alumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox_curso_alumnoKeyPressed(evt);
            }
        });
        jPanel4.add(jComboBox_curso_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 230, 30));

        jComboBox_accesorio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox_accesorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione accesorio:", "audífono", "teclado", "mauses" }));
        jPanel4.add(jComboBox_accesorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 230, 30));

        jComboBox_nro_accesorio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox_nro_accesorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione número:", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        jPanel4.add(jComboBox_nro_accesorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 230, 30));

        jButton_registrar1.setBackground(new java.awt.Color(0, 0, 0));
        jButton_registrar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_registrar1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_registrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registrarse.png"))); // NOI18N
        jButton_registrar1.setText("REGISTRAR");
        jButton_registrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrar1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton_registrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 230, 40));

        jTabbedPane1.addTab("Accesorio", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Gestión de Préstamos de Accesorios");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 580, 30));

        jTextField_busqueda_criterio_alumno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel5.add(jTextField_busqueda_criterio_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 200, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel23.setText("Nombre:");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 80, 30));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel24.setText("Fecha:");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, -1, 30));

        jTable_alumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable_alumno);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 660, 230));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_reporte_alumno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_reporte_alumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        jLabel_reporte_alumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_reporte_alumnoMouseClicked(evt);
            }
        });
        jPanel6.add(jLabel_reporte_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 20, -1));

        jLabel_elimonar_alumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        jLabel_elimonar_alumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_elimonar_alumnoMouseClicked(evt);
            }
        });
        jPanel6.add(jLabel_elimonar_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 20, 30));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 30, 170));

        jButton_buscar_alumno.setBackground(new java.awt.Color(0, 0, 0));
        jButton_buscar_alumno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_buscar_alumno.setForeground(new java.awt.Color(255, 255, 255));
        jButton_buscar_alumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        jButton_buscar_alumno.setText("BUSCAR");
        jButton_buscar_alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscar_alumnoActionPerformed(evt);
            }
        });
        jPanel5.add(jButton_buscar_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 130, 40));

        jDateChooser_fecha_busqueda_alumno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel5.add(jDateChooser_fecha_busqueda_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 150, 30));

        jTabbedPane1.addTab("Administrar Accesorios", jPanel5);

        jPanel2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 760, 420));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 840, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarActionPerformed

        String nombre = jTextField_nombre.getText().trim();
        String especialidad = jTextField_especialidad.getText().trim();

        if (nombre.isEmpty() || especialidad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese datos");
        } else {
            //validar cargo y curso
            String cargo = jComboBox_cargo_funcionario.getSelectedItem().toString();
            String curso = jComboBox_curso.getSelectedItem().toString();

            if (cargo.equalsIgnoreCase("Seleccione Cargo:") && curso.equalsIgnoreCase("Seleccione Curso:")) {
                JOptionPane.showMessageDialog(null, "Seleccione cargo y curso");

            } else {

                FuncionarioController controlFuncionario = new FuncionarioController();
                Funcionario funcionario = new Funcionario();

                funcionario.setNombre(nombre);
                funcionario.setEspecialidad(especialidad);
                funcionario.setCargo(cargo);
                funcionario.setCurso(curso);

                //fecha hora y entrada
                DateFormat dateFormatFecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Calendar calendar = Calendar.getInstance();
                Date date = calendar.getTime();
                String fecha = dateFormatFecha.format(date);

                funcionario.setHora_entrada(fecha);
                funcionario.setHora_salida(null);
                funcionario.setEstado("Ingreso");

                if (controlFuncionario.Guardar(funcionario)) {
                    JOptionPane.showMessageDialog(null, "Ingreso de Funcionario Registrado.");
                    //cargar la tabla
                    this.CargarTablaFuncionarios();

                    //limpar
                    jTextField_nombre.setText("");
                    jTextField_especialidad.setText("");
                    jComboBox_cargo_funcionario.setSelectedItem("Seleccione Cargo:");
                    jComboBox_curso.setSelectedItem("Seleccione Curso:");

                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar.");
                }
            }

        }

    }//GEN-LAST:event_jButton_registrarActionPerformed

    private void jTextField_nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_nombreKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jComboBox_cargo_funcionario.requestFocus();
        }
    }//GEN-LAST:event_jTextField_nombreKeyPressed

    private void jComboBox_cargo_funcionarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox_cargo_funcionarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField_especialidad.requestFocus();
        }
    }//GEN-LAST:event_jComboBox_cargo_funcionarioKeyPressed

    private void jTextField_especialidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_especialidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jComboBox_curso.requestFocus();
        }
    }//GEN-LAST:event_jTextField_especialidadKeyPressed

    private void jComboBox_cursoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox_cursoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton_registrar.requestFocus();
        }
    }//GEN-LAST:event_jComboBox_cursoKeyPressed

    private void jButton_buscar_nombre_funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscar_nombre_funcionarioActionPerformed

        String nombreBuscar = jTextField_nombre_retiro.getText().trim();

        if (nombreBuscar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre");
            return;
        }

        Connection cn = Conexion.conectar();
        String sql = "SELECT * FROM tb_funcionario WHERE nombre = ?";
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombreBuscar); // Evita inyección SQL
            rs = ps.executeQuery();

            if (rs.next()) {
                idFuncionario = rs.getInt("id_funcionario");
                jLabel_especialidad.setText(rs.getString("especialidad"));
                jLabel_cargo.setText(rs.getString("cargo"));
                jLabel_hora_entrada.setText(rs.getString("hora_entrada"));

                String salida = rs.getString("hora_salida");
                String estado = rs.getString("estado");

                if (salida != null) {
                    jLabel_hora_salida.setText(salida);
                } else {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Calendar calendar = Calendar.getInstance();
                    Date currentDate = calendar.getTime();
                    String fechaActual = dateFormat.format(currentDate);
                    jLabel_hora_salida.setText(fechaActual);
                }

                if (estado != null && estado.equalsIgnoreCase("Egresado")) {
                    jButton_retirar.setEnabled(false);
                    jLabel_info.setVisible(true);
                } else {
                    jButton_retirar.setEnabled(true);
                    jLabel_info.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nombre no encontrado");

            }

        } catch (SQLException e) {
            System.out.println("Error al buscar datos del funcionario: " + e.getMessage());
        }

    }//GEN-LAST:event_jButton_buscar_nombre_funcionarioActionPerformed

    private void jButton_retirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_retirarActionPerformed
        // Validar que se haya buscado un funcionario antes de intentar retirarlo
        if (jLabel_especialidad.getText() == null || jLabel_especialidad.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Busque un nombre para retirar");
            return;
        }

        try {
            // Formatear fecha y hora actuales
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            String fecha = dateFormat.format(calendar.getTime());

            // Crear objeto funcionario con datos actualizados
            Funcionario funcionario = new Funcionario();
            funcionario.setHora_salida(fecha); // Hora de salida
            funcionario.setEstado("Egresado");

            // Actualizar en la base de datos
            FuncionarioController funcionarioController = new FuncionarioController();
            if (funcionarioController.actualizar(funcionario, idFuncionario)) {
                JOptionPane.showMessageDialog(null, "Funcionario retirado de la sala de clases");

                // Recargar la tabla con los datos actualizados
                this.CargarTablaFuncionarios();

                // Limpiar los campos de la interfaz
                jTextField_nombre_retiro.setText("");
                jLabel_especialidad.setText("");
                jLabel_hora_entrada.setText("00:00:00");
                jLabel_hora_salida.setText("00:00:00");

                //metodo para crear el ticket en pdf
                ReportesController ticket = new ReportesController();
                ticket.TicketRetiro(idFuncionario);

            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos del funcionario");
            }
        } catch (HeadlessException e) {
            // Manejar cualquier excepción inesperada
            System.out.println("Error en el proceso de retiro: " + e.getMessage());
        }

//        if(jLabel_especialidad.getText().isEmpty()){
//            JOptionPane.showMessageDialog(null, "Busque un nombre para retirar");
//        }else{
//            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//            Calendar calendar = Calendar.getInstance();
//            Date date = calendar.getTime();
//            String fecha = dateFormat.format(date);
//            //Actualizamos datos del funcionario
//            Funcionario funcionario = new Funcionario();
//            FuncionarioController funcionarioController = new FuncionarioController();
//            
//            funcionario.setHora_salida(fecha); //hora salida
//            funcionario.setEstado("EGRESADO");
//            
//            if(funcionarioController.actualizar(funcionario, idFuncionario)){
//                JOptionPane.showMessageDialog(null, "Funcionario retirado de la sala de clases");
//                this.CargarTablaFuncionarios();
//                
//                jTextField_nombre_retiro.setText("");
//                jTextField_especialidad.setText("");
//                jLabel_hora_entrada.setText("00:00:00");
//                jLabel_hora_salida.setText("00:00:00");
//                
//            }else{
//                System.out.println("Error al actualizar datos");
//            }
//            
//            
//        }

    }//GEN-LAST:event_jButton_retirarActionPerformed

    private void jButton_cerrar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cerrar_sesionActionPerformed
        // Crear un cuadro de diálogo para mostrar el mensaje "Cargando"
        JDialog dialogoCargando = new JDialog(this, "Cargando", true);
        JLabel etiquetaMensaje = new JLabel("Cerrando sesión, por favor espere...", SwingConstants.CENTER);
        etiquetaMensaje.setFont(new Font("Tahoma", Font.PLAIN, 14));
        dialogoCargando.add(etiquetaMensaje);
        dialogoCargando.setSize(300, 100);
        dialogoCargando.setLocationRelativeTo(this);

        // Crear un temporizador para cerrar el cuadro de diálogo después de 3 segundos
        Timer timer = new Timer(3000, e -> {
            dialogoCargando.dispose(); // Cerrar el cuadro de diálogo

            // Cerrar la ventana actual
            this.dispose();

            // Abrir el formulario de inicio de sesión
            FormLogin formularioUsuario = new FormLogin();
            formularioUsuario.setVisible(true);
        });

        // Iniciar el temporizador
        timer.setRepeats(false); // Solo se ejecuta una vez
        timer.start();

        // Mostrar el cuadro de diálogo
        dialogoCargando.setVisible(true);
    }//GEN-LAST:event_jButton_cerrar_sesionActionPerformed

    private void jComboBox_cargo_funcionario1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox_cargo_funcionario1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_cargo_funcionario1KeyPressed

    private void jLabel_reporte_funcionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_reporte_funcionarioMouseClicked
        // Instancia de ReporteController
        ReportesController reporteController = new ReportesController();

        // Llamada al método para generar el reporte
        try {
            reporteController.generarReporteTabla();  // Llamada al método de instancia
            JOptionPane.showMessageDialog(null, "Reporte generado exitosamente.");
        } catch (DocumentException | HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el reporte: " + e.getMessage());
        }
    }//GEN-LAST:event_jLabel_reporte_funcionarioMouseClicked

    private void jButton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarActionPerformed
        String nombreEspecialidadBusqueda = jTextField_busqueda_criterio.getText().trim();
        Date fechaBusqueda = jDateChooser_fecha_busqueda.getDate();
        String fechaComoCadena = "";

        if (fechaBusqueda != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Formato para SQL
            fechaComoCadena = sdf.format(fechaBusqueda);
        }

        if (nombreEspecialidadBusqueda.isEmpty() && fechaComoCadena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese nombre o especialidad para búsqueda");
            this.CargarTablaFuncionarios();
        } else {
            FuncionarioController funcionarioController = new FuncionarioController();
            ArrayList<Funcionario> listaFuncionario = funcionarioController.BuscarFuncionarioNombreFecha(nombreEspecialidadBusqueda, fechaComoCadena);

            DefaultTableModel model = new DefaultTableModel();
            this.jTable_funcionarios = new JTable(model);
            this.jScrollPane1.setViewportView(this.jTable_funcionarios);

            // Definir las columnas de la tabla
            model.addColumn("N°");
            model.addColumn("Nombre");
            model.addColumn("Cargo");
            model.addColumn("Especialidad");
            model.addColumn("Curso");
            model.addColumn("Hora de Entrada");
            model.addColumn("Hora de Salida");
            model.addColumn("Estado");

            // Llenar las filas de la tabla
            for (Funcionario funcionario : listaFuncionario) {
                model.addRow(new Object[]{
                    funcionario.getIdFuncionario(),
                    funcionario.getNombre(),
                    funcionario.getCargo(),
                    funcionario.getEspecialidad(),
                    funcionario.getCurso(),
                    funcionario.getHora_entrada(),
                    funcionario.getHora_salida(),
                    funcionario.getEstado()
                });

                //evento
                jTable_funcionarios.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int fila_point = jTable_funcionarios.rowAtPoint(e.getPoint());
                        int columna_point = 0;

                        if (fila_point > 1) {
                            idFuncionario = (int) model.getValueAt(fila_point, columna_point);
                            EnviarDatosFuncionariosSeleccionados(idFuncionario);//metodo
                        }
                    }

                });
            }
            //limpiar campos
            jTextField_busqueda_criterio.setText("");

        }
    }//GEN-LAST:event_jButton_buscarActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        FuncionarioController controlFuncionario = new FuncionarioController();

        if (idFuncionario == 0) {
            JOptionPane.showMessageDialog(null, "Error al eliminar, debe seleccionar un funcionario");
        } else {
            // Mostrar advertencia de confirmación
            int confirmacion = JOptionPane.showConfirmDialog(
                    null,
                    "¿Está seguro de que desea eliminar el funcionario?",
                    "Confirmación de Eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                System.out.println("Intentando eliminar funcionario con ID: " + idFuncionario);

                // Intentar eliminar el funcionario
                if (controlFuncionario.eliminar(idFuncionario)) {
                    JOptionPane.showMessageDialog(null, "Funcionario eliminado de la base de datos");
                    System.out.println("Eliminación exitosa. Recargando tabla...");

                    // Recargar la tabla después de la eliminación
                    this.CargarTablaFuncionarios();
                    this.limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el funcionario");
                    System.out.println("Error: el método eliminar devolvió false.");
                }
            }
        }

    }//GEN-LAST:event_jLabel16MouseClicked

    private void jTextField_nombre_alumnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_nombre_alumnoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nombre_alumnoKeyPressed

    private void jComboBox_curso_alumnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox_curso_alumnoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_curso_alumnoKeyPressed

    private void jButton_registrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrar1ActionPerformed
        String nombre = jTextField_nombre_alumno.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese datos");
        } else {
            //validar cargo y curso
            String accesorio = jComboBox_accesorio.getSelectedItem().toString();
            String nro = jComboBox_nro_accesorio.getSelectedItem().toString();
            String curso = jComboBox_curso_alumno.getSelectedItem().toString();

            if (curso.equalsIgnoreCase("Seleccione curso:") && accesorio.equalsIgnoreCase("Seleccione accesorio:") && nro.equalsIgnoreCase("Seleccione número:")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar curso y accesorio y número");
            } else {
                AlumnoController controlAlumno = new AlumnoController();
                Alumno alumno = new Alumno();

                alumno.setNombre(nombre);
                alumno.setCurso(curso);  // Corrección: setCurso en vez de getCurso
                alumno.setAccesorio_nombre(accesorio);  // Corrección: setAccesorio_nombre
                alumno.setNro_accesorio(Integer.parseInt(nro));  // Corrección: setNro_accesorio como entero

                //fecha hora y entrada
                DateFormat dateFormatFecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Calendar calendar = Calendar.getInstance();
                Date date = calendar.getTime();
                String fecha = dateFormatFecha.format(date);

                alumno.setHora_entrega(fecha);
                alumno.setHora_devolucion(null);
                alumno.setEstado("Prestado");

                if (controlAlumno.Guardar(alumno)) {
                    JOptionPane.showMessageDialog(null, "Ingreso de nombre del alumno Registrado.");
                    //cargar la tabla
                    this.CargarTablaAlumno();

                    //limpiar
                    jTextField_nombre_alumno.setText("");
                    jComboBox_curso_alumno.setSelectedItem("Seleccione curso:");
                    jComboBox_accesorio.setSelectedItem("Seleccione accesorio:");
                    jComboBox_nro_accesorio.setSelectedItem("Seleccione numero:");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar.");
                }
            }
        }
    }//GEN-LAST:event_jButton_registrar1ActionPerformed

    private void jLabel_reporte_alumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_reporte_alumnoMouseClicked
        // Instancia de ReporteAlumno
        ReporteAlumno reporteAlumno = new ReporteAlumno();

        // Llamada al método para generar el reporte
        try {
            reporteAlumno.generarReporteTabla();  // Llamada al método de instancia
            JOptionPane.showMessageDialog(null, "Reporte generado exitosamente.");
        } catch (DocumentException | HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el reporte: " + e.getMessage());
        }
    }//GEN-LAST:event_jLabel_reporte_alumnoMouseClicked

    private void jLabel_elimonar_alumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_elimonar_alumnoMouseClicked
        AlumnoController controlAlumno = new AlumnoController();

        if (idAlumno == 0) {
            JOptionPane.showMessageDialog(null, "Error al eliminar, debe seleccionar un nombre");
        } else {
            // Mostrar advertencia de confirmación
            int confirmacion = JOptionPane.showConfirmDialog(
                    null,
                    "¿Está seguro de que desea eliminar el nombre del Alumno?",
                    "Confirmación de Eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                System.out.println("Intentando eliminar funcionario con ID: " + idFuncionario);

                // Intentar eliminar el funcionario
                if (controlAlumno.eliminar(idAlumno)) {
                    JOptionPane.showMessageDialog(null, "Alumno eliminado de la base de datos");
                    System.out.println("Eliminación exitosa. Recargando tabla...");

                    // Recargar la tabla después de la eliminación
                    this.CargarTablaAlumno();
                    this.limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar datos del Alumno");
                    System.out.println("Error: el método eliminar devolvió false.");
                }
            }
        }
    }//GEN-LAST:event_jLabel_elimonar_alumnoMouseClicked

    private void jButton_buscar_alumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscar_alumnoActionPerformed
        String nombreBusqueda = jTextField_busqueda_criterio_alumno.getText().trim();
        Date fechaBusquedaAlumno = jDateChooser_fecha_busqueda_alumno.getDate();
        String fechaComoCadena = "";

        if (fechaBusquedaAlumno != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Formato para SQL
            fechaComoCadena = sdf.format(fechaBusquedaAlumno);
        }

        if (nombreBusqueda.isEmpty() && fechaComoCadena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese nombre para búsqueda");
            this.CargarTablaAlumno();
        } else {
            AlumnoController alumnoController = new AlumnoController();
            ArrayList<Alumno> listaAlumno = alumnoController.BuscarAlumnoNombreFecha(nombreBusqueda, fechaComoCadena);

            DefaultTableModel model = new DefaultTableModel();
            this.jTable_alumno = new JTable(model);
            this.jScrollPane2.setViewportView(this.jTable_alumno);

            // Definir las columnas de la tabla
            model.addColumn("N°");
            model.addColumn("Nombre");
            model.addColumn("Curso");
            model.addColumn("Accesorio");
            model.addColumn("N° Accesorio");
            model.addColumn("Hora entrega");
            model.addColumn("Hora devolución");

            model.addColumn("Estado");

            // Llenar las filas de la tabla
            for (Alumno alumno : listaAlumno) {
                model.addRow(new Object[]{
                    alumno.getIdAlumno(),
                    alumno.getNombre(),
                    alumno.getCurso(),
                    alumno.getAccesorio_nombre(),
                    alumno.getNro_accesorio(),
                    alumno.getHora_entrega(),
                    alumno.getHora_devolucion(),
                    alumno.getEstado()

                });

                //evento
                jTable_alumno.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int fila_point = jTable_alumno.rowAtPoint(e.getPoint());
                        int columna_point = 0;

                        if (fila_point > 1) {
                            idAlumno = (int) model.getValueAt(fila_point, columna_point);
                            EnviarDatosFuncionariosSeleccionados(idAlumno);//metodo
                        }
                    }

                });
            }
            //limpiar campos
            jTextField_busqueda_criterio_alumno.setText("");

        }
    }//GEN-LAST:event_jButton_buscar_alumnoActionPerformed

    private void jButton_buscar_nombre_alumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscar_nombre_alumnoActionPerformed
        String nombreBuscar = jTextField_nombre_retiro_alumno.getText().trim();

        if (nombreBuscar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre");
            return;
        }

        Connection cn = Conexion.conectar();
        String sql = "SELECT * FROM tb_prestamo WHERE nombre = ?";
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombreBuscar); // Evita inyección SQL
            rs = ps.executeQuery();

            if (rs.next()) {
                idAlumno = rs.getInt("id_prestamo");
                jLabel_curso.setText(rs.getString("curso"));
                jLabel_accesorio_alumno.setText(rs.getString("nombre_accesorio"));
                jLabel_nro_accesorio.setText(rs.getString("numero_accesorio"));
                jLabel_hora_entrega.setText(rs.getString("hora_entrega"));

                String devolucion = rs.getString("hora_devolucion");
                String estado = rs.getString("estado");

                if (devolucion != null) {
                    jLabel_hora_devolucion.setText(devolucion);
                } else {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Calendar calendar = Calendar.getInstance();
                    Date currentDate = calendar.getTime();
                    String fechaActual = dateFormat.format(currentDate);
                    jLabel_hora_devolucion.setText(fechaActual);
                }

                if (estado != null && estado.equalsIgnoreCase("Devuelto")) {
                    jButton_retirar_alumno.setEnabled(false);
                    jLabel_info_alumno.setVisible(true);
                } else {
                    jButton_retirar_alumno.setEnabled(true);
                    jLabel_info_alumno.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nombre no encontrado");

            }

        } catch (SQLException e) {
            System.out.println("Error al buscar datos del Alumno: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton_buscar_nombre_alumnoActionPerformed

    private void jButton_retirar_alumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_retirar_alumnoActionPerformed
        // Validar que se haya buscado un alumnos para la devolucion del accesorio
        if (jLabel_accesorio_alumno.getText() == null || jLabel_accesorio_alumno.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Busque un nombre para devolución");
            return;
        }

        try {
            // Formatear fecha y hora actuales
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            String fecha = dateFormat.format(calendar.getTime());

            // Crear objeto funcionario con datos actualizados
            Alumno alumno = new Alumno();
            alumno.setHora_devolucion(fecha); // Hora de salida
            alumno.setEstado("Devuelto");

            // Actualizar en la base de datos
            AlumnoController AlumnoController = new AlumnoController();
            if (AlumnoController.actualizarAlumno(alumno, idAlumno)) {
                JOptionPane.showMessageDialog(null, "Accesorio entregado");

                // Recargar la tabla con los datos actualizados
                this.CargarTablaAlumno();

                // Limpiar los campos de la interfaz
                jTextField_nombre_retiro_alumno.setText("");
                jLabel_curso.setText("");
                jLabel_accesorio_alumno.setText("");
                jLabel_nro_accesorio.setText("");
                jLabel_hora_entrega.setText("00:00:00");
                jLabel_hora_devolucion.setText("00:00:00");

                //metodo para crear el ticket en pdf
                ReporteAlumno ticket = new ReporteAlumno();
                ticket.TicketRetiro(idAlumno);

            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos del Alumno");
            }
        } catch (HeadlessException e) {
            // Manejar cualquier excepción inesperada
            System.out.println("Error en el proceso de retiro: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton_retirar_alumnoActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JButton jButton_buscar_alumno;
    private javax.swing.JButton jButton_buscar_nombre_alumno;
    private javax.swing.JButton jButton_buscar_nombre_funcionario;
    private javax.swing.JButton jButton_cerrar_sesion;
    private javax.swing.JButton jButton_registrar;
    private javax.swing.JButton jButton_registrar1;
    private javax.swing.JButton jButton_retirar;
    private javax.swing.JButton jButton_retirar_alumno;
    private javax.swing.JComboBox<String> jComboBox_accesorio;
    private javax.swing.JComboBox<String> jComboBox_cargo_funcionario;
    private javax.swing.JComboBox<String> jComboBox_cargo_funcionario1;
    private javax.swing.JComboBox<String> jComboBox_curso;
    private javax.swing.JComboBox<String> jComboBox_curso_alumno;
    private javax.swing.JComboBox<String> jComboBox_nro_accesorio;
    private com.toedter.calendar.JDateChooser jDateChooser_fecha_busqueda;
    private com.toedter.calendar.JDateChooser jDateChooser_fecha_busqueda_alumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_accesorio_alumno;
    private javax.swing.JLabel jLabel_cargo;
    private javax.swing.JLabel jLabel_curso;
    private javax.swing.JLabel jLabel_elimonar_alumno;
    private javax.swing.JLabel jLabel_especialidad;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_hora_devolucion;
    private javax.swing.JLabel jLabel_hora_entrada;
    private javax.swing.JLabel jLabel_hora_entrega;
    private javax.swing.JLabel jLabel_hora_salida;
    private javax.swing.JLabel jLabel_info;
    private javax.swing.JLabel jLabel_info_alumno;
    private javax.swing.JLabel jLabel_logo;
    private javax.swing.JLabel jLabel_nro_accesorio;
    private javax.swing.JLabel jLabel_reporte_alumno;
    private javax.swing.JLabel jLabel_reporte_funcionario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel_administrar_ingreso;
    private javax.swing.JPanel jPanel_registrar_funcionario;
    private javax.swing.JPanel jPanel_salida_funcionario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable_alumno;
    private javax.swing.JTable jTable_funcionarios;
    private javax.swing.JTextField jTextField_busqueda_criterio;
    private javax.swing.JTextField jTextField_busqueda_criterio_alumno;
    private javax.swing.JTextField jTextField_especialidad;
    private javax.swing.JTextField jTextField_nombre;
    private javax.swing.JTextField jTextField_nombre_alumno;
    private javax.swing.JTextField jTextField_nombre_retiro;
    private javax.swing.JTextField jTextField_nombre_retiro_alumno;
    // End of variables declaration//GEN-END:variables

    private void CargarTablaAlumno() {
        Connection cn = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT id_prestamo, nombre, curso, nombre_accesorio, numero_accesorio, hora_entrega, hora_devolucion, estado FROM tb_prestamo";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Crear la JTable con el modelo vacío primero
            this.jTable_alumno = new JTable(model);
            this.jScrollPane2.setViewportView(this.jTable_alumno);

            // Añadir las columnas correctamente
            model.addColumn("N°");
            model.addColumn("Nombre");
            model.addColumn("Curso");
            model.addColumn("Accesorio");
            model.addColumn("Nro Accesorio");
            model.addColumn("Hora entrega");
            model.addColumn("Hora devolución");
            model.addColumn("Estado");

            // Recorrer el ResultSet y agregar las filas a la tabla
            while (rs.next()) {
                Object fila[] = new Object[8]; // Cambié el tamaño a 8
                fila[0] = rs.getInt("id_prestamo"); // Asignar el ID
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("curso");
                fila[3] = rs.getString("nombre_accesorio");
                fila[4] = rs.getString("numero_accesorio");
                fila[5] = rs.getString("hora_entrega");
                fila[6] = rs.getString("hora_devolucion");
                fila[7] = rs.getString("estado");

                model.addRow(fila);
            }
            // Actualizar la tabla para reflejar los cambios
            model.fireTableDataChanged();

        } catch (SQLException e) {
            System.out.println("Error al cargar la tabla registro de alumnos: " + e);
        }

        // Evento en la tabla (asegurarse de que jTable_alumno es el que se usa aquí)
        jTable_alumno.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_alumno.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point >= 0) { // Asegurarse de que la fila sea válida
                    idAlumno = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosAlumnosSeleccionados(idAlumno); // Método
                }
            }
        });
    }

    private void CargarTablaFuncionarios() {
        Connection cn = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT id_funcionario, nombre, cargo, especialidad, curso, hora_entrada, hora_salida, estado FROM tb_funcionario";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Crear la JTable con el modelo vacío primero
            this.jTable_funcionarios = new JTable(model);
            this.jScrollPane1.setViewportView(this.jTable_funcionarios);

            // Añadir las columnas correctamente
            model.addColumn("N°");
            model.addColumn("Nombre");
            model.addColumn("Cargo");
            model.addColumn("Especialidad");
            model.addColumn("Curso");
            model.addColumn("Hora Entrada");
            model.addColumn("Hora Salida");
            model.addColumn("Estado");

            // Recorrer el ResultSet y agregar las filas a la tabla
            while (rs.next()) {
                Object fila[] = new Object[8]; // Cambié el tamaño a 8
                fila[0] = rs.getInt("id_funcionario"); // Asignar el ID
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("cargo");
                fila[3] = rs.getString("especialidad");
                fila[4] = rs.getString("curso");
                fila[5] = rs.getString("hora_entrada");
                fila[6] = rs.getString("hora_salida");
                fila[7] = rs.getString("estado");
                model.addRow(fila);
            }

            // Actualizar la tabla para reflejar los cambios
            model.fireTableDataChanged();

        } catch (SQLException e) {
            System.out.println("Error al cargar la tabla registro de funcionario: " + e);
        }

        //evento
        jTable_funcionarios.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_funcionarios.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > 0) {
                    idFuncionario = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosFuncionariosSeleccionados(idFuncionario);//metodo
                }
            }

        });

    }

    private void EnviarDatosAlumnosSeleccionados(int idAlumno) {
        // Consulta SQL actualizada con los campos correctos
        String sql = "SELECT nombre, curso, nombre_accesorio, numero_accesorio, hora_entrega, hora_devolucion, estado FROM tb_prestamo WHERE id_prestamo = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement pst = cn.prepareStatement(sql)) {

            // Asignar el parámetro del ID del alumno
            pst.setInt(1, idAlumno);

            // Ejecutar la consulta
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Mostrar la ventana de detalles
                    DetalleAlumno detalle = new DetalleAlumno();
                    detalle.setVisible(true);

                    // Asignar los valores a los campos del formulario
                    DetalleAlumno.jLabel_nombre_detalle_alumno.setText(rs.getString("nombre"));
                    DetalleAlumno.jLabel_curso_detalle_alumno.setText(rs.getString("curso"));
                    DetalleAlumno.jLabel_accesorio_detalle_alumno.setText(rs.getString("nombre_accesorio"));
                    DetalleAlumno.jLabel_accesorio_numero_detalle_alumno.setText(String.valueOf(rs.getInt("numero_accesorio")));
                    DetalleAlumno.jLabel_hora_entrega_detalle_alumno.setText(rs.getString("hora_entrega"));
                    DetalleAlumno.jLabel_hora_devolucion_detalle_alumno.setText(rs.getString("hora_devolucion"));
                    DetalleAlumno.jLabel_estado_detalle_alumno.setText(rs.getString("estado"));
                } else {
                    System.out.println("No se encontraron datos para el préstamo con ID: " + idAlumno);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al enviar datos seleccionados: " + e.getMessage());
        }
    }

    private void EnviarDatosFuncionariosSeleccionados(int idFuncionario) {
        String sql = "SELECT nombre, cargo, especialidad, curso, hora_entrada, hora_salida, estado FROM tb_funcionario WHERE id_funcionario = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement pst = cn.prepareStatement(sql)) {

            // Asignar el valor al parámetro de la consulta
            pst.setInt(1, idFuncionario);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Crear y mostrar la ventana del detalle del funcionario
                    DetalleFuncionario detalle = new DetalleFuncionario();
                    detalle.setVisible(true);

                    // Asignar los valores obtenidos a los labels correspondientes
                    DetalleFuncionario.jLabel_nombre_detalle.setText(rs.getString("nombre"));
                    DetalleFuncionario.jLabel_cargo_detalle.setText(rs.getString("cargo"));
                    DetalleFuncionario.jLabel_especialidad_detalle.setText(rs.getString("especialidad"));
                    DetalleFuncionario.jLabel_curso_detalle.setText(rs.getString("curso"));
                    DetalleFuncionario.jLabel_hora_entrada_detalle.setText(rs.getString("hora_entrada"));
                    DetalleFuncionario.jLabel_hora_salida_detalle.setText(rs.getString("hora_salida"));
                    DetalleFuncionario.jLabel_estado_detalle.setText(rs.getString("estado"));
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron datos para el funcionario con ID: " + idFuncionario);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al enviar datos seleccionados: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al obtener los datos del funcionario. Por favor, inténtelo de nuevo.");
        }
    }

    // metodo que envia datos seleccionados 
//    private void EnviarDatosFuncionariosSeleccionados(int idFuncionario) {
//        try {
//            Connection cn = Conexion.conectar();
//            PreparedStatement pst = cn.prepareStatement(
//                    "SELECT * FROM tb_funcionario WHERE id_funcionario = '" + idFuncionario + "'");
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                DetalleFuncionario detalle = new DetalleFuncionario();
//                detalle.setVisible(true);
//
//                DetalleFuncionario.jLabel_nombre_detalle.setText(rs.getString("nombre"));
//                DetalleFuncionario.jLabel_cargo_detalle.setText(rs.getString("cargo"));
//                DetalleFuncionario.jLabel_especialidad_detalle.setText(rs.getString("especialidad"));
//                DetalleFuncionario.jLabel_curso_detalle.setText(rs.getString("curso"));
//                DetalleFuncionario.jLabel_hora_entrada_detalle.setText(rs.getString("hora_entrada"));
//                DetalleFuncionario.jLabel_hora_salida_detalle.setText(rs.getString("hora_salida"));
//                DetalleFuncionario.jLabel_estado_detalle.setText(rs.getString("estado"));
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Error al enviar datos seleccionados" + e);
//        }
//    }
    //METODO PARA LIMPIAR
    private void limpiar() {
        jTextField_nombre.setText("");
        jComboBox_cargo_funcionario.setSelectedItem("Seleccione cargo:");
        jComboBox_curso.setSelectedItem("Seleccione curso:");
        jTextField_especialidad.setText("");
//        jTextField_.setText("");
//        jTextField_salida.setText("");
        //jTextField_estado.setText("");
        jTextField_nombre_alumno.setText("");
        jComboBox_nro_accesorio.setSelectedItem("Seleccione número:");
        jComboBox_accesorio.setSelectedItem("Seleccione accesorio:");
        jTextField_nombre_alumno.setText("");
    }

}
