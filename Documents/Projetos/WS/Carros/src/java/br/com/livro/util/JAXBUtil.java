/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livro.util;

import br.com.livro.domain.Carro;
import br.com.livro.domain.ListaCarros;
import br.com.livro.domain.Response;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamWriter;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author Vinicius.Vianna
 */
public class JAXBUtil {
    
    private static JAXBUtil instance;
    private static JAXBContext context;
    public static JAXBUtil getIntance(){
        return instance;
    }//fecha get
    static{
        try{
            //Informa ao JAXB que é para gerar XML destas classes
            context = JAXBContext.newInstance(Response.class, ListaCarros.class, Carro.class);
        }catch(JAXBException e){
            throw new RuntimeException(e);
        }//fecha catch
    }//fecha static
    public static String toXML(Object object) throws IOException{
        try {
            StringWriter writer = new StringWriter();
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(object, writer);
            String xml = writer.toString();
            return xml;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }//fecha chatch
    }//fecha toXML
    public static String toJSON(Object object) throws IOException{
        try {
            StringWriter writer = new StringWriter();
            Marshaller m = context.createMarshaller();
            MappedNamespaceConvention con = new MappedNamespaceConvention();
            XMLStreamWriter xmlStreamWriter = new MappedXMLStreamWriter(con, writer);
            m.marshal(object, xmlStreamWriter);
            
            String json = writer.toString();
            return json;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }//fecha chatch
    }//fecha toXML
}//fecha classe
