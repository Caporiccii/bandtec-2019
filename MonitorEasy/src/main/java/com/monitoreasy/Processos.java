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
            logger.debug("Capturando quantidade de processos");
            long[] processadorAtual = hardwareAbstracao.getProcessor().getSystemCpuLoadTicks();
            processoTotal = "Quantidade de processos:" + processadorAtual[0];

            logger.info("Capturado com sucesso!!");
        } catch (Exception ex) {
            logger.error("Erro ao capturar processos: " + ex);
        }
        return processoTotal;
    }
}
