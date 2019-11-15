/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreasy;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import org.apache.log4j.Logger;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;

public class Monitor extends javax.swing.JFrame {

    private final StatusTotem status;
    private final SystemInfo systemInfo;
    private final Memory memoria;
    private final Cpu cpu;
    private final Processos processos;
    private final InformacaoHardware informacaoHardware;  
    LogMonitor logger = new LogMonitor();
    Statements query = new Statements();
    

    public final void mostraDados() {
        labelMemoria.setText(memoria.getMemory());
        labelQuantidadeProcessos.setText(processos.getProcessor(systemInfo.getHardware().getProcessor()));
        labelCPUToda.setText(cpu.getCpu(systemInfo.getHardware().getProcessor()));
        labelTotemResultado.setText(informacaoHardware.getInfoHardware(systemInfo.getHardware().getComputerSystem()));
        status.getTempoAtivo();
        labelStatusTotem2.setText(status.getStatusTotem());
        areaProcessos.setText(processos.getProcessos(systemInfo.getHardware().getMemory()));
    }

    public Monitor() {
        //
        Logger log = logger.getLogger();
        systemInfo = new SystemInfo();
        memoria = new Memory();
        status = new StatusTotem();
        cpu = new Cpu(log);
        processos = new Processos(log);
        informacaoHardware = new InformacaoHardware(log);
        query.InsertMemoria();
        initComponents();
        
        mostraDados();
    }

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
        jScrollPane1 = new javax.swing.JScrollPane();
        areaProcessos = new javax.swing.JTextArea();

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

        areaProcessos.setColumns(20);
        areaProcessos.setRows(5);
        jScrollPane1.setViewportView(areaProcessos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelProcessos)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelStatusTotem)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(labelTotem)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelNomeMemoria)
                                            .addComponent(labelCPU))))
                                .addGap(33, 33, 33)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelStatusTotem2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCPUToda, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelTotemResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelQuantidadeProcessos, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelStatusTotem2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelStatusTotem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(labelTotemResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelTotem))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNomeMemoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelQuantidadeProcessos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelCPUToda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(labelProcessos)
                        .addGap(18, 18, 18)
                        .addComponent(labelCPU)
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
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
    private javax.swing.JTextArea areaProcessos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
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
