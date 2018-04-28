/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livro.domain;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vinicius.Vianna
 */
@XmlRootElement(name="carros")
public class ListaCarros implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private List<Carro> carros;
    @XmlElement(name="carro")
    public List<Carro> getCarros(){
        return carros;
    }//fecha getCarros
    
    public void setCarros(List<Carro> carros){
        this.carros = carros;
    }//fecha setCarros

    @Override
    public String toString() {
        return "ListaCarros{" + "carros=" + carros + '}';
    }
    
}//fecha classe
