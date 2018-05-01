/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livro.rest;

import br.com.livro.domain.Response;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Vinicius.Vianna
 */
@Path("/hello")
public class HelloResource {

    @GET
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.TEXT_HTML + ";charset=utf-8")
    public String helloHTML() {
        return "<b>Olá mundo HTML!</b>";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloTextPlain() {
        return "Olá mundo Texto!";
    }

    @GET
    @Consumes({MediaType.APPLICATION_XML, MediaType.TEXT_XML})
    @Produces({MediaType.APPLICATION_XML, MediaType.TEXT_XML})
    public Response helloXML() {
        return Response.Ok("Olá mundo XML!");
    }

    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response helloJSON() {
        return Response.Ok("Olá mundo JSON!");
    }

    public String get() {
        return "HTTP GET";
    }//fecha get

    @POST
    public String post() {
        return "HTTP POST";
    }

    @PUT
    public String put() {
        return "HTTP PUT";
    }

    @DELETE
    public String delete() {
        return "HTTP DELETE";
    }
}//fecha classe
