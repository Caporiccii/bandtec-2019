/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreasy;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;
import oshi.util.FormatUtil;
//import oshi.hardware.GlobalMemory;

public final class Monitor extends javax.swing.JFrame {

    private final StatusTotem status;
    private final SystemInfo systemInfo;
    private final Memory memoria;
    private final Cpu cpu;
    private final Processos processos;
    private final InformacaoHardware informacaoHardware;
    private final Mensagens mensagem;

    private final Date hora;
    LogMonitor logger = new LogMonitor();
    ConexaoBanco con = new ConexaoBanco();
    JdbcTemplate jdbcTemplate
            = new JdbcTemplate(con.getDataSource());

    public final void mostraDados() {
        labelMemoria.setText(memoria.getMemory());
        labelQuantidadeProcessos.setText(processos.getProcessor(systemInfo.getHardware().getProcessor()));
        labelCPUToda.setText(cpu.getCpu(systemInfo.getHardware().getProcessor()));
        labelTotemResultado.setText(informacaoHardware.getSerialNumber());
        status.getTempoAtivo();
        informacaoHardware.getInfoHardware();
        informacaoHardware.getSerialNumber();
        memoria.getMemoryAvailable();
        cpu.getCpuInt(systemInfo.getHardware().getProcessor());
        labelStatusTotem2.setText(status.getStatusTotem());
        areaProcessos.setText(processos.getProcessos(systemInfo.getHardware().getMemory()));

    }

    public void mensagens() {
        try {
            mensagem.geraAlerta(cpu.cpu1, memoria.memoriaAtual);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final void insertRegistro() {
        try {
            jdbcTemplate.update("insert into [dbo].[Registers] (avaliableMemory,totalMemory,totemId,cpu,"
                    + "infoHardware,activeTime,status,moment,memory,memoryUnit,cpuUnit,diskUnit) values (?,?,?,?,?,?,?,?,?,?,?,?)", memoria.memoriaDisponivel / 1000000000,
                    memoria.memoriaTotal / 1000000000, 54, cpu.cpu1, informacaoHardware.nameComputer, (int) status.tempoAtivo, status.statusTotem, hora, memoria.memoriaAtual, "MB", "MB", "MB");
            jdbcTemplate.update("insert into [dbo].[Totems] (name,serialNumber,stationId,active) values (?,?,?,?)",
                    informacaoHardware.nameComputer, informacaoHardware.serialNumber, 10, status.statusTotem);
        } catch (Exception ex) {
            System.out.println("Erro" + ex);
        }
    }

    public Monitor() {
        //
        Logger log = logger.getLogger();
        systemInfo = new SystemInfo();
        memoria = new Memory();
        status = new StatusTotem(log);
        cpu = new Cpu(log);
        processos = new Processos(log);
        informacaoHardware = new InformacaoHardware(log);
        hora = new Date();
        mensagem = new Mensagens();
        initComponents();
        mostraDados();
        insertRegistro();
        mensagens();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelStatusTotem2 = new javax.swing.JLabel();
        labelNomeMemoria = new javax.swing.JLabel();
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
        labelMemoria = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 51, 255));

        labelStatusTotem2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelStatusTotem2.setForeground(new java.awt.Color(255, 255, 255));

        labelNomeMemoria.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelNomeMemoria.setForeground(new java.awt.Color(255, 255, 255));
        labelNomeMemoria.setText("Memória:");

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

        labelMemoria.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelMemoria.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelStatusTotem)
                            .addComponent(labelTotem))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTotemResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelStatusTotem2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCPU)
                            .addComponent(labelProcessos)
                            .addComponent(labelNomeMemoria))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelQuantidadeProcessos, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCPUToda, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelCPU)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelStatusTotem, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelStatusTotem2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelTotem)
                                    .addComponent(labelTotemResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelNomeMemoria)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelProcessos))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelQuantidadeProcessos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelCPUToda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Monitor monitor = new Monitor();
                //  monitor.mostraDados();
                new Monitor().setVisible(true);
                monitor.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent arg0) {
                        //        monitor.mostraDados();

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
