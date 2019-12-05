/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreasy;

import org.apache.log4j.Logger;
import oshi.SystemInfo;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author marco.coelho
 */
public class InformacaoHardware {

    Logger logger;
    SystemInfo sistemaInfo = new SystemInfo();
    OperatingSystem os = sistemaInfo.getOperatingSystem();
    HardwareAbstractionLayer hardwareAbstracao = sistemaInfo.getHardware();
    String nameComputer;
    String serialNumber;
    public InformacaoHardware(Logger logger) {
        this.logger = Logger.getLogger(InformacaoHardware.class);
    }

    public String getInfoHardware() {
        try{
            logger.error("Capturando Informação do Hardware");
         nameComputer = hardwareAbstracao.getComputerSystem().getManufacturer();
        logger.info("Capturada com sucesso!!");
        }
        catch(Exception ex)
        {
            logger.error("Erro ao capturar Informação Hardware: " + ex);
        }
        return nameComputer;
    }
        public String getSerialNumber() {
        try{
            logger.error("Capturando Informação do Hardware");
         serialNumber = hardwareAbstracao.getComputerSystem().getSerialNumber();
        logger.info("Capturada com sucesso!!");
        }
        catch(Exception ex)
        {
            logger.error("Erro ao capturar Informação Hardware: " + ex);
        }
        return serialNumber;
    }
}
