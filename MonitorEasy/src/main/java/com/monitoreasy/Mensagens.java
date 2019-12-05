/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreasy;

import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public class Mensagens {

    private final Integer limiteAmareloCpu;
    private final Integer limiteVermelhoCpu;
    private final Integer limiteAmareloMemoria;
    private final Integer limiteVermelhoMemoria;
    private final IntegracaoSlack slack;
    private final JSONObject mensagem;
    private Logger logger;
    private final InformacaoHardware info;
    private final Cpu cpu;

    public Mensagens() {
        this.limiteAmareloCpu = 35;
        this.limiteVermelhoCpu = 50;
        this.limiteAmareloMemoria = 50;
        this.limiteVermelhoMemoria = 75;
        this.slack = new IntegracaoSlack(logger);
        this.mensagem = new JSONObject();
        this.info = new InformacaoHardware(logger);
        this.cpu = new Cpu(logger);
    }

    public void geraAlerta(Double cpu, Double memoria) throws Exception {
        if (cpu >= limiteAmareloCpu) {
            mensagem.put("text", "Totem *" + info.serialNumber+ "* esta em estado amarelo");
            slack.enviarMensagem(mensagem);
        }
        else if (cpu >= limiteVermelhoCpu){
            mensagem.put("text", "Totem *" + info.serialNumber+ "* esta em estado vermelho");
            slack.enviarMensagem(mensagem);
             if (memoria >= limiteAmareloMemoria) {
            mensagem.put("text", "Totem *" + info.serialNumber+ "* esta em estado amarelo");
            slack.enviarMensagem(mensagem);
        }
        else if (memoria >= limiteVermelhoMemoria){
            mensagem.put("text", "Totem *" + info.serialNumber+ "* esta em estado vermelho");
            slack.enviarMensagem(mensagem);
    }
    }}
}
