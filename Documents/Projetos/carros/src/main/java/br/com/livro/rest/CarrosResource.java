/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livro.rest;

import br.com.livro.domain.Carro;
import br.com.livro.domain.CarroService;
import br.com.livro.domain.Response;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Vinicius.Vianna
 */
@Path("/carros")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + "chaset=uft-8")
public class CarrosResource {

    private CarroService carroService = new CarroService();

    @GET
    public List<Carro> get() {
        List<Carro> carros = carroService.getCarros();
        return carros;
    }//fecha get

    @GET
    @Path("{id}")
    public Carro get(@PathParam("id") long id) {
        Carro c = carroService.getCarro(id);
        return c;
    }//fecha get

    @GET
    @Path("/tipo/{tipo}")
    public List<Carro> getByTipo(@PathParam("tipo") String tipo) {
        List<Carro> carros = carroService.findByTipo(tipo);
        return carros;
    }//fecha getByTipo

    @GET
    @Path("/nome/{nome}")
    public List<Carro> getbyName(@PathParam("nome") String nome) {
        List<Carro> carros = carroService.findbyName(nome);
        return carros;
    }//fecha getByName

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") long id) {
        carroService.delete(id);
        return Response.Ok("Carro deletado com sucesso");
    }//fecha delete

    @POST
    public Response post(Carro c) {
        carroService.save(c);
        return Response.Ok("Carro salvo com sucesso");
    }//fecha post

    @PUT
    public Response put(Carro c) {
        carroService.save(c);
        return Response.Ok("Carro atualizado com sucesso");
    }//fecha put
}//fecha classe
