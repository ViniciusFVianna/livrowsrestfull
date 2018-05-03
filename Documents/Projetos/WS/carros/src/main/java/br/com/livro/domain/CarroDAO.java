/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livro.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.hibernate.Query;

/**
 *
 * @author Vinicius.Vianna
 */
@Component
@SuppressWarnings("uncheked")
public class CarroDAO extends HibernateDAO<Carro> {

    public CarroDAO() {
        super(Carro.class);
    }
    
//    Consulta um carro pelo id
    public Carro getCarroById(Long id){
//        O hibernate consulta automaticamente
        return super.get(id);
    }//fecha getCarros
//    Busca um carro pelo nome
    public List<Carro> findByName(String nome){
        Query q = getSession().createQuery("from Carro where lower(nome) like lower(?)");
        q.setString(0, "%"+ nome +"%");
        return q.list();
    }//fecha findByName
//    Busca pelo tipo
    public List<Carro> findByTipo(String tipo){
        Query q = getSession().createQuery("from Carro where tipo=?");
        q.setString(0, tipo);
        List<Carro> carros = q.list();
        return carros;
    }//fecha findByTipo
//    Consulta todos os carros
    public List<Carro> getCarros(){
        Query q = getSession().createQuery("from Carro");
        List<Carro> carros = q.list();
        return carros;
    }//fecha metodo
//    Insere ou atualiza um carro
    public void save(Carro c){
        super.save(c);
    }//fecha save
//    Deleta o carro pelo id
    public boolean delete(Long id){
        Carro c = get(id);
        delete(c);
        return true;
    }//fecha metodo
}//fecha classe
