package com.monitoreasy;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.ComputerSystem;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;
import oshi.util.Util;

public class MonitoraMaquina {

    SystemInfo sistemaInfo = new SystemInfo();
    OperatingSystem os = sistemaInfo.getOperatingSystem();
    HardwareAbstractionLayer hardwareAbstracao = sistemaInfo.getHardware();
      String processoTotal;
    String cpu;
    String infoHardware;
    int nelem = 1;
    double tempoAtivo;
    String statusTotem;

   
    public String getProcessor(CentralProcessor processo) {
        long[] processadorAtual = hardwareAbstracao.getProcessor().getSystemCpuLoadTicks();
        processoTotal = "Estado processos:" + processadorAtual[0];
        return processoTotal;
    }

    public String getCpu(CentralProcessor media) {
        long[] prevTicks = hardwareAbstracao.getProcessor().getSystemCpuLoadTicks();
        Util.sleep(1000);
    
        cpu = String.format("Uso atual %.1f%%", media.getSystemCpuLoadBetweenTicks() * 100);

        return cpu;
    }

    public String getInfoHardware(ComputerSystem nome) {
String nameComputer = hardwareAbstracao.getComputerSystem().getManufacturer();
        return nameComputer;
    }

    public double getTempoAtivo() {
   tempoAtivo  = sistemaInfo.getHardware().getProcessor().getSystemUptime();
        
        System.out.println(tempoAtivo);
   
        return tempoAtivo ;
    }
    public String getStatusTotem (){
    if(tempoAtivo <= 0)
    {
     statusTotem = "Totem Inativo";
    }
    else 
    {
           statusTotem = "Totem Ativo";
    }
        return statusTotem;
    }

    
}
