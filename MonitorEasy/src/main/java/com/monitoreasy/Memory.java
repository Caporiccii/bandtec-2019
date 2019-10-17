package com.monitoreasy;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.util.FormatUtil;

public class Memory {

    SystemInfo sistemaInfo = new SystemInfo();
    long memoriaDisponivel;
    long memoriaTotal;
    String monitorMemoria;

    public String getMemory(GlobalMemory memoria) {

        memoriaDisponivel = memoria.getAvailable();
        memoriaTotal = memoria.getTotal();
        monitorMemoria = String.format("Total:%s Disponivel:%s",
                FormatUtil.formatBytes(memoriaTotal),
                FormatUtil.formatBytes(memoriaDisponivel));

        return monitorMemoria;
    }
}
