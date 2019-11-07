
package com.monitoreasy;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class LogMonitor {

    public static void main(String[] args) {
        // cria objeto para utilização do logger
        Logger logger = Logger.getLogger(LogMonitor.class);
        BasicConfigurator.configure();
        logger.info("Marco");
        logger.error("Fudeu");
        
    }
    
     
}
