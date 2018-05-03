/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livro.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vinicius.Vianna
 */
@Entity
@XmlRootElement
public class Carro implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id", unique=true, nullable=false)
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, length = 50)
    private String tipo;
    @Column(nullable=false, length = 100)
    private String nome;
    @Column(name="descricao", nullable=false, length = 500)
    private String desc;
    @Column(nullable=false, length = 50)
    private String urlFoto;
    @Column(nullable=false, length = 50)
    private String urlVideo;
    @Column(nullable=false, length = 15)
    private String latitude;
    @Column(nullable=false, length = 15)
    private String longetude;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongetude() {
        return longetude;
    }

    public void setLongetude(String longetude) {
        this.longetude = longetude;
    }

    @Override
    public String toString() {
        return "Carro{" + "id=" + id + ", tipo=" + tipo + ", nome=" + nome + ", desc=" + desc + ", urlFoto=" + urlFoto + ", urlVideo=" + urlVideo + ", latitude=" + latitude + ", longetude=" + longetude + '}';
    }

    public Boolean vericationLong(String id) {
        try {
            Long num = Long.parseLong(id);
            return num > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}//fecha classe
