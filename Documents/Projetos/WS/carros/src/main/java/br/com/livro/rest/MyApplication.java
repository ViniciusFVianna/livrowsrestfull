/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livro.rest;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Application;

/**
 *
 * @author Vinicius.Vianna
 */
public class MyApplication extends Application {
//    Não precisa do JettisonFeature
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        //Configura o pacote para fazer scan das classes com anotaçãoes REST.
        properties.put("jersey.config.server.provider.packages", "br.com.livro");
        return properties;
    }//fecha getProperties
}//fecha classe
