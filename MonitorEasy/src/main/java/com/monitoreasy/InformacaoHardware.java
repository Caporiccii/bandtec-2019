/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreasy;

import oshi.SystemInfo;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author marco.coelho
 */
public class InformacaoHardware {

    SystemInfo sistemaInfo = new SystemInfo();
    OperatingSystem os = sistemaInfo.getOperatingSystem();
    HardwareAbstractionLayer hardwareAbstracao = sistemaInfo.getHardware();

    public String getInfoHardware(ComputerSystem nome) {
        String nameComputer = hardwareAbstracao.getComputerSystem().getManufacturer();
        return nameComputer;
    }
}
