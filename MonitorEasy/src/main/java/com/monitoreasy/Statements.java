package com.monitoreasy;

import java.util.Date;

public class Statements {

    public String sql;
    
    public String insertRegistro(Integer memoriaDisponivel, Integer memoriaTotal
    ,Integer memory, Integer totalProcess,Integer cpu, Integer infoH,
    Integer activeTime,String status,String memoryUnit,
    String cpuUnit, String diskUnit,Date moment){ 
        
       sql = "   insert into Registers "
            + "(avaliableMemory,totalMemory,memory,totalProcess,cpu,"
            + "infoHardware,activeTime,status,memoryUnit\n"
            + ",cpuUnit,diskUnit,moment) values (?,?,?,?,?,?,?,?,?,?,?,?)";
       
       return sql;
    }
}
