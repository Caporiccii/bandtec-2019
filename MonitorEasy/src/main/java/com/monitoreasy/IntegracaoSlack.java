/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreasy;

import java.io.BufferedReader;

import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.log4j.Logger;
import org.json.JSONObject;



public class IntegracaoSlack {
Logger logger;

    public IntegracaoSlack(Logger logger) {
        this.logger = logger;
    }


         // private static final Logger logger = LoggerFactory.getLogger(SlackConfiguration.class);
        private final String url = "https://apimonitoreasy.herokuapp.com/alerts/message";

        public void enviarMensagem(JSONObject message) throws Exception {

            URL obj = new URL(this.url);

            //Essa função faz a conexão entre o link HTTP do slack ao JAVA
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //Método de envio das informações 
            con.setRequestMethod("POST");
            con.setDoOutput(true);

            //Enviando as informações via bytes e colocando no na variável url para que o sistema entenda
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(message.toString());

            //limpa as informações que foram inseridas 
            wr.flush();
            //fecha as informações  
            wr.close();

            int responseCode = con.getResponseCode();

            //Enviando solicitação para o slack atráves da URL
            logger.debug("Sending 'POST' request to URL: " + this.url);
            logger.debug("POST parameters: " + message.toString());
            logger.debug("Response Code: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String inputLine;

            StringBuffer response = new StringBuffer();

            while ((inputLine = reader.readLine()) != null) {

                response.append(inputLine);

            }

            reader.close();

            System.out.println("Success: " + response);
        }
    }

