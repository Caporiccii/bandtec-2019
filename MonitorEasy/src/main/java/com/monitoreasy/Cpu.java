package com.monitoreasy;

import org.apache.log4j.Logger;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.util.Util;

public class Cpu {

    SystemInfo sistemaInfo = new SystemInfo();
    HardwareAbstractionLayer hardwareAbstracao = sistemaInfo.getHardware();
    private final Logger logger;
    
    String cpu;
    public Cpu(Logger logger) {
        this.logger = logger;
        
    }
    public String getCpu(CentralProcessor media) {
        try{
            logger.debug("Capturando uso de CPU");
        long[] prevTicks = hardwareAbstracao.getProcessor().getSystemCpuLoadTicks();
        Util.sleep(1000);

        cpu = String.format("Uso atual %.1f%%", media.getSystemCpuLoadBetweenTicks() * 100);
        logger.info("Capturada com sucesso!!");
        }
        catch(Exception ex){
        logger.error("Erro ao capturar uso de CPU" + ex);
        }
        return cpu;
    }
}
