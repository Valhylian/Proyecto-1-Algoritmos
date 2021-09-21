/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominosa;

import static dominosa.Dominosa.solucionesMatrices;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author valeria
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
     
    public Interfaz() {
        initComponents();
    
    }
    
    public static JButton [][]matrizBotones;
    public static ArrayList<int[][]> matrizSoluciones;
    public static int contador=0;
    
    
    public void generarMatrizGrafica (int matrix[][])
    {
        
        int ancho = matrix[0].length;
        int largo = matrix.length;
        matrizBotones = new JButton[largo][ancho];
        panelMatriz.setLayout(new GridLayout(largo, ancho));
        for (int i=0; i<largo; i++){
            for (int j=0; j<ancho; j++){
                String contenido =Integer.toString(matrix[i][j]);
                matrizBotones[i][j] = new JButton(contenido);
                matrizBotones[i][j].setBackground(Color.BLACK);
                //matrizBotones[i][j].setSize(largo/largo, ancho/ancho);
                panelMatriz.add(matrizBotones[i][j]);
            }
        }
        RedibujarTablero();
    }
    
    private void RedibujarTablero()
    {
        //Se valida los componentes del elemento pnlTablero
        panelMatriz.validate();
        //Se redibuja el elemento pnlTablero y sus componentes hijos
        panelMatriz.repaint();
    }
    
    public void pintarMatriz (int matriz[][])
    {
        for (int x=0; x<matriz.length; x++){
            for (int y=0; y<matriz[0].length; y++){
                if (matriz[x][y] == 0){
                    matrizBotones[x][y].setBackground(Color.red);
                }
                else{
                    matrizBotones[x][y].setBackground(Color.green);
                }
            }
        }
    }
    
    public static void escribirTextBoxFuerzaBruta(String contenido)
    {
        fuerzabtxt.append(contenido);
    }
    
    public static void escribirTextBoxBacktracking(String contenido)
    {
        backtrackingtxt.append(contenido);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        panelFondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        backtrackingtxt = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        panelMatriz = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        fuerzabtxt = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btn_solucion = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1201, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dominosa");
        setMaximumSize(null);
        setMinimumSize(null);
        setPreferredSize(null);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        panelFondo.setBackground(new java.awt.Color(0, 0, 0));
        panelFondo.setForeground(new java.awt.Color(0, 0, 0));
        panelFondo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        panelFondo.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dominosa");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jLabel1.setOpaque(true);
        panelFondo.add(jLabel1);
        jLabel1.setBounds(-10, 0, 1170, 27);

        backtrackingtxt.setEditable(false);
        backtrackingtxt.setColumns(20);
        backtrackingtxt.setLineWrap(true);
        backtrackingtxt.setRows(5);
        backtrackingtxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backtrackingtxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(backtrackingtxt);

        panelFondo.add(jScrollPane2);
        jScrollPane2.setBounds(864, 130, 226, 360);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(" Backtracking ");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        panelFondo.add(jLabel2);
        jLabel2.setBounds(890, 80, 171, 33);

        panelMatriz.setBackground(new java.awt.Color(0, 0, 0));
        panelMatriz.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout panelMatrizLayout = new javax.swing.GroupLayout(panelMatriz);
        panelMatriz.setLayout(panelMatrizLayout);
        panelMatrizLayout.setHorizontalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );
        panelMatrizLayout.setVerticalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        panelFondo.add(panelMatriz);
        panelMatriz.setBounds(430, 200, 290, 260);

        fuerzabtxt.setEditable(false);
        fuerzabtxt.setColumns(20);
        fuerzabtxt.setLineWrap(true);
        fuerzabtxt.setRows(5);
        fuerzabtxt.setWrapStyleWord(true);
        fuerzabtxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fuerzabtxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        fuerzabtxt.setDoubleBuffered(true);
        jScrollPane4.setViewportView(fuerzabtxt);

        panelFondo.add(jScrollPane4);
        jScrollPane4.setBounds(50, 150, 226, 340);

        jTextArea3.setColumns(20);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane3.setViewportView(jTextArea3);

        panelFondo.add(jScrollPane3);
        jScrollPane3.setBounds(380, 80, 390, 40);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" Fuerza Bruta ");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        panelFondo.add(jLabel4);
        jLabel4.setBounds(83, 101, 158, 33);

        btn_solucion.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn_solucion.setText("Siguiente solución");
        btn_solucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_solucionActionPerformed(evt);
            }
        });
        panelFondo.add(btn_solucion);
        btn_solucion.setBounds(470, 490, 200, 29);

        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton3.setText("Ingresar matriz");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelFondo.add(jButton3);
        jButton3.setBounds(480, 130, 200, 29);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Matriz a ingresar:");
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        panelFondo.add(jLabel5);
        jLabel5.setBounds(470, 40, 220, 33);

        getContentPane().add(panelFondo);
        panelFondo.setBounds(0, 0, 1150, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_solucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_solucionActionPerformed
        // TODO add your handling code here:
       // TODO add your handling code here:
        
        matrizSoluciones=dominosa.Dominosa.solucionesMatrices;
        int [][] matrizAux = matrizSoluciones.get(contador);
        for (int i = 0; i < matrizAux.length; i++) {
           for (int j = 0; j < matrizAux[i].length; j++) {
               if (matrizAux[i][j] == 0){
                   matrizBotones[i][j].setBackground(Color.red);
               }
               else{
                   matrizBotones[i][j].setBackground(Color.green);
               }

           }
       }
        if(contador<matrizSoluciones.size()-1){
            contador+=1;    
        }else{
            JOptionPane.showMessageDialog(jFrame1, "Ya no hay más soluciones disponibles.");
        }
    }//GEN-LAST:event_btn_solucionActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                
            }
             
 
 
 
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea backtrackingtxt;
    private javax.swing.JButton btn_solucion;
    private static javax.swing.JTextArea fuerzabtxt;
    private javax.swing.JButton jButton3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelMatriz;
    // End of variables declaration//GEN-END:variables
}
