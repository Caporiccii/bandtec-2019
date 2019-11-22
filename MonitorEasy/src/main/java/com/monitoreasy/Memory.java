package com.monitoreasy;

import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.util.FormatUtil;

public class Memory {

    SystemInfo sistemaInfo = new SystemInfo();
    ConexaoBanco con = new ConexaoBanco();
    public long memoriaDisponivel;
    public long memoriaTotal;
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

        memoriaDisponivel = memoria.getAvailable()*100;
        memoriaTotal = memoria.getTotal()*100;
        monitorMemoria = String.format("Total:%s Disponivel:%s",
                FormatUtil.formatBytes(memoriaTotal),
                FormatUtil.formatBytes(memoriaDisponivel));
                    
       // jdbcTemplate.update(
         //       "   insert into [dbo].[Registers] (avaliableMemory,totalMemory) values (?,?)",
           //    memoriaDisponivel,memoriaTotal);
        return monitorMemoria;
    }
}
