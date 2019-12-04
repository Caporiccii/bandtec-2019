/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreasy;

import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

public class Processos {

    SystemInfo sistemaInfo = new SystemInfo();
    HardwareAbstractionLayer hardwareAbstracao = sistemaInfo.getHardware();
    OperatingSystem os = sistemaInfo.getOperatingSystem();
    String processoTotal;
    String processos;
    int n = 5;
    GlobalMemory memoria;
     long[] processadorAtual;
    private final Logger logger;
    private final SystemInfo systemInfo;

    public Processos(Logger logger) {
        this.logger = logger;
        systemInfo = new SystemInfo();
        memoria = systemInfo.getHardware().getMemory();
    }

    public String getProcessor(CentralProcessor processo) {
        try {
            logger.debug("Capturando quantidade de processos");
            processadorAtual = hardwareAbstracao.getProcessor().getSystemCpuLoadTicks();
          ;
            processoTotal = "Quantidade de processos:" + processadorAtual[0];

            logger.info("Capturado com sucesso!!");
        } catch (Exception ex) {
            logger.error("Erro ao capturar processos: " + ex);
        }
        return processoTotal;
    }

    public String getProcessos(GlobalMemory memoria) {
        List<OSProcess> proce = Arrays.asList(os.getProcesses(5, OperatingSystem.ProcessSort.CPU));

        processos = "   PID  %CPU %MEM       VSZ       RSS Name\n";
        for (int i = 0; i < proce.size() && i < 5; i++) {
            OSProcess p = proce.get(i);
            processos += String.format(String.format(" %5d %5.1f %4.1f %9s %9s %s\n", p.getProcessID(),
                    100d * (p.getKernelTime() + p.getUserTime()) / p.getUpTime(),
                    100d * p.getResidentSetSize() / memoria.getTotal(), FormatUtil.formatBytes(p.getVirtualSize()),
                    FormatUtil.formatBytes(p.getResidentSetSize()), p.getName()));
        }
        return processos;
    }
}
