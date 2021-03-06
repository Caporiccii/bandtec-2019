/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreasy;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;

/**
 *
 * @author marco.coelho
 */
public class StatusTotem {

    
    SystemInfo sistemaInfo = new SystemInfo();
    double tempoAtivo;
    String statusTotem;
    private final Logger logger;

    public StatusTotem(Logger logger) {
        this.logger = Logger.getLogger(StatusTotem.class);
    }
    
    public double getTempoAtivo() {
        try{
        tempoAtivo = sistemaInfo.getHardware().getProcessor().getSystemUptime();

        System.out.println(tempoAtivo);
        logger.debug("Capturando tempo ativo");
        }
        catch(Exception ex){
            logger.error(ex);
        }
        return tempoAtivo;
    }

    public String getStatusTotem() {
        if (tempoAtivo <= 0) {
            statusTotem = "Totem Inativo";
        } else {
            statusTotem = "Totem Ativo";
        }
       
        return statusTotem;
    }

}
