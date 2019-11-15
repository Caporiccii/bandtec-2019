package com.monitoreasy;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class Statements {

    ConexaoBanco con = new ConexaoBanco();
    private final Memory memoria;

    public Statements() {
    memoria = new Memory();
    }

    JdbcTemplate jdbcTemplate
            = new JdbcTemplate(con.getDataSource());

    public void InsertMemoria() {

     int a =  jdbcTemplate.update(
                "   insert into [dbo].[Registers] (avaliableMemory) values (?)",
                memoria.memoriaTotal);
        
    }

}
