package com.monitoreasy;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;

public class LogMonitor {

    public static void main(String[] args) {
        // cria objeto para utilização do logger
        Logger logger = Logger.getLogger(LogMonitor.class);
        BasicConfigurator.configure();

        PatternLayout layout = new PatternLayout();
        String conversionPattern = "%-7p %d [%t] %c %x - %m%n";
        layout.setConversionPattern(conversionPattern);

        FileAppender fileAppender = new FileAppender();
        fileAppender.setFile("applog3.txt");
        fileAppender.setLayout(layout);
        fileAppender.activateOptions();
        logger.info("Marco");
        logger.error("Fudeu");

    }

}
