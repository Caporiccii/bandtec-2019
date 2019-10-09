/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto.jdbc;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Aluno
 */
public class ProgramaLeitura {
    public static void main(String[] args) {
        DadosConexao dados = new DadosConexao();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dados.getDataSource());
        
        List lista = jdbcTemplate.queryForList("select * from leitura");
        
        System.out.println("Consulta: "+ lista);
    }
}
