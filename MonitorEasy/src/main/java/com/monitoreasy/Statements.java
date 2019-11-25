package com.monitoreasy;

import java.util.Date;
import org.springframework.jdbc.core.JdbcTemplate;

public class Statements {

    public String sql;
    ConexaoBanco con = new ConexaoBanco();
    JdbcTemplate jdbcTemplate
            = new JdbcTemplate(con.getDataSource());

    public void insertRegistro(long memoriaDisponivel, long memoriaTotal, Integer processos, Integer cpu, String nameComputer, Integer tempoAtivo, String statusTotem, Date hora) {

         jdbcTemplate.update("insert into Registers (avaliableMemory,totalMemory,totalProcess,cpu,"
                + "infoHardware,activeTime,status,moment) values (?,?,?,?,?,?,?,?,?,?,?,?)",memoriaDisponivel, memoriaTotal,
              processos,  cpu,  nameComputer,
             tempoAtivo,  statusTotem,  hora);

        
    }
}
