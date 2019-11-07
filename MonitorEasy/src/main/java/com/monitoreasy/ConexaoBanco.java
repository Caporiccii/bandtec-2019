
package com.monitoreasy;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

public class ConexaoBanco extends LogMonitor{
    
private Logger logger;
    private BasicDataSource dataSource;

    public ConexaoBanco(Logger logger) {
        this.logger = logger;
            }

    public ConexaoBanco() {
      try{  
          dataSource​ = new​ BasicDataSource();
        dataSource​.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource​.setUrl("jdbc:sqlserver://srvgrupo.database.windows.net/bdgrupo10");
        // quem for acessar do yoshi: localhost -> 10.3.2.180
        // quem for acessar do yoshi: gaga -> gaga-seunome
        
        dataSource​.setUsername("monitoreasy");
        dataSource​.setPassword("#Gfgrupo10b"); // ou sua senha
        
    }
    catch(Exception ex){
    //logger vai printar qual é a exceção do erro
        logger.info(ex);
    
    }
    }
    
    public BasicDataSource getDataSource() {
        return dataSource;
    }

}