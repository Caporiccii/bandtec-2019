/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreasy;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

public class Processos {

    SystemInfo sistemaInfo = new SystemInfo();
    HardwareAbstractionLayer hardwareAbstracao = sistemaInfo.getHardware();
    String processoTotal;

    public String getProcessor(CentralProcessor processo) {
        long[] processadorAtual = hardwareAbstracao.getProcessor().getSystemCpuLoadTicks();
        processoTotal = "Estado processos:" + processadorAtual[0];
        return processoTotal;
    }
}
