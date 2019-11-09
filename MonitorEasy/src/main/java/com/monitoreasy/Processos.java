/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreasy;

import org.apache.log4j.Logger;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

public class Processos {

    SystemInfo sistemaInfo = new SystemInfo();
    HardwareAbstractionLayer hardwareAbstracao = sistemaInfo.getHardware();
    String processoTotal;
    private final Logger logger;

    public Processos(Logger logger) {
        this.logger = logger;
    }

    public String getProcessor(CentralProcessor processo) {
        try {
            long[] processadorAtual = hardwareAbstracao.getProcessor().getSystemCpuLoadTicks();
            processoTotal = "Estado processos:" + processadorAtual[0];

            logger.info(processoTotal);
        } catch (Exception ex) {
            logger.error(ex);
        }
        return processoTotal;
    }
}
