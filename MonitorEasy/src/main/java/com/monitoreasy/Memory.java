package com.monitoreasy;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.util.FormatUtil;

public class Memory {
    
    SystemInfo sistemaInfo = new SystemInfo();
    public double memoriaDisponivel;
    public double memoriaTotal;
    public double memoriaAtual;
    public String monitorMemoria;
    private final SystemInfo systemInfo;
    private final GlobalMemory memoria;
    private final Logger logger;
    
    public Memory() {
        systemInfo = new SystemInfo();
        memoria = systemInfo.getHardware().getMemory();
        logger = Logger.getLogger(Memory.class);
    }
    
    public String getMemory() {
        try {
            memoriaDisponivel = memoria.getAvailable();
            memoriaTotal = memoria.getTotal();
            memoriaAtual = memoria.getSwapUsed();
            monitorMemoria = String.format("Total:%s Disponivel:%s", (FormatUtil.formatBytes((long) memoriaTotal)), FormatUtil.formatBytes((long) memoriaDisponivel));
        logger.debug("Capturando Memoria");
        } catch (Exception ex) {
            logger.error(ex + " Erro");
        }
        
        return monitorMemoria;
    }

    public Double getMemoryAvailable() {
        memoriaDisponivel = memoria.getAvailable() * 100;
        System.out.println("FOI" + memoriaDisponivel);
        return memoriaDisponivel;
    }
    
}
