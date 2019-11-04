
package com.monitoreasy;

import org.apache.commons.dbcp2.BasicDataSource;


public class ConexaoBanco {

    private BasicDataSource dataSource;

    public ConexaoBanco() {
        dataSource​ = new​ BasicDataSource();
        dataSource​.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource​.setUrl("jdbc:sqlserver://srvgrupo.database.windows.net/bdgrupo10");
        // quem for acessar do yoshi: localhost -> 10.3.2.180
        // quem for acessar do yoshi: gaga -> gaga-seunome
        
        dataSource​.setUsername("monitoreasy");
        dataSource​.setPassword("#Gfgrupo10b"); // ou sua senha
    }
    
    public BasicDataSource getDataSource() {
        return dataSource;
    }

}