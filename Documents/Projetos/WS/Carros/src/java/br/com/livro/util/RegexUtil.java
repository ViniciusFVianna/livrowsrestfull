/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livro.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;

/**
 *
 * @author Vinicius.Vianna
 */
public class RegexUtil {
    private static final Pattern regexAll = Pattern.compile("/carros");
    private static final Pattern regexById = Pattern.compile("/carros/([0-9]*)");
    //Verifica se URL é no padrão "/carros/id"
    public static Long matchId(String requestUri) throws ServletException{
        //Verifica id
        Matcher matcher = regexById.matcher(requestUri);
        if(matcher.find() && matcher.groupCount()> 0){
            String s = matcher.group(1);
            if(s != null && s.trim().length() > 0){
                Long id = Long.parseLong(s);
                return id;                        
            }//fecha if
        }//fecha if
        return null;
    }//fecha matchId
    //Verifica se a URL é no pardrão "/carros/id"
    public boolean matchAll(String requestUri) throws ServletException{
        Matcher matcher = regexAll.matcher(requestUri);
        if(matcher.find()){
            return true;
        }//fecha if
        return false;
    }//fecha matchAll
}//fecha calsse
