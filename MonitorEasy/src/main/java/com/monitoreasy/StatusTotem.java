/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreasy;

import oshi.SystemInfo;

/**
 *
 * @author marco.coelho
 */
public class StatusTotem {
    
     SystemInfo sistemaInfo = new SystemInfo();
        double tempoAtivo;
    String statusTotem;

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
