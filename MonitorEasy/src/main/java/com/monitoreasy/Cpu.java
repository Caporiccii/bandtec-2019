package com.monitoreasy;


import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.util.Util;


public class Cpu {
    SystemInfo sistemaInfo = new SystemInfo();
    HardwareAbstractionLayer hardwareAbstracao = sistemaInfo.getHardware();
 
        String cpu;
       public String getCpu(CentralProcessor media) {
        long[] prevTicks = hardwareAbstracao.getProcessor().getSystemCpuLoadTicks();
        Util.sleep(1000);
    
        cpu = String.format("Uso atual %.1f%%", media.getSystemCpuLoadBetweenTicks() * 100);

        return cpu;
    }
}
