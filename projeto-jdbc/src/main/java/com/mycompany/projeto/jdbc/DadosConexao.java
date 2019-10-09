package com.mycompany.projeto.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

public class DadosConexao {

    private BasicDataSource dataSource;

    public DadosConexao() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
// exemplo para MySql: "com.mysql.cj.jdbc.Driver"
        dataSource.setUrl("jdbc:mysql://localhost:3306/gaga?useTimezone=true&serverTimezone=UTC");
// exemplo para MySql: "jdbc:mysql://localhost:3306/meubanco"
        dataSource.setUsername("root");
        dataSource.setPassword("bandtec");
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
}
