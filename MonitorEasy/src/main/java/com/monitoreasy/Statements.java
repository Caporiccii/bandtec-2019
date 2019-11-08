
package com.monitoreasy;

import java.time.LocalDateTime;
import org.springframework.jdbc.core.JdbcTemplate;


public class Statements {
       public static void main(String[] args) {
        ConexaoBanco con = new ConexaoBanco();
        
        JdbcTemplate jdbcTemplate = 
          new JdbcTemplate(con.getDataSource());
        
        jdbcTemplate.update(
        "   insert into [dbo].[Registers] (avaliableMemory) values (?)", 
        0);
        
}}
