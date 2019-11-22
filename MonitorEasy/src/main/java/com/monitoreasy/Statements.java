package com.monitoreasy;

import java.util.Date;
import org.springframework.jdbc.core.JdbcTemplate;

public class Statements {

    public String sql;
    ConexaoBanco con = new ConexaoBanco();
    JdbcTemplate jdbcTemplate
            = new JdbcTemplate(con.getDataSource());

    public String insertRegistro(Integer memoriaDisponivel, Integer memoriaTotal,
             Integer memory, Integer totalProcess, Integer cpu, Integer infoH,
            Integer activeTime, String status, String memoryUnit,
            String cpuUnit, String diskUnit, Date moment) {

        jdbcTemplate.update("insert into Registers (avaliableMemory,totalMemory,memory,totalProcess,cpu,"
                + "infoHardware,activeTime,status,memoryUnit,cpuUnit,diskUnit,moment) values (?,?,?,?,?,?,?,?,?,?,?,?)",memoriaDisponivel, memoriaTotal,
              memory, totalProcess,  cpu,  infoH,
             activeTime,  status,  memoryUnit,
             cpuUnit, diskUnit,  moment);

        return sql;
    }
}
