/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreasy;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

/**
 *
 * @author marco.coelho
 */
public class Monitor extends javax.swing.JFrame {

  //  MonitoraMaquina monitor = new MonitoraMaquina();
   // private final HardwareAbstractionLayer hardware = sistemaInfo.getHardware();
   
    private final MonitoraMaquina monitora;
    private final SystemInfo systemInfo;
       private final Memory memoria;

    public final void mostraDados() {
        
        labelMemoria.setText(memoria.getMemory(systemInfo.getHardware().getMemory()));
        labelQuantidadeProcessos.setText(monitora.getProcessor(systemInfo.getHardware().getProcessor()));
        labelCPUToda.setText(monitora.getCpu(systemInfo.getHardware().getProcessor()));
        labelTotemResultado.setText(monitora.getInfoHardware(systemInfo.getHardware().getComputerSystem()));
        monitora.getTempoAtivo();
        labelStatusTotem2.setText(monitora.getStatusTotem());
    }

    /**
     * Creates new form Monitor
     */
    public Monitor() {
        monitora = new MonitoraMaquina();
                systemInfo = new SystemInfo();
                memoria = new Memory();
                      initComponents();
        mostraDados();
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
        labelStatusTotem2 = new javax.swing.JLabel();
        labelNomeMemoria = new javax.swing.JLabel();
        labelMemoria = new javax.swing.JLabel();
        labelProcessos = new javax.swing.JLabel();
        labelQuantidadeProcessos = new javax.swing.JLabel();
        labelCPU = new javax.swing.JLabel();
        labelCPUToda = new javax.swing.JLabel();
        labelTotem = new javax.swing.JLabel();
        labelTotemResultado = new javax.swing.JLabel();
        labelStatusTotem = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 51, 255));

        labelStatusTotem2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelStatusTotem2.setForeground(new java.awt.Color(255, 255, 255));

        labelNomeMemoria.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelNomeMemoria.setForeground(new java.awt.Color(255, 255, 255));
        labelNomeMemoria.setText("Memória:");

        labelMemoria.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelMemoria.setForeground(new java.awt.Color(255, 255, 255));

        labelProcessos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelProcessos.setForeground(new java.awt.Color(255, 255, 255));
        labelProcessos.setText("Processos:");

        labelQuantidadeProcessos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelQuantidadeProcessos.setForeground(new java.awt.Color(255, 255, 255));

        labelCPU.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelCPU.setForeground(new java.awt.Color(255, 255, 255));
        labelCPU.setText("CPU:");

        labelCPUToda.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelCPUToda.setForeground(new java.awt.Color(255, 255, 255));

        labelTotem.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelTotem.setForeground(new java.awt.Color(255, 255, 255));
        labelTotem.setText("Id Totem:");

        labelTotemResultado.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelTotemResultado.setForeground(new java.awt.Color(255, 255, 255));

        labelStatusTotem.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelStatusTotem.setForeground(new java.awt.Color(255, 255, 255));
        labelStatusTotem.setText("Status:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.PNG"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(labelTotem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelTotemResultado))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelNomeMemoria)
                                    .addComponent(labelStatusTotem)
                                    .addComponent(labelProcessos)
                                    .addComponent(labelCPU))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelStatusTotem2)
                                    .addComponent(labelMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelQuantidadeProcessos)
                                    .addComponent(labelCPUToda))))
                        .addGap(0, 114, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelTotem)
                    .addComponent(labelTotemResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStatusTotem, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelStatusTotem2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeMemoria)
                    .addComponent(labelMemoria))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelProcessos)
                    .addComponent(labelQuantidadeProcessos))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCPU)
                    .addComponent(labelCPUToda))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Monitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Monitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Monitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Monitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Monitor monitor = new Monitor();
                monitor.mostraDados();
                new Monitor().setVisible(true);
                monitor.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent arg0) {
                        monitor.mostraDados();
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void windowClosing(WindowEvent arg0) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void windowClosed(WindowEvent arg0) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void windowIconified(WindowEvent arg0) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void windowDeiconified(WindowEvent arg0) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void windowActivated(WindowEvent arg0) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void windowDeactivated(WindowEvent arg0) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelCPU;
    private javax.swing.JLabel labelCPUToda;
    private javax.swing.JLabel labelMemoria;
    private javax.swing.JLabel labelNomeMemoria;
    private javax.swing.JLabel labelProcessos;
    private javax.swing.JLabel labelQuantidadeProcessos;
    private javax.swing.JLabel labelStatusTotem;
    private javax.swing.JLabel labelStatusTotem2;
    private javax.swing.JLabel labelTotem;
    private javax.swing.JLabel labelTotemResultado;
    // End of variables declaration//GEN-END:variables
}
