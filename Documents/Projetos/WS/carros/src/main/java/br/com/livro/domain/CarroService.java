/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livro.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CarroService {

    @Autowired
    private CarroDAO db;

    //Lista todos os carros do banco de dados
    public List<Carro> getCarros() {
        List<Carro> carros = db.getCarros();
        return carros;
    }//fecha getCarros

    //Busca um carro pelo id
    public Carro getCarro(Long id) {
        return db.getCarroById(id);
    }//fecha metodo
    
    //Deleta o carro pelo id
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Long id) {
            return db.delete(id);
    }//fecha delete
    
    //Salva ou atualiza o carro
    @Transactional(rollbackFor = Exception.class)
    public boolean save(Carro carro) {
        db.saveOrUpdate(carro);
        return true;
    }//fecha save
    
    //Busca o carro pelo nome
    public List<Carro> findbyName(String name) {
            return db.findByName(name);
    }//fecha findbyName

    public List<Carro> findByTipo(String tipo) {
            return db.findByTipo(tipo);
    }//fecha metodo
}//fecha classe
