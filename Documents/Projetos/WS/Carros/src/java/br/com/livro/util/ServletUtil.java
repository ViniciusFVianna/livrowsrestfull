/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livro.util;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vinicius.Vianna
 */
public class ServletUtil{

    public static void writeXML(HttpServletResponse response,String xml) throws IOException{
        if(xml != null){
            PrintWriter writer = response.getWriter();
            response.setContentType("application/xml;charset=UTF-8");
            writer.write(xml);
            writer.close();
        }//fecha if
    }//fecha writeXML
    
    public static void writeJSON(HttpServletResponse response, String json) throws IOException{
        if(json != null){
            PrintWriter writer = response.getWriter();
            response.setContentType("appliction/json:charset=UTF-8");
            writer.write(json);
            writer.close();
        }//fecha if
    }//fecha writeJSON
}//fecha calsse
