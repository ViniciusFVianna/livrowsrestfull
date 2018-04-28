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
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius.Vianna
 */
public class CarroDAO extends BaseDAO{
    public Carro getCarroById(Long id) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            String sql = "select * from carro where id=?";
            
            conn = getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Carro c = createCarro(rs);
                rs.close();
                return c;
            }
        }finally{
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }//fecha finally
        return null;
    }//fecha getCarros
    
    public List<Carro> findByName(String name) throws SQLException{
        List<Carro> carros = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            String sql = "select * from carro where lower(nome) like ?";
          conn = getConnection();
          stmt = conn.prepareStatement(sql);
          stmt.setString(1, "%" + name.toLowerCase() + "%");
          ResultSet rs = stmt.executeQuery();
            while (rs.next()) {                
                Carro c = createCarro(rs);
                carros.add(c);
            }
            rs.close();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return carros;
    }//fecha findByName
    
    public List<Carro> findByTipo(String tipo) throws SQLException{
        List<Carro> carros = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
             String sql = "select * from carro where tipo = ?";
            conn = getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipo);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Carro c = createCarro(rs);
                carros.add(c);
            }//fecha while
            rs.close();
        }finally{
           if(stmt != null){
               stmt.close();
           }if(conn != null){
               conn.close();
           }
        }//fecha finally
        return carros;
    }//fecha findByTipo
    
    public List<Carro> getCarros() throws SQLException{
        List<Carro> carros = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        String sql = "select * from carro";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Carro c = createCarro(rs);
                carros.add(c);
            }
            rs.close();
        } finally {
            if(stmt != null){
                stmt.close();
            }if(conn != null){
                conn.close();
            }
        }
        return carros;
    }//fecha metodo
    
    public Carro createCarro(ResultSet rs) throws SQLException{
        Carro c = new Carro();
        c.setId(rs.getLong("id"));
        c.setNome(rs.getString("nome"));
        c.setDesc(rs.getString("descricao"));
        c.setUrlFoto(rs.getString("urlFoto"));
        c.setUrlVideo(rs.getString("urlVideo"));
        c.setLatitude(rs.getString("latitude"));
        c.setLongetude(rs.getString("longetude"));
        c.setTipo(rs.getString("tipo"));
        return c;
    }//fecha metodo
    
    public void save(Carro c) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            if (c.getId() == null) {
                stmt = conn.prepareStatement("insert into carro (nome, descricao, urlFoto, urlVideo,"
                + "latitude, longetude, tipo) values(?,?,?,?,?,?,?,?)",
        Statement.RETURN_GENERATED_KEYS);
            }else{
                stmt = conn.prepareStatement("update carro set nome=?, descricao=?, urlFoto=?,"
                        + "urlVideo=?, latitude=?, longetude=?, tipo=? where id=?");
            }
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getDesc());
            stmt.setString(3, c.getUrlFoto());
            stmt.setString(4, c.getUrlVideo());
            stmt.setString(5, c.getLatitude());
            stmt.setString(6, c.getLongetude());
            stmt.setString(7, c.getTipo());
            
            if(c.getId() != null){
                stmt.setLong(8, c.getId());
            }
            int count = stmt.executeUpdate();
            if (count == 0) {
                throw new SQLException("Erro ao inserir o carro");
            }
            if(c.getId() == null){
                long id = getGeneratedId(stmt);
                c.setId(id);
            }
        } finally {
            if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                stmt.close();
            }
        }
    }//fecha save
    
    public static Long getGeneratedId(Statement stmt) throws SQLException{
        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next()){
            Long id = rs.getLong(1);
            return id;
        }
        return 0L;
    }//fecha metodo
    
    public boolean delete(Long id) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("delete from carro where id=?");
            stmt.setLong(1, id);
            int count = stmt.executeUpdate();
            boolean ok = count > 0;
            return ok;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }//fecha metodo
}//fecha classe
