/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreasy;

import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;

/**
 *
 * @author marco.coelho
 */
public class StatusTotem {

    ConexaoBanco con = new ConexaoBanco();
    Statements statements = new Statements();
    SystemInfo sistemaInfo = new SystemInfo();
    double tempoAtivo;
    String statusTotem;
 JdbcTemplate jdbcTemplate
            = new JdbcTemplate(con.getDataSource());
    public double getTempoAtivo() {
        tempoAtivo = sistemaInfo.getHardware().getProcessor().getSystemUptime();

        System.out.println(tempoAtivo);
 
        return tempoAtivo;
    }

    public String getStatusTotem() {
        if (tempoAtivo <= 0) {
            statusTotem = "Totem Inativo";
        } else {
            statusTotem = "Totem Ativo";
        }
        jdbcTemplate.update(
                "   insert into [dbo].[Registers] (activeTime,status) values (?,?)",
               tempoAtivo,statusTotem);
        return statusTotem;
    }

}
