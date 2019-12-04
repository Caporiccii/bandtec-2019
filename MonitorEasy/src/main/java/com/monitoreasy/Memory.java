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
        monitorMemoria = String.format("Total:%s Disponivel:%s",memoriaTotal,memoriaDisponivel);
            
                    
        jdbcTemplate.update(
            "   insert into [dbo].[Registers] (avaliableMemory,totalMemory) values (?,?)",
              memoriaDisponivel,memoriaTotal);
        return monitorMemoria;
    }
       public Double getMemoryAvailable(){
         memoriaDisponivel = memoria.getAvailable();
           System.out.println("FOI"+memoriaDisponivel);
           return memoriaDisponivel;
       }
       
}
