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

        labelNomeMemoria = new javax.swing.JLabel();
        labelMemoria = new javax.swing.JLabel();
        labelProcessos = new javax.swing.JLabel();
        labelQuantidadeProcessos = new javax.swing.JLabel();
        labelCPU = new javax.swing.JLabel();
        labelCPUToda = new javax.swing.JLabel();
        labelTotem = new javax.swing.JLabel();
        labelTotemResultado = new javax.swing.JLabel();
        labelStatusTotem = new javax.swing.JLabel();
        labelStatusTotem2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelNomeMemoria.setText("Memoria:");

        labelProcessos.setText("Processos:");

        labelCPU.setText("CPU");

        labelTotem.setText("Nome Totem:");

        labelStatusTotem.setText("Status Totem");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNomeMemoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMemoria, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelTotem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelTotemResultado))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelProcessos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelQuantidadeProcessos))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelCPU)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelCPUToda))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelStatusTotem)
                                .addGap(18, 18, 18)
                                .addComponent(labelStatusTotem2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeMemoria)
                    .addComponent(labelMemoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelProcessos)
                    .addComponent(labelQuantidadeProcessos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCPU)
                    .addComponent(labelCPUToda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotemResultado)
                    .addComponent(labelTotem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStatusTotem, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelStatusTotem2))
                .addContainerGap(298, Short.MAX_VALUE))
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