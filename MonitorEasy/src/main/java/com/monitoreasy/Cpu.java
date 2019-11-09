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

    public Cpu(Logger logger) {
        this.logger = logger;
    }

    String cpu;

    public String getCpu(CentralProcessor media) {
        long[] prevTicks = hardwareAbstracao.getProcessor().getSystemCpuLoadTicks();
        Util.sleep(1000);

        cpu = String.format("Uso atual %.1f%%", media.getSystemCpuLoadBetweenTicks() * 100);
        logger.info(cpu);

        return cpu;
    }
}
