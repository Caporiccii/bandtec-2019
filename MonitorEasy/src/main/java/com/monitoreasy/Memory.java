package com.monitoreasy;

import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.util.FormatUtil;

public class Memory {

    SystemInfo sistemaInfo = new SystemInfo();
    ConexaoBanco con = new ConexaoBanco();
    public double memoriaDisponivel;
    public double memoriaTotal;
    public double memoriaAtual;
    public String monitorMemoria;
    private final SystemInfo systemInfo;
    private final GlobalMemory memoria;
        JdbcTemplate jdbcTemplate
            = new JdbcTemplate(con.getDataSource());
    
    public Memory() {
        systemInfo = new SystemInfo();
        memoria = systemInfo.getHardware().getMemory();
        
       }

    public String getMemory() {

        memoriaDisponivel = memoria.getAvailable();
        memoriaTotal = memoria.getTotal();
        memoriaAtual = memoria.getSwapUsed();
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA"+memoriaAtual);
        monitorMemoria = String.format("Total:%s Disponivel:%s",(FormatUtil.formatBytes((long) memoriaTotal)),FormatUtil.formatBytes((long)memoriaDisponivel));
            
                  
        return monitorMemoria;
    }
       public Double getMemoryAvailable(){
         memoriaDisponivel = memoria.getAvailable()*100;
           System.out.println("FOI"+memoriaDisponivel);
           return memoriaDisponivel;
       }
       
}
